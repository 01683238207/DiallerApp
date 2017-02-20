package com.example.ovi.studentinformation;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class SingleRow{
    String titles;
    SingleRow(String titles){
        this.titles=titles;
    }
}
public class MyAdapter extends BaseAdapter {
    ArrayList<SingleRow> list;
    Context context;
    MyAdapter(Context c){
        context=c;
        list=new ArrayList<SingleRow>();
        Resources res=c.getResources();
        String[] titles=res.getStringArray(R.array.titles);
        for (int i=0;i<5;i++){
            try{
                SingleRow s=new SingleRow(titles[i]);
                list.add(s);
            }
            catch (Exception e){}
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row,viewGroup,false);
        TextView title= (TextView) row.findViewById(R.id.id);


        SingleRow temp=list.get(i);
        title.setText(temp.titles);
        return row;
    }
}
