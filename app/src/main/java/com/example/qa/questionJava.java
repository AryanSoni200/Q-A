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

public class questionJava extends AppCompatActivity {

    String questions[] = {
            "Who invented Java Programming?",
            "Which statement is true about Java?",
            "Which component is used to compile, debug and execute the java programs?",
            "Which one of the following is not a Java feature?",
            "Which is valid C expression?"
    };
    String answers[] = {
            "James Gosling",
            "Java is a platform-independent programming language",
            "JDK",
            "Use of pointers",
            "keyword"
    };
    String options[] = {
            "Steve Jobs", "James Gosling", "Dennis Ritchie", "Rasmus Lerdorf",
            "Java is a sequence-dependent programming language", "Java is a code dependent programming language", "Java is a platform-independent programming languag", "Object-oriented",
            "JRE", "JIT", "JDK", "JVM",
            "Use of pointers", "Portable", "Dynamic and Extensible", "Object-oriented",
            "identifier & keyword", "identifier", "keyword", "none of the mentioned"
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
                    Toast.makeText(questionJava.this, "Please Select one choic", Toast.LENGTH_SHORT).show();
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
                        Intent in = new Intent(questionJava.this, ResultJava.class);
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