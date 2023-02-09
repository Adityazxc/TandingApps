package com.example.tanding.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;

import com.example.tanding.fragment.ChatFragment;
import com.example.tanding.fragment.GorListFragment;
import com.example.tanding.fragment.HistoryFragment;
import com.example.tanding.fragment.HomeFragment;
import com.example.tanding.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    GorListFragment gorListFragment = new GorListFragment();
    ChatFragment chatFragment = new ChatFragment();
    HistoryFragment historyFragment = new HistoryFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.fragmentFrame, gorListFragment, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_menu:
                        fragmentManager.beginTransaction()
                                .replace(R.id.fragmentFrame, gorListFragment, null)
                                .setReorderingAllowed(true)
                                .addToBackStack(null)
                                .commit();

                        break;
                    case R.id.chat_menu:
                        fragmentManager.beginTransaction()
                                .replace(R.id.fragmentFrame, chatFragment, null)
                                .setReorderingAllowed(true)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.history_menu:
                        fragmentManager.beginTransaction()
                                .replace(R.id.fragmentFrame, historyFragment, null)
                                .setReorderingAllowed(true)
                                .addToBackStack(null)
                                .commit();
                        break;
                }
                return true;
            }
        });
    }
}