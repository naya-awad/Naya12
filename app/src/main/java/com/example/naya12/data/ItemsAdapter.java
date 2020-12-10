package com.example.naya12.data;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.naya12.R;

import java.util.ArrayList;

public class ItemsAdapter extends ArrayAdapter<MyItem>
{
    public ItemsAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    /**
     * \
     * building the single item view
     *
     * @param position    index item in the listView
     * @param convertView item view
     * @param parent      listView
     */
    @NonNull
    @Override
    //3.overriding getView
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        //3.1
        View v = LayoutInflater.from(getContext()).inflate(R.layout.item_task_view, parent, false);
        //3.2 find view by id
        TextView tvTitle = v.findViewById(R.id.itmTvTitle);
        TextView tvImportant = v.findViewById(R.id.itmTvImportant);
        TextView tvNeccessary = v.findViewById(R.id.itmTvNeccessary);
        TextView tvSubject = v.findViewById(R.id.itmTvSubject);

        ImageButton btnDelete = v.findViewById(R.id.itmbtnDelete);
        ImageButton btnCall = v.findViewById(R.id.itmbtnCall);
        ImageButton btnEdit = v.findViewById(R.id.itmbtnEdit);


        //3.3 get the soutable task,object
        MyTask task = getItem(position);

        //3.4 connect the data to the view (view the data using item view)
        tvTitle.setText(task.getTitle());
        tvSubject.setText(task.getSub());



}
