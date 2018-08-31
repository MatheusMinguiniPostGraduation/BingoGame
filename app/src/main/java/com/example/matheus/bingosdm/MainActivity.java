package com.example.matheus.bingosdm;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final Integer LIMIT = 75;

    private Random random;
    private Integer numbersLeft;
    private ArrayList<Integer> sortedList;

    //Screen components
    private TextView numbersLeftView;
    private TextView numberSortedView;
    private TextView numberSorteListdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeActivityWithDefaultParameters();

    }

    private void initializeActivityWithDefaultParameters() {
        numbersLeft = LIMIT;

        random = new Random(System.currentTimeMillis());
        sortedList = new ArrayList<Integer>();

        numbersLeftView = (TextView) findViewById(R.id.numbersLeft);
        numberSortedView = (TextView) findViewById(R.id.numberSorted);
        numberSorteListdView = (TextView) findViewById(R.id.numberSorteList);

        numberSortedView.setText("@string/no_numbers_sorted");
        numbersLeftView.setText(LIMIT.toString());
        Button replayButton = findViewById(R.id.replayButton);
        replayButton.setVisibility(View.INVISIBLE);
    }

    public void sortNumbers(View button){
       if(button.getId() == R.id.button){
           Integer number;

           if(sortedList.size() < LIMIT){
               addSortNumber();

               if(sortedList.size() == LIMIT) setUpButton();

           }
       }
    }

    private void addSortNumber() {
        Integer number;
        do{
            number = random.nextInt(LIMIT) + 1;
        }while(sortedList.contains(number));

        numbersLeft--;

        numberSortedView.setText(number.toString());
        numbersLeftView.setText(numbersLeft.toString());
        String currentText = numberSorteListdView.getText().toString().concat(" [" + number.toString() + "] ");
        numberSorteListdView.setText(currentText);

        sortedList.add(number);
    }

    private void setUpButton(){
        Button sortButton = (Button) findViewById(R.id.button);
        Button replayButton = (Button)  findViewById(R.id.replayButton);
        replayButton.setVisibility(View.VISIBLE);
        sortButton.setBackgroundColor(Color.BLACK); //sortButton.setEnabled(false);
        Toast.makeText(this, "Não há mais números à serem sorteados", Toast.LENGTH_SHORT).show();
    }
}
