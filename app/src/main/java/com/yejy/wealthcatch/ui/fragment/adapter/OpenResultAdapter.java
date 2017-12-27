package com.yejy.wealthcatch.ui.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yejy.wealthcatch.R;

/**
 * Created by yejinyun on 2017/12/27.
 */

public class OpenResultAdapter extends RecyclerView.Adapter<OpenResultAdapter.Holder> {
    private static final int[] RES_ID = new int[] {
            R.drawable.icon_launch,
            R.drawable.icon_launch,
            R.drawable.icon_launch,
            R.drawable.icon_launch
    };

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_open_result, parent, false);
        Holder holder = new Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.imageView.setImageResource(RES_ID[position]);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public Holder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView;
        }
    }
}
