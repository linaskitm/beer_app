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
    List<Coctail> data;

    // create constructor to initialize context and data sent from SearchActivity
    public Adapter(Context context, List<Coctail> data) {
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
        Coctail current = data.get(position);
        myHolder.drinkName.setText(current.getDrinkName());
        myHolder.drinkTags.setText("Type: " + current.getDrinkTags());
        myHolder.drinkCategory.setText("Category: " + current.getDrinkCategory());
        myHolder.drinkGlass.setText(current.getDrinkGlass());
        myHolder.drinkIngredients1.setText(current.getIngredients1());
        myHolder.drinkIngredients2.setText(current.getIngredients2());
        myHolder.drinkIngredients3.setText(current.getIngredients3());
    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView drinkName;
        TextView drinkTags;
        TextView drinkCategory;
        TextView drinkGlass;
        TextView drinkIngredients1;
        TextView drinkIngredients2;
        TextView drinkIngredients3;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            drinkName = (TextView) itemView.findViewById(R.id.drinkName);
            drinkTags = (TextView) itemView.findViewById(R.id.drinkTags);
            drinkCategory = (TextView) itemView.findViewById(R.id.drinkCategory);
            drinkGlass = (TextView) itemView.findViewById(R.id.drinkGlass);
            drinkIngredients1 = (TextView) itemView.findViewById(R.id.drinkIngredient1);
            drinkIngredients2 = (TextView) itemView.findViewById(R.id.drinkIngredient2);
            drinkIngredients3 = (TextView) itemView.findViewById(R.id.drinkIngredient3);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "You clicked an item " , Toast.LENGTH_SHORT).show();
        }
    }
}
