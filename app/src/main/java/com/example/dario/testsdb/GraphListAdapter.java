package com.example.dario.testsdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class GraphListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Graph> GraphList;

    public GraphListAdapter(Context context,  int layout, ArrayList<Graph> GraphList) {
        this.context = context;
        this.layout = layout;
        this.GraphList = GraphList;
    }

    @Override
    public int getCount() {
        return GraphList.size();
    }

    @Override
    public Object getItem(int position) {
        return GraphList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {TextView txtViewGraph, txtViewIdGraph;}

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        GraphListAdapter.ViewHolder holder = new GraphListAdapter.ViewHolder();
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtViewGraph = (TextView) row.findViewById(R.id.txtViewGraph);
            holder.txtViewIdGraph = (TextView) row.findViewById(R.id.txtViewIdGraph);
            row.setTag(holder);
        }
        else {
            holder = (GraphListAdapter.ViewHolder) row.getTag();
        }
        Graph graph = GraphList.get(position);
        holder.txtViewGraph.setText(graph.getNameGraph());
        holder.txtViewIdGraph.setText(String.valueOf(graph.getIdGraph()));
        return row;
    }
}
