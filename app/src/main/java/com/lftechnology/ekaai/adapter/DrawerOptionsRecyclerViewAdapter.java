package com.lftechnology.ekaai.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lftechnology.ekaai.Ekaai;
import com.lftechnology.ekaai.R;
import com.lftechnology.ekaai.constant.AppConstant;
import com.lftechnology.ekaai.helper.ItemTouchHelperAdapter;
import com.lftechnology.ekaai.helper.ItemTouchHelperViewHolder;
import com.lftechnology.ekaai.helper.OnStartDragListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * RecyclerView Adapter for right navigation drawer, to populate different units within a conversion system
 */
public class DrawerOptionsRecyclerViewAdapter extends RecyclerView.Adapter<DrawerOptionsRecyclerViewAdapter.ItemViewHolder> implements ItemTouchHelperAdapter {
    private final List<String> mDataset;
    private final OnStartDragListener mDragStartListener;
    private String mSelectedConversion;

    public DrawerOptionsRecyclerViewAdapter(String[] dataset, OnStartDragListener mDragStartListener, String selectedConversion) {
        mDataset = new ArrayList(Arrays.asList(dataset));
        this.mDragStartListener = mDragStartListener;
        mSelectedConversion = selectedConversion;
    }

    @Override
    public DrawerOptionsRecyclerViewAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawer_right_recycler_view_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.textView.setText(Html.fromHtml(mDataset.get(position)));

        Glide.with(Ekaai.getContext()).load(R.drawable.drag_handle).into(holder.handleView);
        // Start a drag whenever the handle view it touched
        holder.handleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mDataset, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        updateUserPreference();
        return true;
    }

    private void updateUserPreference() {
        Gson gson = new Gson();
        String jsonDataset = gson.toJson(mDataset);
        SharedPreferences sharedPref = Ekaai.getContext().getSharedPreferences(AppConstant.EKAAI, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(mSelectedConversion, jsonDataset);
        editor.apply();
    }

    /**
     * Simple implementation of a view holder that implements {@link ItemTouchHelperViewHolder} and has a
     * "handle" view that initiates a drag event when touched.
     */
    public static class ItemViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

        @Bind(R.id.tv_option)
        TextView textView;

        @Bind(R.id.drag_handle)
        ImageView handleView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.WHITE);
            itemView.getBackground().setAlpha(100);
            textView.setTextColor(Color.BLACK);
            Glide.with(Ekaai.getContext()).load(R.drawable.drag_handle_active).into(handleView);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
            textView.setTextColor(ContextCompat.getColor(Ekaai.getContext(), R.color.colorNavText));
            Glide.with(Ekaai.getContext()).load(R.drawable.drag_handle).into(handleView);
        }
    }

}