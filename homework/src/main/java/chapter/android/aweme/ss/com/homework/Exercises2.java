package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflate = LayoutInflater.from(this).inflate(R.layout.activity_chatroom, null);
        setContentView(inflate);

        Toast.makeText(this, "" + getViewCount(inflate), Toast.LENGTH_SHORT).show();
    }

    public static int getViewCount(View view) {
        int count = 0;

        if (view == null) {
            return 0;
        }

        if (view instanceof ViewGroup) {
            int childNum = ((ViewGroup) view).getChildCount();
            count += childNum;

            for (int i = 0; i < childNum; i++) {

                count += getViewCount(((ViewGroup) view).getChildAt(i));

            }

        } else {
            return 0;
        }

        return count;
    }
}
