package sample.sample_callback1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tw = (TextView)findViewById(R.id.textView);

        // 非同期タスク初期化
        ASyncTaskTest ak = new ASyncTaskTest();

        // コールバック設定
        ak.setOnCallBack(new ASyncTaskTest.CallBackTask() {

            @Override
            public void CallBack(String result) {
                tw.setText(result);
            }
        });
        ak.execute("Sample_Callback1");    // 非同期タスクを実行。
    }
}
