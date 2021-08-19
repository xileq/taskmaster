package com.myapplicationdev.android.ourndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
    ArrayList<Song> songList;


    ArrayList<String> years;
    ArrayAdapter<String> spinnerAdapter;
    CustomAdapter adapter;
    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(this);
        songList.clear();
        songList.addAll(dbh.getAllSongs());
        adapter.notifyDataSetChanged();

        years.clear();
        years.addAll(dbh.getYears());
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.high){
            DBHelper dbh = new DBHelper(SecondActivity.this);
            songList.clear();
            songList.addAll(dbh.getAllSongsByStars(3));
            adapter.notifyDataSetChanged();
        }
        else if(item.getItemId() == R.id.med){
            DBHelper dbh = new DBHelper(SecondActivity.this);
            songList.clear();
            songList.addAll(dbh.getAllSongsByStars(2));
            adapter.notifyDataSetChanged();

        }
        else if(item.getItemId() == R.id.low){
            DBHelper dbh = new DBHelper(SecondActivity.this);
            songList.clear();
            songList.addAll(dbh.getAllSongsByStars(1));
            adapter.notifyDataSetChanged();

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle(getTitle().toString() + " ~ " + getResources().getText(R.string.title_activity_second));

        lv = (ListView) this.findViewById(R.id.lv);




        DBHelper dbh = new DBHelper(this);
        songList = dbh.getAllSongs();
        years = dbh.getYears();
        dbh.close();

        adapter = new CustomAdapter(this, R.layout.row, songList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                i.putExtra("song", songList.get(position));
                startActivity(i);
            }
        });



    }
}
