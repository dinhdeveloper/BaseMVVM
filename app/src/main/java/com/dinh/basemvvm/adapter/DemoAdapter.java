package com.dinh.basemvvm.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dinh.basemvvm.R;
import com.dinh.basemvvm.model.DemoModel;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {
    List<DemoModel> list;
    Context context;

    public DemoAdapter(Context context, List<DemoModel> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_item_demo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DemoModel model = list.get(position);
        if (model != null) {
            if (!TextUtils.isEmpty(model.getImage())) {
                Glide.with(context).load(model.getImage()).error(R.drawable.no_image_full).into(holder.imv_item);
            }
            if (!TextUtils.isEmpty(model.getTitle())) {
                holder.tv_title.setText(model.getTitle());
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imv_item;
        TextView tv_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imv_item = itemView.findViewById(R.id.imv_item);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
