package com.sourcey.materiallogindemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import com.backendless.Backendless;
import com.dshantanu.androidsquareslib.AndroidSquares;


public class MainActivity extends ActionBarActivity   {
//95672068
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        AndroidSquares slot = (AndroidSquares) findViewById(R.id.a);
        AndroidSquares roul = (AndroidSquares) findViewById(R.id.b);
        AndroidSquares black = (AndroidSquares) findViewById(R.id.c);
        AndroidSquares payp = (AndroidSquares) findViewById(R.id.d);


        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        slot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoSlot(v);
            }
        });

        roul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoRoulette(v);
            }
        });

        black.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoBlackjack(v);
            }
        });

        payp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoPaypal(v);
            }
        });


    }


    public void gotoSlot(View v) {
        String currentUserId = Backendless.UserService.CurrentUser().getUserId();
        Toast.makeText(getApplicationContext(), currentUserId, Toast.LENGTH_SHORT).show();

        Context context = getApplicationContext();
        CharSequence text = "Clicked slot :D";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent intentsss = new Intent(this, slotActivity.class);
        startActivity(intentsss);
    }



    public void gotoRoulette(View v) {
        Context context = getApplicationContext();
        CharSequence text = "Clicked roulette :D";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent intentss = new Intent(this, serverActivity.class);
        startActivity(intentss);

    }


public void gotoBlackjack(View v) {
        Context context = getApplicationContext();
        CharSequence text = "Clicked blackjack :D";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();    }


public void gotoPaypal(View v) {
        Context context = getApplicationContext();
        CharSequence text = "Clicked paypal :D";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    Intent intents = new Intent(this, PaypalActivity.class);
    startActivity(intents);

}
        }
