package edu.uncc.assignment05.fragments;

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

import edu.uncc.assignment05.MainActivity;
import edu.uncc.assignment05.R;
import edu.uncc.assignment05.models.User;

public class AddUserFragment extends Fragment implements SelectGenderFragment.OnSelectGenderClickListener, SelectAgeFragment.OnSelectAgeClickListener,
    SelectGroupFragment.OnSelectGroupClickListener, SelectStateFragment.OnSelectStateClickListener{

    private EditText editTextName, editTextEmail;
    private TextView textViewGender, textViewAge, textViewState, textViewGroup;
    private Button btnSelectGender, btnSelectState, btnSelectAge, btnSelectGroup, btnSubmit;
    private String name, email, gender, state, group;
    private int age = -1;
    private final MainActivity mainActivity;

    public AddUserFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextEmail = view.findViewById(R.id.editTextEmail);

        textViewGender = view.findViewById(R.id.textViewGender);
        textViewAge = view.findViewById(R.id.textViewAge);
        textViewState = view.findViewById(R.id.textViewState);
        textViewGroup = view.findViewById(R.id.textViewGroup);

        btnSelectGender = view.findViewById(R.id.buttonSelectGender);
        btnSelectState = view.findViewById(R.id.buttonSelectState);
        btnSelectAge = view.findViewById(R.id.buttonSelectAge);
        btnSelectGroup = view.findViewById(R.id.buttonSelectGroup);
        btnSubmit = view.findViewById(R.id.buttonSubmit);

        btnSelectGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SelectGenderFragment selectGenderFragment = new SelectGenderFragment();
                selectGenderFragment.setSelectGenderClickListener(AddUserFragment.this);

                getParentFragmentManager().beginTransaction()
                        .replace(R.id.rootView, selectGenderFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        btnSelectAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectAgeFragment selectAgeFragment = new SelectAgeFragment();
                selectAgeFragment.setSelectAgeClickListener(AddUserFragment.this);

                getParentFragmentManager().beginTransaction()
                        .replace(R.id.rootView, selectAgeFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        btnSelectGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectGroupFragment selectGroupFragment = new SelectGroupFragment();
                selectGroupFragment.setSelectGroupClickListener(AddUserFragment.this);

                getParentFragmentManager().beginTransaction()
                        .replace(R.id.rootView, selectGroupFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        btnSelectState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectStateFragment selectStateFragment = new SelectStateFragment();
                selectStateFragment.setSelectStateClickListener(AddUserFragment.this);

                getParentFragmentManager().beginTransaction()
                        .replace(R.id.rootView, selectStateFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                if (!(!name.isEmpty() && !email.isEmpty() && gender != null && age != -1 && state != null && group != null)){
                    Toast.makeText(getContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = new User(name, email, gender, age, state, group);

                mainActivity.addNewUser(user);

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (gender != null){
            textViewGender.setText(gender);
        }
        if (age != -1){
            textViewAge.setText(String.valueOf(age));
        }
        if (state != null){
            textViewState.setText(state);
        }
        if (group != null){
            textViewGroup.setText(group);
        }
    }

    @Override
    public void selectGenderClick(String gender) {
        getParentFragmentManager().popBackStack();
        this.gender = gender;
    }

    @Override
    public void selectAgeClick(int age) {
        getParentFragmentManager().popBackStack();
        this.age = age;
    }

    @Override
    public void selectGroupClick(String group) {
        getParentFragmentManager().popBackStack();
        this.group = group;
    }

    @Override
    public void selectStateClick(String state) {
        getParentFragmentManager().popBackStack();
        this.state = state;
    }
}