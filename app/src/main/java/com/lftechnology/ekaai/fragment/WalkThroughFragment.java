package com.lftechnology.ekaai.fragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.lftechnology.ekaai.Ekaai;
import com.lftechnology.ekaai.R;

public class WalkThroughFragment extends BaseFragment {
    public static final String POSITION = "position";
    private int mPosition;

    public static WalkThroughFragment newInstance(int position) {
        WalkThroughFragment fragment = new WalkThroughFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup mRootView;
        if (mPosition == 0) {
            mRootView = (ViewGroup) inflater.inflate(R.layout.fragment_walk_through_intro, container, false);
            ImageView logo = (ImageView) mRootView.findViewById(R.id.app_icon_in_menu);
            Glide.with(Ekaai.getContext()).load(R.drawable.ekaai_icon).into(logo);
            logo.setBackground(Ekaai.getContext().getResources().getDrawable(R.drawable.swap_btn_cont_blue));
        } else {
            mRootView = (ViewGroup) inflater.inflate(R.layout.fragment_walk_through_demo, container, false);
            VideoView videoView = (VideoView) mRootView.findViewById(R.id.vv_walk_through_demo);
            String path = "android.resource://" + Ekaai.getContext().getPackageName() + "/" + R.raw.ekaai_demo;
            videoView.setVideoURI(Uri.parse(path));
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.setLooping(true);
                }
            });
            videoView.start();
        }
        return mRootView;
    }
}

