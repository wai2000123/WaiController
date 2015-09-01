/**
 Created by Wai on 10/8/2015.
 */
package wai.waigoprocontroller;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GoProAPI {
    private static final String TAG = "API Return";
    HttpURLConnection conn = null;
    public void APICall(String action){
        new HttpAsyncTask().execute(AppConstant.domain+AppConstant.type+action);
    }
//    public void StartStream(){
//            new HttpAsyncTask().execute(domain+type+"execute?p1=gpStream&c1=start");
//    }
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
        }
    }

    public static String GET(String url){
        URL link = null;
        try {
            link = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpURLConnection conn = null;
            // make GET request to the given URL

            conn = (HttpURLConnection) link.openConnection();

            conn.setRequestMethod("GET");
            // receive response as inputStream
            inputStream = new BufferedInputStream(conn.getInputStream());

            // convert inputstream to string
            if(inputStream != null)
            {
                Log.i(TAG,"1");
                result = convertInputStreamToString(inputStream);
            }
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.toString());
        }

        return result;
    }
    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }
}
