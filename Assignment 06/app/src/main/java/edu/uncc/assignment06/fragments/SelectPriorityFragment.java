//Assignment 6
//SelectPriorityFragment.java
//Zeke Marshall
package edu.uncc.assignment06.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uncc.assignment06.CategoryRecyclerAdapter;
import edu.uncc.assignment06.MainActivity;
import edu.uncc.assignment06.PrioRecyclerAdapter;
import edu.uncc.assignment06.R;
import edu.uncc.assignment06.models.Data;

public class SelectPriorityFragment extends Fragment {
    private PrioListener prioListener;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private PrioRecyclerAdapter adapter;


    public SelectPriorityFragment() {
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
        View view = inflater.inflate(R.layout.fragment_select_priority, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PrioRecyclerAdapter(Data.priorities, prioListener);
        recyclerView.setAdapter(adapter);

        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        return view;
    }

    public interface PrioListener{
        void prioSelected(String prio);
    }

    public void setPrioListener(MainActivity mainActivity){
        prioListener = mainActivity;
    }
}