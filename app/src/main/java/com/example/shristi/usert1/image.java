package com.example.shristi.usert1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;

public class image extends AppCompatActivity {
    public static String link1;
    public static String disc;


    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);
        String appVersion = "v1";
        Backendless.initApp(this, "A0EC8CE8-BC06-EC54-FFE2-9B50776AAA00", "AE1E553B-0836-C1E1-FFAF-96E976956000", appVersion);
         String URL =
                "https://api.backendless.com/A0EC8CE8-BC06-EC54-FFE2-9B50776AAA00/v1/files/img/" + link1 + "%3Foverwrite%3Dfalse";
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); StrictMode.setThreadPolicy(policy);

        //ImageView iv = (ImageView) findViewById(R.id.image1);
       // Bitmap bitmap = getBitmapFromURL("https://api.backendless.com/A0EC8CE8-BC06-EC54-FFE2-9B50776AAA00/v1/files/img/" + link1 + "%3Foverwrite%3Dfalse");
       //https://develop.backendless.com/console/A0EC8CE8-BC06-EC54-FFE2-9B50776AAA00/appversion/5ABCC519-94A5-2CCB-FFBA-11F90089D100/wbwyyzocbxuwyktbltppdmmnclpwnltijobe/files/view/img/"+link1+"%3Foverwrite%3Dfalse
        //https://develop.backendless.com/console/A0EC8CE8-BC06-EC54-FFE2-9B50776AAA00/appversion/5ABCC519-94A5-2CCB-FFBA-11F90089D100/jinkmzvcfaupvhvkehdogttydsnqmauqpgvi/files/view/img/IMG_20150423_100810.jpg%3Foverwrite%3Dfalse                                                                                                                                                                                                                              
        TextView msg=(TextView)findViewById(R.id.msg);
        msg.setText(disc);
      //    iv.setImageBitmap(bitmap);
        imageView = (ImageView) findViewById(R.id.image1);

        // Create an object for subclass of AsyncTask
        GetXMLTask task = new GetXMLTask();
        // Execute the task
        task.execute(new String[]{URL});
        Toast.makeText(getApplicationContext(),"Loading Image!", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Loading Image!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
   /* public Bitmap getBitmapFromURL(String src){
        try{
            URL url= new URL(src);
            HttpURLConnection connection= (HttpURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input=connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;

        }

    }*/
    private class GetXMLTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {


            Bitmap map = null;
            for (String url : urls) {
                map = downloadImage(url);
            }
            return map;
        }

        // Sets the Bitmap returned by doInBackground
        @Override
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }

        // Creates Bitmap from InputStream and returns it
        private Bitmap downloadImage(String url) {
            Bitmap bitmap = null;
            InputStream stream = null;
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inSampleSize = 1;

            try {
                stream = getHttpConnection(url);
                bitmap = BitmapFactory.
                        decodeStream(stream, null, bmOptions);
                stream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return bitmap;
        }

        // Makes HttpURLConnection and returns InputStream
        private InputStream getHttpConnection(String urlString)
                throws IOException {
            InputStream stream = null;
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            try {
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                httpConnection.setRequestMethod("GET");
                httpConnection.connect();

                if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    stream = httpConnection.getInputStream();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return stream;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
