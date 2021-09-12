package com.example.dynamicfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
FragmentManager fragmentManager;
Button mBtnReplace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  initviews();
  fragmentManager =getSupportFragmentManager();
    }

    private void initviews() {
        mBtnReplace = findViewById(R.id.btnReplace);
        mBtnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentA fragmentA = new FragmentA();
                fragmentTransaction.replace(R.id.container,fragmentA,"FragmentA").commit();
            }
        });
    }

}