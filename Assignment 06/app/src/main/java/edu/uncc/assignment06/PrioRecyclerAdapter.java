//Assignment 6
//PrioRecyclerAdapter.java
//Zeke Marshall
package edu.uncc.assignment06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.uncc.assignment06.fragments.SelectPriorityFragment;

public class PrioRecyclerAdapter extends RecyclerView.Adapter<PrioRecyclerAdapter.PrioViewHolder> {
    private String[] list;
    private static SelectPriorityFragment.PrioListener prioListener;

    public PrioRecyclerAdapter(String[] list, SelectPriorityFragment.PrioListener prioListener) {
        this.list = list;
        PrioRecyclerAdapter.prioListener = prioListener;
    }


    @NonNull
    @Override
    public PrioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selection_list_item, parent, false);
        return new PrioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrioViewHolder holder, int position) {
        holder.prio = list[position];
        holder.textView.setText(holder.prio);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public static class PrioViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        String prio;
        public PrioViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            prio = textView.getText().toString();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prioListener.prioSelected(prio);
                }
            });
        }
    }
}
