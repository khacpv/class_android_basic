package com.oic.app.a12asyntask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    httpCall("khacpv");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //new Thread(new Runnable() {
        //    @Override
        //    public void run() {
        //        volleyCall("khacpv");
        //    }
        //}).start();

        //retrofitCall();
    }

    /**
     * call in background thread
     * https://developer.android.com/training/basics/network-ops/connecting.html
     */
    private String httpCall(String user) throws Exception {
        String urlStr = "https://api.github.com/users/" + user + "/repos";
        java.net.URL url = new URL(urlStr);
        InputStream stream;
        HttpsURLConnection connection;
        String result = null;

        connection = (HttpsURLConnection) url.openConnection();

        connection.setReadTimeout(3000);    // 3s timeout
        connection.setConnectTimeout(3000); // 3s timeout
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpsURLConnection.HTTP_OK) {
            throw new IOException("HTTP Code: " + responseCode);
        }
        stream = connection.getInputStream();
        if (stream != null) {
            result = Utils.readStream(stream);
        }
        if (stream != null) {
            stream.close();
        }
        connection.disconnect();
        return result;
    }

    /**
     * volley call: https://developer.android.com/training/volley/simple.html
     */
    private void volleyCall(String user) {
        String url ="https://api.github.com/users/" + user + "/repos";
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new com.android.volley.Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    log("Response is: "+ response.substring(0,500));
                }
            }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                log("That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    /**
     * http://square.github.io/retrofit/
     * https://futurestud.io/tutorials/retrofit-synchronous-and-asynchronous-requests
     */
    private void retrofitCall() {
        final OkHttpClient okHttpClient =
            new OkHttpClient.Builder().readTimeout(3, TimeUnit.SECONDS)
                .connectTimeout(3, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

        GitHubService service = retrofit.create(GitHubService.class);

        Call<List<Repo>> repos = service.listRepos("khacpv");

        // Asynchronously
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, retrofit2.Response<List<Repo>> response) {
                List<Repo> repos = response.body();
                if (repos == null) {
                    log("repos is null");
                    return;
                }
                log("repos: " + repos.size());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                log("error: " + t.getMessage());
            }
        });

        //// Synchronously
        //try {
        //    repos.execute();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }

    private void log(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
