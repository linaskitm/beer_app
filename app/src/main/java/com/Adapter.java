package com;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<Beer> data;

    // create constructor to initialize context and data sent from SearchActivity
    public Adapter(Context context, List<Beer> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_beer, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder = (MyHolder) holder;
        Beer current = data.get(position);
        myHolder.drinkName.setText(current.getDrinkName());
        myHolder.drinkTagline.setText("Type: " + current.getDrinkDescription());
        myHolder.drinkDescription.setText("Category: " + current.getDrinkFirstBrewed());
        myHolder.drinkFirstBrewed.setText(current.getDrinkTagline());

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView drinkName;
        TextView drinkTagline;
        TextView drinkDescription;
        TextView drinkFirstBrewed;


        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            drinkName = (TextView) itemView.findViewById(R.id.drinkName);
            drinkTagline = (TextView) itemView.findViewById(R.id.drinkTags);
            drinkDescription = (TextView) itemView.findViewById(R.id.drinkCategory);
            drinkFirstBrewed = (TextView) itemView.findViewById(R.id.drinkGlass);
;
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "You clicked an item " , Toast.LENGTH_SHORT).show();
        }
    }
}
