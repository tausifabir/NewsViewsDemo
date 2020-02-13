package com.example.newsviewsdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.newsviewsdemo.Adapter.NewsAdapter;
import com.example.newsviewsdemo.Newsapi.NewsResponse;
import com.example.newsviewsdemo.Newsapi.NewsService;
import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    public  static final String baseUrl ="https://newsapi.org/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        drawerLayout = findViewById(R.id.drawerID);
        recyclerView = findViewById(R.id.newsRecyclerView);
        NavigationView navigationView = findViewById(R.id.navigationID);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setNavigationItemSelectedListener(this);
        drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                R.string.navi_open,
                R.string.navi_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NewsService newsService = RetrofitClient.getClient(baseUrl)
                .create(NewsService.class);


        newsService.getNewsResponse()
                .enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                        if(response.isSuccessful()){
                            NewsResponse newsResponse= response.body();
                            LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(MainActivity.this);
                            adapter = new NewsAdapter(MainActivity.this,newsResponse);
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(adapter);


                         Toast.makeText(MainActivity.this, ""+response.body().getArticles().size(), Toast.LENGTH_SHORT).show();
                           // Toast.makeText(MainActivity.this, ""+response.body().getArticles().get(1).getTitle(), Toast.LENGTH_SHORT).show();
                            //Toast.makeText(MainActivity.this, ""+response.body().getArticles().get(1).getContent(), Toast.LENGTH_SHORT).show();
                           // Toast.makeText(MainActivity.this, ""+response.body().getArticles().get(1).getPublishedAt(), Toast.LENGTH_SHORT).show();
                           // Toast.makeText(MainActivity.this, ""+response.body().getArticles().get(1).getUrl(), Toast.LENGTH_SHORT).show();*/
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable throwable) {

                        Log.e("onFailure: ", throwable.getLocalizedMessage());
                    }
                });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }



    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {




        if(drawerToggle.onOptionsItemSelected(item)){
            return  true;
        }

        switch (item.getItemId()){
            case R.id.refresh:
                Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        if(item.getItemId()==R.id.login){
            Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();

        }
        else if(item.getItemId()==R.id.Home){
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.about){
            Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,About.class);
        }
        else if(item.getItemId()==R.id.exit){
            Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
        }

        int id = item.getItemId();
        item.setChecked(true);
        drawerLayout.closeDrawers();



        return false;
    }



}
