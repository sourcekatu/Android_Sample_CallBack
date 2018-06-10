package sample.sample_callback_repeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ASyncTaskTest.CallBackTask, View.OnClickListener {
    TextView tw;
    ASyncTaskTest ak = new ASyncTaskTest();
    Button button;
    Integer ii = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tw = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button2);

        // クリアボタンセット。
        button.setOnClickListener(this);

        // コールバック設定
        ak.setOnCallBack(this);
        ak.execute(String.valueOf(ii)); // 非同期タスクを実行。
    }

    // 非同期タスクのコールバックが呼ばれるたびに処理を行う。
    @Override
    public void CallBack(String result) {
        tw.setText(result);

        ii++;

        // 再度非同期タスク設定して実行。
        ak = new ASyncTaskTest();
        ak.setOnCallBack(this);
        ak.execute(String.valueOf(ii));
    }

    @Override
    public void onClick(View v) {
        ii = 0;
        tw.setText(String.valueOf(ii));
    }
}
