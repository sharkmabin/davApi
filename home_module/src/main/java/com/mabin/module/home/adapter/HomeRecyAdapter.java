package com.mabin.module.home.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.mabin.module.home.data.MovieData;
import com.mabin.module.home.viewholder.HomeMovieViewHolder;
import com.main.home.R;

public class HomeRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MovieData movieData;
    private String type4;

    private static final int MOVIE = 0;

    public HomeRecyAdapter(MovieData movieData, String type4) {
        this.movieData = movieData;
        this.type4 = type4;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = null;
        if (viewType == MOVIE) {
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_vedio_item_layout, viewGroup, false);
        }
        return new HomeMovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int i) {
        MovieData.DataBean.ItemsBean itemsBean = movieData.getData().getItems().get(i);
        int type = getItemViewType(i);

        HomeMovieViewHolder movieViewHolder = null;

        if (type == MOVIE) {
            movieViewHolder = (HomeMovieViewHolder) holder;
            Glide.with(movieViewHolder.mThumb.getContext())
                    .load(itemsBean.getImg().replace("type4", type4))
                    .placeholder(android.R.color.darker_gray)
                    .into(movieViewHolder.mThumb);
            movieViewHolder.mTitle.setText(itemsBean.getCollection().getName());
            movieViewHolder.mPosition = i;
        }
    }

    @Override
    public int getItemCount() {
        return movieData.getData().getItems().size();
    }

    @Override
    public int getItemViewType(int position) {
        if (movieData.getData().getItems().size() > position) {
            return MOVIE;
        }
        return super.getItemViewType(position);
    }
}
