package chapter.android.aweme.ss.com.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChatroomActivity extends AppCompatActivity {

    public static final String EXSTRA_INDEX =
            "chapter.android.aweme.ss.com.homework.index";
    private int mIndex;
    private TextView contentInfoTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        mIndex = getIntent().getIntExtra(EXSTRA_INDEX, 0);
        contentInfoTV = findViewById(R.id.tv_content_info);
        contentInfoTV.setText("this is " + mIndex + " message.");

    }
}
