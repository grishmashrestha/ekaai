package com.lftechnology.ekaai.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lftechnology.ekaai.Ekaai;
import com.lftechnology.ekaai.R;
import com.lftechnology.ekaai.helper.ItemTouchHelperViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/18/16.
 */

/**
 * RecyclerView Adapter for Drawer Layout
 */
public class DrawerMenuRecyclerViewAdapter extends RecyclerView.Adapter<DrawerMenuRecyclerViewAdapter.ItemViewHolder> {
    private final List<String> mDataset;
    private String mSelectedConversion;

    private UpdateFragmentInMainActivity mainActivity;

    public DrawerMenuRecyclerViewAdapter(String[] dataset, UpdateFragmentInMainActivity mainActivity, String selectedConversion) {
        mDataset = new ArrayList(Arrays.asList(dataset));
        mSelectedConversion = selectedConversion;
        this.mainActivity = mainActivity;
    }

    @Override
    public DrawerMenuRecyclerViewAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawer_left_recycler_view_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        String currentData = mDataset.get(position);
        Glide.with(Ekaai.getContext()).load(getDrawableForCurrentPosition(position)).into(holder.imageView);

        holder.textView.setText(Html.fromHtml(currentData));

        if (mSelectedConversion.equals(currentData)) {
            holder.relativeLayout.setBackgroundResource(R.color.colorPrimary);
            holder.textView.setTextColor(Color.WHITE);
            holder.imageView.setColorFilter(Color.WHITE);

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.updateFragment(mDataset.get(position));
            }
        });
    }

    private int getDrawableForCurrentPosition(int position) {
        int drawable;
        switch (position) {
            case 0:
                drawable = R.drawable.length;
                break;
            case 1:
                drawable = R.drawable.temperature;
                break;
            case 2:
                drawable = R.drawable.time;
                break;
            case 3:
                drawable = R.drawable.volume;
                break;
            case 4:
                drawable = R.drawable.weight;
                break;
            default:
                drawable = R.drawable.length;
        }
        return drawable;
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
        public final ImageView imageView;
        public final RelativeLayout relativeLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_option);
            imageView = (ImageView) itemView.findViewById(R.id.menu_icon);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rl_drawer_left);
        }
    }

    public interface UpdateFragmentInMainActivity {
        void updateFragment(String selectedConversion);
    }
}
