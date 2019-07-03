package com.example.simplifiedcodingfirebasecrudoperations;

import android.app.Activity;
import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class artistlist extends ArrayAdapter<artist> {
    private Activity context;

    private List<artist> artistList;

public artistlist(Activity context,List<artist>artistList)
{
    super(context,R.layout.holder,artistList);
    this.context=context;
    this.artistList=artistList;
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listviewItem=inflater.inflate(R.layout.holder,null,true);
        TextView t1=(TextView)listviewItem.findViewById(R.id.textView);
        TextView t2=(TextView)listviewItem.findViewById(R.id.textView2);
        artist a=artistList.get( position);
        t1.setText(a.getArtistname());
        t2.setText(a.getArtistgenere());
        return listviewItem;
    }
}
