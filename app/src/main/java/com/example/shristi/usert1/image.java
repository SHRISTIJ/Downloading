package com.example.shristi.usert1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.backendless.Backendless;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class image extends AppCompatActivity {
    private  Bitmap bitmap;
    private ImageView iv;
    public static String link1;
    public static String disc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);
        String appVersion = "v1";
        Backendless.initApp(this, "A0EC8CE8-BC06-EC54-FFE2-9B50776AAA00", "AE1E553B-0836-C1E1-FFAF-96E976956000", appVersion);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); StrictMode.setThreadPolicy(policy);

        iv =(ImageView)findViewById(R.id.image1);
        bitmap=getBitmapFromURL("https://api.backendless.com/A0EC8CE8-BC06-EC54-FFE2-9B50776AAA00/v1/files/img/"+link1+"%3Foverwrite%3Dfalse" );
       //https://develop.backendless.com/console/A0EC8CE8-BC06-EC54-FFE2-9B50776AAA00/appversion/5ABCC519-94A5-2CCB-FFBA-11F90089D100/wbwyyzocbxuwyktbltppdmmnclpwnltijobe/files/view/img/"+link1+"%3Foverwrite%3Dfalse
        //https://develop.backendless.com/console/A0EC8CE8-BC06-EC54-FFE2-9B50776AAA00/appversion/5ABCC519-94A5-2CCB-FFBA-11F90089D100/jinkmzvcfaupvhvkehdogttydsnqmauqpgvi/files/view/img/IMG_20150423_100810.jpg%3Foverwrite%3Dfalse                                                                                                                                                                                                                              
        TextView msg=(TextView)findViewById(R.id.msg);
        msg.setText(disc);
          iv.setImageBitmap(bitmap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public Bitmap getBitmapFromURL(String src){
        try{
            URL url= new URL(src);
            HttpURLConnection connection= (HttpURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input=connection.getInputStream();
            Bitmap myBitmap= BitmapFactory.decodeStream(input);
            return myBitmap;
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;

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
