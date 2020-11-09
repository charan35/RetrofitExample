package com.journaldev.retrofitintro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.journaldev.retrofitintro.CartFetch.Cartfetch;
import com.journaldev.retrofitintro.CartFetch.Product;
import com.journaldev.retrofitintro.CartFetch.Re;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VolleyActivity extends AppCompatActivity {

    String url = "http://chillkrt.com/Apis/cart_fetch2.php";
    private Button getApiBtn, postApiBtn;
    private TextView resultTextView;
    RequestQueue requestQueue;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        resultTextView = (TextView) findViewById(R.id.resultTextView);
        getApiBtn = (Button) findViewById(R.id.getApiBtn);
        postApiBtn = (Button)findViewById(R.id.postApiBtn);

        // RequestQueue For Handle Network Request
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        //Click Listner for GET JSONObject
        getApiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        //Click Listner for POST JSONObject
        postApiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData();
            }
        });
    }


    public void postData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            //input your API parameters
            object.put("cust_id","C1");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        resultTextView.setText("String Response : "+ response.toString());


                        JSONArray ja_data = null;
                        try {
                            ja_data = response.getJSONArray("res");
                            int length = response.length();
                            for(int i=0; i<length; i++) {
                                JSONObject jsonObj = ja_data.getJSONObject(i);
                                Toast.makeText(VolleyActivity.this, jsonObj.getString("partner_id"), Toast.LENGTH_LONG).show();

                                // getting inner array Ingredients
                                JSONArray ja = jsonObj.getJSONArray("products");
                                int len = ja.length();

                                ArrayList<String> Ingredients_names = new ArrayList<>();
                                for(int j=0; j<len; j++) {
                                    JSONObject json = ja.getJSONObject(j);
                                    Ingredients_names.add(json.getString("name"));
                                    Toast.makeText(VolleyActivity.this, json.getString("name"), Toast.LENGTH_LONG).show();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                      /*  for(int i = 0; i < response.length(); i++){

                            Cartfetch cartfetch = new Cartfetch();
                            List<Re> res= cartfetch.getRes();
                            List<Product> product = res.get(0).getProducts();


                            try {
                                JSONObject jsonObject = response.getJSONObject(String.valueOf(i));
                                Log.e("qwedsaw",jsonObject.toString());


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }


                        try {
                            JSONObject jsonObject = new JSONObject(String.valueOf(response));

                            JSONObject jsonObjectBadges = jsonObject.getJSONObject("res");
                            int Notice = jsonObjectBadges.getInt("cust_id");
                            int Event = jsonObjectBadges.getInt("partner_id");
*//*
                            JSONObject jsonObjectResponse = jsonObject.getJSONObject("Response");
                            int ResponseVal = jsonObjectResponse.getInt("ResponseVal");
                            String Reason = jsonObjectResponse.getString("Reason");*//*

                            Log.e("URL_DATA : ", "Notice : " + Notice  + "\n" +
                                    "Event : " + Event  + "\n");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
*/




                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                resultTextView.setText("Error getting response");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    // Get Request For JSONObject
    public void getData(){
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        try {
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    resultTextView.setText("Resposne : " + response.toString());
                    Toast.makeText(getApplicationContext(), "I am OK !" + response.toString(), Toast.LENGTH_LONG).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}