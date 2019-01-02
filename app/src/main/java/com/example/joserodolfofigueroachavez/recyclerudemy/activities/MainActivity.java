package com.example.joserodolfofigueroachavez.recyclerudemy.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.joserodolfofigueroachavez.recyclerudemy.model.Movie;
import com.example.joserodolfofigueroachavez.recyclerudemy.adapters.MyAdapter;
import com.example.joserodolfofigueroachavez.recyclerudemy.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
    private List<Movie> movies;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = getAllMovies();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        adapter = new MyAdapter(movies, R.layout.reciclerview_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Movie movie, int position) {
                removeMovie(position);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    private List<Movie> getAllMovies(){
        List<Movie> movie = new ArrayList<>();
        movie.add(new Movie("BenHur", R.drawable.benhur));
        movie.add(new Movie("Deadpool", R.drawable.deadpool));
        movie.add(new Movie("Guardians of Galaxy", R.drawable.guardians));
        movie.add(new Movie("Warcraft", R.drawable.warcraft));
        return movie;

    }

    private void addMovie(int position) {
        movies.add(position, new Movie("New element no. :" + (++counter), R.drawable.newmovie));
        adapter.notifyItemInserted(position);
        llm.scrollToPosition(position);
    }

    private void removeMovie(int position){
        movies.remove(position);
        counter = counter-1;
        adapter.notifyItemRemoved(position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add:
                addMovie(adapter.getItemCount());
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

}
