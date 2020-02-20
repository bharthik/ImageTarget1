package com.fanisko.mobile.imagetarget;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import product.OverrideUnityActivity;

//import com.fanisko.icewolves.mobile.android.ui.view.MainActivity;


public class MainUnityActivity extends OverrideUnityActivity {
    // Setup activity layout
    String json = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        json = intent.getStringExtra("arList");
        addControlsToUnityFrame();
        handleIntent(intent);


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
        setIntent(intent);
    }

    void handleIntent(Intent intent) {
        if (intent == null || intent.getExtras() == null) return;

        if (intent.getExtras().containsKey("doQuit"))
            if (mUnityPlayer != null) {
                finish();
            }
    }

    @Override
    protected void showMainActivity(String setToColor) {
        /*Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("setColor", setToColor);
        startActivity(intent);*/
    }

    @Override
    public void onUnityPlayerUnloaded() {
        showMainActivity("");
    }

    public void addControlsToUnityFrame() {
        FrameLayout layout = mUnityPlayer;

        {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.arbtn);
            imageView.setX(10);
            imageView.setY(10);
            Log.i("Json", json);
            mUnityPlayer.UnitySendMessage("ARSessionOrigin", "JsonFromNative", json);
            //mUnityPlayer.UnitySendMessage("ARSessionOrigin", "JsonFromNative", json);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    finish();



                }
            });
            layout.addView(imageView, 100, 100);
        }
    }


}
