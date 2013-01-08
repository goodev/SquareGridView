package org.goodev.squaregrid;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter{
    public static class Item{
        public String text;
        public int resId;
    }

    private List<Item> mItems = new ArrayList<GridAdapter.Item>();
    private Context mContext;
    public GridAdapter(Context context) {
        //测试数据
        for (int i = 0; i < 50; i++) {
            Item object = new Item();
            object.text = "Text "+i;
            object.resId = R.drawable.icon;
            mItems.add(object);
        }
        mContext = context;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);
        }
        ImageView image = (ImageView) convertView.findViewById(R.id.icon);
        TextView text = (TextView) convertView.findViewById(R.id.text);
        Item item = (Item) getItem(position);
        image.setImageResource(item.resId);
        text.setText(item.text);
        return convertView;
    }
}
