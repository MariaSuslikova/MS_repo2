package com.mssslkova.tamagotchi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter
{
    Context context;
    List<RecordEntity> values;
    public MyAdapter(Context context, List<RecordEntity> values)
    {
        //super(context, R.layout.row, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public int getCount()
    {
        return values.size();
    }
    @Override
    public RecordEntity getItem(int position)
    {
        return values.get(position);
    }
    @Override
    public long getItemId(int position)
    {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        RecordEntity recordEntity  = getItem(position);
        TextView name = rowView.findViewById(R.id.name);
        TextView livetime = rowView.findViewById(R.id.livetime);
        name.setText(recordEntity.getName());
        livetime.setText(String.valueOf(recordEntity.getLivetime()));
        return rowView;
    }
}
