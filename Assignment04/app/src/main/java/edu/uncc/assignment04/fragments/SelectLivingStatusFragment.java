//Assignment 4
//SelectLivingStatusFragment.java
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

public class SelectLivingStatusFragment extends Fragment {

    public SelectLivingStatusFragment() {
        // Required empty public constructor
    }
    Response response;
    public static SelectLivingStatusFragment newInstance(String param1, String param2) {
        SelectLivingStatusFragment fragment = new SelectLivingStatusFragment();
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

        View view = inflater.inflate(R.layout.fragment_select_living_status, container, false);

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
                        String living = selectedButton.getText().toString();
                        response.setLivingStatus(living);
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