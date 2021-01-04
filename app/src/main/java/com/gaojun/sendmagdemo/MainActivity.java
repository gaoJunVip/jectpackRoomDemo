package com.gaojun.sendmagdemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gaojun.sendmagdemo.db.AppDataBase;
import com.gaojun.sendmagdemo.db.Book;
import com.gaojun.sendmagdemo.db.DBThreadUtil;
import com.gaojun.sendmagdemo.db.User;
import com.gaojun.sendmagdemo.db.UserAndBooks;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private TextView tvAdd;

    private TextView tvDelete;

    private RecyclerView mRecyclerView;

    private MsgRecyclerAdapter msgRecyclerAdapter;

    private EditText etAdd;

    private EditText etDelete;

    private String etAddText;

    private String etDeleteText;

    private EditText etBookAdd;

    private String etBookText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListener();
    }

    private void setListener() {
        // 添加一段数据
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAddText = etAdd.getText().toString();
                etBookText = etBookAdd.getText().toString();
                DBThreadUtil.getInstance().executeRunnable(new Runnable() {
                    @Override
                    public void run() {
                        User user = new User();
                        user.setName(etAddText);
                        user.setAge("18");
                        user.setSex("女");
                        AppDataBase.getInstance(MainActivity.this).studentDao().insertUser(user);
                        ArrayList<Book> books = new ArrayList<>();
                        if (TextUtils.isEmpty(etBookText)) {
                            return;
                        }
                        String[] split = etBookText.split(",");
                        Book book = new Book();
                        book.setBookName(split[0]);
                        book.setPrice("21");
                        book.setUserId(etAddText);
                        Book book1 = new Book();
                        book1.setBookName(split[1]);
                        book1.setPrice("20");
                        book1.setUserId(etAddText);
                        Book book2 = new Book();
                        book2.setBookName(split[2]);
                        book2.setPrice("21");
                        book2.setUserId(etAddText);
                        Book book3 = new Book();
                        book3.setBookName(split[3]);
                        book3.setPrice("21");
                        book3.setUserId(etAddText);
                        books.add(book);
                        books.add(book1);
                        books.add(book2);
                        books.add(book3);
                        AppDataBase.getInstance(MainActivity.this).studentDao().insertBookList(books);
                    }
                });

            }
        });
        // 根据名称删除数据
        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBThreadUtil.getInstance().executeRunnable(new Runnable() {
                    @Override
                    public void run() {
                        etDeleteText = etDelete.getText().toString();
                        AppDataBase.getInstance(MainActivity.this).studentDao().deleteUserByName(etDeleteText);
                    }
                });
            }
        });
    }

    private void findViews() {
        tvAdd = findViewById(R.id.tv_add);
        etBookAdd = findViewById(R.id.et_book_add);
        tvDelete = findViewById(R.id.tv_delete);
        mRecyclerView = findViewById(R.id.msg_recyclerView);
        etAdd = findViewById(R.id.et_add);
        etDelete = findViewById(R.id.et_delete);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        msgRecyclerAdapter = new MsgRecyclerAdapter();
        mRecyclerView.setAdapter(msgRecyclerAdapter);
        AppDataBase.getInstance(MainActivity.this).studentDao().loadUserWithBooks().observe(this, new Observer<List<UserAndBooks>>() {
            @Override
            public void onChanged(List<UserAndBooks> userAndBooks) {
                Log.e("--->", "loadUserWithBooks");
                msgRecyclerAdapter.setDataBookListNotify(userAndBooks);
            }
        });
    }
}
