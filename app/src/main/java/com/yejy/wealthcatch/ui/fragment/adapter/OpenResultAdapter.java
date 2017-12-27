package com.yejy.wealthcatch.ui.fragment.adapter;

import android.support.v7.widget.RecyclerView;
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
        ImageView imageView = new ImageView(parent.getContext());
        imageView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        imageView.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        Holder holder = new Holder(imageView);
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
