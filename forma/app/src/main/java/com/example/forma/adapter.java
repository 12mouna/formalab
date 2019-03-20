package com.example.forma;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends ArrayAdapter<model> {
    private ArrayList<model> arrayList;
    private Context p ;
    private int item;
    public adapter(@NonNull Context context, int resource, ArrayList<model> liste) {
        super(context, resource, liste);
        this.arrayList = liste;
        this.p = context;
        this.item = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(p).inflate(item,parent,false);
        TextView kathya=convertView.findViewById(R.id.kathya);
        TextView date=convertView.findViewById(R.id.date);
        TextView kadeh=convertView.findViewById(R.id.bkadeh);
        kathya.setText(arrayList.get(position).getSomthg());
        kadeh.setText(arrayList.get(position).getMoney());
        date.setText(arrayList.get(position).getDate());


        return convertView;
    }
}
