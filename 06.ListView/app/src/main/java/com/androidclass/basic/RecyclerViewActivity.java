package com.androidclass.basic;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.androidclass.basic.model.Comic;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        List<Comic> data = new ArrayList<Comic>();
        data.add(new Comic(R.drawable.aicap, "Nữ Hoàng Ai Cập"));
        data.add(new Comic(R.drawable.conan, "Thám tử Connan"));
        data.add(new Comic(R.drawable.doraemon, "Doraemon"));
        data.add(new Comic(R.drawable.hesman, "Dũng sĩ Hesman"));
        data.add(new Comic(R.drawable.ironman, "Người sắt"));
        data.add(new Comic(R.drawable.khongloxanh, "Người khổng lồ xanh"));
        data.add(new Comic(R.drawable.mattrang, "Thủy thủ mặt trăng"));
        data.add(new Comic(R.drawable.songoku, "Bảy viên ngọc rồng"));
        data.add(new Comic(R.drawable.aicap, "Nữ Hoàng Ai Cập"));
        data.add(new Comic(R.drawable.conan, "Thám tử Connan"));
        data.add(new Comic(R.drawable.doraemon, "Doraemon"));
        data.add(new Comic(R.drawable.hesman, "Dũng sĩ Hesman"));
        data.add(new Comic(R.drawable.ironman, "Người sắt"));
        data.add(new Comic(R.drawable.khongloxanh, "Người khổng lồ xanh"));
        data.add(new Comic(R.drawable.mattrang, "Thủy thủ mặt trăng"));
        data.add(new Comic(R.drawable.songoku, "Bảy viên ngọc rồng"));
        data.add(new Comic(R.drawable.aicap, "Nữ Hoàng Ai Cập"));
        data.add(new Comic(R.drawable.conan, "Thám tử Connan"));
        data.add(new Comic(R.drawable.doraemon, "Doraemon"));
        data.add(new Comic(R.drawable.hesman, "Dũng sĩ Hesman"));
        data.add(new Comic(R.drawable.ironman, "Người sắt"));
        data.add(new Comic(R.drawable.khongloxanh, "Người khổng lồ xanh"));
        data.add(new Comic(R.drawable.mattrang, "Thủy thủ mặt trăng"));
        data.add(new Comic(R.drawable.songoku, "Bảy viên ngọc rồng"));
        data.add(new Comic(R.drawable.aicap, "Nữ Hoàng Ai Cập"));
        data.add(new Comic(R.drawable.conan, "Thám tử Connan"));
        data.add(new Comic(R.drawable.doraemon, "Doraemon"));
        data.add(new Comic(R.drawable.hesman, "Dũng sĩ Hesman"));
        data.add(new Comic(R.drawable.ironman, "Người sắt"));
        data.add(new Comic(R.drawable.khongloxanh, "Người khổng lồ xanh"));
        data.add(new Comic(R.drawable.mattrang, "Thủy thủ mặt trăng"));
        data.add(new Comic(R.drawable.songoku, "Bảy viên ngọc rồng"));


        mAdapter = new MyAdapter(data);
        mRecyclerView.setAdapter(mAdapter);
    }
}
