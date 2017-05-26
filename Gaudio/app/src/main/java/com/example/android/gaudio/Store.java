package com.example.android.gaudio;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.android.gaudio.R.id.playing;
import static com.example.android.gaudio.R.id.songs;


public class Store extends AppCompatActivity {

    private int items = 0;
    private int selected = 0;
    private int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        items = 0;
        selected = 0;
        price = 0;


        // Find the View that shows the numbers category
        TextView song = (TextView) findViewById(songs);

        // Set a click listener on that View
        song.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(Store.this, Songs.class);
                startActivity(songsIntent);
            }
        });


        // Find the View that shows the numbers category
        TextView play = (TextView) findViewById(playing);

        // Set a click listener on that View
        play.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(Store.this, MainActivity.class);
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
                Intent playlistsIntent = new Intent(Store.this, Playlists.class);
                startActivity(playlistsIntent);
            }
        });


        // Set a click listener on a View to count selected items
        final CheckBox resultOneListner = (CheckBox) findViewById(R.id.result_1);
        resultOneListner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (resultOneListner.isChecked()) {
                    selected += 1;
                }
            }
        });

        // Set a click listener on a View to count selected items
        final CheckBox resultTwoListner = (CheckBox) findViewById(R.id.result_2);
        resultTwoListner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (resultTwoListner.isChecked()) {
                    selected += 1;
                }
            }
        });

        // Set a click listener on a View to count selected items
        final CheckBox resultThreeListner = (CheckBox) findViewById(R.id.result_3);
        resultThreeListner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (resultThreeListner.isChecked()) {
                    selected += 1;
                }
            }
        });

        // Set a click listener on a View to add item to cart
        final Button addToCart = (Button) findViewById(R.id.add_to_cart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items += selected;
                price = items * 3;
                Toast.makeText(Store.this, "You have " + items + " item(s) in cart", Toast.LENGTH_LONG).show();
                selected =0;
            }
        });

        // Set a click listener on a View to delete item from cart
        Button deleteItem = (Button) findViewById(R.id.delete);
        deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected > items){
                    items = 0;
                    price = items * 3;
                    Toast.makeText(Store.this, "You have " + items + " item(s) in cart", Toast.LENGTH_LONG).show();
                    selected =0;
                }else{
                    items -= selected;
                    price = items * 3;
                    Toast.makeText(Store.this, "You have " + items + " item(s) in cart", Toast.LENGTH_LONG).show();
                    selected =0;
                }

            }
        });

        // Set a click listener on a View to show number of items & price
        ImageView cart = (ImageView) findViewById(R.id.cart_status);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Store.this, "You have " + items + " item(s) in cart. Cost: $" + price, Toast.LENGTH_LONG).show();
            }
        });
    }
}
