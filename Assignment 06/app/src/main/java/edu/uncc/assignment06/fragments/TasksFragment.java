//Assignment 6
//TasksFragment.java
//Zeke Marshall
package edu.uncc.assignment06.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import edu.uncc.assignment06.MainActivity;
import edu.uncc.assignment06.R;
import edu.uncc.assignment06.TaskRecyclerAdapter;
import edu.uncc.assignment06.models.Task;

public class TasksFragment extends Fragment {
    private ArrayList<Task> mTasks = new ArrayList<>();
    private TasksListener tasksListener;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private TaskRecyclerAdapter adapter;

    public TasksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTasks = tasksListener.getAllTasks();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        ImageView imageViewAsc = view.findViewById(R.id.imageViewSortAsc);
        ImageView imageViewDec = view.findViewById(R.id.imageViewSortDesc);
        TextView textViewPriority = view.findViewById(R.id.textViewSortIndicator);

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TaskRecyclerAdapter(mTasks, tasksListener);
        recyclerView.setAdapter(adapter);

        Button btnClearAll = view.findViewById(R.id.buttonClearAll);
        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasksListener.clearAllTasks();
                mTasks = tasksListener.getAllTasks();
                adapter.notifyDataSetChanged();
            }
        });

        Button btnAddNew = view.findViewById(R.id.buttonAddNew);
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasksListener.gotoAddTask();
            }
        });

        imageViewAsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortAdapter(1);
                adapter.notifyDataSetChanged();
                textViewPriority.setText("Sort by Priority (ASC)");
            }
        });

        imageViewDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortAdapter(-1);
                adapter.notifyDataSetChanged();
                textViewPriority.setText("Sort by Priority (DESC)");
            }
        });

        return view;
    }

    //TODO: The interface for the TasksFragment
    public interface TasksListener{
        ArrayList<Task> getAllTasks();
        void gotoAddTask();
        void gotoTaskDetails(Task task);
        void clearAllTasks();
        void deleteTask(Task task);
    }

    public void setTasksListener(MainActivity mainActivity){
        tasksListener = mainActivity;
    }

    public void listChanged(){
        mTasks = tasksListener.getAllTasks();
        adapter.notifyDataSetChanged();
    }

    private void sortAdapter(int orderType){
        Collections.sort(this.mTasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return orderType * Integer.compare(t1.getPriority(), t2.getPriority());
            }
        });
    }
}

