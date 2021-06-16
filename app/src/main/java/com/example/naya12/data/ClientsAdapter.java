package com.example.naya12.data;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.naya12.R;

import java.util.ArrayList;

public class ClientsAdapter extends ArrayAdapter<MyClient>
{
    public ClientsAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    /**\
     * building the single item view
     * @param position index item in the listevew
     * @param convertView item view
     * @param parent listeview
     * @return
     */
    @NonNull
    @Override
    //3. overriding getview
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //3.1
        View v= LayoutInflater.from(getContext()).inflate(R.layout.activity_item,parent,false);
        //3.2 find view by id
        TextView nameI=v.findViewById(R.id.nameI);
        ImageView imageI=v.findViewById(R.id.imageI);
        // 3.3 get the suitable task object
        MyClient client=getItem(position);
        //3.4 connect the data to the view (view the data using item views)
        nameI.setText(client.getNameClient());
        return v;
    }



}
