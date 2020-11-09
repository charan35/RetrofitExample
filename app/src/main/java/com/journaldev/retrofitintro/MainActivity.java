package com.journaldev.retrofitintro;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.journaldev.retrofitintro.pojo.CreateUserResponse;
import com.journaldev.retrofitintro.pojo.MultipleResource;
import com.journaldev.retrofitintro.pojo.User;
import com.journaldev.retrofitintro.pojo.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;

    Button next,tree,navbar,media,sample,cart,volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.responseText);
        next = (Button) findViewById(R.id.next);
        tree = (Button) findViewById(R.id.tree);
        navbar = (Button) findViewById(R.id.navbar);
        media = (Button) findViewById(R.id.media);
        sample = (Button) findViewById(R.id.sample);
        cart = (Button) findViewById(R.id.cart);
        volley = (Button) findViewById(R.id.volley);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
        tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TreeActivity.class));
            }
        });
        navbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
            }
        });
        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MediaActivity.class));
            }
        });

        sample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SampleActivity.class));
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });

        volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,VolleyActivity.class));
            }
        });


        /**
         GET List Resources
         **/
//        Call<MultipleResource> call = apiInterface.doGetListResources();
//        call.enqueue(new Callback<MultipleResource>() {
//            @Override
//            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {
//
//
//                Log.d("TAG",response.code()+"");
//
//                String displayResponse = "";
//
//                MultipleResource resource = response.body();
//                Integer text = resource.page;
//                Integer total = resource.total;
//                Integer totalPages = resource.totalPages;
//                List<MultipleResource.Datum> datumList = resource.data;
//
//                displayResponse += text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n";
//
//                for (MultipleResource.Datum datum : datumList) {
//                    displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
//                }
//
//                responseText.setText(displayResponse);
//
//            }
//
//            @Override
//            public void onFailure(Call<MultipleResource> call, Throwable t) {
//                call.cancel();
//            }
//        });

        /**
         Create new user
         **/
//        User user = new User("morpheus", "leader");
//        Call<User> call1 = apiInterface.createUser(user);
//        call1.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user1 = response.body();
//
//                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                call.cancel();
//            }
//        });

        /**
         GET List Users
         **/
//        Call<UserList> call2 = apiInterface.doGetUserList("2");
//        call2.enqueue(new Callback<UserList>() {
//            @Override
//            public void onResponse(Call<UserList> call, Response<UserList> response) {
//
//                UserList userList = response.body();
//                Integer text = userList.page;
//                Integer total = userList.total;
//                Integer totalPages = userList.totalPages;
//                List<UserList.Datum> datumList = userList.data;
//                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
//
//                for (UserList.Datum datum : datumList) {
//                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<UserList> call, Throwable t) {
//                call.cancel();
//            }
//        });


        /**
         POST name and job Url encoded.
         **/
//        Call<UserList> call3 = apiInterface.doCreateUserWithField("morpheus","leader");
//        call3.enqueue(new Callback<UserList>() {
//            @Override
//            public void onResponse(Call<UserList> call, Response<UserList> response) {
//                UserList userList = response.body();
//                Integer text = userList.page;
//                Integer total = userList.total;
//                Integer totalPages = userList.totalPages;
////                responseText.setText(userList.page.toString());
//                List<UserList.Datum> datumList = userList.data;
//                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
//
//                responseText.setText(datumList.toString());
//
//
//                for (UserList.Datum datum : datumList) {
//                    responseText.setText(datum.id);
//                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<UserList> call, Throwable t) {
//                call.cancel();
//            }
//        });

    }
}
