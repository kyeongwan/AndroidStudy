package kr.almostthere.android4.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.almostthere.android4.R;
import kr.almostthere.android4.model.PersonModel;

public class MainActivity extends AppCompatActivity {

    ArrayList<PersonModel> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.lv_main_list);

        personList = new ArrayList<>();                         // 데이터가 담길 Array 선언

        personList.add(new PersonModel(0, "가가가", "222"));
        personList.add(new PersonModel(0, "가가가2", "222"));
        personList.add(new PersonModel(0, "가가가3", "222"));
        personList.add(new PersonModel(0, "가가가4", "222"));

        // 간단한 어뎁터 사용방법
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, stringArrayList);

        // BaseAdapter 사용 방법
        // 어뎁터를 클래스를 따로 분리하여 구현하는 것이 일반적
        // 분리 할 경우 데이터는 생성자를 통해 넘겨준다
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return personList.size();
            }

            @Override
            public PersonModel getItem(int i) {
                return personList.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View convertView, ViewGroup viewGroup) {

                if (convertView == null) {
                    LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.item_listview, viewGroup, false);
                }

                ImageView iv = (ImageView) convertView.findViewById(R.id.iv_item);
                Button bt = (Button) convertView.findViewById(R.id.bt_item);
                TextView tv = (TextView) convertView.findViewById(R.id.tv_item);

                tv.setText(personList.get(i).getName());

                return convertView;
            }
        };

        // 어뎁터 바인딩
        list.setAdapter(baseAdapter);
    }

}
