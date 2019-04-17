package com.example.student.assignment1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    protected void ticTacToe(View view) {

        Intent myIntent = new Intent(view.getContext(), TicTacToe.class);
        this.startActivity(myIntent);

    }

    protected void numberGuessing(View view) {

        Intent myIntent = new Intent(view.getContext(), NumberGuessing.class);
        this.startActivity(myIntent);

    }

    protected void memoryChallenge(View view) {

        Intent myIntent = new Intent(view.getContext(), MemoryChallenge.class);
        this.startActivity(myIntent);

    }

}
