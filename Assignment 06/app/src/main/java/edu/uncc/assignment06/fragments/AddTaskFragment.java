//Assignment 6
//AddTaskFragment.java
//Zeke Marshall
package edu.uncc.assignment06.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import edu.uncc.assignment06.MainActivity;
import edu.uncc.assignment06.R;
import edu.uncc.assignment06.models.Data;
import edu.uncc.assignment06.models.Task;

public class AddTaskFragment extends Fragment {

    private AddNewListener addNewListener;
    private String category, prio;
    private TextView textViewCategory, textViewPrio;

    public AddTaskFragment() {
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
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);
        textViewCategory = view.findViewById(R.id.textViewCategory);
        textViewPrio = view.findViewById(R.id.textViewPriority);
        EditText editTextName = view.findViewById(R.id.editTextName);

        view.findViewById(R.id.buttonSelectCategory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewListener.goToCategory();
            }
        });

        view.findViewById(R.id.buttonSelectPriority).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewListener.goToPrio();
            }
        });

        view.findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                if (name.isEmpty() || category == null || prio == null){
                    Toast.makeText(getContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                int prioInt = 0;
                if (prio.equals("Very High")){
                    prioInt = 5;
                }
                if (prio.equals("High")){
                    prioInt = 4;
                }
                if (prio.equals("Medium")){
                    prioInt = 3;
                }
                if (prio.equals("Low")){
                    prioInt = 2;
                }
                if (prio.equals("Very Low")){
                    prioInt = 1;
                }
                Task task = new Task(name, category, prio, prioInt);
                addNewListener.submitTask(task);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (category != null){
            textViewCategory.setText(category);
        }
        if (prio != null){
            textViewPrio.setText(prio);
        }
    }

    public interface AddNewListener{
        void goToPrio();
        void goToCategory();
        void submitTask(Task task);
    }

    public void setAddNewListener(MainActivity mainActivity){
        addNewListener = mainActivity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrio(String prio) {
        this.prio = prio;
    }
}