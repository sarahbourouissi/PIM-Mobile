package com.sourcey.materiallogindemo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.json.JSONException;
import org.json.JSONObject;

import static com.sourcey.materiallogindemo.Users.idd;

public class ConfirmationActivity extends AppCompatActivity {

    SharedPreferences prefs ;
    TextView balance ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);


//        String userId = UserIdStorageFactory.instance().getStorage().get();
//
//
//        BackendlessUser user = Backendless.UserService.findById( userId );
//
//  Toast.makeText(getApplicationContext(), user.getEmail(), Toast.LENGTH_SHORT).show();


        prefs = this.getSharedPreferences(
                "com.example.app", Context.MODE_PRIVATE);
        balance=(TextView)  findViewById(R.id.balance);



        //Getting Intent
        Intent intent = getIntent();


        try {
            JSONObject jsonDetails = new JSONObject(intent.getStringExtra("PaymentDetails"));

            //Displaying payment details
            showDetails(jsonDetails.getJSONObject("response"), intent.getStringExtra("PaymentAmount"));
        } catch (JSONException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void showDetails(JSONObject jsonDetails, String paymentAmount) throws JSONException {

//        String currentUserObjectId = UserIdStorageFactory.instance().getStorage().get();
//        if (!TextUtils.isEmpty(currentUserObjectId)) {
//            Backendless.Data.of(BackendlessUser.class).findById(currentUserObjectId, new AsyncCallback<BackendlessUser>() {
//                @Override
//                public void handleResponse(BackendlessUser response) {
//                    Backendless.UserService.setCurrentUser(response);
//                    Toast.makeText(getApplicationContext(), "haw mawjouuuud 1", Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void handleFault(BackendlessFault fault) {
//                    Toast.makeText(getApplicationContext(), "haw mawjouuuud 1", Toast.LENGTH_SHORT).show();
//                }
//            });
//            if (currentUserObjectId != null)
//                Toast.makeText(getApplicationContext(), "haw mawjouuuud 2", Toast.LENGTH_SHORT).show();
//            else
//                Toast.makeText(getApplicationContext(), "mahouch mawjoud 2", Toast.LENGTH_SHORT).show();
//        }
//
//
//
        if (idd != null ){
        Toast.makeText(getApplicationContext(),idd, Toast.LENGTH_SHORT).show();}




        //Views
        TextView textViewId = (TextView) findViewById(R.id.paymentId);
        TextView textViewStatus= (TextView) findViewById(R.id.paymentStatus);
        TextView textViewAmount = (TextView) findViewById(R.id.paymentAmount);
        Log.e("hhhhhhhhhhhhhhhhh",jsonDetails.toString());

        //Showing the details from json object.
        textViewId.setText(jsonDetails.getString("id"));

        textViewStatus.setText(jsonDetails.getString("state"));
        textViewAmount.setText(paymentAmount+" USD");
        Toast.makeText(getApplicationContext(),paymentAmount, Toast.LENGTH_SHORT).show();
        prefs.edit().putString("balance" , String.valueOf(Float.parseFloat(prefs.getString("balance","0"))
                +Float.parseFloat(paymentAmount))).commit();

/***********************/

        String appVersion = "v1";
        Backendless.initApp( this, "90AAA3BC-7A12-C560-FF51-67F0FF7CDF00", "0D351D4D-340C-4495-FFC5-8D5C28B29A00", appVersion );
       // Backendless.UserService.login( "sarah@backendless.com", "my_super_password", new AsyncCallback<BackendlessUser>()
        BackendlessUser user=Backendless.UserService.CurrentUser(); // I am always get null
      //  {
//            public void handleResponse( BackendlessUser user )
//            {
                // user has been logged in, now user properties can be updated
                user.setProperty( "balance", Integer.parseInt(user.getProperty("balance").toString())+Integer.parseInt(paymentAmount) );
                Backendless.UserService.update( user, new AsyncCallback<BackendlessUser>()
                {
                    public void handleResponse( BackendlessUser user )
                    {
                        // user has been updated
                    }

                    public void handleFault( BackendlessFault fault )
                    {
                        // user update failed, to get the error code call fault.getCode()
                    }
                });
          //  }

//            public void handleFault( BackendlessFault fault )
//            {
//                // login failed, to get the error code call fault.getCode()
//            }
     //   });

 /*********************/
        String balancing = prefs.getString("balance","0");

        balance.setText(balance.getText()+balancing);

    }
}
