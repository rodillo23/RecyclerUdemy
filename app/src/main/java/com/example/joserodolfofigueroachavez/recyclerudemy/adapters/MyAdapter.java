package com.example.joserodolfofigueroachavez.recyclerudemy.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joserodolfofigueroachavez.recyclerudemy.R;
import com.example.joserodolfofigueroachavez.recyclerudemy.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Movie> movies;
    private int layout;
    private OnItemClickListener onItemClickListener;

    public MyAdapter(List<Movie> movies, int layout, OnItemClickListener onItemClickListener) {
        this.movies = movies;
        this.layout = layout;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(movies.get(i), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView movieTitle;
        private ImageView moviePoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movieTitle = (TextView) itemView.findViewById(R.id.movieTitle);
            moviePoster = (ImageView) itemView.findViewById(R.id.moviePoster);


        }

        public void bind(final Movie movie, final OnItemClickListener listener){

            movieTitle.setText(movie.getMovieName());
            Picasso.get().load(movie.getMoviePoster()).fit().into(moviePoster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(movie, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Movie movie, int position);
    }
}
