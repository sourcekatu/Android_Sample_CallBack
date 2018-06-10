package sample.sample_callback2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ASyncTaskTest.CallBackTask{
    TextView tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tw = (TextView)findViewById(R.id.textView);

        // 非同期タスク初期化
        ASyncTaskTest ak = new ASyncTaskTest();

        // コールバック設定
        ak.setOnCallBack(this);

        ak.execute("Sample_CallBack2");    // 非同期タスクを実行。
    }

    @Override
    public void CallBack(String result) {
        tw.setText(result);
    }
}
