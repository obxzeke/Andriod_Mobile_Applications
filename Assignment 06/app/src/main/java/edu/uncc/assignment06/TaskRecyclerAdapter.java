//Assignment 6
//TaskRecyclerAdapter.java
//Zeke Marshall
package edu.uncc.assignment06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.uncc.assignment06.fragments.TasksFragment;
import edu.uncc.assignment06.models.Task;

public class TaskRecyclerAdapter extends RecyclerView.Adapter<TaskRecyclerAdapter.TaskViewHolder> {
    static ArrayList<Task> tasks;
    private static TasksFragment.TasksListener tasksListener;

    public TaskRecyclerAdapter(ArrayList<Task> tasks, TasksFragment.TasksListener tasksListener){
        this.tasks = tasks;
        this.tasksListener = tasksListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.textViewName.setText(task.getName());
        holder.textViewCategory.setText(task.getCategory());
        holder.textViewPrio.setText(task.getPriorityStr());
        holder.task = task;
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewCategory, textViewPrio;
        ImageView deleteImg;
        Task task;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewCategory = itemView.findViewById(R.id.textViewCategory);
            textViewPrio = itemView.findViewById(R.id.textViewPriority);
            deleteImg = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tasksListener.gotoTaskDetails(task);
                }
            });

            deleteImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tasksListener.deleteTask(task);
                }
            });
        }
    }
}
