package edu.uncc.assignment05.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import edu.uncc.assignment05.R;
import edu.uncc.assignment05.models.Data;

public class SelectStateFragment extends Fragment {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private SelectStateFragment.OnSelectStateClickListener selectStateClickListener;

    public SelectStateFragment() {
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
        View view = inflater.inflate(R.layout.fragment_select_state, container, false);
        Button btnCancel = view.findViewById(R.id.buttonCancel);

        listView = view.findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, Data.states);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String state = Data.states[position];
                if (selectStateClickListener != null){
                    selectStateClickListener.selectStateClick(state);
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

    public interface OnSelectStateClickListener{
        void selectStateClick(String state);
    }

    public void setSelectStateClickListener(AddUserFragment addUserFragment){
        selectStateClickListener = addUserFragment;
    }
}