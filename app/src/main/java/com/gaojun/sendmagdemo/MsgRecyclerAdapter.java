package com.gaojun.sendmagdemo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaojun.sendmagdemo.db.User;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/**
 * 消息列表适配器
 *
 * @author Gaojun
 * @time 2019/7/25 10:09
 */
public class MsgRecyclerAdapter extends RecyclerView.Adapter<MsgRecyclerAdapter.ViewHolder> {
    private List<User> userList;

    @NonNull
    @Override
    public MsgRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.adapter_main_item_layout, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MsgRecyclerAdapter.ViewHolder holder, int position) {
        User user = userList.get(position);
        if (user != null) {
            holder.tvTitle.setText(user.name);
            holder.tvAge.setText(user.age);
        }
    }

    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        private TextView tvAge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.main_adapter_item_name_tv);
            tvAge = itemView.findViewById(R.id.main_adapter_item_age_tv);
        }
    }

    public void setDataNotify(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }
}
