package com.example.dario.testsdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by dario on 27/2/18.
 */

public class EnlaceListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Enlace> EnlaceList;

    public EnlaceListAdapter(Context context,  int layout, ArrayList<Enlace> EnlaceList) {
        this.context = context;
        this.layout = layout;
        this.EnlaceList = EnlaceList;
    }

    @Override
    public int getCount() {
        return EnlaceList.size();
    }

    @Override
    public Object getItem(int position) {
        return EnlaceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{ TextView txtAtributeNode, txtIdNode_Node;}

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        EnlaceListAdapter.ViewHolder holder = new EnlaceListAdapter.ViewHolder();
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtAtributeNode = row.findViewById(R.id.txtAtributeNode);
            holder.txtIdNode_Node = row.findViewById(R.id.txtIdNode_Node);
            row.setTag(holder);
        }
        else {
            holder = (EnlaceListAdapter.ViewHolder) row.getTag();
        }
        Enlace enlace = EnlaceList.get(position);
//        holder.txtAtributeNode.setText(node.getAtributoNode());
//        holder.txtIdNode_Node.setText((String.valueOf(node.getIdNode()))); // el identificador es Int pero lo paso a string solo para mostrarlo por pantalla
        return row;
    }
}

