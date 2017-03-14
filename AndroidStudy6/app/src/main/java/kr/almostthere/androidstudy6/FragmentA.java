package kr.almostthere.androidstudy6;



import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lk on 2017. 3. 13..
 */
public class FragmentA extends Fragment {

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_a, container, false);
        textView = (TextView) v.findViewById(R.id.fragment_a_tv);
        return v;
    }


    @Override
    public void onStart() {
        super.onStart();


        new MyAsyncTask().execute("987", "1589", "687", "399", "1722", "50");

    }

    public class MyAsyncTask extends AsyncTask<String, Integer, Long> {

        // 이곳에 포함된 code는 AsyncTask가 execute 되자 마자 UI 스레드에서 실행됨.
        // 작업 시작을 UI에 표현하거나
        // background 작업을 위한 ProgressBar를 보여 주는 등의 코드를 작성.

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Background 작업 시작 ");
        }

        @Override
        protected Long doInBackground(String... params) {
            long totalTimeSpent = 0;

            // 인자 개수 파악
            int numberOfParams = params.length;

            for (int i = 0; i < numberOfParams; i++) {
                // 각 인자를 이용한 복잡한 Task 실행함.
                // 예제에서는 인자로 전달된 시간만큼 sleep
                SystemClock.sleep(new Integer(params[i]));
                // background 작업에 걸린시간을 더해 리턴함
                totalTimeSpent += new Long(params[i]);


                // onInBackground(...)에서 publishProgress(...)를 사용하면
                // 자동 호출되는 callback으로
                // 이곳에서 ProgressBar를 증가 시키고, text 정보를 update하는 등의
                // background 작업 진행 상황을 UI에 표현함.

                // onProgressUpdate 를 호출하는 함수
                publishProgress((int)(((i+1)/(float)numberOfParams)*100));
            }
            return totalTimeSpent;

        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            textView.setText(progress[0] + "%");
        }


        @Override
        protected void onPostExecute(Long result) {
            super.onPostExecute(result);

            textView.setText(result + "");

        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

    }
}
