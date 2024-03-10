//Assignment 4
//SelectMaritalStatusFragment.java
//Zeke Marshall
package edu.uncc.assignment04.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.uncc.assignment04.MainActivity;
import edu.uncc.assignment04.R;
import edu.uncc.assignment04.Response;

public class SelectMaritalStatusFragment extends Fragment {

    public SelectMaritalStatusFragment() {
        // Required empty public constructor
    }

    public static SelectMaritalStatusFragment newInstance(String param1, String param2) {
        SelectMaritalStatusFragment fragment = new SelectMaritalStatusFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    Response response;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_marital_status, container, false);

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);

        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        view.findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton selectedButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

                if (getArguments() != null) {
                    response = (Response) getArguments().getSerializable("response");
                }

                try {
                    if (selectedButton != null) {
                        String marital = selectedButton.getText().toString();
                        response.setMaritalStatus(marital);
                    }
                    else {
                        throw new Exception();
                    }

                    if (getActivity() != null){
                        ((MainActivity)getActivity()).goToDemographicFragment(response);
                    }

                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}