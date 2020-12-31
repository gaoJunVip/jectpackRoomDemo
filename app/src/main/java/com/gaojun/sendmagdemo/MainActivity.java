package com.gaojun.sendmagdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gaojun.sendmagdemo.db.AppDataBase;
import com.gaojun.sendmagdemo.db.DBThreadUtil;
import com.gaojun.sendmagdemo.db.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvAdd;

    private TextView tvDelete;

    private RecyclerView mRecyclerView;

    private MsgRecyclerAdapter msgRecyclerAdapter;

    private EditText etAdd;

    private EditText etDelete;

    private String etAddText;

    private String etDeleteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListener();
    }

    private void setListener() {
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAddText = etAdd.getText().toString();
                DBThreadUtil.getInstance().executeRunnable(new Runnable() {
                    @Override
                    public void run() {
                        User user = new User(etAddText, "18", "女");
                        AppDataBase.getInstance(MainActivity.this).studentDao().insertUser(user);
                    }
                });
            }
        });
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
        tvDelete = findViewById(R.id.tv_delete);
        mRecyclerView = findViewById(R.id.msg_recyclerView);
        etAdd = findViewById(R.id.et_add);
        etDelete = findViewById(R.id.et_delete);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        msgRecyclerAdapter = new MsgRecyclerAdapter();
        mRecyclerView.setAdapter(msgRecyclerAdapter);
        AppDataBase.getInstance(MainActivity.this).studentDao().getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                msgRecyclerAdapter.setDataNotify(users);
            }
        });
    }
}
