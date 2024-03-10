//Assignment 4
//MainActivity.java
//Zeke Marshall
package edu.uncc.assignment04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import edu.uncc.assignment04.fragments.DemographicFragment;
import edu.uncc.assignment04.fragments.IdentificationFragment;
import edu.uncc.assignment04.fragments.MainFragment;
import edu.uncc.assignment04.fragments.ProfileFragment;
import edu.uncc.assignment04.fragments.SelectEducationFragment;
import edu.uncc.assignment04.fragments.SelectIncomeFragment;
import edu.uncc.assignment04.fragments.SelectLivingStatusFragment;
import edu.uncc.assignment04.fragments.SelectMaritalStatusFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new MainFragment(), "mainFragment")
                .commit();

    }

    public void goToIdentificationFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new IdentificationFragment())
                .commit();
    }

    public void goToDemographicFragment(Response response){
        DemographicFragment demographicFragment = new DemographicFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("response", response);
        demographicFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, demographicFragment)
                .addToBackStack(null)
                .commit();
    }

    public void goToEducationFragment(Response response){
        SelectEducationFragment educationFragment = new SelectEducationFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("response", response);
        educationFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, educationFragment, "educationFragment")
                .addToBackStack(null)
                .commit();
    }

    public void goToMaritalFragment(Response response){
        SelectMaritalStatusFragment maritalStatusFragment = new SelectMaritalStatusFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("response", response);
        maritalStatusFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, maritalStatusFragment, "maritalFragment")
                .addToBackStack(null)
                .commit();
    }

    public void goToLivingFragment(Response response){
        SelectLivingStatusFragment livingStatusFragment = new SelectLivingStatusFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("response", response);
        livingStatusFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, livingStatusFragment, "livingFragment")
                .addToBackStack(null)
                .commit();
    }

    public void goToIncomeFragment(Response response){
        SelectIncomeFragment incomeFragment = new SelectIncomeFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("response", response);
        incomeFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, incomeFragment, "incomeFragment")
                .addToBackStack(null)
                .commit();
    }

    public void goToProfileFragment(Response response){
        ProfileFragment profileFragment = new ProfileFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("response", response);
        profileFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, profileFragment, "profileFragment")
                .addToBackStack(null)
                .commit();
    }
}