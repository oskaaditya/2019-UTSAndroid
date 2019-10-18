package com.example.a2019_utsmobile.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a2019_utsmobile.R;
import com.example.a2019_utsmobile.fragments.AboutFragment;
import com.example.a2019_utsmobile.fragments.BookFragment;
import com.example.a2019_utsmobile.fragments.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    private AboutFragment aboutFragment;
    private BookFragment bookFragment;
    private UserFragment userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aboutFragment = AboutFragment.newInstance("Oska Aditya Pratama");
        loadFragment(new BookFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return  false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_about:
                if (menuItem.getItemId() == R.id.action_about) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, aboutFragment)
                            .addToBackStack(null)
                            .commit();
                }
//                fragment = new AboutFragment();
                break;
            case R.id.action_book:
//                if (menuItem.getItemId() == R.id.action_user) {
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.fragment_container, userFragment)
//                            .addToBackStack(null)
//                            .commit();
//
//                }
                fragment = new BookFragment();
                break;
            case R.id.action_user:
//                if (menuItem.getItemId() == R.id.action_user) {
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.fragment_container, bookFragment)
//                            .addToBackStack(null)
//                            .commit();
//                }
                fragment = new UserFragment();
                break;
        }
        return  loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    public void handleMasukSaran(View view) {
        startActivity(new Intent(MainActivity.this, SaranActivity.class));
        finish();
    }
}
