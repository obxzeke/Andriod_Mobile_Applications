//Assignment 4
//IdentificationFragment.java
//Zeke Marshall
package edu.uncc.assignment04.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import edu.uncc.assignment04.MainActivity;
import edu.uncc.assignment04.R;
import edu.uncc.assignment04.Response;

public class IdentificationFragment extends Fragment {

    public IdentificationFragment() {
        // Required empty public constructor
    }

    public static IdentificationFragment newInstance(String param1, String param2) {
        IdentificationFragment fragment = new IdentificationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_identification, container, false);

        EditText inputName = view.findViewById(R.id.editTextName);
        EditText inputEmail = view.findViewById(R.id.editTextEmail);
        RadioGroup roleGroup = view.findViewById(R.id.radioGroup);

        view.findViewById(R.id.buttonNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = roleGroup.getCheckedRadioButtonId();
                String role = "";
                try{
                    if (checkedId == R.id.radioButtonStudent){
                        role = "Student";
                    }
                    else if (checkedId == R.id.radioButtonEmployee){
                        role = "Employee";
                    }
                    else if (checkedId == R.id.radioButtonOther){
                        role = "Other";
                    }
                    else{
                        throw new Exception();
                    }

                    String name = String.valueOf(inputName.getText());
                    String email = String.valueOf(inputEmail.getText());
                    Response response = new Response(name, email, role);

                    if (getActivity() != null){
                        ((MainActivity)getActivity()).goToDemographicFragment(response);
                    }

                }
                catch (Exception e){
                    Toast.makeText(getActivity(), "Input is not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}