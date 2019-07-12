package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * 作业1：
 * 打印出Activity屏幕切换 Activity会执行什么生命周期？
 */
public class Exercises1 extends AppCompatActivity {

    private static final String TAG = "Exercises1";
    private static final String ON_CREATE = "onCreate() called.\n";
    private static final String ON_START = "onStart() called.\n";
    private static final String ON_RESUME = "onResume() called.\n";
    private static final String ON_PAUSE = "onPause() called.\n";
    private static final String ON_STOP = "onStop() called.\n";
    private static final String ON_DESTROY = "onDestroy() called.\n";
    private static final String KEY_TEXT = "textViewContent";

    private static TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises1);

        textView = findViewById(R.id.textView);

        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(KEY_TEXT, ""));
        }
        Log.d(TAG, ON_CREATE);
        textView.append(ON_CREATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, ON_RESUME);
        textView = findViewById(R.id.textView);
        textView.append(ON_RESUME);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, ON_START);
        textView = findViewById(R.id.textView);
        textView.append(ON_START);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, ON_PAUSE);
        textView = findViewById(R.id.textView);
        textView.append(ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, ON_STOP);
        textView = findViewById(R.id.textView);
        textView.append(ON_STOP);
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, ON_DESTROY);
        textView = findViewById(R.id.textView);
        textView.append(ON_DESTROY);
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        textView = findViewById(R.id.textView);
        savedInstanceState.putString(KEY_TEXT, textView.getText().toString());
    }
}
