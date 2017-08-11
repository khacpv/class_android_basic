package com.androidclass.basic;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.androidclass.basic.adapter.AdvancedAdapter;
import com.androidclass.basic.model.Comic;
import java.util.ArrayList;
import java.util.List;

public class AdvancedListActivity extends Activity {

    List<Comic> data;

    ListView listView;

    AdvancedAdapter mAdvancedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_list);

        listView = (ListView) findViewById(R.id.list_view);

        data = new ArrayList<Comic>();
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

        mAdvancedAdapter = new AdvancedAdapter(this, data);
        listView.setAdapter(mAdvancedAdapter);
    }
}
