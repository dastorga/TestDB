package com.example.dario.testsdb;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.dario.testsdb", appContext.getPackageName());
    }

    @Test
    public void useAppContextRecuperarIdGraph() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);
        Graph graph;

        MDB.dropTable("GRAPH");
        MDB.insertGraph(1,"Grafo 1");
        graph = MDB.recoverGraph(1);

        assertEquals(1, graph.getIdGraph());
    }

    @Test
    public void recuperarGraphs() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);
        List<Graph> lista_graphs;

        MDB.dropTable("GRAPH");
        MDB.insertGraph(1,"Grafo 1");
        MDB.insertGraph(2,"Grafo 2");
        MDB.insertGraph(3,"Grafo 3");
        MDB.insertGraph(4,"Grafo 4");
        lista_graphs = MDB.recoverGraphs();

        assertEquals(4, lista_graphs.size());
    }

    @Test
    public void recuperarNameGraph() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("GRAPH");
        MDB.insertGraph(1,"Test");
        String name = MDB.recoverGraph(1).getNameGraph();

        assertEquals("Test", name);
    }

    @Test
    public void dropTableGraph() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("GRAPH");
        MDB.insertGraph(1,"Test 1");
        MDB.insertGraph(2,"Test 2");
        MDB.insertGraph(3,"Test 3");
        MDB.insertGraph(4,"Test 4");
        MDB.dropTable("GRAPH");

        assertEquals(0, MDB.recoverGraphs().size());
    }

    @Test
    public void insertNode() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.insertGraph(1,"Primer Grafo");
        MDB.insertNode(1,1,"Nodo Test",1);

        assertEquals(1, MDB.recoverNode(1).getIdNode());
    }

    @Test
    public void idGraphInNode() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.insertGraph(1,"Primer Grafo");
        MDB.insertNode(1,1,"Nodo Test",1);

        assertEquals(1, MDB.recoverNode(1).getIdGraphNode());
    }

    @Test
    public void nodesInGraph() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.insertGraph(1,"Primer Grafo");
        MDB.insertNode(1,1,"Nodo Test 1",1);
        MDB.insertNode(2,2,"Nodo Test 2",1);
        MDB.insertNode(3,3,"Nodo Test 3",1);
        MDB.insertNode(4,4,"Nodo Test 4",1);

        assertEquals(1, MDB.recoverNode(1).getIdGraphNode());
        assertEquals(1, MDB.recoverNode(2).getIdGraphNode());
        assertEquals(1, MDB.recoverNode(3).getIdGraphNode());
        assertEquals(1, MDB.recoverNode(4).getIdGraphNode());
    }

    @Test
    public void countNodes() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");

        MDB.insertGraph(1,"Primer Grafo");

        MDB.insertNode(1,1,"Nodo Test 1",1);
        MDB.insertNode(2,2,"Nodo Test 2",1);
        MDB.insertNode(3,3,"Nodo Test 3",1);
        MDB.insertNode(4,4,"Nodo Test 4",1);

        assertEquals(4, MDB.recoverNodes().size());
    }

    @Test
    public void existeAtributoEnlace() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(1,"Primer Grafo"); //Creo Grafo

        MDB.insertNode(1, 1, "Sandra", 1);
        MDB.insertNode(2, 2, "Pablo", 1);
        MDB.insertNode(3, 3, "Carlos", 1);
        MDB.insertNode(4, 4, "Ana", 1);

        MDB.insertEnlace(1,1,3,"Colaboradora",1);
        MDB.insertEnlace(2,2,1,"Asesora",1);
        MDB.insertEnlace(3,2,3,"Colaboradora",1);
        MDB.insertEnlace(4,4,2,"Es Colega",1);

        assertEquals("Es Colega", MDB.recoverEnlace(4).getAtributoEnlace());
    }

    @Test
    public void idGraphInEnlace() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(1,"Primer Grafo"); //Creo Grafo

        MDB.insertNode(1, 1, "Sandra", 1);
        MDB.insertNode(2, 2, "Pablo", 1);
        MDB.insertNode(3, 3, "Carlos", 1);
        MDB.insertNode(4, 4, "Ana", 1);

        MDB.insertEnlace(1,1,3,"Colaboradora",1);
        MDB.insertEnlace(2,2,1,"Asesora",1);
        MDB.insertEnlace(3,2,3,"Colaboradora",1);
        MDB.insertEnlace(4,4,2,"Es Colega",1);

        assertEquals(1, MDB.recoverEnlace(1).getIdGraphEnlace());
        assertEquals(1, MDB.recoverEnlace(2).getIdGraphEnlace());
        assertEquals(1, MDB.recoverEnlace(3).getIdGraphEnlace());
        assertEquals(1, MDB.recoverEnlace(4).getIdGraphEnlace());
    }

    @Test
    public void recuperarNodos() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(1,"Primer Grafo"); //Creo Grafo

        MDB.insertNode(1, 1, "Sandra", 1);
        MDB.insertNode(2, 2, "Pablo", 1);
        MDB.insertNode(3, 3, "Carlos", 1);
        MDB.insertNode(4, 4, "Ana", 1);

        MDB.insertEnlace(1,1,3,"Colaboradora",1);
        MDB.insertEnlace(2,2,1,"Asesora",1);
        MDB.insertEnlace(3,2,3,"Colaboradora",1);
        MDB.insertEnlace(4,4,2,"Es Colega",1);

        MDB.insertGraph(2,"Segundo Grafo"); //Creo Grafo
        MDB.insertGraph(3,"Tercero Grafo"); //Creo Grafo

        assertEquals(4, MDB.recoverNodesInGraph(1).size());
        assertEquals(0, MDB.recoverNodesInGraph(2).size());
        assertEquals(0, MDB.recoverNodesInGraph(3).size());
    }

    @Test
    public void recuperarNodos2() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(1,"Primer Grafo"); //Creo Grafo

        MDB.insertNode(1, 1, "Sandra", 1);
        MDB.insertNode(2, 2, "Pablo", 1);
        MDB.insertNode(3, 3, "Carlos", 1);
        MDB.insertNode(4, 4, "Ana", 1);

        MDB.insertEnlace(1,1,3,"Colaboradora",1);
        MDB.insertEnlace(2,2,1,"Asesora",1);
        MDB.insertEnlace(3,2,3,"Colaboradora",1);
        MDB.insertEnlace(4,4,2,"Es Colega",1);

        MDB.insertGraph(2,"Segundo Grafo"); //Creo Grafo
        MDB.insertGraph(3,"Tercero Grafo"); //Creo Grafo

        assertEquals(4, MDB.recoverNodesInGraph(1).size());
        assertEquals(0, MDB.recoverNodesInGraph(2).size());
        assertEquals(0, MDB.recoverNodesInGraph(3).size());
    }

    @Test
    public void existeNodesInGraph() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(1,"Primer Grafo"); //Creo Grafo

        MDB.insertNode(1, 1, "Sandra", 1);
        MDB.insertNode(2, 2, "Pablo", 1);
        MDB.insertNode(3, 3, "Carlos", 1);
        MDB.insertNode(4, 4, "Ana", 1);

        MDB.insertEnlace(1,1,3,"Colaboradora",1);
        MDB.insertEnlace(2,2,1,"Asesora",1);
        MDB.insertEnlace(3,2,3,"Colaboradora",1);
        MDB.insertEnlace(4,4,2,"Es Colega",1);

        MDB.insertGraph(2,"Segundo Grafo"); //Creo segundo Grafo

        MDB.insertGraph(3,"Tercero Grafo"); //Creo tercer Grafo

        assertTrue("Debe dar True",MDB.existsNodesInGraph(1));
        assertFalse("Debe dar False",MDB.existsNodesInGraph(2));
        assertFalse("Debe dar False",MDB.existsNodesInGraph(3));
    }

    @Test
    public void existeEnlacesInGraph() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(1,"Primer Grafo"); //Creo Grafo

        MDB.insertNode(1, 1, "Sandra", 1);
        MDB.insertNode(2, 2, "Pablo", 1);
        MDB.insertNode(3, 3, "Carlos", 1);
        MDB.insertNode(4, 4, "Ana", 1);

        MDB.insertEnlace(1,1,3,"Colaboradora",1);
        MDB.insertEnlace(2,2,1,"Asesora",1);
        MDB.insertEnlace(3,2,3,"Colaboradora",1);
        MDB.insertEnlace(4,4,2,"Es Colega",1);

        MDB.insertGraph(2,"Segundo Grafo"); //Creo segundo Grafo
        MDB.insertGraph(3,"Tercero Grafo"); //Creo tercer Grafo

        assertTrue("Debe dar True",MDB.existsEnlacesInGraph(1));
        assertFalse("Debe dar False",MDB.existsNodesInGraph(2));
        assertFalse("Debe dar False",MDB.existsNodesInGraph(3));
    }

    @Test
    public void deleteGraphCascade() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(1,"Primer Grafo"); //Creo Grafo

        MDB.insertNode(1, 1, "Sandra", 1);
        MDB.insertNode(2, 2, "Pablo", 1);
        MDB.insertNode(3, 3, "Carlos", 1);
        MDB.insertNode(4, 4, "Ana", 1);

        MDB.insertEnlace(1,1,3,"Colaboradora",1);
        MDB.insertEnlace(2,2,1,"Asesora",1);
        MDB.insertEnlace(3,2,3,"Colaboradora",1);
        MDB.insertEnlace(4,4,2,"Es Colega",1);

        MDB.deleteGraph(1);

        assertEquals(0, MDB.recoverNodesInGraph(1).size());
        assertEquals(0, MDB.recoverGraphs().size());
    }

    @Test
    public void deleteGraphCascade2() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(1,"Primer Grafo");  //New Grafo
        MDB.insertGraph(2,"Segundo Grafo"); //New Grafo
        MDB.insertGraph(3,"Tercero Grafo"); //New Grafo

        MDB.insertNode(1, 1, "Sandra", 1);
        MDB.insertNode(2, 2, "Pablo", 1);
        MDB.insertNode(3, 3, "Carlos", 1);
        MDB.insertNode(4, 4, "Ana", 1);
        MDB.insertEnlace(1,1,3,"Colaboradora",1);
        MDB.insertEnlace(2,2,1,"Asesora",1);
        MDB.insertEnlace(3,2,3,"Colaboradora",1);
        MDB.insertEnlace(4,4,2,"Es Colega",1);

        MDB.insertNode(1, 1, "Nodo 1", 2);
        MDB.insertNode(2, 2, "Nodo 2", 2);
        MDB.insertEnlace(1,1,2,"Enlace 1",2);
        MDB.insertEnlace(2,2,1,"Enlace 2",2);

        MDB.deleteGraph(1);

        assertEquals(2, MDB.recoverGraphs().size());
    }

    @Test
    public void deleteNode() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(2,"Segundo Grafo"); //New Grafo

        MDB.insertNode(1, 1, "Nodo 1", 2);
        MDB.insertNode(2, 2, "Nodo 2", 2);

        MDB.insertEnlace(1,1,2,"Enlace 1",2);
        MDB.insertEnlace(2,2,1,"Enlace 2",2);

        MDB.deleteNode(2);

        assertEquals(1, MDB.recoverNodes().size());
    }

    @Test
    public void updateGraph() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(1,"Primer Grafo"); //Creo un solo grafo

        MDB.insertNode(1, 1, "Nodo 1", 1);
        MDB.insertNode(2, 2, "Nodo 2", 1);

        MDB.insertEnlace(1, 1, 2, "Enlace 1", 1);
        MDB.insertEnlace(2, 2, 1, "Enlace 2", 1);

        MDB.updateGraph(1,"Cambie el nombre del grafo"); // Actualizo el nombre del Grafo

        assertEquals("Cambie el nombre del grafo", MDB.recoverGraph(1).getNameGraph());
    }

    @Test
    public void updateNode() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(1,"Primer Grafo"); //Creo un solo grafo

        MDB.insertNode(1, 1, "Nodo 1", 1);
        MDB.insertNode(2, 2, "Nodo 2", 1);

        MDB.insertEnlace(1, 1, 2, "Enlace 1", 1);
        MDB.insertEnlace(2, 2, 1, "Enlace 2", 1);

        MDB.updateNode(2,2,"Edite",1);

        assertEquals("Edite", MDB.recoverNode(2).getAtributoNode());
        assertFalse(MDB.recoverNode(2).getAtributoNode()=="Nodo 2");
    }

    @Test
    public void updateEnlace() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        final MiBaseDatos MDB = new MiBaseDatos(appContext);

        MDB.dropTable("NODE");
        MDB.dropTable("GRAPH");
        MDB.dropTable("ENLACE");

        MDB.insertGraph(1,"Primer Grafo"); //Creo un solo grafo

        MDB.insertNode(1, 1, "Nodo 1", 1);
        MDB.insertNode(2, 2, "Nodo 2", 1);

        MDB.insertEnlace(1, 1, 2, "Enlace 1", 1);
        MDB.insertEnlace(2, 2, 1, "Enlace 2", 1);
        MDB.insertEnlace(3, 1, 1, "Enlace 3", 1);

        MDB.updateEnlace(3, 2, 2,"Edite enlace",1);

        assertEquals(2, MDB.recoverEnlace(3).getOrigenEnlace());
        assertEquals(2, MDB.recoverEnlace(3).getDestinoEnlace());
        assertEquals("Edite enlace", MDB.recoverEnlace(3).getAtributoEnlace());
    }


}
