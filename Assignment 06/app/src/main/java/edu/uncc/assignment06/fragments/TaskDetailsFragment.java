//Assignment 6
//TaskDetailsFragment.java
//Zeke Marshall
package edu.uncc.assignment06.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import edu.uncc.assignment06.MainActivity;
import edu.uncc.assignment06.R;
import edu.uncc.assignment06.models.Task;

public class TaskDetailsFragment extends Fragment {
    private Task task;
    private TaskDetailsListener taskDetailsListener;

    public TaskDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_details, container, false);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewCategory = view.findViewById(R.id.textViewCategory);
        TextView textViewPriority = view.findViewById(R.id.textViewPriority);
        ImageView imageViewDelete = view.findViewById(R.id.imageViewDelete);
        Button btnBack = view.findViewById(R.id.buttonBack);

        textViewName.setText(task.getName());
        textViewCategory.setText(task.getCategory());
        textViewPriority.setText(task.getPriorityStr());

        imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskDetailsListener.deleteTaskFromDetailsPage(task);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });


        return view;
    }

    public interface TaskDetailsListener{
        void deleteTaskFromDetailsPage(Task task);
    }

    public void setTaskDetailsListener(MainActivity mainActivity) {
        taskDetailsListener = mainActivity;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}