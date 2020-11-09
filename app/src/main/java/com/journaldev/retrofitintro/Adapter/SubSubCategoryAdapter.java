package com.journaldev.retrofitintro.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.journaldev.retrofitintro.R;
import com.journaldev.retrofitintro.pojo.Sub_Sub_Category;

import java.util.List;

public class SubSubCategoryAdapter extends RecyclerView.Adapter<SubSubCategoryAdapter.MyViewHolder>{

    public List<Sub_Sub_Category> subsubcategory;
    List<Sub_Sub_Category> petsFilter;
    private Context context;

    public SubSubCategoryAdapter(List<Sub_Sub_Category> subsubcategory, Context context) {
        this.subsubcategory = subsubcategory;
        this.petsFilter = subsubcategory;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mTitle.setText(subsubcategory.get(position).getSubsubcat_name());

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.skipMemoryCache(true);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
        requestOptions.placeholder(R.drawable.ic_notifications_black_24dp);

        Glide.with(context)
                .asBitmap()
                .load("http://chillkrt.com/admin/"+subsubcategory.get(position).getSubsubcat_img())
                .apply(requestOptions)
                .into(holder.mPicture);

        holder.mRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, subsubcategory.get(position).getSubsubcat_name(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, SubCategoryActivity.class);
//                intent.putExtra("cat_name",subcategory.get(position).getSubcat_name());
//                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return subsubcategory.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView mPicture;
        private TextView mTitle;
        private LinearLayout mRowContainer;

        public MyViewHolder(View itemView) {
            super(itemView);
            mPicture = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.title);
            mRowContainer = itemView.findViewById(R.id.row_container);
        }
    }
}
