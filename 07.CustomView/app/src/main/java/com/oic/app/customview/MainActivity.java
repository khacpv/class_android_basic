package com.oic.app.customview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimeView timeView = (TimeView) findViewById(R.id.timeView);
        String content = timeView.getText().toString();
    }

    public static boolean isIntentAvailable(Context ctx, Intent intent) {
        final PackageManager mgr = ctx.getPackageManager();
        List<ResolveInfo> list =
            mgr.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    @Override
    public void finish() {
        // Prepare data intent
        Intent data = new Intent();
        data.putExtra("returnKey1", "Swinging on a star. ");
        data.putExtra("returnKey2", "You could be better then you are. ");
        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        super.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returnKey1")) {
                Toast.makeText(this, data.getExtras().getString("returnKey1"), Toast.LENGTH_SHORT).show();
            }
        }

    }

    public class MyActivity extends Activity {

        ListView listView;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String value = (String) listView.getItemAtPosition(position);

                    Toast.makeText(MyActivity.this, value, Toast.LENGTH_SHORT).show();
                }
            });


            Intent startIntent = new Intent(this, MyStartService.class);
            //... do intent.putExtra([your data]) if need
            startService(startIntent);

            Intent stopIntent = new Intent(this, MyStartService.class);
            stopService(stopIntent);
        }

        public class CustomAdapter extends ArrayAdapter<String> {
            public CustomAdapter(Context context, int resource, List<> data){
                super(context, resource, data);
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView,
                @NonNull ViewGroup parent) {
                LayoutInflater inflater = LayoutInflater.from(context).inflate(this.resource, null);
                View itemView = inflater.inflate(this.resource, null, false);
                return itemView;
            }
        }
    }
}
