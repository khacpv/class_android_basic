package com.androidclass.basic.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.androidclass.basic.R;
import com.androidclass.basic.model.Comic;
import java.util.List;

public class AdvancedAdapter extends ArrayAdapter<Comic> {

    List<Comic> data;

    public AdvancedAdapter(Context context, List<Comic> data) {
        super(context, R.layout.row_comic);
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        Log.e("TAG","position: "+ position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_comic, null, false);
            holder = new ViewHolder();

            holder.thumbnail = (ImageView) convertView.findViewById(R.id.imv_thumbnail);
            holder.title = (TextView) convertView.findViewById(R.id.tv_title);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Comic comic = getItem(position);

        holder.thumbnail.setImageResource(comic.image);
        holder.title.setText(comic.title);
        return convertView;
    }

    @Override
    public Comic getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private static class ViewHolder {
        ImageView thumbnail;

        TextView title;
    }
}
