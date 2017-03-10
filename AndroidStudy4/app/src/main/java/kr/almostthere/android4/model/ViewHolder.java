package kr.almostthere.android4.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.almostthere.android4.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public ViewHolder(Context context, ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(R.layout.item_listview, parent, false));

        textView = (TextView) itemView.findViewById(R.id.tv_item);
    }
}