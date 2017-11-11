package com.example.dario.testsdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dario on 14/9/17.
 */

public class MiBaseDatos extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 1;

    // Nombre de nuestro archivo de base de datos
    private static final String NOMBRE_BASEDATOS = "mibasedatos8.db";

    // Sentencia SQL para la creación de tabla palabra
    private static final String TABLA_WORD = "CREATE TABLE WORD" + "(_id INT PRIMARY KEY, word VARCHAR)";

    private static final String TABLA_GRAPH = "CREATE TABLE GRAPH" + "(id_graph INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR)";

    private static final String TABLA_NODE = "CREATE TABLE NODE" + "(id_node INTEGER PRIMARY KEY AUTOINCREMENT, atributo VARCHAR, id_graph INT, FOREIGN KEY(id_graph) REFERENCES GRAPH(id_graph) ON DELETE CASCADE)";

    private static final String TABLA_ENLACE = "CREATE TABLE ENLACE" + "(id_enlace INT PRIMARY KEY, origen INT, destino INT, atributo VARCHAR, id_graph INT, FOREIGN KEY(id_graph) REFERENCES GRAPH(id_graph) ON DELETE CASCADE)";

    // CONSTRUCTOR de la clase
    public MiBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        // para habilitar el uso de FOREIGN KEY(id_graph)
        db.execSQL("PRAGMA foreign_keys = ON;");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLA_GRAPH);
        db.execSQL(TABLA_NODE);
        db.execSQL(TABLA_ENLACE);
        db.execSQL(TABLA_WORD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLA_GRAPH);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLA_NODE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLA_ENLACE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLA_WORD);
        onCreate(db);
    }

    //////////////////////////////// INSERTAR /////////////////////////////////////////////////

    public int insertGraph(String name) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();

            valores.put("name", name);

            long newRowId;

            // REcordar que al ser autoincrementado va aumentando de uno en uno
            newRowId = db.insert("GRAPH", null, valores);

            db.close();

            return ((int) newRowId);
        }
        return -1; //en caso de error en la insercion
    }

    public int insertNode(String atributo, int id_graph) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();

            valores.put("atributo", atributo);
            valores.put("id_graph", id_graph);

            long newRowId;
            newRowId = db.insert("NODE", null, valores);
            db.close();

            return ((int) newRowId);
        }
        return -1; //en caso de error en la insercion
    }

    public void insertEnlace(int id_enlace, int origen, int destino, String atributo, int id_graph) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();

            valores.put("id_enlace", id_enlace);
            valores.put("origen", origen);
            valores.put("destino", destino);
            valores.put("atributo", atributo);
            valores.put("id_graph", id_graph);

            db.insert("ENLACE", null, valores);
            db.close();
        }
    }

    public void insertUser(int id, String name, int phone, String email) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();

            valores.put("_id", id);
            valores.put("name", name);
            valores.put("phone", phone);
            valores.put("email", email);

            db.insert("USER", null, valores);
            db.close();
        }
    }

    public void insertWord(int id, String word) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();

            valores.put("_id", id);
            valores.put("word", word);

            db.insert("WORD", null, valores);
            db.close();
        }
    }

    //////////////////////////////// RECUPERAR /////////////////////////////////////////////////

    public Graph recoverGraph(int id_graph) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_graph", "name"};
        Cursor c = db.query("GRAPH", valores_recuperar, "id_graph=" + id_graph, null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Graph graph = new Graph(c.getInt(0), c.getString(1));
        db.close();
        c.close();
        return graph;
    }

    public List<Graph> recoverGraphs() {
        SQLiteDatabase db = getReadableDatabase();
        List<Graph> lista_graphs = new ArrayList<Graph>();
        String[] valores_recuperar = {"id_graph", "name"};
        Cursor c = db.query("GRAPH", valores_recuperar, null, null, null, null, null, null);
        lista_graphs.clear();;
        while (c.moveToNext()){
            lista_graphs.add(new Graph(c.getInt(0), c.getString(1)));
        }
        db.close();
        c.close();
        return lista_graphs;
    }

    public Node recoverNode(int id_node) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_node", "codigo", "atributo", "id_graph"};
        Cursor c = db.query("NODE", valores_recuperar, "id_node=" + id_node, null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Node node = new Node(c.getInt(0), c.getString(1), c.getInt(2));
        db.close();
        c.close();
        return node;
    }


    public List<Node> recoverNodes() {
        SQLiteDatabase db = getReadableDatabase();
        List<Node> lista_nodes = new ArrayList<Node>();
        String[] valores_recuperar = {"id_node", "codigo", "atributo", "id_graph"};
        Cursor c = db.query("NODE", valores_recuperar, null, null, null, null, null, null);
        lista_nodes.clear();;
        while (c.moveToNext()){
            lista_nodes.add(new Node(c.getInt(0), c.getString(1), c.getInt(2)));
        }
        db.close();
        c.close();
        return lista_nodes;
    }

    public Enlace recoverEnlace(int id_enlace) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_enlace", "origen", "destino", "atributo", "id_graph"};
        Cursor c = db.query("ENLACE", valores_recuperar, "id_enlace=" + id_enlace, null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Enlace enlace = new Enlace(c.getInt(0), c.getInt(1), c.getInt(2), c.getString(3), c.getInt(4));
        db.close();
        c.close();
        return enlace;
    }

    public ArrayList<Node> recoverNodesInGraph(int id_graph) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Node> lista_nodes = new ArrayList<Node>();
        String[] valores_recuperar = {"id_node", "atributo", "id_graph"};

        Cursor c = db.query("NODE", valores_recuperar, "id_graph=" + id_graph, null, null, null, null, null);

        lista_nodes.clear();;
        while (c.moveToNext()){
            lista_nodes.add(new Node(c.getInt(0), c.getString(1), c.getInt(2)));
        }
        db.close();
        c.close();
        return lista_nodes;
    }

    public List<Word> recoverWords() {
        SQLiteDatabase db = getReadableDatabase();
        List<Word> lista_words = new ArrayList<Word>();
        String[] valores_recuperar = {"_id", "word"};
        Cursor c = db.query("WORD", valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();
        do {
            Word word = new Word(c.getInt(0), c.getString(1));
            lista_words.add(word);
        } while (c.moveToNext());
        db.close();
        c.close();
        return lista_words;
    }

    //////////////////////////////// EXISTIR /////////////////////////////////////////////////

    // Dado un grafo, me indica si existen nodos para ese grafo.
    public Boolean existsNodesInGraph(int id_graph) {
        SQLiteDatabase db = getReadableDatabase();
        List<Node> lista_nodes = new ArrayList<Node>();
        String[] valores_recuperar = {"id_node", "atributo", "id_graph"};

        Cursor c = db.query("NODE", valores_recuperar, "id_graph=" + id_graph, null, null, null, null, null);

        lista_nodes.clear();;
        while (c.moveToNext()){
            lista_nodes.add(new Node(c.getInt(0), c.getString(1), c.getInt(2)));
        }
        db.close();
        c.close();
        if (lista_nodes.size()==0){
            return false;
        }
        return true;
    }

    //Dado un grafo me indica si existen enlaces para ese grafo.
    public Boolean existsEnlacesInGraph(int id_graph) {
        SQLiteDatabase db = getReadableDatabase();
        List<Enlace> lista_enlaces = new ArrayList<Enlace>();
        String[] valores_recuperar = {"id_enlace", "origen", "destino", "atributo", "id_graph"};

        Cursor c = db.query("ENLACE", valores_recuperar, "id_graph=" + id_graph, null, null, null, null, null);

        lista_enlaces.clear();;
        while (c.moveToNext()){
            lista_enlaces.add(new Enlace(c.getInt(0), c.getInt(1), c.getInt(2), c.getString(3), c.getInt(4)));
        }
        db.close();
        c.close();
        if (lista_enlaces.size()==0){
            return false;
        }
        return true;
    }

    //////////////////////////////// ELIMINAR /////////////////////////////////////////////////

    public void deleteGraph(int id_graph) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("GRAPH", "id_graph="+id_graph, null);
        db.close();
    }

    public void deleteNode(int id_node) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("NODE", "id_node="+id_node, null);
        db.close();
    }

    public void deleteEnlace(int id_enlace) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("ENLACE", "id_enlace="+id_enlace, null);
        db.close();
    }

    public void deleteUser(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("USER", "_id="+id, null);
        db.close();
    }

    public void deleteWord(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("WORD", "_id="+id, null);
        db.close();
    }

    // Elimina los elementos de la tabla que se pasa como parametro
    public void dropTable(String table) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + table);
        db.close();
    }

    //////////////////////////////// ACTUALIZAR /////////////////////////////////////////////////

    public void updateUser(int id, String name, int phone, String email){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("_id", id);
        valores.put("name", name);
        valores.put("phone", phone);
        valores.put("email", email);

        db.update("USER", valores, "_id=" + id, null);
        db.close();
    }

    public void updateWord(int id, String word){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("_id", id); //ver
        valores.put("word", word);

        db.update("WORD", valores, "_id=" + id, null);
        db.close();
    }

    public void updateGraph(int id_graph, String name){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("id_graph", id_graph); //ver
        valores.put("name", name);

        db.update("GRAPH", valores, "id_graph=" + id_graph, null);
        db.close();
    }

    public void updateNode(int id_node, String atributo, int id_graph){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("id_node", id_node); //ver
        valores.put("atributo", atributo);
        valores.put("id_graph", id_graph);

        db.update("NODE", valores, "id_node=" + id_node, null);
        db.close();
    }

    public void updateEnlace(int id_enlace, int origen, int destino, String atributo, int id_graph){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("id_enlace", id_enlace); //ver
        valores.put("origen", origen);
        valores.put("destino", destino);
        valores.put("atributo", atributo);
        valores.put("id_graph", id_graph);

        db.update("ENLACE", valores, "id_enlace=" + id_enlace, null);
        db.close();
    }

    
}
