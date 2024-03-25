package com.example.vims_user;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private ImageButton buttonDrawerToggel;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        navController = Navigation.findNavController(this,R.id.frame_layout);



//        toggle = new ActionBarDrawerToggle (this,drawerLayout,R.string.start,R.string.close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


//                           IDES
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        buttonDrawerToggel = findViewById(R.id.buttonDrawerToggel);
        navigationView = findViewById(R.id.navigation_view);
       



        NavigationUI.setupWithNavController(bottomNavigationView,navController);


        // ACTION BAR
        setSupportActionBar(toolbar);

//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }



        //MENU BAR




        buttonDrawerToggel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });













        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation item clicks here
                int id = item.getItemId();

                if (id == R.id.navigation_video) {
                    Intent yt = new Intent(Intent.ACTION_VIEW);
                    yt.setData(Uri.parse("https://www.youtube.com/@vitsengineeringcollegesatn6823"));
                    startActivity(yt);
                    // Close the drawer if needed
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }

                if (id == R.id.navigation_website) {
                    Intent web = new Intent(Intent.ACTION_VIEW);
                    web.setData(Uri.parse("https://www.vitsdpr.ac.in/Default"));
                    startActivity(web);
                    // Close the drawer if needed
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }



                return false;
            }
        });



    }



}