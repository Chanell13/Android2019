package com.example.entregable1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class EnlaceAdapter extends ArrayAdapter <Enlace>{

    Enlace[] enlaces;
    int layout;
    Context context;


    public EnlaceAdapter(Context mContext, Enlace[] enlaces, int layout) {
        super(mContext,R.layout.activity_main,enlaces);
        this.enlaces = enlaces;
        this.layout = layout;
        this.context=mContext;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        convertView=layoutInflater.inflate(R.layout.shortcut_cardview,null);
        ImageView imageViewpicture=convertView.findViewById(R.id.shortcut_picture);
        TextView textViewname=convertView.findViewById(R.id.shortcut_name);
        TextView textViewdescription=convertView.findViewById(R.id.shortcut_description);

        Enlace enlace=enlaces[position];
        if (!enlace.getUrl().isEmpty()) {
            Picasso.get()
                    .load(enlace.getUrl())
                    .placeholder(android.R.drawable.ic_menu_myplaces)
                    .error(android.R.drawable.ic_menu_myplaces)
                    .into(imageViewpicture);
        }


        textViewname.setText(enlaces[position].getNombre());
        textViewdescription.setText(enlaces[position].getDescripción());



        return convertView;
    }

//  class ViewHolder extends Arra{

//  }
}
