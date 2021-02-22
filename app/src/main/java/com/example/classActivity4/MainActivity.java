package com.example.classActivity4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private boolean twoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if we cannot find second fragment in the layout, only one column
        if(findViewById(R.id.fragContainer_land_second_1) != null){
            twoPane = true;
        }

        if (!twoPane){
            loadFragment(new FirstFragment(), R.id.fragContainer_first);
            Button button_personality = findViewById(R.id.button_personality);
            button_personality.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("type", "personality");
                    startActivity(intent);
                }
            });

            Button button_houseInfo = findViewById(R.id.button_houseInfo);
            button_houseInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("type", "house info");
                    startActivity(intent);
                }
            });
        } else {
            loadFragment(new FirstFragment(), R.id.fragContainer_land_first);
            Bundle bundle1 = new Bundle();
            bundle1.putString("type", "personality");
            SecondFragment secondFragment1 = new SecondFragment();
            secondFragment1.setArguments(bundle1);
            loadFragment(secondFragment1, R.id.fragContainer_land_second_1);

            Bundle bundle2 = new Bundle();
            bundle2.putString("type", "house info");
            SecondFragment secondFragment2 = new SecondFragment();
            secondFragment2.setArguments(bundle2);
            loadFragment(secondFragment2, R.id.fragContainer_land_second_2);
        }

    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }
}