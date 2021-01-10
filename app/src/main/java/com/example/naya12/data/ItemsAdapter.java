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



}
