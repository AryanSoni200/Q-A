package com.example.qa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class ResultActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;
    Button Restart;
    CircularProgressBar circularProgressBar;
    TextView ResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv1 = findViewById(R.id.tvRes);
        tv2 = findViewById(R.id.tvRes2);
        tv3 = findViewById(R.id.tvRes3);
        Restart = findViewById(R.id.reStart);
        circularProgressBar = findViewById(R.id.circulatProgressBar);
        ResultText = findViewById(R.id.resultText);

        circularProgressBar.setProgress(questionActivity.correct);

        StringBuffer sb1 = new StringBuffer();
        sb1.append("Correct Answer:" + questionActivity.correct + "\n");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answer:" + questionActivity.wrong + "\n");

        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score:" + questionActivity.correct + "\n");

        StringBuffer sb4 = new StringBuffer();
        sb4.append(questionActivity.correct + "/" + "5");

        tv1.setText(sb1);
        tv2.setText(sb2);
        tv3.setText(sb3);
        ResultText.setText(sb4);

        questionActivity.correct = 0;
        questionActivity.wrong = 0;

        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}