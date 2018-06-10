package sample.sample_callback1;

import android.os.AsyncTask;

// AsyncTaskの引数は以下の用途で使用。
// 第一引数：doInBackgroundの引数
// 第二引数：onProgressUpdateの引数
// 第三引数：doInBackgroundの戻り値 and onPostExecuteの引数
public class ASyncTaskTest extends AsyncTask<String, Void, String> {

    private CallBackTask mcallbacktask;

    // バックグラウンドの処理。ここではTextViewの操作はできない。
    @Override
    protected String doInBackground(String... strings) {
        return strings[0];
    }

    // doInBackgroundの処理が終了した後に呼ばれる。ここではTextViewの操作はできる。
    @Override
    protected void onPostExecute(String result) { mcallbacktask.CallBack(result); }

    public void setOnCallBack(CallBackTask t_object)
    {
        mcallbacktask = t_object;
    }

    // コールバック用のインターフェース定義
    interface CallBackTask
    {
        void CallBack(String result);
    }
}
