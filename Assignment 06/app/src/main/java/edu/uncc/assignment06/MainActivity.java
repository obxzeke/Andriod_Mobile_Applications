//Assignment 6
//MainActivity.java
//Zeke Marshall
package edu.uncc.assignment06;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import edu.uncc.assignment06.fragments.AddTaskFragment;
import edu.uncc.assignment06.fragments.SelectCategoryFragment;
import edu.uncc.assignment06.fragments.SelectPriorityFragment;
import edu.uncc.assignment06.fragments.TaskDetailsFragment;
import edu.uncc.assignment06.fragments.TasksFragment;
import edu.uncc.assignment06.models.Data;
import edu.uncc.assignment06.models.Task;

public class MainActivity extends AppCompatActivity implements TasksFragment.TasksListener, AddTaskFragment.AddNewListener,
        SelectCategoryFragment.CategoryListener, SelectPriorityFragment.PrioListener, TaskDetailsFragment.TaskDetailsListener {

    private ArrayList<Task> mTasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTasks.addAll(Data.sampleTestTasks); //adding for testing

        TasksFragment tasksFragment = new TasksFragment();
        tasksFragment.setTasksListener(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootView, tasksFragment, "tasksFragment")
                .commit();
    }

    @Override
    public ArrayList<Task> getAllTasks() {
        return mTasks;
    }

    @Override
    public void gotoAddTask() {
        AddTaskFragment addTaskFragment = new AddTaskFragment();
        addTaskFragment.setAddNewListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, addTaskFragment, "addTaskFrag")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoTaskDetails(Task task) {
        TaskDetailsFragment taskDetailsFragment = new TaskDetailsFragment();
        taskDetailsFragment.setTask(task);
        taskDetailsFragment.setTaskDetailsListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, taskDetailsFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void clearAllTasks() {
        mTasks.clear();
    }

    @Override
    public void deleteTask(Task task) {
        mTasks.remove(task);
        TasksFragment tasksFragment = (TasksFragment) getSupportFragmentManager().findFragmentByTag("tasksFragment");
        tasksFragment.listChanged();
    }

    @Override
    public void goToPrio() {
        SelectPriorityFragment selectPriorityFragment = new SelectPriorityFragment();
        selectPriorityFragment.setPrioListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, selectPriorityFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToCategory() {
        SelectCategoryFragment selectCategoryFragment = new SelectCategoryFragment();
        selectCategoryFragment.setCategoryListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, selectCategoryFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void submitTask(Task task) {
        getSupportFragmentManager().popBackStack();
        mTasks.add(task);
    }

    @Override
    public void categorySelected(String category) {
        AddTaskFragment addTaskFragment = (AddTaskFragment) getSupportFragmentManager().findFragmentByTag("addTaskFrag");
        addTaskFragment.setCategory(category);
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void prioSelected(String prio) {
        AddTaskFragment addTaskFragment = (AddTaskFragment) getSupportFragmentManager().findFragmentByTag("addTaskFrag");
        addTaskFragment.setPrio(prio);
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void deleteTaskFromDetailsPage(Task task) {
        mTasks.remove(task);
        TasksFragment tasksFragment = (TasksFragment) getSupportFragmentManager().findFragmentByTag("tasksFragment");
        tasksFragment.listChanged();
        getSupportFragmentManager().popBackStack();
    }
}