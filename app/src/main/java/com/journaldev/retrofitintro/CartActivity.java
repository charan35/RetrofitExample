package com.journaldev.retrofitintro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.journaldev.retrofitintro.Adapter.CartAdapter;
import com.journaldev.retrofitintro.Api.ApiClient;
import com.journaldev.retrofitintro.Api.UserService;
import com.journaldev.retrofitintro.CartFetch.Cartfetch;
import com.journaldev.retrofitintro.CartFetch.Product;
import com.journaldev.retrofitintro.CartFetch.Re;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {

//    @BindView(R.id.recycler_cart)
//    RecyclerView recycler_cart;
//    private RecyclerView.LayoutManager layoutManager;
//    private CartAdapter adapter;
      UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ButterKnife.bind(this);

        userService = ApiClient.getretrofit().create(UserService.class);

//        recycler_cart = findViewById(R.id.recycler_cart);
//        layoutManager = new LinearLayoutManager(this);
//        recycler_cart.setLayoutManager(layoutManager);
    }

   /* private void getCartItems(){
        Call<Cartfetch> call3 = userService.getCartList("C1");
        call3.enqueue(new Callback<Cartfetch>() {
            @Override
            public void onResponse(Call<Cartfetch> call, Response<Cartfetch> response) {
                Cartfetch userList = response.body();


                List<Re> datumList = userList.getRes();

                for (Re datum : datumList) {
                    List<Product> productList = datum.getProducts();
                    Log.e("weasdcs",datum.getCustId()+datum.getDate()+datum.getPartnerId());

//                    for(Product prod : productList)
//                        Log.e("weasdcs",prod.getName()+prod.getPartnrId());
                }*/
               /* if(Status.equals(100)) {
                    startActivity(new Intent(CartActivity.this, CartActivity.class));
                    Toast.makeText(CartActivity.this, "Otp Sent Successfully", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(CartActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Cartfetch> call, Throwable t) {
                call.cancel();
                System.out.println("----mmmm---onfail---"+t.getMessage());
            }
        });
    }*/


    private void getCartItems(){
        Call<Cartfetch> call = userService.getCartList("C4");
        call.enqueue(new Callback<Cartfetch>() {
            @Override
            public void onResponse(@NotNull Call<Cartfetch> call, Response<Cartfetch> response) {
                Cartfetch userList = response.body();

                Log.e("qwerfcxs", String.valueOf(response.body().getRes()));

                List<Re> datumList = userList.getRes();

                for (Re datum : datumList) {
//                    List<Product> productList = datum.getProducts();
                    Log.e("weasdcs",datum.getCustId()+datum.getDate()+datum.getPartnerId());

//                    for(Product prod : productList)
//                        Log.e("weasdcs",prod.getName()+prod.getPartnrId());
                }
            }

            @Override
            public void onFailure(Call<Cartfetch> call, Throwable t) {
                call.cancel();
                System.out.println("----mmmm---onfail---"+t.getMessage());
            }
        });
    }



    @Override
    protected void onResume() {
        super.onResume();
        getCartItems();
    }
}