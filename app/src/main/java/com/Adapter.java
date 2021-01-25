package com;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<Beer> data;
    public static final String ENTRY = "com.ENTRY";// raktas

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
        myHolder.drinkTagline.setText(current.getDrinkTagline());
        myHolder.drinkFirstBrewed.setText("First Brewed: " + current.getDrinkDescription());
        myHolder.drinkDescription.setText("Description: " + current.getDrinkFirstBrewed());


    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView drinkName;
        TextView drinkTagline;
        TextView drinkFirstBrewed;
        TextView drinkDescription;



        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            drinkName = (TextView) itemView.findViewById(R.id.drinkName);
            drinkTagline = (TextView) itemView.findViewById(R.id.drinkTagline);
            drinkFirstBrewed = (TextView) itemView.findViewById(R.id.drinkFirstBrewed);
            drinkDescription = (TextView) itemView.findViewById(R.id.drinkDescription);

;
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {
            // Intention to go in newEntry window                       from     --------->   to
            Intent goToNewEntryActivity = new Intent(context, NewEntryActivity.class);
            int itemPosition = getAdapterPosition();// grazina konkrecia kortele
            Beer beer = data.get(itemPosition);
            goToNewEntryActivity.putExtra(ENTRY, (Serializable) beer);
            // going to newEntry window, action.
            context.startActivity(goToNewEntryActivity);
        }
    }
}
