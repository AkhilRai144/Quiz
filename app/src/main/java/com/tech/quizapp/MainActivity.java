package com.tech.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView questionText;
    Button btn1, btn2, btn3, btn4, submit;
    int flag = 0;
    int score = 0;
    String selectedAnswer="";
    int totalQuestion = QuestionModels.question.length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = findViewById(R.id.questionText);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        submit = findViewById(R.id.submit);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        submit.setOnClickListener(this);


        loadQuestion();


    }

    private void loadQuestion() {
        if (flag == totalQuestion){
           finishQuiz();
            return;
        }
        questionText.setText(QuestionModels.question[flag]);
        btn1.setText(QuestionModels.answer[flag][0]);
        btn2.setText(QuestionModels.answer[flag][1]);
        btn3.setText(QuestionModels.answer[flag][2]);
        btn4.setText(QuestionModels.answer[flag][3]);
    }

    private void finishQuiz() {
        String passStatus = "";
        if (score>totalQuestion*0.60){
            passStatus = "Passed";
        }else {
            passStatus = "Failed";
        }

       AlertDialog.Builder alertDialog =  new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage( "Score is "+score+ " out of "+totalQuestion)
                .setCancelable(false)
                .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restartQuiz();
                    }

                });
        alertDialog.show();
    }
    void restartQuiz(){
        score=0;
        flag=0;
        loadQuestion();
    }

    @Override
    public void onClick(View view) {
        btn1.setBackgroundColor(Color.WHITE);
        btn2.setBackgroundColor(Color.WHITE);
        btn3.setBackgroundColor(Color.WHITE);
        btn4.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.submit) {
            if (selectedAnswer.equals(QuestionModels.correctAns[flag])) {
                score++;
            }
            flag++;
            loadQuestion();

        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }

    }
}

