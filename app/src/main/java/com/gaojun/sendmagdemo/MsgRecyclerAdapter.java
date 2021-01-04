package com.gaojun.sendmagdemo;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gaojun.sendmagdemo.db.Book;
import com.gaojun.sendmagdemo.db.User;
import com.gaojun.sendmagdemo.db.UserAndBooks;

import java.util.ArrayList;
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

    private List<UserAndBooks> userAndBooksList = new ArrayList<>();

    @NonNull
    @Override
    public MsgRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.adapter_main_item_layout, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MsgRecyclerAdapter.ViewHolder holder, int position) {
        UserAndBooks userAndBooks = this.userAndBooksList.get(position);
        if (userAndBooks != null) {
            holder.tvTitle.setText(userAndBooks.user.getName());
            holder.tvAge.setText(userAndBooks.user.getAge());
            List<Book> bookList = userAndBooks.bookList;
            holder.mListLayout.removeAllViews();
            if (bookList != null && bookList.size() > 0) {
                for (int i = 0; i < bookList.size(); i++) {
                    TextView textView = new TextView(holder.itemView.getContext());
                    textView.setText(bookList.get(i).getBookName());
                    textView.setPadding(5, 5, 5, 5);
                    holder.mListLayout.addView(textView);
                }
            } else {
                Log.e("--->", "bookList == null");
            }
        }
    }

    @Override
    public int getItemCount() {
        return userAndBooksList == null ? 0 : userAndBooksList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        private TextView tvAge;

        private LinearLayout mListLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.main_adapter_item_name_tv);
            tvAge = itemView.findViewById(R.id.main_adapter_item_age_tv);
            mListLayout = itemView.findViewById(R.id.main_adapter_list_layout);
        }
    }

    public void setDataNotify(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    public void setDataBookListNotify(List<UserAndBooks> userAndBooks) {
        userAndBooksList.clear();
        userAndBooksList.addAll(userAndBooks);
        notifyDataSetChanged();
    }
}
