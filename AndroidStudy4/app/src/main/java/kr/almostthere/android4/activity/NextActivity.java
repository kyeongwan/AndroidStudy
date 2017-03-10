package kr.almostthere.android4.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import kr.almostthere.android4.R;
import kr.almostthere.android4.adapter.RecyclerViewAdapter;
import kr.almostthere.android4.model.PersonModel;

/**
 * Created by lk on 2017. 3. 7..
 */

public class NextActivity extends AppCompatActivity {

    LinearLayoutManager mLayoutManager;
    RecyclerViewAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.nextlayout);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // 리사이클러 뷰는 레이아웃 매니저를 사용함
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setHasFixedSize(true);

        // 데이터 선언
        ArrayList<PersonModel> personList = new ArrayList<>();

        personList.add(new PersonModel(0,"가가가", "222"));
        personList.add(new PersonModel(0,"가가가2", "222"));
        personList.add(new PersonModel(0,"가가가3", "222"));
        personList.add(new PersonModel(0,"가가가4", "222"));


        // 어뎁터 선언
        mAdapter = new RecyclerViewAdapter(personList);
        mRecyclerView.setAdapter(mAdapter);
    }

}
