//Assignment 6
//CategoryRecyclerAdapter.java
//Zeke Marshall
package edu.uncc.assignment06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.uncc.assignment06.fragments.SelectCategoryFragment;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder> {

    private String[] list;
    private static SelectCategoryFragment.CategoryListener categoryListener;


    public CategoryRecyclerAdapter(String[] list, SelectCategoryFragment.CategoryListener categoryListener) {
        this.list = list;
        CategoryRecyclerAdapter.categoryListener = categoryListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selection_list_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.category = list[position];
        holder.textView.setText(holder.category);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        String category;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            category = textView.getText().toString();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    categoryListener.categorySelected(category);
                }
            });
        }
    }
}
