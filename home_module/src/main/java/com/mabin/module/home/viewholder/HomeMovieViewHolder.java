package com.mabin.module.home.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dueeeke.videocontroller.component.PrepareView;
import com.mabin.module.home.listener.OnItemChildClickListener;
import com.mabin.module.home.listener.OnItemClickListener;
import com.main.home.R;

public class HomeMovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public int mPosition;
    public FrameLayout mPlayerContainer;
    public TextView mTitle;
    public ImageView mThumb;
    public PrepareView mPrepareView;

    private OnItemChildClickListener mOnItemChildClickListener;

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemChildClickListener(OnItemChildClickListener mOnItemChildClickListener) {
        this.mOnItemChildClickListener = mOnItemChildClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public HomeMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        mPlayerContainer = itemView.findViewById(R.id.player_container);
        mTitle = itemView.findViewById(R.id.tv_title);
        mPrepareView = itemView.findViewById(R.id.prepare_view);
        mThumb = mPrepareView.findViewById(R.id.thumb);
        if (mOnItemChildClickListener != null) {
            mPlayerContainer.setOnClickListener(this);
        }
        if (mOnItemClickListener != null) {
            itemView.setOnClickListener(this);
        }
        itemView.setTag(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.player_container) {
            if (mOnItemChildClickListener != null) {
                mOnItemChildClickListener.onItemChildClick(mPosition);
            }
        } else {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(mPosition);
            }
        }
    }
}
