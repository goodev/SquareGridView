package org.goodev.squaregrid;

import java.util.ArrayList;
import java.util.List;

import org.goodev.squaregrid.OptimizeGridView.OptimizeGridAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter implements OptimizeGridAdapter<GridAdapter.Item>{
    public static class Item{
        public String text;
        public int resId;
    }

    private List<Item> mItems = new ArrayList<GridAdapter.Item>();
    private Context mContext;
    public GridAdapter(Context context) {
        for (int i = 0; i < 100; i++) {
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
        View press = convertView.findViewById(R.id.press);
        Item item = (Item) getItem(position);
        //解决残影问题，这里判断如果是NULL item则只显示一个白色背景
        if(isNullItem(item)) {
            convertView.setBackgroundResource(R.drawable.grid_bg);
            image.setVisibility(View.INVISIBLE);
            text.setVisibility(View.INVISIBLE);
            press.setVisibility(View.INVISIBLE);
            return convertView;
        }
        image.setVisibility(View.VISIBLE);
        text.setVisibility(View.VISIBLE);
        press.setVisibility(View.VISIBLE);
        convertView.setBackgroundResource(R.drawable.grid_item_border);
        image.setImageResource(item.resId);
        text.setText(item.text);
        return convertView;
    }


    public static Item NULL_ITEM = new Item();
    @Override
    public List<Item> getItems() {
        return mItems;
    }

    @Override
    public void setItems(List<Item> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    @Override
    public Item getNullItem() {
        return NULL_ITEM;
    }

    @Override
    public boolean isNullItem(Item item) {
        return item == NULL_ITEM;
    }


}
