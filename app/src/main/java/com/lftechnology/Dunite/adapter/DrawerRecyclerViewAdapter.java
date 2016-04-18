package com.lftechnology.Dunite.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lftechnology.Dunite.R;
import com.lftechnology.Dunite.Dunite;
import com.lftechnology.Dunite.constant.AppConstant;
import com.lftechnology.Dunite.helper.ItemTouchHelperAdapter;
import com.lftechnology.Dunite.helper.ItemTouchHelperViewHolder;
import com.lftechnology.Dunite.helper.OnStartDragListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import timber.log.Timber;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/18/16.
 */

/**
 * RecyclerView Adapter for Drawer Layout
 */
public class DrawerRecyclerViewAdapter extends RecyclerView.Adapter<DrawerRecyclerViewAdapter.ItemViewHolder> {
    private final List<String> mDataset;

    private String mSelectedConversion;
    private UpdateFragmentInMainActivity mainActivity;

    public DrawerRecyclerViewAdapter(String[] dataset, UpdateFragmentInMainActivity mainActivity, String selectedConversion) {
        mDataset = new ArrayList(Arrays.asList(dataset));
        this.mainActivity = mainActivity;
        mSelectedConversion = selectedConversion;
    }

    @Override
    public DrawerRecyclerViewAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawer_recycler_view_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.textView.setText(Html.fromHtml(mDataset.get(position)));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.updateFragment(mDataset.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    /**
     * Simple implementation of a view holder that implements {@link ItemTouchHelperViewHolder}
     */
    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_option);
        }
    }

    public interface UpdateFragmentInMainActivity {
        void updateFragment(String selectedConversion);
    }
}
