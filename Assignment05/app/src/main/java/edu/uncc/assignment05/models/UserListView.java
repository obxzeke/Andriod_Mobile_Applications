package edu.uncc.assignment05.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.uncc.assignment05.R;

public class UserListView extends ArrayAdapter<User> {


    public UserListView(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textViewName = convertView.findViewById(R.id.textViewName);
            viewHolder.textViewEmail = convertView.findViewById(R.id.textViewEmail);
            viewHolder.textViewAge = convertView.findViewById(R.id.textViewAge);
            viewHolder.textViewGender = convertView.findViewById(R.id.textViewGender);
            viewHolder.textViewState = convertView.findViewById(R.id.textViewState);
            viewHolder.textViewGroup = convertView.findViewById(R.id.textViewGroup);
            convertView.setTag(viewHolder);
        }

        User user = getItem(position);
        ViewHolder viewHolder = (ViewHolder)convertView.getTag();

        viewHolder.textViewName.setText(user.getName());
        viewHolder.textViewEmail.setText(user.getEmail());
        viewHolder.textViewAge.setText(String.valueOf(user.getAge()));
        viewHolder.textViewGender.setText(user.getGender());
        viewHolder.textViewState.setText(user.getState());
        viewHolder.textViewGroup.setText(user.getGroup());


        return convertView;
    }

    private static class ViewHolder{
        TextView textViewName;
        TextView textViewEmail;
        TextView textViewAge;
        TextView textViewGender;
        TextView textViewState;
        TextView textViewGroup;
    }
}
