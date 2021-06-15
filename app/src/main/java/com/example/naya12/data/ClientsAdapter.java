package com.example.naya12.data;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageDecoder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.naya12.R;

import java.util.ArrayList;

public class ClientsAdapter extends ArrayAdapter<MyClient> {
    public ClientsAdapter(@NonNull Context context, int resource) {
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
        View v = LayoutInflater.from(getContext()).inflate(R.layout.activity_item, parent, false);
        //3.2 find view by id
        TextView nameI = v.findViewById(R.id.nameI);

        ImageButton imageI = v.findViewById(R.id.imageI);


        //3.3 get the suitable client,object
        MyClient i = getItem(position);

        //3.4 connect the data to the view (view the data using item view)
        nameI.setText(i.getNameClient());

        return v;
        //           imageI
        //tvSubject.setText(task.getSub());
        //           switch (task.getImportant()) {
        //               case 5:
        //                   tvNeccessary.setBackgroundColor(Color.RED);
//                    break;
//                case 4:
//                    tvNeccessary.setBackgroundColor(Color.YELLOW);
//                    break;
//                case 3:
//                    tvNeccessary.setBackgroundColor(Color.CYAN);
//                    break;
//                case 2:
//                    tvNeccessary.setBackgroundColor(Color.MAGENTA);
//                    break;
//                case 1:
//                    tvNeccessary.setBackgroundColor(Color.rgb(0, 200, 0));
//                    break;
//            }
//            switch (task.getNeccessary()) {
//                case 5:
//                    tvImportant.setBackgroundColor(Color.RED);
//                    break;
//                case 4:
//                    tvImportant.setBackgroundColor(Color.YELLOW);
//                    break;
//                case 3:
//                    tvImportant.setBackgroundColor(Color.CYAN);
//                    break;
//                case 2:
//                    tvImportant.setBackgroundColor(Color.MAGENTA);
//                    break;
//                case 1:
//                    tvImportant.setBackgroundColor(Color.rgb(0, 200, 0));
//                    break;
//            }
//            return v;
//        }
//
//    }
    }
}






