package com.example.prabh.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.prabh.recycler_view.R.drawable.dog;

/**
 * Created by prabh on 14-04-2016.
 */

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {
    Context context;
    ArrayList<Information> data;
    LayoutInflater inflater;
    int prepos = 0;

    //---------- It is for initilising data---------//
    public MyCustomAdapter(Context context, ArrayList<Information> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);    //--initialization of layput inflater
    }

    //----------return mycustomadapter view holder class------//
    @Override
    public MyCustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_item_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    //------ it call for each of the row in recy view---------//
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.textview.setText(data.get(position).title);
        holder.imageView.setImageResource(data.get(position).imageId);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Detail.class);
                context.startActivity(i);
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        if (position > prepos) {

            AnimationUtil.animate(holder, true);

        } else {

            AnimationUtil.animate(holder, false);
        }

    }

    // -----------this getitemcount return length of our data set---------//
    @Override
    public int getItemCount() {

        return data.size();
    }

    //-----------view holder class---------------//
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textview;
        ImageView imageView;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.txt_row);
//            itemView.setOnClickListener(this);
            imageView = (ImageView) itemView.findViewById(R.id.img_row);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }

//                @Override
//                public void onClick(View v) {
//                int position = getAdapterPosition();
//                    Intent i = new Intent(context,Detail.class);
//                    context.startActivity(i);
//
//
//                }
    }


}
