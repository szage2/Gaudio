package com.example.android.gaudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.gaudio.R.drawable.play;
import static com.example.android.gaudio.R.id.playing;
import static com.example.android.gaudio.R.id.songs;

public class Songs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);


        // Find the View that shows the numbers category
        TextView play = (TextView) findViewById(playing);

        // Set a click listener on that View
        play.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(Songs.this, MainActivity.class);
                startActivity(playIntent);
            }
        });

        // Find the View that shows the numbers category
        TextView playlists = (TextView) findViewById(R.id.playlists);

        // Set a click listener on that View
        playlists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playlistsIntent = new Intent(Songs.this, Playlists.class);
                startActivity(playlistsIntent);
            }
        });

        // Find the View that shows the numbers category
        TextView store = (TextView) findViewById(R.id.store);

        // Set a click listener on that View
        store.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent storeIntent = new Intent(Songs.this, Store.class);
                startActivity(storeIntent);
            }
        });

    }
}
