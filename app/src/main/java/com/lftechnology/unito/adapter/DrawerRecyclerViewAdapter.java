package com.lftechnology.unito.adapter;

import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lftechnology.unito.R;
import com.lftechnology.unito.helper.ItemTouchHelperAdapter;
import com.lftechnology.unito.helper.ItemTouchHelperViewHolder;
import com.lftechnology.unito.helper.OnStartDragListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/18/16.
 */
public class DrawerRecyclerViewAdapter extends RecyclerView.Adapter<DrawerRecyclerViewAdapter.ViewHolder> implements ItemTouchHelperAdapter {
    private final List<String> mDataset;

    private final OnStartDragListener mDragStartListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_option);
        }
    }

    public DrawerRecyclerViewAdapter(String[] dataset, OnStartDragListener mDragStartListener) {
        mDataset = new ArrayList( Arrays.asList(dataset));
        this.mDragStartListener = mDragStartListener;
    }

    @Override
    public DrawerRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawer_recycler_view_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DrawerRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mDataset, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }
}
