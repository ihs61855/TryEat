package com.example.socce.tryeat_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by socce on 2018-05-08.
 */

public class RestaurantListAdapter extends BaseAdapter {
    private Context mContext = null;
    private int mLayout;
    private ArrayList<RestaurantListItem> mList = new ArrayList<RestaurantListItem>();

    private class ViewHolder{
        public ImageView mIcon;
        public TextView mName;
        public TextView mRate;
    }

    public RestaurantListAdapter(Context mContext,int mLayout, ArrayList<RestaurantListItem> mList){
        super();
        this.mContext = mContext;
        this.mLayout=mLayout;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mLayout, null);

            holder.mIcon = (ImageView) convertView.findViewById(R.id.icon);
            holder.mName = (TextView) convertView.findViewById(R.id.name);
            holder.mRate = (TextView) convertView.findViewById(R.id.rate);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        RestaurantListItem item = mList.get(position);

        holder.mIcon.setImageDrawable(item.getmIcon());
        holder.mName.setText(item.getmName());
        holder.mRate.setText(item.getmRate());

        return convertView;
    }

    public void addItem(RestaurantListItem item){
        mList.add(item);
    }
}
