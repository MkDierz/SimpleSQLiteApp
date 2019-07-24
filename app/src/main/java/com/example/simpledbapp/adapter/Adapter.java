package com.example.simpledbapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.simpledbapp.R;
import com.example.simpledbapp.model.Data;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> item;

    public  Adapter(Activity activity, List<Data> items ){
        this.activity = activity;
        this.item =  items;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int location  ) {
        return item.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertview == null)
            convertview = inflater.inflate(R.layout.list_row, null);

        TextView id = convertview.findViewById(R.id.id);
        TextView name = convertview.findViewById(R.id.name);
        TextView address = convertview.findViewById(R.id.address);

        Data data = (Data) item.get(position);

        id.setText(data.getId());
        name.setText(data.getName());
        address.setText(data.getAddress());

        return convertview;
    }

}


