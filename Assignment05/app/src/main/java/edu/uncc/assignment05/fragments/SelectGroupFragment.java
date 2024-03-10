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

public class SelectGroupFragment extends Fragment {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private SelectGroupFragment.OnSelectGroupClickListener selectGroupClickListener;

    public SelectGroupFragment() {
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
        View view = inflater.inflate(R.layout.fragment_select_group, container, false);
        Button btnCancel = view.findViewById(R.id.buttonCancel);

        listView = view.findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, Data.groups);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String group = Data.groups[position];
                if (selectGroupClickListener != null){
                    selectGroupClickListener.selectGroupClick(group);
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

    public interface OnSelectGroupClickListener{
        void selectGroupClick(String group);
    }

    public void setSelectGroupClickListener(AddUserFragment addUserFragment){
        selectGroupClickListener = addUserFragment;
    }
}