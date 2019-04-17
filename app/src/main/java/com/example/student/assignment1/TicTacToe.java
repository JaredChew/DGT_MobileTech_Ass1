package com.example.student.assignment1;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TicTacToe extends AppCompatActivity {

    private boolean gameEnd = false;

    private int p1Score = 0;
    private int p2Score = 0;
    private int turns = 0;

    private String player = "Player1";
    private char block[] = new char[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        for(int i = 0; i < 9; i++) {

            block[i] = 'E';

        }

    }

    private void reset() {

        gameEnd = false;

        turns = 0;
        player = "Player1";

        for(int i = 0; i < 9; i++) {

            block[i] = 'E';

        }

        ImageButton x1y1 =(ImageButton) findViewById(R.id.x1y1);
        x1y1.setImageResource(R.drawable.x1y1);

        ImageButton x2y1 =(ImageButton) findViewById(R.id.x2y1);
        x2y1.setImageResource(R.drawable.x2y1);

        ImageButton x3y1 =(ImageButton) findViewById(R.id.x3y1);
        x3y1.setImageResource(R.drawable.x3y1);

        ImageButton x1y2 =(ImageButton) findViewById(R.id.x1y2);
        x1y2.setImageResource(R.drawable.x1y2);

        ImageButton x2y2 =(ImageButton) findViewById(R.id.x2y2);
        x2y2.setImageResource(R.drawable.x2y2);

        ImageButton x3y2 =(ImageButton) findViewById(R.id.x3y2);
        x3y2.setImageResource(R.drawable.x3y2);

        ImageButton x1y3 =(ImageButton) findViewById(R.id.x1y3);
        x1y3.setImageResource(R.drawable.x1y3);

        ImageButton x2y3 =(ImageButton) findViewById(R.id.x2y3);
        x2y3.setImageResource(R.drawable.x2y3);

        ImageButton x3y3 =(ImageButton) findViewById(R.id.x3y3);
        x3y3.setImageResource(R.drawable.x3y3);

        LinearLayout winlose_ll = (LinearLayout) findViewById(R.id.winlose_ui);
        winlose_ll.setVisibility(winlose_ll.INVISIBLE);

    }

    private void setBlockState(int position, char state) {

        block[position] = state;

    }

    private char getBlockState(int position) {

        return block[position];

    }

    public void playerTurn(View view) {

        int blockClick = Integer.parseInt(view.getTag().toString());

        if(player == "Player1") {

            switch (blockClick) {

                case 0:

                    if (getBlockState(0) == 'E' && gameEnd == false) {

                        ImageButton x1y1 = (ImageButton) findViewById(R.id.x1y1);
                        x1y1.setImageResource(R.drawable.x1y1x);

                        setBlockState(0, 'X');

                        game();

                    }

                    break;

                case 1:

                    if (getBlockState(1) == 'E' && gameEnd == false) {

                        ImageButton x2y1 = (ImageButton) findViewById(R.id.x2y1);
                        x2y1.setImageResource(R.drawable.x2y1x);

                        setBlockState(1, 'X');

                        game();

                    }

                    break;

                case 2:

                    if (getBlockState(2) == 'E' && gameEnd == false) {

                        ImageButton x3y1 = (ImageButton) findViewById(R.id.x3y1);
                        x3y1.setImageResource(R.drawable.x3y1x);

                        setBlockState(2, 'X');

                        game();

                    }

                    break;

                case 3:

                    if (getBlockState(3) == 'E' && gameEnd == false) {

                        ImageButton x1y2 = (ImageButton) findViewById(R.id.x1y2);
                        x1y2.setImageResource(R.drawable.x1y2x);

                        setBlockState(3, 'X');

                        game();

                    }

                    break;

                case 4:

                    if (getBlockState(4) == 'E' && gameEnd == false) {

                        ImageButton x2y2 = (ImageButton) findViewById(R.id.x2y2);
                        x2y2.setImageResource(R.drawable.x2y2x);

                        setBlockState(4, 'X');

                        game();

                    }

                    break;

                case 5:

                    if (getBlockState(5) == 'E' && gameEnd == false) {

                        ImageButton x3y2 = (ImageButton) findViewById(R.id.x3y2);
                        x3y2.setImageResource(R.drawable.x3y2x);

                        setBlockState(5, 'X');

                        game();

                    }

                    break;

                case 6:

                    if (getBlockState(6) == 'E' && gameEnd == false) {

                        ImageButton x1y3 = (ImageButton) findViewById(R.id.x1y3);
                        x1y3.setImageResource(R.drawable.x1y3x);

                        setBlockState(6, 'X');

                        game();

                    }

                    break;

                case 7:

                    if (getBlockState(7) == 'E' && gameEnd == false) {

                        ImageButton x2y3 = (ImageButton) findViewById(R.id.x2y3);
                        x2y3.setImageResource(R.drawable.x2y3x);

                        setBlockState(7, 'X');

                        game();

                    }

                    break;

                case 8:

                    if (getBlockState(8) == 'E' && gameEnd == false) {

                        ImageButton x3y3 = (ImageButton) findViewById(R.id.x3y3);
                        x3y3.setImageResource(R.drawable.x3y3x);

                        setBlockState(8, 'X');

                        game();

                    }

                    break;

            }

        }

        else if (player == "Player2") {

            switch (blockClick) {

                case 0:

                    if (getBlockState(0) == 'E' && gameEnd == false) {

                        ImageButton x1y1 = (ImageButton) findViewById(R.id.x1y1);
                        x1y1.setImageResource(R.drawable.x1y1o);

                        setBlockState(0, 'O');

                        game();

                    }

                    break;

                case 1:

                    if (getBlockState(1) == 'E' && gameEnd == false) {

                        ImageButton x2y1 = (ImageButton) findViewById(R.id.x2y1);
                        x2y1.setImageResource(R.drawable.x2y1o);

                        setBlockState(1, 'O');

                        game();

                    }

                    break;

                case 2:

                    if (getBlockState(2) == 'E' && gameEnd == false) {

                        ImageButton x3y1 = (ImageButton) findViewById(R.id.x3y1);
                        x3y1.setImageResource(R.drawable.x3y1o);

                        setBlockState(2, 'O');

                        game();

                    }

                    break;

                case 3:

                    if (getBlockState(3) == 'E' && gameEnd == false) {

                        ImageButton x1y2 = (ImageButton) findViewById(R.id.x1y2);
                        x1y2.setImageResource(R.drawable.x1y2o);

                        setBlockState(3, 'O');

                        game();

                    }

                    break;

                case 4:

                    if (getBlockState(4) == 'E' && gameEnd == false) {

                        ImageButton x2y2 = (ImageButton) findViewById(R.id.x2y2);
                        x2y2.setImageResource(R.drawable.x2y2o);

                        setBlockState(4, 'O');

                        game();

                    }

                    break;

                case 5:

                    if (getBlockState(5) == 'E' && gameEnd == false) {

                        ImageButton x3y2 = (ImageButton) findViewById(R.id.x3y2);
                        x3y2.setImageResource(R.drawable.x3y2o);

                        setBlockState(5, 'O');

                        game();

                    }

                    break;

                case 6:

                    if (getBlockState(6) == 'E' && gameEnd == false) {

                        ImageButton x1y3 = (ImageButton) findViewById(R.id.x1y3);
                        x1y3.setImageResource(R.drawable.x1y3o);

                        setBlockState(6, 'O');

                        game();

                    }

                    break;

                case 7:

                    if (getBlockState(7) == 'E' && gameEnd == false) {

                        ImageButton x2y3 = (ImageButton) findViewById(R.id.x2y3);
                        x2y3.setImageResource(R.drawable.x2y3o);

                        setBlockState(7, 'O');

                        game();

                    }

                    break;

                case 8:

                    if (getBlockState(8) == 'E' && gameEnd == false) {

                        ImageButton x3y3 = (ImageButton) findViewById(R.id.x3y3);
                        x3y3.setImageResource(R.drawable.x3y3o);

                        setBlockState(8, 'O');

                        game();

                    }

                    break;

            }

        }

    }

    private void game() {

        winCheck();
        playerSwitch();

    }

    private void winCheck() {

        //Winning mode horizontal

        int winCount = 0;
        int counter = 0;

        for (int i = 0; i < 9; i++) {

            if (player == "Player1" && block[i] == 'X') {
                winCount++;
            }
            else if (player == "Player2" && block[i] == 'O') {
                winCount++;
            }

            if (winCount == 3) {
                gameEnd = true;
                winLose();
                return;
            }

            counter++;

            if(counter == 3) {
                winCount = 0;
                counter = 0;
            }

        }

        ////////////////////////////////////////////
        //Winning mode vertical

        int xPosCounter = 0;

        winCount = 0;
        counter = 0;

        for (int i = 0; xPosCounter < 3; i += 3) {

            if (player == "Player1" && block[i] == 'X') {
                winCount++;
            }
            else if (player == "Player2" && block[i] == 'O') {
                winCount++;
            }

            if (winCount == 3) {
                gameEnd = true;
                winLose();
                return;
            }

            counter++;

            if (counter == 3) {
                xPosCounter++;
                winCount = 0;
                counter = 0;
                i -= 8;
            }

        }

        ////////////////////////////////////////////
        //Winning mode diagonal

	    /* backslash-diagonal */

        winCount = 0;
        counter = 0;

        for (int i = 0; i < 9; i += 4) {

            if (player == "Player1" && block[i] == 'X') {
                winCount++;
            }
            else if (player == "Player2" && block[i] == 'O') {
                winCount++;
            }

            if (winCount == 3) {
                gameEnd = true;
                winLose();
                return;
            }

            counter++;

        }

	    /* forward slash diagonal */

        winCount = 0;
        counter = 0;

        for (int i = 2; i < 7; i += 2) {

            if (player == "Player1" && block[i] == 'X') {
                winCount++;
            }
            else if (player == "Player2" && block[i] == 'O') {
                winCount++;
            }

            if (winCount == 3) {
                gameEnd = true;
                winLose();
                return;
            }

            counter++;

        }

        ////////////////////////////////////////////
        //Draw

        if(turns == 8) {
            player = "Draw";
            winLose();
        }

    }

    private void playerSwitch() {

        if(player == "Player1") {
            player = "Player2";
        }
        else if(player == "Player2") {
            player = "Player1";
        }

        turns++;

    }

    private void winLose() {

        TextView winLoseDraw = (TextView)findViewById(R.id.winLoseDraw);

        LinearLayout winlose_ll = (LinearLayout) findViewById(R.id.winlose_ui);
        winlose_ll.setVisibility(winlose_ll.VISIBLE);

        if(player == "Player1") {
            p1Score++;
            TextView player1Score = (TextView) findViewById(R.id.player1Score);
            player1Score.setText("Player 1 wins: " + p1Score);
            winLoseDraw.setText("Player 1 Win!");
        }
        else if(player == "Player2") {
            p2Score++;
            TextView player2Score = (TextView) findViewById(R.id.player2Score);
            player2Score.setText("Player 1 wins: " + p2Score);
            winLoseDraw.setText("Player 2 Win!");
        }
        else if (player == "Draw") {
            winLoseDraw.setText("Draw!");
        }

    }

    public void againButton(View view) {

        TextView winLoseDraw = (TextView)findViewById(R.id.winLoseDraw);
        Button playAgain = (Button)findViewById(R.id.again);

        winLoseDraw.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);

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
