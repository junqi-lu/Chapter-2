package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {

    private List<Item> mItemList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        init();
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ItemAdapter mAdapter = new ItemAdapter(this, mItemList);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setMyClickListener(new ItemAdapter.MyClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(Exercises3.this, ChatroomActivity.class);
                intent.putExtra(ChatroomActivity.EXSTRA_INDEX, position);
                startActivity(intent);
            }
        });

    }

    private void init() {
        for (int i = 0; i < 10; i++) {
            Item item = new Item(R.drawable.icon_girl, R.drawable.im_icon_notice_official,
                    "this is description", "this is title", "this is time");
            mItemList.add(item);
        }
    }
}