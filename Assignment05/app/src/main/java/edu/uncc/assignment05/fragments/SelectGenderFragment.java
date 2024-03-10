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

public class SelectGenderFragment extends Fragment {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private OnSelectGenderClickListener selectGenderClickListener;

    public SelectGenderFragment() {
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
        View view = inflater.inflate(R.layout.fragment_select_gender, container, false);
        Button btnCancel = view.findViewById(R.id.buttonCancel);

        listView = view.findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, Data.genders);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String gender = Data.genders[position];
                if (selectGenderClickListener != null){
                    selectGenderClickListener.selectGenderClick(gender);
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

    public interface OnSelectGenderClickListener{
        void selectGenderClick(String gender);
    }

    public void setSelectGenderClickListener(AddUserFragment addUserFragment){
        selectGenderClickListener = addUserFragment;
    }
}