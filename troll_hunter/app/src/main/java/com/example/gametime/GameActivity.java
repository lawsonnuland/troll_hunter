package com.example.gametime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        updateText();
    }

    int damage;
    int hp = 100;
    int trollhealth = 100;


    public void updateText(){
        trollhealth -= damage;
        TextView textView = findViewById(R.id.textView2);
        if (hp >0) {
            if (hp ==100 && trollhealth > 99) {
                textView.setText("You are face to face with a deadly troll! To arms! It has 100 health.");
            } else if (!(trollhealth == 100) && trollhealth > 0){
                textView.setText("You did " + damage + " damage. You have " + hp + " hp remaining. The troll has " + trollhealth + " remaining.");
            } else {
                Intent win = new Intent(this, Victory.class );
                startActivity(win);
            }
        } else if (hp <= 0 && trollhealth > 0){
            Intent loss = new Intent(this, Loss.class);
            startActivity(loss);
        } else if (hp <= 0 && trollhealth<=0) {
            Intent neither = new Intent(this, Neither.class);
            startActivity(neither);
        }
    }



    public void attack(View view){
        damage = 6;
        hp -=5;
        updateText();
    }

    public void defend(View view){
        damage = 0;
        if(hp<=98) {
            hp += 2;
        }
        updateText();
    }

    public void magic(View view){
        damage = 8;
        hp -= 10;
        updateText();
    }

    public void run(View view){
        damage = 0;
        hp = 0;
        updateText();
    }
}
