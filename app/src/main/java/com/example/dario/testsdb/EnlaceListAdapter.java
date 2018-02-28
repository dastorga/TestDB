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

    private class ViewHolder{TextView txtViewEnalce, textViewNodoOrigen, textViewNodoDestino;}

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        EnlaceListAdapter.ViewHolder holder = new EnlaceListAdapter.ViewHolder();
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtViewEnalce = row.findViewById(R.id.txtViewEnalce);
            holder.textViewNodoOrigen = row.findViewById(R.id.textViewNodoOrigen);
            holder.textViewNodoDestino = row.findViewById(R.id.textViewNodoDestino);
            row.setTag(holder);
        }
        else {
            holder = (EnlaceListAdapter.ViewHolder) row.getTag();
        }
        Enlace enlace = EnlaceList.get(position);
        holder.txtViewEnalce.setText(enlace.getAtributoEnlace());
        holder.textViewNodoOrigen.setText((String.valueOf(enlace.getOrigenEnlace())));
        holder.textViewNodoDestino.setText((String.valueOf(enlace.getDestinoEnlace())));
        return row;
    }
}

