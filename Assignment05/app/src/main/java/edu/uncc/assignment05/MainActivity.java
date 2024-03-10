package edu.uncc.assignment05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import edu.uncc.assignment05.fragments.AddUserFragment;
import edu.uncc.assignment05.fragments.SelectAgeFragment;
import edu.uncc.assignment05.fragments.SelectGroupFragment;
import edu.uncc.assignment05.fragments.SelectSortFragment;
import edu.uncc.assignment05.fragments.UserDetailsFragment;
import edu.uncc.assignment05.fragments.UsersFragment;
import edu.uncc.assignment05.models.Data;
import edu.uncc.assignment05.models.User;
import edu.uncc.assignment05.models.UserListView;

public class MainActivity extends AppCompatActivity implements UsersFragment.OnClearAllClickListener, UsersFragment.OnAddNewClickListener,
    UsersFragment.OnDetailUserClickListener, UserDetailsFragment.OnDeleteUserClickListener, UsersFragment.OnSortClickListener,
        SelectSortFragment.OnSortAllClickListener {

    private ArrayList<User> userList = Data.sampleTestUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsersFragment usersFragment = new UsersFragment();
        usersFragment.setOnClearAllClickListener(this);
        usersFragment.setAddNewClickListener(this);
        usersFragment.setOnDetailUserClickListener(this);
        usersFragment.setOnSortClickListener(this);

        Bundle bundle = new Bundle();
        bundle.putSerializable("userList", userList);
        usersFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootView, usersFragment)
                .commit();
    }

    @Override
    public void onClearAllClick() {
        userList.clear();

        UsersFragment usersFragment = new UsersFragment();
        usersFragment.setOnClearAllClickListener(this);
        usersFragment.setAddNewClickListener(this);
        usersFragment.setOnDetailUserClickListener(this);
        usersFragment.setOnSortClickListener(this);

        Bundle bundle = new Bundle();
        bundle.putSerializable("userList", userList);
        usersFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, usersFragment)
                .commit();
    }

    @Override
    public void onAddNewClick() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new AddUserFragment(this))
                .addToBackStack(null)
                .commit();
    }

    public void addNewUser(User user){
        getSupportFragmentManager().popBackStack();
        userList.add(user);
    }

    @Override
    public void onDetailUserClick(User user) {
        UserDetailsFragment userDetailsFragment = new UserDetailsFragment();
        userDetailsFragment.setOnDeleteUserClickListener(this);

        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        userDetailsFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, userDetailsFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onDeleteUserClick(User user) {
        getSupportFragmentManager().popBackStack();
        userList.remove(user);
    }

    @Override
    public void onSortClick() {
        SelectSortFragment selectSortFragment = new SelectSortFragment();
        selectSortFragment.setOnSortAllClickListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, selectSortFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onSortAllClick(int orderType, String type) {
        getSupportFragmentManager().popBackStack();

        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                switch (type){
                    case "name":
                        return orderType * u1.getName().compareTo(u2.getName());
                    case "email":
                        return orderType * u1.getEmail().compareTo(u2.getEmail());
                    case "gender":
                        return orderType * u1.getGender().compareTo(u2.getGender());
                    case "age":
                        return orderType * Integer.compare(u1.getAge(), u2.getAge());
                    case "state":
                        return orderType * u1.getState().compareTo(u2.getState());
                    case "group":
                        return orderType * u1.getGroup().compareTo(u2.getName());
                    default:
                        return 0;
                }
            }
        });
    }
}