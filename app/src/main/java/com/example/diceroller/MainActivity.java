package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText Number;
    TextView Message, Counter, tv, tv2;
    int count;
     static ArrayList<String> question = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Number = findViewById(R.id.number);
        Message = findViewById(R.id.message);
        Counter = findViewById(R.id.counter);
        tv = this.findViewById(R.id.numberTextView);
        tv2 = findViewById(R.id.icebreakermsg);


        question.add("If you could go anywhere in the world, where would you go?");
        question.add("If you were stranded on a desert island, what three things would you want to take with you?");
        question.add("If you could eat only one food for the rest of your life, what would that be?");
        question.add("If you won a million dollars, what is the first thing you would buy?");
        question.add("If you could spaned the day with one fictional character, who would it be?");
        question.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public int roll_the_dice(int n){
        Random r = new Random();
        int number = r.nextInt(n);
        return number;
    }
public void change(View view){
    Intent intent = new Intent(this,Main2Activity.class);
    startActivity(intent);
}

    public void on_button_click(View view){

        tv.setText(Integer.toString(roll_the_dice(7-1)+1));

        if(Number.getText().toString().equals(tv.getText().toString())){
            Message.setText("Congratulation!!!");
            count++;
            Counter.setText("Number of matched: " + count);
        }else{
            Message.setText("Not A Match!!");
        }

    }
     public void icebreaker(View view){
        int num = roll_the_dice(question.size());
        tv2.setText(question.get(num));


     }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
