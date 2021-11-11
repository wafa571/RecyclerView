package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
    private LinkedList<String> mRecipe;
    private LayoutInflater mInfalter;
    Intent i;

    class RecipeViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final TextView recipeItemView;
        final RecipeListAdapter mAdapter;

        public RecipeViewHolder(View itemView, RecipeListAdapter adapter) {
            super(itemView);
            recipeItemView = itemView.findViewById(R.id.recipe);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int mPosition = getLayoutPosition();
            Log.d("---------------", Integer.toString(mPosition));
            switch (mPosition) {
                case (1):
                    Intent i = new Intent(v.getContext(), detail1.class);
                    v.getContext().startActivity(i);
                    break;
                case (2):
                    Intent i2 = new Intent(v.getContext(), detail2.class);
                    v.getContext().startActivity(i2);
                    break;


            }


        }

    }

    public RecipeListAdapter(Context context, LinkedList<String> recipelist) {
        mInfalter = LayoutInflater.from(context);
        this.mRecipe = recipelist;
    }

    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInfalter.inflate(R.layout.recipelist_item, parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position) {
        String mCurrent = mRecipe.get(position);
        holder.recipeItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mRecipe.size();
    }


}
