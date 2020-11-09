package com.journaldev.retrofitintro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.journaldev.retrofitintro.pojo.login;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity  {

    EditText mobile;
    Button next;

    APIInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mobile = findViewById(R.id.mobile);
        next = findViewById(R.id.next);

        apiInterface = APIClient.getClient().create(APIInterface.class);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    get_otp();
                }
            }
        });
    }

        private void get_otp(){
            Call<login> call3 = apiInterface.send_otp("+919676513909");
            call3.enqueue(new Callback<login>() {
                @Override
                public void onResponse(Call<login> call, Response<login> response) {
                    Log.e("erroro",response.body().toString());
                    login userList = response.body();
                    String Status = userList.status;
                    String Message = userList.message;
                    String Status_code = userList.status_code;

                    try {
                        login logi;
                        // Log.w("resedatasync", new Gson().toJson(response));
                        logi = response.body();
                        Log.e("errorLog",logi.status);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Log.e("error1",userList.status);


                    List<login.Datum> datumList = userList.data;
                    Log.e("error2",datumList.get(6).phone_number);

                    Toast.makeText(getApplicationContext(), Status + " page\n" + Message + " total\n" + Status_code + " totalPages\n", Toast.LENGTH_SHORT).show();


                    /*if(Status.equals("success")) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }*/

                    for (login.Datum datum : datumList) {
                        Toast.makeText(LoginActivity.this,datum.username,Toast.LENGTH_SHORT).show();
                        Log.e("error3",datum.username);
                    }
                }

                @Override
                public void onFailure(Call<login> call, Throwable t) {
                    call.cancel();
                }
            });
        }


        private boolean validate() {
            if (mobile.getText().toString().isEmpty()) {
                mobile.requestFocus();
                mobile.setError("Enter Mobile Number");
                return false;
            }
            return true;
        }
}