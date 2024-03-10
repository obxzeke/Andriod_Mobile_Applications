package edu.uncc.assignment05.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

import edu.uncc.assignment05.MainActivity;
import edu.uncc.assignment05.R;
import edu.uncc.assignment05.models.User;
import edu.uncc.assignment05.models.UserListView;

public class UsersFragment extends Fragment {

    public UsersFragment() {
        // Required empty public constructor
    }

    private ArrayList<User> userList;
    ListView listView;
    UserListView adapter;

    private OnClearAllClickListener clearAllClickListener;

    private OnAddNewClickListener addNewClickListener;
    private OnDetailUserClickListener detailUserClickListener;
    private OnSortClickListener sortClickListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            userList = (ArrayList<User>) getArguments().getSerializable("userList");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);

        Button btnClearAll = view.findViewById(R.id.buttonClearAll);
        Button btnAddNew = view.findViewById(R.id.buttonAddNew);
        Button btnSort = view.findViewById(R.id.buttonSort);

        listView = view.findViewById(R.id.listView);
        adapter = new UserListView(getContext(), R.layout.user_list_item, userList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = userList.get(position);
                if (detailUserClickListener != null){
                    detailUserClickListener.onDetailUserClick(user);
                }
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearAllClickListener != null){
                    clearAllClickListener.onClearAllClick();
                }
            }
        });

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addNewClickListener != null){
                    addNewClickListener.onAddNewClick();
                }
            }
        });

        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortClickListener != null){
                    sortClickListener.onSortClick();
                }
            }
        });

        return view;
    }

    public interface OnClearAllClickListener {
        void onClearAllClick();
    }
    public void setOnClearAllClickListener(MainActivity mainActivity){
        clearAllClickListener = mainActivity;
    }

    public interface OnAddNewClickListener{
        void onAddNewClick();
    }

    public void setAddNewClickListener(MainActivity mainActivity){
        addNewClickListener = mainActivity;
    }

    public interface OnDetailUserClickListener{
        void onDetailUserClick(User user);
    }

    public void setOnDetailUserClickListener(MainActivity mainActivity){
        detailUserClickListener = mainActivity;
    }

    public interface OnSortClickListener {
        void onSortClick();
    }
    public void setOnSortClickListener(MainActivity mainActivity){
        sortClickListener = mainActivity;
    }

}