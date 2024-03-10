//Assignment 4
//SelectIncomeFragment.java
//Zeke Marshall
package edu.uncc.assignment04.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import edu.uncc.assignment04.MainActivity;
import edu.uncc.assignment04.R;
import edu.uncc.assignment04.Response;

public class SelectIncomeFragment extends Fragment {

    public SelectIncomeFragment() {
        // Required empty public constructor
    }
    Response response;
    public static SelectIncomeFragment newInstance(String param1, String param2) {
        SelectIncomeFragment fragment = new SelectIncomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_select_income, container, false);

        SeekBar seekBar = view.findViewById(R.id.seekBar);
        TextView incomeSeekDescription = view.findViewById(R.id.textViewHouseHoldIncome);

        seekBar.setProgress(0);
        incomeSeekDescription.setText("<$25K");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch(progress){
                    case 0:
                        incomeSeekDescription.setText("<$25K");
                        break;
                    case 1:
                        incomeSeekDescription.setText("$25K to <$50K");
                        break;
                    case 2:
                        incomeSeekDescription.setText("$50K to <$100K");
                        break;
                    case 3:
                        incomeSeekDescription.setText("$100K to <$200K");
                        break;
                    case 4:
                        incomeSeekDescription.setText(">$200K");
                        break;
                    default:
                        incomeSeekDescription.setText("null");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        view.findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String income;

                if (getArguments() != null) {
                    response = (Response) getArguments().getSerializable("response");
                }

                try{
                    if (seekBar.getProgress() == 0){
                        income = "<$25K";
                    }
                    else if (seekBar.getProgress() == 1){
                        income = "$25K to <$50K";
                    }
                    else if (seekBar.getProgress() == 2){
                        income = "$50K to <$100K";
                    }
                    else if (seekBar.getProgress() == 3){
                        income = "$100K to <$200K";
                    }
                    else if (seekBar.getProgress() == 4){
                        income = ">$200K";
                    }
                    else{
                        throw new Exception();
                    }

                    response.setIncome(income);
                    if (getActivity() != null){
                        ((MainActivity)getActivity()).goToDemographicFragment(response);
                    }
                }
                catch (Exception e) {
                    Toast.makeText(getActivity(), "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}