package com.example.student.assignment1;

import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class NumberGuessing extends AppCompatActivity {

    private CountDownTimer timer = null;

    private int num1 = 0;
    private int num2 = 0;
    private int num3 = 0;
    private int num4 = 0;

    private boolean winCheck = false;

    private String player = "p1";
    private String position = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_guessing);

        ranNumGen();
        startTimer();

    }

    private void startTimer() {

        timer = new CountDownTimer(100000, 1000) {

            public void onTick(long timeRemaining) {

                TextView timer_text = (TextView) findViewById(R.id.time);
                timer_text.setText("" + timeRemaining / 1000);

            }

            public void onFinish() {

                ImageButton up1 = (ImageButton) findViewById(R.id.upBtn1);
                ImageButton up2 = (ImageButton) findViewById(R.id.upBtn2);
                ImageButton up3 = (ImageButton) findViewById(R.id.upBtn3);
                ImageButton up4 = (ImageButton) findViewById(R.id.upBtn4);

                up1.setVisibility(up1.INVISIBLE);
                up2.setVisibility(up2.INVISIBLE);
                up3.setVisibility(up3.INVISIBLE);
                up4.setVisibility(up4.INVISIBLE);

                ImageButton down1 = (ImageButton) findViewById(R.id.downBtn1);
                ImageButton down2 = (ImageButton) findViewById(R.id.downBtn2);
                ImageButton down3 = (ImageButton) findViewById(R.id.downBtn3);
                ImageButton down4 = (ImageButton) findViewById(R.id.downBtn4);

                down1.setVisibility(up1.INVISIBLE);
                down2.setVisibility(up2.INVISIBLE);
                down3.setVisibility(up3.INVISIBLE);
                down4.setVisibility(up4.INVISIBLE);

                gameEnd();

            }

        };

        timer.start();

    }

    protected void game(View view) {

        if(view.getTag().equals(player)) {

            if(position.equals("num1")) {

                TextView num1_text = (TextView) findViewById(R.id.num1);

                if(Integer.parseInt(num1_text.getText().toString()) == num1) {

                    ImageButton up1 = (ImageButton) findViewById(R.id.upBtn1);
                    up1.setVisibility(up1.INVISIBLE);

                    ImageButton down1 = (ImageButton) findViewById(R.id.downBtn1);
                    down1.setVisibility(down1.INVISIBLE);

                    num1 = 10;

                    if(player.equals("p1")) {
                        TextView p1_score = (TextView) findViewById(R.id.p1_score);
                        p1_score.setText("" + (Integer.parseInt(p1_score.getText().toString()) + 1));
                    }
                    else {
                        TextView p2_score = (TextView) findViewById(R.id.p2_score);
                        p2_score.setText("" + (Integer.parseInt(p2_score.getText().toString()) + 1));
                    }

                }

            }

            else if(position.equals("num2")) {

                TextView num2_text = (TextView) findViewById(R.id.num2);

                if(Integer.parseInt(num2_text.getText().toString()) == num2) {

                    ImageButton up2 = (ImageButton) findViewById(R.id.upBtn2);
                    up2.setVisibility(up2.INVISIBLE);

                    ImageButton down2 = (ImageButton) findViewById(R.id.downBtn2);
                    down2.setVisibility(down2.INVISIBLE);

                    num2 = 10;

                    if(player.equals("p1")) {
                        TextView p1_score = (TextView) findViewById(R.id.p1_score);
                        p1_score.setText("" + (Integer.parseInt(p1_score.getText().toString()) + 1));
                    }
                    else {
                        TextView p2_score = (TextView) findViewById(R.id.p2_score);
                        p2_score.setText("" + (Integer.parseInt(p2_score.getText().toString()) + 1));
                    }

                }

            }

            else if(position.equals("num3")) {

                TextView num3_text = (TextView) findViewById(R.id.num3);

                if(Integer.parseInt(num3_text.getText().toString()) == num3) {

                    ImageButton up3 = (ImageButton) findViewById(R.id.upBtn3);
                    up3.setVisibility(up3.INVISIBLE);

                    ImageButton down3 = (ImageButton) findViewById(R.id.downBtn3);
                    down3.setVisibility(down3.INVISIBLE);

                    num3 = 10;

                    if(player.equals("p1")) {
                        TextView p1_score = (TextView) findViewById(R.id.p1_score);
                        p1_score.setText("" + (Integer.parseInt(p1_score.getText().toString()) + 1));
                    }
                    else {
                        TextView p2_score = (TextView) findViewById(R.id.p2_score);
                        p2_score.setText("" + (Integer.parseInt(p2_score.getText().toString()) + 1));
                    }

                }

                    }

            else if(position.equals("num4")) {

                TextView num4_text = (TextView) findViewById(R.id.num4);

                if(Integer.parseInt(num4_text.getText().toString()) == num4) {

                    ImageButton up4 = (ImageButton) findViewById(R.id.upBtn4);
                    up4.setVisibility(up4.INVISIBLE);

                    ImageButton down4 = (ImageButton) findViewById(R.id.downBtn4);
                    down4.setVisibility(down4.INVISIBLE);

                    num4 = 10;

                    if(player.equals("p1")) {
                        TextView p1_score = (TextView) findViewById(R.id.p1_score);
                        p1_score.setText("" + (Integer.parseInt(p1_score.getText().toString()) + 1));
                    }
                    else {
                        TextView p2_score = (TextView) findViewById(R.id.p2_score);
                        p2_score.setText("" + (Integer.parseInt(p2_score.getText().toString()) + 1));
                    }

                }

            }

            if((num1 + num2 + num3 + num4) == 40) { gameEnd(); }

            if(player.equals("p1") && winCheck == false) {

                player = "p2";

                Button p1_ok = (Button) findViewById(R.id.okBtn_p1);
                p1_ok.setVisibility(p1_ok.INVISIBLE);

                Button p2_ok = (Button) findViewById(R.id.okBtn_p2);
                p2_ok.setVisibility(p2_ok.VISIBLE);

            }

            else if(player.equals("p2") && winCheck == false) {

                player = "p1";

                Button p2_ok = (Button) findViewById(R.id.okBtn_p2);
                p2_ok.setVisibility(p2_ok.INVISIBLE);

                Button p1_ok = (Button) findViewById(R.id.okBtn_p1);
                p1_ok.setVisibility(p1_ok.VISIBLE);

            }
            else {

                Button p1_ok = (Button) findViewById(R.id.okBtn_p1);
                p1_ok.setVisibility(p1_ok.INVISIBLE);

                Button p2_ok = (Button) findViewById(R.id.okBtn_p2);
                p2_ok.setVisibility(p2_ok.INVISIBLE);

            }

            scrollReset("");

        }

    }

    private void reset() {

        timer.cancel();

        ranNumGen();

        player = "p1";
        position = "";

        winCheck = false;

        TextView num1_text = (TextView) findViewById(R.id.num1);
        TextView num2_text = (TextView) findViewById(R.id.num1);
        TextView num3_text = (TextView) findViewById(R.id.num1);
        TextView num4_text = (TextView) findViewById(R.id.num1);

        num1_text.setText("0");
        num2_text.setText("0");
        num3_text.setText("0");
        num4_text.setText("0");

        ImageButton up1 = (ImageButton) findViewById(R.id.upBtn1);
        ImageButton up2 = (ImageButton) findViewById(R.id.upBtn2);
        ImageButton up3 = (ImageButton) findViewById(R.id.upBtn3);
        ImageButton up4 = (ImageButton) findViewById(R.id.upBtn4);

        up1.setVisibility(up1.VISIBLE);
        up2.setVisibility(up2.VISIBLE);
        up3.setVisibility(up3.VISIBLE);
        up4.setVisibility(up4.VISIBLE);

        ImageButton down1 = (ImageButton) findViewById(R.id.downBtn1);
        ImageButton down2 = (ImageButton) findViewById(R.id.downBtn2);
        ImageButton down3 = (ImageButton) findViewById(R.id.downBtn3);
        ImageButton down4 = (ImageButton) findViewById(R.id.downBtn4);

        down1.setVisibility(up1.VISIBLE);
        down2.setVisibility(up2.VISIBLE);
        down3.setVisibility(up3.VISIBLE);
        down4.setVisibility(up4.VISIBLE);

        TextView winLoseDraw = (TextView) findViewById(R.id.winLoseDraw);
        Button playAgain = (Button) findViewById(R.id.playAgain);

        winLoseDraw.setVisibility(winLoseDraw.INVISIBLE);
        playAgain.setVisibility(playAgain.INVISIBLE);

        scrollReset("");

        startTimer();

    }

    private void scrollReset(String scrollNum) {

        TextView num1_text = (TextView) findViewById(R.id.num1);
        TextView num2_text = (TextView) findViewById(R.id.num2);
        TextView num3_text = (TextView) findViewById(R.id.num3);
        TextView num4_text = (TextView) findViewById(R.id.num4);

        if(!scrollNum.equals("num1") && num1 != 10) { num1_text.setText("0"); }
        if(!scrollNum.equals("num2") && num2 != 10) { num2_text.setText("0"); }
        if(!scrollNum.equals("num3") && num3 != 10) { num3_text.setText("0"); }
        if(!scrollNum.equals("num4") && num4 != 10) { num4_text.setText("0"); }

    }

    private void ranNumGen() {

        Random rng = new Random();

        num1 = rng.nextInt(9);
        num2 = rng.nextInt(9);
        num3 = rng.nextInt(9);
        num4 = rng.nextInt(9);

    }

    protected void increase_button(View view) {

        position = view.getTag().toString();

        if(position.equals("num1")) {

            TextView num1_text = (TextView) findViewById(R.id.num1);

            if(num1_text.getText().equals("9")) {
                num1_text.setText("" + 0);
            }
            else {
                num1_text.setText("" + (Integer.parseInt(num1_text.getText().toString()) + 1));
            }

            scrollReset("num1");

        }

        else if(position.equals("num2")) {

            TextView num2_text = (TextView) findViewById(R.id.num2);

            if(num2_text.getText().equals("9")) {
                num2_text.setText("" + 0);
            }
            else {
                num2_text.setText("" + (Integer.parseInt(num2_text.getText().toString()) + 1));
            }

            scrollReset("num2");

        }

        else if(position.equals("num3")) {

            TextView num3_text = (TextView) findViewById(R.id.num3);

            if(num3_text.getText().equals("9")) {
                num3_text.setText("" + 0);
            }
            else {
                num3_text.setText("" + (Integer.parseInt(num3_text.getText().toString()) + 1));
            }

            scrollReset("num3");

        }

        else if(position.equals("num4")) {

            TextView num4_text = (TextView) findViewById(R.id.num4);

            if(num4_text.getText().equals("9")) {
                num4_text.setText("" + 0);
            }
            else {
                num4_text.setText("" + (Integer.parseInt(num4_text.getText().toString()) + 1));
            }

            scrollReset("num4");

        }

    }

    protected void decrease_button(View view) {

        position = view.getTag().toString();

        if(position.equals("num1")) {

            TextView num1_text = (TextView) findViewById(R.id.num1);

            if(num1_text.getText().equals("0")) {
                num1_text.setText("" + 9);
            }
            else {
                num1_text.setText("" + (Integer.parseInt(num1_text.getText().toString()) - 1));
            }

            scrollReset("num1");

        }

        else if(position.equals("num2")) {

            TextView num2_text = (TextView) findViewById(R.id.num2);

            if(num2_text.getText().equals("0")) {
                num2_text.setText("" + 9);
            }
            else {
                num2_text.setText("" + (Integer.parseInt(num2_text.getText().toString()) - 1));
            }

            scrollReset("num2");

        }

        else if(position.equals("num3")) {

            TextView num3_text = (TextView) findViewById(R.id.num3);

            if(num3_text.getText().equals("0")) {
                num3_text.setText("" + 9);
            }
            else {
                num3_text.setText("" + (Integer.parseInt(num3_text.getText().toString()) - 1));
            }

            scrollReset("num3");

        }

        else if(position.equals("num4")) {

            TextView num4_text = (TextView) findViewById(R.id.num4);

            if(num4_text.getText().equals("0")) {
                num4_text.setText("" + 9);
            }
            else {
                num4_text.setText("" + (Integer.parseInt(num4_text.getText().toString()) - 1));
            }

            scrollReset("num4");

        }

    }

    private void gameEnd() {

        TextView winLoseDraw = (TextView) findViewById(R.id.winLoseDraw);
        TextView p1 = (TextView) findViewById(R.id.p1_score);
        TextView p2 = (TextView) findViewById(R.id.p2_score);

        Button playAgain = (Button) findViewById(R.id.playAgain);

        if(Integer.parseInt(p1.getText().toString()) > Integer.parseInt(p2.getText().toString())) {
            winLoseDraw.setText("Player 1 Wins!");
        }
        else if(Integer.parseInt(p2.getText().toString()) > Integer.parseInt(p1.getText().toString())) {
            winLoseDraw.setText("Player 2 Wins!");
        }
        else {
            winLoseDraw.setText("Draw");
        }

        winLoseDraw.setVisibility(winLoseDraw.VISIBLE);
        playAgain.setVisibility(playAgain.VISIBLE);

        timer.cancel();

        winCheck = true;

    }

    protected void playAgain(View view) {

        reset();

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mainMenu:
                this.finish();
                return true;
            case R.id.restart:
                reset();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
