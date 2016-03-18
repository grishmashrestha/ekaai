package com.lftechnology.unito.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lftechnology.unito.R;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/18/16.
 */
public class DrawerRecyclerViewAdapter extends RecyclerView.Adapter<DrawerRecyclerViewAdapter.ViewHolder> {
//    String[] mDataset = {"Grishma Shrestha", "Binod Shrestha", "Rajesh Khadka", "Surhid Amatya", "Shilu Shrestha", "Manas Shrestha", "Grishma Shrestha", "Binod Shrestha", "Rajesh Khadka", "Surhid Amatya", "Shilu Shrestha", "Manas Shrestha"};
    private String mSelectedConversion;
    String[] mDataset;

    public DrawerRecyclerViewAdapter(String[] myDataset) {
        mDataset = myDataset;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_option);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}
