package kr.android.androidstudy7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import kr.android.androidstudy7.R;
import kr.android.androidstudy7.model.UserModel;

/**
 * Created by lk on 2017. 3. 17..
 */

public class UserListAdapter extends BaseAdapter {

    private List<UserModel> list;
    private Context context;

    public UserListAdapter(List<UserModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public UserListAdapter(Context context){
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<UserModel> list){
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvId.setText(list.get(i).getId() + "");
        viewHolder.tvName.setText(list.get(i).getName());
        viewHolder.tvPw.setText(list.get(i).getPw());


        return view;
    }


    public class ViewHolder {

        @Bind(R.id.tv_id)   TextView tvId;
        @Bind(R.id.tv_name) TextView tvName;
        @Bind(R.id.tv_pw)   TextView tvPw;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
