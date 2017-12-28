package com.yejy.wealthcatch.ui.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.yejy.wealthcatch.R;

/**
 * Created by yejinyun on 2017/12/27.
 */

public class OpenResultAdapter extends RecyclerView.Adapter<OpenResultAdapter.Holder> {
    private static final int[] RES_ID = new int[] {
            R.drawable.daletou,
            R.drawable.fucai3d,
            R.drawable.pailie3,
            R.drawable.shuangseqiu
    };
    private final static String[] TITLES = new String[]{
            "大乐透",
            "3D福彩",
            "排列3",
            "双色球"
    };

    private final static String[] NUMBERS = new String[]{
            "23 07 28 02 04 | 02 08",
            "0 3 1",
            "3 8 4",
            "07 11 12 13 18 19 | 16"
    };

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_open_result, parent, false);
        Holder holder = new Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.imageView.setImageResource(RES_ID[position]);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QMUIDialog.MessageDialogBuilder messageDialogBuilder = new QMUIDialog.MessageDialogBuilder(view.getContext());
                messageDialogBuilder.setTitle(TITLES[position] + "开奖结果")
                        .setMessage(NUMBERS[position]);
                messageDialogBuilder.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
