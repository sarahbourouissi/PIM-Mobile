package com.sourcey.materiallogindemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.widget.PopupMenu;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TapisActivity extends AppCompatActivity {

Context context=this;
    final int  b=0;




    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15
    ,button16,button17,button18,button19,button20,button21,button22,button23,button24,button25,button26,button27,button28,button29,button30,button31,button32
            ,button33,button34,button35,button36, buttonred, buttonblack;



   // TextView mresult, win;
    public CountDownTimer timer=null ;
    Boolean clicked = false ;
    Spinner spinner;

    String mybet="" ;
    int chips1=0,chips2=0,chips3=0,chips4=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tapis);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        buttonblack = (Button) findViewById(R.id.black);
        buttonred = (Button) findViewById(R.id.redi);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);
        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);
        button16 = (Button) findViewById(R.id.button16);
        button17 = (Button) findViewById(R.id.button17);
        button18 = (Button) findViewById(R.id.button18);
        button19 = (Button) findViewById(R.id.button19);
        button20 = (Button) findViewById(R.id.button20);
        button21 = (Button) findViewById(R.id.button21);
        button22 = (Button) findViewById(R.id.button22);
        button23 = (Button) findViewById(R.id.button23);
        button24 = (Button) findViewById(R.id.button24);
        button25 = (Button) findViewById(R.id.button25);
        button26 = (Button) findViewById(R.id.button26);
        button27 = (Button) findViewById(R.id.button27);
        button28 = (Button) findViewById(R.id.button28);
        button29 = (Button) findViewById(R.id.button29);
        button30 = (Button) findViewById(R.id.button30);
        button31 = (Button) findViewById(R.id.button31);
        button32 = (Button) findViewById(R.id.button32);
        button33 = (Button) findViewById(R.id.button33);
        button34 = (Button) findViewById(R.id.button34);
        button35 = (Button) findViewById(R.id.button35);
        button36 = (Button) findViewById(R.id.button36);
        button1.setBackgroundColor(Color.TRANSPARENT);
        button2.setBackgroundColor(Color.TRANSPARENT);
        button3.setBackgroundColor(Color.TRANSPARENT);
        button4.setBackgroundColor(Color.TRANSPARENT);
        button5.setBackgroundColor(Color.TRANSPARENT);
        button6.setBackgroundColor(Color.TRANSPARENT);
        button7.setBackgroundColor(Color.TRANSPARENT);
        button8.setBackgroundColor(Color.TRANSPARENT);
        button9.setBackgroundColor(Color.TRANSPARENT);
        button10.setBackgroundColor(Color.TRANSPARENT);
        button11.setBackgroundColor(Color.TRANSPARENT);
        button12.setBackgroundColor(Color.TRANSPARENT);
        button13.setBackgroundColor(Color.TRANSPARENT);
        button14.setBackgroundColor(Color.TRANSPARENT);
        button15.setBackgroundColor(Color.TRANSPARENT);
        button16.setBackgroundColor(Color.TRANSPARENT);
        button17.setBackgroundColor(Color.TRANSPARENT);
        button18.setBackgroundColor(Color.TRANSPARENT);
        button19.setBackgroundColor(Color.TRANSPARENT);
        button20.setBackgroundColor(Color.TRANSPARENT);
        button21.setBackgroundColor(Color.TRANSPARENT);
        button22.setBackgroundColor(Color.TRANSPARENT);
        button23.setBackgroundColor(Color.TRANSPARENT);
        button24.setBackgroundColor(Color.TRANSPARENT);
        button25.setBackgroundColor(Color.TRANSPARENT);
        button26.setBackgroundColor(Color.TRANSPARENT);
        button27.setBackgroundColor(Color.TRANSPARENT);
        button28.setBackgroundColor(Color.TRANSPARENT);
        button29.setBackgroundColor(Color.TRANSPARENT);
        button30.setBackgroundColor(Color.TRANSPARENT);
        button31.setBackgroundColor(Color.TRANSPARENT);
        button32.setBackgroundColor(Color.TRANSPARENT);
        button33.setBackgroundColor(Color.TRANSPARENT);
        button34.setBackgroundColor(Color.TRANSPARENT);
        button35.setBackgroundColor(Color.TRANSPARENT);
        button36.setBackgroundColor(Color.TRANSPARENT);

        buttonred.setBackgroundColor(Color.TRANSPARENT);
      buttonblack.setBackgroundColor(Color.TRANSPARENT);


        new MyClientTask("",0,"getresult").execute() ;
button1.setOnLongClickListener( new View.OnLongClickListener(){


    @Override
    public boolean onLongClick(View view) {
        PopupMenu popup = new PopupMenu(TapisActivity.this, button1);
        //Inflating the Popup using xml file
        popup.getMenuInflater()
                .inflate(R.menu.menu_combinaison, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(
                        TapisActivity.this,
                        "You Clicked : " + item.getTitle(),
                        Toast.LENGTH_SHORT
                ).show();


                return true;}
});  popup.show();   return true;}  } ) ;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chips1=1;

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                     //   addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });



// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();



            }
        });


        buttonblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chips1=1;

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm black ")
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                 clicked=true;
                        mybet="black";
                        //   addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });



// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();



            }
        });



        buttonred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chips1=1;

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm red ")
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        clicked=true;
                        mybet="red";
                        //   addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });



// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();



            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(2);
                chips1=2;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                    //    addChips(chips1);
                        System.out.println("added");
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(3);
                chips1=3;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                      //  addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(4);
                chips1=4;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                      //  addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(5);
                chips1=5;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(6);
                chips1=6;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                    //    addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(7);
                chips1=7;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(8);
                chips1=8;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                       // addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(9);
                chips1=9;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                      //  addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(10);
                chips1=10;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                      //  addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(11);
                chips1=11;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                    //    addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(12);
                chips1=12;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                     //   addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(13);
                chips1=13;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(14);
                chips1=14;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                     //   addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(15);
                chips1=15;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(15);
                chips1=15;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                     //   addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(16);
                chips1=16;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(17);
                chips1=17;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                    //    addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(18);
                chips1=18;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(19);
                chips1=19;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                      //  addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(20);
                chips1=20;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(21);
                chips1=21;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                     //   addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(22);
                chips1=22;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(23);
                chips1=23;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                      //  addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(24);
                chips1=24;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(25);
                chips1=25;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                     //   addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(26);
                chips1=26;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(27);
                chips1=27;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                      //  addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(28);
                chips1=28;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(29);
                chips1=29;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                       // addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(30);
                chips1=30;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(31);
                chips1=31;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                      //  addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(32);
                chips1=32;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(33);
                chips1=33;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                    //    addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(34);
                chips1=34;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(35);
                chips1=35;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                    //    addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(36);
                chips1=36;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("do you confirm "+chips1)
                        .setTitle("Confirm");
// Add the buttons
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        System.out.println("ff");
                        System.out.println(1);
                        addChips(chips1);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();


                dialog.show();
            }
        });
    }


    public void addChips(final int x){

        System.out.println("here");
        StringRequest strReq = new StringRequest(Request.Method.POST,
              "", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        Toast.makeText(getApplicationContext(), "yess ! ", Toast.LENGTH_LONG).show();



                    } else {

                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("number", x+"");



                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(strReq);


    }





    public class clientin extends AsyncTask<Void, Void, Void> {

        String dstAddress;
        int dstPort;
        String response = "";
        String msgToServer;

        clientin(String addr, int port, String msgTo) {
            dstAddress = "192.168.43.1";
            dstPort = 8080;
            msgToServer = msgTo;
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            Socket socket = null;
            DataOutputStream dataOutputStream = null;
            DataInputStream dataInputStream = null;

            try {
                socket = new Socket(dstAddress, dstPort);
                dataOutputStream = new DataOutputStream(
                        socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                if (msgToServer != null) {
                    dataOutputStream.writeUTF(msgToServer);
                }

                response = dataInputStream.readUTF();

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "UnknownHostException: " + e.toString();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "IOException: " + e.toString();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
          //  win.setText(response);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    new AlertDialog.Builder(context)
                            .setTitle("Bet Result")
                            .setMessage(response)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {


                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }, 4000);



            super.onPostExecute(result);
        }

    }

    public class MyClientTask extends AsyncTask<Void, Void, Void> {

        String dstAddress;
        int dstPort;
        String response = "";
        String msgToServer;

        MyClientTask(String addr, int port, String msgTo) {
            dstAddress = "192.168.43.1";
            dstPort = 8080;
            msgToServer = msgTo;
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            Socket socket = null;
            DataOutputStream dataOutputStream = null;
            DataInputStream dataInputStream = null;

            try {
                socket = new Socket(dstAddress, dstPort);
                dataOutputStream = new DataOutputStream(
                        socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                if(msgToServer != null){
                    dataOutputStream.writeUTF(msgToServer);
                }

                response = dataInputStream.readUTF();

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "UnknownHostException: " + e.toString();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "IOException: " + e.toString();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
//            mresult.setText(response);
 if (Integer.parseInt(response)==-1) {

     final Handler handler = new Handler();
     handler.postDelayed(new Runnable() {
         @Override
         public void run() {
             new MyClientTask("",0,"getresult").execute() ;
             TapisActivity.this.setTitle(" roulette rolling ...");
         }
     }, 300);

 }
            else {
     TapisActivity.this.runOnUiThread(new Runnable() {

         @Override
         public void run() {
             timer = new CountDownTimer(Integer.parseInt(response) * 1000, 1000) {
                 @Override
                 public void onTick(long l) {
                     TapisActivity.this.setTitle(" time remaining before round " + l / 1000);


                 }


                 @Override
                 public void onFinish() {

                     Random rn = new Random();
                     int range = 20 - 5 + 1;
                     int randomNum = rn.nextInt(range) + 5;

                     final Handler handler1 = new Handler();
                     handler1.postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             //Do something after 100ms

                         }
                     }, randomNum);
                     if (clicked) {
                         new clientin("", 0, mybet).execute();

                     } else {
                         new clientin("", 0, "no").execute();

                     }

                     final Handler handler = new Handler();
                     handler.postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             new MyClientTask("", 0, "getresult").execute();
                         }
                     }, 1000);

                 }
             }.start();


         }
     });

 }

            super.onPostExecute(result);
            Intent i = new Intent(getApplicationContext(), TapisActivity.class);

        }
    }


}
