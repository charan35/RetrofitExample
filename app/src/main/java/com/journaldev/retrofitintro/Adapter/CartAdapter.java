package com.journaldev.retrofitintro.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.journaldev.retrofitintro.CartFetch.Cartfetch;
import com.journaldev.retrofitintro.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>{

    public List<Cartfetch> cart;
    List<Cartfetch> petsFilter;
    private Context context;

    public CartAdapter(List<Cartfetch> cart, Context context) {
        this.cart = cart;
        this.petsFilter = cart;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

//        holder.mName.setText(cart.get(position).get());
//        holder.mSale.setText(Math.toIntExact(cart.get(position).getPrdTot()));
//        holder.mOffer.setText(Math.toIntExact(cart.get(position).getTotalPay()));
//        holder.mSale.setPaintFlags(holder.mSale.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.skipMemoryCache(true);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
        requestOptions.placeholder(R.drawable.ic_notifications_black_24dp);
        requestOptions.error(R.drawable.ic_notifications_black_24dp);

//        Glide.with(context)
//                .asBitmap()
//                .load(cart.get(position).get())
//                .apply(requestOptions)
//                .into(holder.mPicture);

        holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.d(TAG, "onClick: clicked on: " + cart.get(position).getProduct_name());
               /* Intent intent = new Intent(context, ItemActivity.class);
                intent.putExtra("name", pets.get(position).getName());
                intent.putExtra("category", pets.get(position).getCategory());
                intent.putExtra("type", pets.get(position).getType());
                intent.putExtra("price", pets.get(position).getPrice());
                intent.putExtra("desc", pets.get(position).getDescription());
                intent.putExtra("image_url", pets.get(position).getPicture());
                context.startActivity(intent);*/
            }
        });

      /*  holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product itemLabel = cart.get(position);
                cart.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cart.size());
                Toast.makeText(context, "Removed : " + itemLabel, Toast.LENGTH_SHORT).show();
            }
        });

        holder.mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(String.valueOf(holder.mCount.getText()));
                count++;
                holder.mCount.setText("" + count);
            }
        });

        holder.mRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(String.valueOf(holder.mCount.getText()));
                if (count == 1) {
                    holder.mCount.setText("1");
                } else {
                    count -= 1;
                    holder.mCount.setText("" + count);
                }
            }
        });
*/
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView mPicture,mRemove,mAdd;
        private RatingBar mRating;
        private TextView mName, mSale, mOffer, mCount;
        private Button mDelete;
        private RelativeLayout mRowContainer;

        public MyViewHolder(View itemView) {
            super(itemView);
            mPicture = itemView.findViewById(R.id.image);
            mRemove = itemView.findViewById(R.id.remove);
            mAdd = itemView.findViewById(R.id.add);
            mName = itemView.findViewById(R.id.name);
            mSale = itemView.findViewById(R.id.sale_price);
            mOffer = itemView.findViewById(R.id.offer_price);
            mRating = itemView.findViewById(R.id.rating);
            mCount = itemView.findViewById(R.id.count);
            mDelete = itemView.findViewById(R.id.delete);
            mRowContainer = itemView.findViewById(R.id.row_container);

        }
    }
}
