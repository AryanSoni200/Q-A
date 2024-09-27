package com.example.qa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class questionPython extends AppCompatActivity {

    String questions[] = {
            "Who developed Python Programming Language?",
            "Which type of Programming does Python support?",
            "Is Python case sensitive when dealing with identifiers?",
            "Which of the following is the correct extension of the Python file?",
            "Is Python code compiled or interpreted?"
    };
    String answers[] = {
            "Guido van Rossum",
            "all of the mentioned",
            "Yes",
            ".py",
            "Python code is both compiled and interpreted"
    };
    String options[] = {
            "Steve Jobs", "Guido van Rossum", "Dennis Ritchie", "Rasmus Lerdorf",
            "object-oriented programming", "structured programming", "functional programming", "all of the mentioned",
            "No", "Yes", "machine dependent", "none of the mentioned",
            ".python", "Portable", ".py", ".p",
            "Python code is both compiled and interpreted", "Python code is neither compiled nor interpreted", "Python code is only compiled", "Python code is only interpreted"
    };
    int flag = 0;

    public static int marks = 0, correct = 0, wrong = 0;

    TextView tv;
    Button submit, quit;
    RadioGroup radioG;
    RadioButton r1, r2, r3, r4;
    private TextView questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final TextView score = (TextView) findViewById(R.id.textview4);
        TextView textView = (TextView) findViewById(R.id.displayName);
        Intent intent = getIntent();

        questionNumber = findViewById(R.id.displayName);
        submit = (Button) findViewById(R.id.button3);
        quit = (Button) findViewById(R.id.button4);
        tv = (TextView) findViewById(R.id.tvQue);

        radioG = (RadioGroup) findViewById(R.id.answerGroup);

        r1 = (RadioButton) findViewById(R.id.radioButton1);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);

        tv.setText(questions[flag]);
        r1.setText(options[0]);
        r2.setText(options[1]);
        r3.setText(options[2]);
        r4.setText(options[3]);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioG.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(questionPython.this, "Please Select one choic", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = (RadioButton) findViewById(radioG.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if (ansText.equals(answers[flag])) {
                    correct++;
//                    Toast.makeText(questionActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
//                    Toast.makeText(questionActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null) {
                    score.setText("" + correct);
                    if (flag < questions.length) {
                        tv.setText(questions[flag]);
                        r1.setText(options[flag * 4]);
                        r2.setText(options[flag * 4 + 1]);
                        r3.setText(options[flag * 4 + 2]);
                        r4.setText(options[flag * 4 + 3]);

                        questionNumber.setText(flag + "/" + questions.length + "Question");
                    } else {
                        marks = correct;
                        Intent in = new Intent(questionPython.this, ResultPython.class);
                        startActivity(in);
                    }

                    radioG.clearCheck();
                }
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(i);
            }
        });
    }
}