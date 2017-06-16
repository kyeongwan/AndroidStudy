package kr.android.androidstudy13;

import android.util.Log;

/**
 * Created by lk on 2017. 4. 9..
 */

public class ThreadClass extends Thread {

    private long time;
    private String msg;

    /**
     * 생성자
     *
     * @param msg
     */
    public ThreadClass(String msg) {
        this.msg = msg;
        this.time = System.currentTimeMillis();
    }

    @Override
    public void run() {
        try {
            for(int i=0; i<10; i++) {
                Log.e(this.getName(), "Time : " + (System.currentTimeMillis() - time));
                this.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
