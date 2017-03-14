package kr.almostthere.androidstudy6;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class FragmentB extends Fragment {

    TextView textView;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        textView = (TextView) v.findViewById(R.id.textView2);
        return v;

    }


    @Override
    public void onStart() {
        super.onStart();
        try {

            JSONObject jsonObject1 = new JSONObject();


            jsonObject1.put("name", "가가가");
            jsonObject1.put("age", 30);

            textView.setText(jsonObject1.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
//
//    public class TestThread extends AsyncTask<void, void, void>{
//
//        @Override
//        protected void doInBackground(void... voids) {
//
//        }
//    }

}