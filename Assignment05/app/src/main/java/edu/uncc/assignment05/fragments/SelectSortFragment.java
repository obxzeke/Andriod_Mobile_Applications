package edu.uncc.assignment05.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import edu.uncc.assignment05.MainActivity;
import edu.uncc.assignment05.R;
import edu.uncc.assignment05.models.User;

public class SelectSortFragment extends Fragment {
    private ArrayList<User> userList;
    private OnSortAllClickListener sortAllClickListener;
    public SelectSortFragment() {
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
        View view = inflater.inflate(R.layout.fragment_select_sort, container, false);
        ImageView imageViewNameAscending = view.findViewById(R.id.imageViewNameAscending);
        ImageView imageViewEmailAscending = view.findViewById(R.id.imageViewEmailAscending);
        ImageView imageViewGenderAscending = view.findViewById(R.id.imageViewGenderAscending);
        ImageView imageViewAgeAscending = view.findViewById(R.id.imageViewAgeAscending);
        ImageView imageViewStateAscending = view.findViewById(R.id.imageViewStateAscending);
        ImageView imageViewGroupAscending = view.findViewById(R.id.imageViewGroupAscending);
        ImageView imageViewNameDescending = view.findViewById(R.id.imageViewNameDescending);
        ImageView imageViewEmailDescending = view.findViewById(R.id.imageViewEmailDescending);
        ImageView imageViewGenderDescending = view.findViewById(R.id.imageViewGenderDescending);
        ImageView imageViewAgeDescending = view.findViewById(R.id.imageViewAgeDescending);
        ImageView imageViewStateDescending = view.findViewById(R.id.imageViewStateDescending);
        ImageView imageViewGroupDescending = view.findViewById(R.id.imageViewGroupDescending);
        Button btnCancel = view.findViewById(R.id.buttonCancel);

        imageViewNameAscending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(1, "name");
                }
            }
        });
        imageViewEmailAscending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(1, "email");
                }
            }
        });
        imageViewGenderAscending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(1, "gender");
                }
            }
        });
        imageViewAgeAscending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(1, "age");
                }
            }
        });
        imageViewStateAscending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(1, "state");
                }
            }
        });
        imageViewGroupAscending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(1, "group");
                }
            }
        });

        imageViewNameDescending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(-1, "name");
                }
            }
        });
        imageViewEmailDescending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(-1, "email");
                }
            }
        });
        imageViewGenderDescending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(-1, "gender");
                }
            }
        });
        imageViewAgeDescending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(-1, "age");
                }
            }
        });
        imageViewStateDescending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(-1, "state");
                }
            }
        });
        imageViewGroupDescending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sortAllClickListener != null){
                    sortAllClickListener.onSortAllClick(-1, "group");
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

    public interface OnSortAllClickListener {
        void onSortAllClick(int orderType, String type);
    }
    public void setOnSortAllClickListener(MainActivity mainActivity){
        sortAllClickListener = mainActivity;
    }
}