package com.example.joserodolfofigueroachavez.recyclerudemy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
    private List<String> names;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getText();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        adapter = new MyAdapter(names, R.layout.reciclerview_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                deleteElement(position);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    private List<String> getText(){
        List<String> names = new ArrayList<>();
        names.add("Chivas");
        names.add("Pumas");
        names.add("America");
        names.add("Atlas");
        names.add("Pachuca");
        names.add("Toluca");
        names.add("Tigres");
        return names;

    }

    private void addElement(int position) {
        names.add(position, "New element no. :" + (++counter));
        adapter.notifyItemInserted(position);
        llm.scrollToPosition(position);
    }

    private void deleteElement(int position){
        names.remove(position);
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
                addElement(adapter.getItemCount());
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

}
