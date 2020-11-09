package com.journaldev.retrofitintro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.journaldev.retrofitintro.Api.ApiClient;
import com.journaldev.retrofitintro.Api.UserService;
import com.journaldev.retrofitintro.pojo.Check_otp;
import com.journaldev.retrofitintro.pojo.login;
import com.journaldev.retrofitintro.pojo.otp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SampleActivity extends AppCompatActivity {

    @BindView(R.id.mobile) EditText mobile;
    @BindView(R.id.get_otp) Button get_otp;

    @BindView(R.id.et_mobile) EditText et_mobile;
    @BindView(R.id.otp) EditText otp;
    @BindView(R.id.type) EditText type;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.device_id) EditText device_id;
    @BindView(R.id.check) Button check;

    String Mobile,etMobile,Otp,Type,Password,Device_id;
    private UserService userService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ButterKnife.bind(this);
        userService = ApiClient.getretrofit().create(UserService.class);


        get_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mobile = mobile.getText().toString();
                get_otp();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etMobile = et_mobile.getText().toString();
                Otp = otp.getText().toString();
                Type = type.getText().toString();
                Password = password.getText().toString();
                Device_id = device_id.getText().toString();
                check_login();
            }
        });
    }

    private void get_otp(){
        Call<otp> call3 = ApiClient.getretrofit().create(UserService.class).send_otp(Mobile);
        call3.enqueue(new Callback<otp>() {
            @Override
            public void onResponse(Call<otp> call, Response<otp> response) {
                Log.e("erroro", response.body().toString());
                otp userList = response.body();
                String Otp =userList.getOTP_IS();
                if(!Otp.equals(""))
                {
                    Toast.makeText(SampleActivity.this, Otp, Toast.LENGTH_SHORT).show();
                    Log.e("qwertyhbgfdsazxvb",Otp);
                }
            }
            @Override
            public void onFailure(Call<otp> call, Throwable t) {
                call.cancel();
            }
        });
    }

    private void check_login(){
        Call<Check_otp> call = ApiClient.getretrofit().create(UserService.class).check_otp(etMobile,Otp,Type,Password,Device_id);
        call.enqueue(new Callback<Check_otp>() {
            @Override
            public void onResponse(Call<Check_otp> call, Response<Check_otp> response) {
                Log.e("erroro", response.body().toString());
                Check_otp userList = response.body();
                String Message =userList.getMessage();
                if(!Message.equals(""))
                {
                    Toast.makeText(SampleActivity.this, Message, Toast.LENGTH_SHORT).show();
                    Log.e("qwertyhbgfdsazxvb",Message);
                }

            }

            @Override
            public void onFailure(Call<Check_otp> call, Throwable t) {
                call.cancel();
            }
        });
    }


}