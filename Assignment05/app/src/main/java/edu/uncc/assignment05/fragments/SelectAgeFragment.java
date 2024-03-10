package edu.uncc.assignment05.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import edu.uncc.assignment05.R;
import edu.uncc.assignment05.models.Data;

public class SelectAgeFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter<Integer> adapter;
    private OnSelectAgeClickListener selectAgeClickListener;

    public SelectAgeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_select_age, container, false);
        Button btnCancel = view.findViewById(R.id.buttonCancel);
        ArrayList<Integer> ageList = new ArrayList<>();

        for(int i = 18; i <= 100; i++){
            ageList.add(i);
        }

        listView = view.findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, ageList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int age = ageList.get(position);
                if (selectAgeClickListener != null){
                    selectAgeClickListener.selectAgeClick(age);
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        return view;
    }
    public interface OnSelectAgeClickListener{
        void selectAgeClick(int age);
    }

    public void setSelectAgeClickListener(AddUserFragment addUserFragment){
        selectAgeClickListener = addUserFragment;
    }
}