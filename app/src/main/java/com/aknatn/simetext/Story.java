package com.aknatn.simetext;

import android.view.View;

import com.aknatn.simetext.GameScreen;

public class Story {
    GameScreen gs;
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    boolean masterSword = false;
    boolean killedPlant = false;
    public Story(GameScreen gs){
        this.gs = gs;
    }

    public void selectPosition(String position){
        switch(position){
            case "startingPoint": startingPoint(); break;
            case "sign": sign(); break;
            case "pipe": pipe(); break;
            case "plant": plant(); break;
            case "dead": dead(); break;
            case "goTitleScreen": gs.goTitleScreen(); break;
            case "sword": sword(); break;
            case "monster": monster(); break;
            case "attack": attack(); break;
        }
    }

    public void startingPoint() {
        gs.image.setImageResource(R.drawable.trail);
        gs.text.setText("You are standing on a road and there is a wooden sign nearby.");

        gs.button1.setText("Go North");
        gs.button2.setText("Go East");
        gs.button3.setText("Go West");
        gs.button4.setText("Read the sign");

        nextPosition1 = "monster";
        nextPosition2 = "sword";
        nextPosition3 = "pipe";
        nextPosition4 = "sign";

        showAllButtons();
    }

    public void showAllButtons() {
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
        gs.button4.setVisibility(View.VISIBLE);
    }

    public void sign(){
        gs.image.setImageResource(R.drawable.woodensign);
        gs.text.setText("The sign says,\n\nMonster Ahead!");

        gs.button1.setText("Back");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "startingPoint";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void pipe(){
        gs.image.setImageResource(R.drawable.warppipe);
        gs.text.setText("You find a giant pipe.");

        gs.button1.setText("Look inside");
        gs.button2.setText("Go back");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "plant";
        nextPosition2 = "startingPoint";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void plant(){
        if(!masterSword) {
            gs.image.setImageResource(R.drawable.carnivorousplant);
            gs.text.setText("Piranha plant is inside.\nAlas you are easten by it.");

            gs.button1.setText(">");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "dead";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }else{
            gs.image.setImageResource(R.drawable.carnivorousplant);
            gs.text.setText("You have defeated the piranha plant with your master sword!\n\nYou feel much stronger now.");
            killedPlant = true;

            gs.button1.setText("Back");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "startingPoint";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void sword(){
        gs.image.setImageResource(R.drawable.swordaltar);
        gs.text.setText("You find a Master Sword!.\n(You have a Master Sword now.)");
        masterSword = true;

        gs.button1.setText("Back");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "startingPoint";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void monster(){
        gs.image.setImageResource(R.drawable.gargoyle);
        gs.text.setText("You encounter a gargoyle!!!");
        masterSword = true;

        gs.button1.setText("Attack");
        gs.button2.setText("Run");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "attack";
        nextPosition2 = "startingPoint";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void attack(){
        if(masterSword && killedPlant){
            gs.image.setImageResource(R.drawable.opentreasurechest);
            gs.text.setText("You have defeated the gargoyle with your Master Sword and experience, you get the treasure and the world is saved!!!");

            gs.button1.setText("Go to Title Screen");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "goTitleScreen";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }else{
            gs.image.setImageResource(R.drawable.hastygrave);
            gs.text.setText("You are too weak and died.\nYour adventure ends here.");

            gs.button1.setText("Go to Title Screen");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "goTitleScreen";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void dead(){
        gs.image.setImageResource(R.drawable.hastygrave);
        gs.text.setText("You have died.\nYour adventure ends here.");

        gs.button1.setText("Go to Title Screen");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "goTitleScreen";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }
}
