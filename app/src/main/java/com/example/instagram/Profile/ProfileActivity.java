package com.example.instagram.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
//import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.instagram.R;
import com.example.instagram.Utils.BottomNavigationViewHelper;
import com.example.instagram.Utils.GridImageAdapter;
import com.example.instagram.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;


public class ProfileActivity extends AppCompatActivity {
        private static final String TAG="ProfileActivity";
    private static final int ACTIVITY_NUM=4;
    ImageView profileMenu;
    Toolbar toolbar;
    private final Context mContext=ProfileActivity.this;
    private ProgressBar mProgressBar;
    private ImageView profilePrhoto;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started.");
        mProgressBar=(ProgressBar)findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);

        //getSupportActionBar().hide();
        setupBottomNavigationView();
        setupToolbar();
        setActivityWidgets();
        setProfileImage();

        tempGridSetup();
    }

    private void tempGridSetup(){
        ArrayList<String> imgURLs=new ArrayList<>();
        imgURLs.add("https://st2.depositphotos.com/2001755/5408/i/450/depositphotos_54081723-stock-photo-beautiful-nature-landscape.jpg");
        imgURLs.add("https://st2.depositphotos.com/2001755/5408/i/450/depositphotos_54081723-stock-photo-beautiful-nature-landscape.jpg");
        imgURLs.add("https://mrkp-static-production.themarkup.org/uploads/2020/03/photos-841x473.jpg");
        imgURLs.add("https://mrkp-static-production.themarkup.org/uploads/2020/03/photos-841x473.jpg");
        imgURLs.add("https://mrkp-static-production.themarkup.org/uploads/2020/03/photos-841x473.jpg");
        imgURLs.add("https://mrkp-static-production.themarkup.org/uploads/2020/03/photos-841x473.jpg");
        imgURLs.add("https://mrkp-static-production.themarkup.org/uploads/2020/03/photos-841x473.jpg");
        imgURLs.add("https://mrkp-static-production.themarkup.org/uploads/2020/03/photos-841x473.jpg");
        imgURLs.add("https://mrkp-static-production.themarkup.org/uploads/2020/03/photos-841x473.jpg");


        setupImageGrid(imgURLs);
    }

    private void setupImageGrid(ArrayList<String> imgURLs){
        GridView gridView=(GridView) findViewById(R.id.gridView);

        GridImageAdapter adapter=new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgURLs);
        gridView.setAdapter(adapter);

    }

    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting profile photo. ");
        String imgURL="mrkp-static-production.themarkup.org/uploads/2020/03/photos-841x473.jpg";
        UniversalImageLoader.setImage(imgURL, profilePrhoto, mProgressBar, "https://");
    }

    private void setActivityWidgets(){
        mProgressBar=(ProgressBar)findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePrhoto=(ImageView) findViewById(R.id.profile_photo);
    }

    private void setupToolbar(){
        toolbar =(Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

       profileMenu=(ImageView) findViewById(R.id.profileMenu);

        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to account settings");
                Intent intent= new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });

        /*
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d(TAG, "onMenuItemClick: clicked menu item: " +item);

                switch (item.getItemId())
                {
                    case R.id.profileMenu:
                        Log.d(TAG, "onMenuItemClick: Navigating to Profile Preferences.");

                }
                return false;
            }
        });


         */
    }

    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx=(BottomNavigationViewEx) findViewById(R.id.BottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }
    */
}
