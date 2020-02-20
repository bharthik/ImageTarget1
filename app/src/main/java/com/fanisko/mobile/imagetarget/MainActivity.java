package com.fanisko.mobile.imagetarget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String json = " {\n" +
            "        \"arList\": [\n" +
            "            {\n" +
            "                \"adsButtonName\": \"GET GIVEAWAYS\",\n" +
            "                \"adsInfo\": \"Your chances at winning $10,000 is just a pizza and a away Your chances at winning $10,000 is just a pizza and a away Your chances at winning $10,000 is just a pizza and a away Your chances at winning $10,000 is just a pizza and a away Your chances at winning $10,000 is just a pizza and a away Your chances at winning $10,000 is just a pizza and a away\",\n" +
            "                \"targetImageUrl\": \"https://engage-ar.s3-us-west-2.amazonaws.com/201812141413/Target_Image.jpg\",\n" +
            "                \"targetVideoUrl\": \"https://www.youtube.com/watch?v=ZV58-VIcBLA\",\n" +
            "                \"adsRedirectUrl\": \"https://fanisko.com/\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activatebtn = findViewById(R.id.scanAd);

        activatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainUnityActivity.class);
                intent.putExtra("arList", json);
                //  intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                // startActivityForResult(intent, 1);
                startActivity(intent);
            }
        });

    }
}
