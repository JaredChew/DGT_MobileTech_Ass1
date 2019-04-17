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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MemoryChallenge extends AppCompatActivity {

    private int ply1_score = 0;
    private int ply2_score = 0;
    private CountDownTimer timer_300s = null;
    private CountDownTimer prepareTimer = null;
    private CountDownTimer showRecordTimer = null;
    private String ply1Round = "";
    private String ply2Round = "";
    private String ply1_record[][] = new String[3][3];
    private String ply2_record[][] = new String[3][3];
    private int ply1_countRound = 0;
    private int ply1_countNo = 0;
    private int ply2_countRound = 0;
    private int ply2_countNo = 0;
    private String plyRecord = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_challenge);

    }

    private void PrepareThreeSeconds() {

        prepareTimer = new CountDownTimer(3000, 100) {

            TextView prepareTime = (TextView) findViewById(R.id.prepare_time);

            public void onTick(long threeSeconds) {
                resetScore();

                prepareTime.setVisibility(prepareTime.VISIBLE);
                prepareTime.setText("" + threeSeconds / 1000);
            }

            public void onFinish() {
                ply1Round = "att";
                ply2Round = "def";

                resetRound();

                ply1Button_Visible();
                roundOfPly2_Visible();
                ply2Button_Invisible();
                roundOfPly1_Invisible();

                prepareTime.setVisibility(prepareTime.INVISIBLE);
                gameUI_Background_Invisible();

                timerStart();
            }

        };
        prepareTimer.start();
    }

    private void ply1Button_Visible(){

        ImageView ply1_btnR =(ImageView) findViewById(R.id.ply1_btn1);
        ImageView ply1_btnO =(ImageView) findViewById(R.id.ply1_btn2);
        ImageView ply1_btnY =(ImageView) findViewById(R.id.ply1_btn3);
        ImageView ply1_btnG =(ImageView) findViewById(R.id.ply1_btn4);
        ImageView ply1_btnB =(ImageView) findViewById(R.id.ply1_btn5);
        ImageView ply1_btnP =(ImageView) findViewById(R.id.ply1_btn6);

        ply1_btnR.setVisibility(ply1_btnR.VISIBLE);
        ply1_btnO.setVisibility(ply1_btnO.VISIBLE);
        ply1_btnY.setVisibility(ply1_btnY.VISIBLE);
        ply1_btnG.setVisibility(ply1_btnG.VISIBLE);
        ply1_btnB.setVisibility(ply1_btnB.VISIBLE);
        ply1_btnP.setVisibility(ply1_btnP.VISIBLE);

    }
    private void ply1Button_Invisible(){

        ImageView ply1_btnR =(ImageView) findViewById(R.id.ply1_btn1);
        ImageView ply1_btnO =(ImageView) findViewById(R.id.ply1_btn2);
        ImageView ply1_btnY =(ImageView) findViewById(R.id.ply1_btn3);
        ImageView ply1_btnG =(ImageView) findViewById(R.id.ply1_btn4);
        ImageView ply1_btnB =(ImageView) findViewById(R.id.ply1_btn5);
        ImageView ply1_btnP =(ImageView) findViewById(R.id.ply1_btn6);

        ply1_btnR.setVisibility(ply1_btnR.INVISIBLE);
        ply1_btnO.setVisibility(ply1_btnO.INVISIBLE);
        ply1_btnY.setVisibility(ply1_btnY.INVISIBLE);
        ply1_btnG.setVisibility(ply1_btnG.INVISIBLE);
        ply1_btnB.setVisibility(ply1_btnB.INVISIBLE);
        ply1_btnP.setVisibility(ply1_btnP.INVISIBLE);

    }
    private void ply2Button_Visible(){

        ImageView ply2_btnR =(ImageView) findViewById(R.id.ply2_btn1);
        ImageView ply2_btnO =(ImageView) findViewById(R.id.ply2_btn2);
        ImageView ply2_btnY =(ImageView) findViewById(R.id.ply2_btn3);
        ImageView ply2_btnG =(ImageView) findViewById(R.id.ply2_btn4);
        ImageView ply2_btnB =(ImageView) findViewById(R.id.ply2_btn5);
        ImageView ply2_btnP =(ImageView) findViewById(R.id.ply2_btn6);

        ply2_btnR.setVisibility(ply2_btnR.VISIBLE);
        ply2_btnO.setVisibility(ply2_btnO.VISIBLE);
        ply2_btnY.setVisibility(ply2_btnY.VISIBLE);
        ply2_btnG.setVisibility(ply2_btnG.VISIBLE);
        ply2_btnB.setVisibility(ply2_btnB.VISIBLE);
        ply2_btnP.setVisibility(ply2_btnP.VISIBLE);

    }
    private void ply2Button_Invisible(){

        ImageView ply2_btnR =(ImageView) findViewById(R.id.ply2_btn1);
        ImageView ply2_btnO =(ImageView) findViewById(R.id.ply2_btn2);
        ImageView ply2_btnY =(ImageView) findViewById(R.id.ply2_btn3);
        ImageView ply2_btnG =(ImageView) findViewById(R.id.ply2_btn4);
        ImageView ply2_btnB =(ImageView) findViewById(R.id.ply2_btn5);
        ImageView ply2_btnP =(ImageView) findViewById(R.id.ply2_btn6);

        ply2_btnR.setVisibility(ply2_btnR.INVISIBLE);
        ply2_btnO.setVisibility(ply2_btnO.INVISIBLE);
        ply2_btnY.setVisibility(ply2_btnY.INVISIBLE);
        ply2_btnG.setVisibility(ply2_btnG.INVISIBLE);
        ply2_btnB.setVisibility(ply2_btnB.INVISIBLE);
        ply2_btnP.setVisibility(ply2_btnP.INVISIBLE);

    }

    public void clickPly1_Button(View view) {
        plyRecord = view.getTag().toString();

        //Player 1
        if(ply1Round.equals("att")){
            if(ply1_countNo<3) {
                //Player 1
                if (plyRecord.equals("p1_red")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Red";
                    ++ply1_countNo;
                } else if (plyRecord.equals("p1_orange")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Orange";
                    ++ply1_countNo;
                } else if (plyRecord.equals("p1_yellow")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Yellow";
                    ++ply1_countNo;
                } else if (plyRecord.equals("p1_green")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Green";
                    ++ply1_countNo;
                } else if (plyRecord.equals("p1_blue")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Blue";
                    ++ply1_countNo;
                } else if (plyRecord.equals("p1_purple")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Purple";
                    ++ply1_countNo;
                }

            }

            if(ply1_countNo == 3){
                ++ply1_countRound;
                ply1_countNo=0;

                ply1Button_Invisible();
                ply2Button_Visible();
            }
        }
        else if(ply1Round.equals("def")){
            if(ply1_countNo<3) {
                if (plyRecord.equals("p1_red")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Red";
                    ++ply1_countNo;
                } else if (plyRecord.equals("p1_orange")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Orange";
                    ++ply1_countNo;
                } else if (plyRecord.equals("p1_yellow")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Yellow";
                    ++ply1_countNo;
                } else if (plyRecord.equals("p1_green")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Green";
                    ++ply1_countNo;
                } else if (plyRecord.equals("p1_blue")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Blue";
                    ++ply1_countNo;
                } else if (plyRecord.equals("p1_purple")) {
                    ply1_record[ply1_countRound][ply1_countNo] = "Purple";
                    ++ply1_countNo;
                }
            }

            if(ply1_countNo == 3){

                ++ply1_countRound;

                ply1_countNo=0;

                int x = checkColor(ply1_countRound);

                switch(x){
                    case 0:
                        showRecord(x);
                        ply1Button_Invisible();
                        ply2Button_Visible();

                        ply1_countNo = 0;
                        ply1_countRound = 0;

                        setRound(ply2_countRound+1);

                        if(ply2_countRound==3){
                            ply1_countRound=3;
                        }
                        break;
                    case 1:
                        showRecord(x);
                        ply1Button_Invisible();
                        ply2Button_Visible();

                        ply1_countNo = 0;
                        ply1_countRound = 0;

                        setRound(ply2_countRound+1);

                        if(ply2_countRound==3){
                            ply1_countRound=3;
                        }
                        break;
                    case 2:
                        showRecord(x);
                        ply1Button_Invisible();
                        ply2Button_Visible();

                        ply1_countNo = 0;
                        ply1_countRound = 0;

                        setRound(ply2_countRound+1);

                        if(ply2_countRound==3){
                            ply1_countRound=3;
                        }
                        break;
                    case 3:
                        //win no need show and jump
                        break;
                }

            }

            if(ply1_countRound == 3){
                resetRound();

                ply1Button_Visible();
                ply2Button_Invisible();

                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        ply1_record[i][j] = null;
                        ply2_record[i][j] = null;
                    }
                }

                ply1_countNo = 0;
                ply1_countRound = 0;
                ply2_countNo = 0;
                ply2_countRound = 0;

                // Switch player 1 status
                ply1Round = "att";
                roundOfPly2_Visible();
                // Switch player 2 status
                ply2Round = "def";
                roundOfPly1_Invisible();
            }
            else if(ply1_countRound == ply2_countRound){

                setRound(ply2_countRound+1);

                ply1Button_Invisible();
                ply2Button_Visible();

                ply1_countNo = 0;
                ply1_countRound = 0;
            }

        }
    }
    public void clickPly2_Button(View view) {
        plyRecord = view.getTag().toString();
        //Player 2
        if(ply2Round.equals("att")){
            if(ply2_countNo<3) {
                if (plyRecord.equals("p2_red")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Red";
                    ply2_countNo++;
                } else if (plyRecord.equals("p2_orange")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Orange";
                    ply2_countNo++;
                } else if (plyRecord.equals("p2_yellow")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Yellow";
                    ply2_countNo++;
                } else if (plyRecord.equals("p2_green")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Green";
                    ply2_countNo++;
                } else if (plyRecord.equals("p2_blue")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Blue";
                    ply2_countNo++;
                } else if (plyRecord.equals("p2_purple")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Purple";
                    ply2_countNo++;
                }
            }
            if(ply2_countNo == 3){
                ++ply2_countRound;
                ply2_countNo=0;

                ply2Button_Invisible();
                ply1Button_Visible();
            }
        }
        else if(ply2Round.equals("def")){
            if(ply2_countNo<3) {
                if (plyRecord.equals("p2_red")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Red";
                    ++ply2_countNo;
                } else if (plyRecord.equals("p2_orange")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Orange";
                    ++ply2_countNo;
                } else if (plyRecord.equals("p2_yellow")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Yellow";
                    ++ply2_countNo;
                } else if (plyRecord.equals("p2_green")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Green";
                    ++ply2_countNo;
                } else if (plyRecord.equals("p2_blue")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Blue";
                    ++ply2_countNo;
                } else if (plyRecord.equals("p2_purple")) {
                    ply2_record[ply2_countRound][ply2_countNo] = "Purple";
                    ++ply2_countNo;
                }
            }
            if(ply2_countNo == 3){
                ++ply2_countRound;

                ply2_countNo=0;

                int x = checkColor(ply2_countRound);

                switch(x){
                    case 0:
                        showRecord(x);
                        ply2Button_Invisible();
                        ply1Button_Visible();

                        ply2_countNo = 0;
                        ply2_countRound = 0;

                        setRound(ply1_countRound+1);

                        if(ply1_countRound==3){
                            ply2_countRound=3;
                        }
                        break;
                    case 1:
                        showRecord(x);
                        ply2Button_Invisible();
                        ply1Button_Visible();

                        ply2_countNo = 0;
                        ply2_countRound = 0;

                        setRound(ply1_countRound+1);

                        if(ply1_countRound==3){
                            ply2_countRound=3;
                        }
                        break;
                    case 2:
                        showRecord(x);
                        ply2Button_Invisible();
                        ply1Button_Visible();

                        ply2_countNo = 0;
                        ply2_countRound = 0;

                        setRound(ply1_countRound+1);

                        if(ply1_countRound==3){
                            ply2_countRound=3;
                        }
                        break;
                    case 3:
                        //win no need show and jump
                        break;
                }

            }

            if(ply2_countRound == 3){
                resetRound();

                ply2Button_Visible();
                ply1Button_Invisible();

                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        ply1_record[i][j] = null;
                        ply2_record[i][j] = null;
                    }
                }

                ply1_countNo = 0;
                ply1_countRound = 0;
                ply2_countNo = 0;
                ply2_countRound = 0;

                // Switch player 1 status
                ply2Round = "att";
                roundOfPly1_Visible();
                // Switch player 2 status
                ply1Round = "def";
                roundOfPly2_Invisible();
            }
            else if(ply2_countRound == ply1_countRound){
                setRound(ply1_countRound+1);

                ply2Button_Invisible();
                ply1Button_Visible();

                ply2_countNo = 0;
                ply2_countRound = 0;
            }
        }

    }

    private void gameUI_Background_Invisible(){

        TextView btnBackground = (TextView) findViewById(R.id.mc_ui_background);
        btnBackground.setVisibility(btnBackground.INVISIBLE);

    }
    private void gameUI_Background_Visible(){

        TextView btnBackground = (TextView) findViewById(R.id.mc_ui_background);
        btnBackground.setVisibility(btnBackground.VISIBLE);

    }
    private void gameUI_start_btn_Invisible(){

        LinearLayout gameUiPlace = (LinearLayout) findViewById(R.id.mc_ui_place);
        gameUiPlace.setVisibility(gameUiPlace.INVISIBLE);

        TextView gameTitleWinner = (TextView) findViewById(R.id.mc_ui_gametitle_winner);
        gameTitleWinner.setVisibility(gameTitleWinner.INVISIBLE);

        Button gamestartBtn = (Button) findViewById(R.id.mc_ui_gamestart_btn);
        gamestartBtn.setVisibility(gamestartBtn.INVISIBLE);

    }
    private void gameUI_start_btn_Visible(){

        LinearLayout gameUiPlace = (LinearLayout) findViewById(R.id.mc_ui_place);
        gameUiPlace.setVisibility(gameUiPlace.VISIBLE);

        TextView gameTitleWinner = (TextView) findViewById(R.id.mc_ui_gametitle_winner);
        gameTitleWinner.setVisibility(gameTitleWinner.VISIBLE);

        Button gamestartBtn = (Button) findViewById(R.id.mc_ui_gamestart_btn);
        gamestartBtn.setVisibility(gamestartBtn.VISIBLE);

    }

    private void roundOfPly1_Visible(){
        ImageView roundOfPly1 = (ImageView) findViewById(R.id.ply1_round);
        roundOfPly1.setVisibility(roundOfPly1.VISIBLE);
    }
    private void roundOfPly1_Invisible(){
        ImageView roundOfPly1 = (ImageView) findViewById(R.id.ply1_round);
        roundOfPly1.setVisibility(roundOfPly1.INVISIBLE);
    }
    private void roundOfPly2_Visible(){
        ImageView roundOfPly2 = (ImageView) findViewById(R.id.ply2_round);
        roundOfPly2.setVisibility(roundOfPly2.VISIBLE);
    }
    private void roundOfPly2_Invisible(){
        ImageView roundOfPly2 = (ImageView) findViewById(R.id.ply2_round);
        roundOfPly2.setVisibility(roundOfPly2.INVISIBLE);
    }

    private void checkScore(){
        TextView showWIn = (TextView) findViewById(R.id.mc_ui_gametitle_winner);
        Button changeStartBtn = (Button) findViewById(R.id.mc_ui_gamestart_btn);

        changeStartBtn.setText("Play again");

        if(ply1_score > ply2_score){
            showWIn.setText("Player 1 win !");
        }
        else if(ply2_score > ply1_score){
            showWIn.setText("Player 2 win !");
        }
        else{
            showWIn.setText("Draw !");
        }

    }
    private void resetUI(){
        TextView showWIn = (TextView) findViewById(R.id.mc_ui_gametitle_winner);
        Button changeStartBtn = (Button) findViewById(R.id.mc_ui_gamestart_btn);

        changeStartBtn.setText(R.string.mc_ui_sb_text);
        showWIn.setText(R.string.mc_ui_gametitle_default);

    }

    private void setRound(int i){
        TextView round = (TextView) findViewById(R.id.rounds);
        round.setText("Round :  " + i);
    }
    private void resetRound(){
        TextView round = (TextView) findViewById(R.id.rounds);
        round.setText(R.string.mc_rounds_default);
    }

    private void showRecord(int i){
        //Round 1
        TextView record1_1=(TextView) findViewById(R.id.record1_1);
        TextView record1_2=(TextView) findViewById(R.id.record1_2);
        TextView record1_3=(TextView) findViewById(R.id.record1_3);
        //Round 2
        TextView record2_1=(TextView) findViewById(R.id.record2_1);
        TextView record2_2=(TextView) findViewById(R.id.record2_2);
        TextView record2_3=(TextView) findViewById(R.id.record2_3);
        //Round 3
        TextView record3_1=(TextView) findViewById(R.id.record3_1);
        TextView record3_2=(TextView) findViewById(R.id.record3_2);
        TextView record3_3=(TextView) findViewById(R.id.record3_3);

        if(ply1Round.equals("def")){
            if(i == 0){
                record1_1.setText(ply2_record[i][0]);
                record1_2.setText(ply2_record[i][1]);
                record1_3.setText(ply2_record[i][2]);
            }
            else if(i == 1){
                record2_1.setText(ply2_record[i][0]);
                record2_2.setText(ply2_record[i][1]);
                record2_3.setText(ply2_record[i][2]);
            }
            else if(i == 2){
                record3_1.setText(ply2_record[i][0]);
                record3_2.setText(ply2_record[i][1]);
                record3_3.setText(ply2_record[i][2]);
            }
        }
        if(ply2Round.equals("def")){
            if(i == 0){
                record1_1.setText(ply1_record[i][0]);
                record1_2.setText(ply1_record[i][1]);
                record1_3.setText(ply1_record[i][2]);
            }
            else if(i == 1){
                record2_1.setText(ply1_record[i][0]);
                record2_2.setText(ply1_record[i][1]);
                record2_3.setText(ply1_record[i][2]);
            }
            else if(i == 2){
                record3_1.setText(ply1_record[i][0]);
                record3_2.setText(ply1_record[i][1]);
                record3_3.setText(ply1_record[i][2]);
            }
        }

        //only use to wait 3 seconds
        resetRecord();


    }
    private void resetRecord(){

        showRecordTimer = new CountDownTimer(3000,100) {
            //Round 1
            TextView record1_1=(TextView) findViewById(R.id.record1_1);
            TextView record1_2=(TextView) findViewById(R.id.record1_2);
            TextView record1_3=(TextView) findViewById(R.id.record1_3);
            //Round 2
            TextView record2_1=(TextView) findViewById(R.id.record2_1);
            TextView record2_2=(TextView) findViewById(R.id.record2_2);
            TextView record2_3=(TextView) findViewById(R.id.record2_3);
            //Round 3
            TextView record3_1=(TextView) findViewById(R.id.record3_1);
            TextView record3_2=(TextView) findViewById(R.id.record3_2);
            TextView record3_3=(TextView) findViewById(R.id.record3_3);

            public void onTick(long l) {
                ply1Button_Invisible();
                ply2Button_Invisible();

            }
            public void onFinish() {
                if(ply1Round.equals("def")){
                    ply2Button_Visible();
                }
                else if(ply2Round.equals("def")){
                    ply1Button_Visible();
                }

                record1_1.setText(R.string.mc_record_name_null);
                record1_2.setText(R.string.mc_record_name_null);
                record1_3.setText(R.string.mc_record_name_null);
                record2_1.setText(R.string.mc_record_name_null);
                record2_2.setText(R.string.mc_record_name_null);
                record2_3.setText(R.string.mc_record_name_null);
                record3_1.setText(R.string.mc_record_name_null);
                record3_2.setText(R.string.mc_record_name_null);
                record3_3.setText(R.string.mc_record_name_null);

            }
        };

        showRecordTimer.start();

    }

    private void resetScore(){
        TextView ply1_score = (TextView) findViewById(R.id.ply1_mark);
        TextView ply2_score = (TextView) findViewById(R.id.ply1_mark);
        TextView timer_300s = (TextView) findViewById(R.id.time_300s);

        ply1_score.setText(R.string.mc_ply1_default_score);
        ply2_score.setText(R.string.mc_ply2_default_score);
        timer_300s.setText(R.string.mc_default_time_300s);
    }

    public void clickStartButton(View view){

        gameUI_start_btn_Invisible();
        PrepareThreeSeconds();

    }

    private void timerStart(){

        timer_300s = new CountDownTimer(300000, 100) {
            public void onTick(long l) {
                TextView time_300s = (TextView) findViewById(R.id.time_300s);
                time_300s.setText("Time :  " + l / 1000);
            }
            public void onFinish() {

                checkScore();
                resetRound();
                resetScore();

                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        ply1_record[i][j] = null;
                        ply2_record[i][j] = null;
                    }
                }

                ply1_countRound = 0;
                ply1_countNo = 0;

                ply2_countRound = 0;
                ply2_countNo = 0;

                ply1Round = "";
                ply2Round = "";

                ply1Button_Invisible();
                ply2Button_Invisible();
                roundOfPly1_Invisible();
                roundOfPly2_Invisible();

                timer_300s.cancel();
                prepareTimer.cancel();

                if(showRecordTimer != null) {
                    showRecordTimer.cancel();
                }

                gameUI_Background_Visible();
                gameUI_start_btn_Visible();
            }
        };
        timer_300s.start();
    }

    private int checkColor(int k){
        TextView ply1_mark = (TextView) findViewById(R.id.ply1_mark);
        TextView ply2_mark = (TextView) findViewById(R.id.ply2_mark);

        int countWin = 0;

        for(int i = 0; i<k ;i++) {
            for(int j = 0; j < 3; j++) {
                if (ply1Round.equals("def")) {
                    if (ply1_record[i][j].equals(ply2_record[i][j])) {
                        countWin++;
                    }
                    else {
                        return i;
                    }

                }
                else if (ply2Round.equals("def")) {
                    if (ply2_record[i][j].equals(ply1_record[i][j])) {
                        countWin++;
                    }
                    else {
                        return i;
                    }
                }
            }
            if (countWin == (3*(i+1))){
                if (ply1Round.equals("def")) {
                    if(i+1 == ply1_countRound) {
                        ply1_score += 1 * (i + 1);
                        ply1_mark.setText("Score :  " + ply1_score + "   ");
                    }
                }
                if (ply2Round.equals("def")) {
                    if(i+1 == ply2_countRound){
                        ply2_score += 1 * (i + 1);
                        ply2_mark.setText("Score :  " + ply2_score + "   ");
                    }
                }
            }
        }

        return 3;
    }

    private void reset() {
        resetUI();

        resetRound();

        resetScore();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                ply1_record[i][j] = null;
                ply2_record[i][j] = null;
            }
        }

        ply1_countRound = 0;
        ply1_countNo = 0;

        ply2_countRound = 0;
        ply2_countNo = 0;

        ply1Round = "";
        ply2Round = "";

        ply1Button_Invisible();
        ply2Button_Invisible();
        roundOfPly1_Invisible();
        roundOfPly2_Invisible();

        timer_300s.cancel();
        prepareTimer.cancel();

        if(showRecordTimer != null) {
            showRecordTimer.cancel();
        }

        gameUI_Background_Visible();
        gameUI_start_btn_Visible();

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
