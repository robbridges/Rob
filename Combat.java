package com.company;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Combat  {
    Scanner sc = CharBuilder.sc;
    Random randNum = new Random();

    List<Enemy> enemyList = new Enemy().createList();
    Enemy enemy = enemyList.get(randNum.nextInt(enemyList.size()));

    CharBuilder character = new CharBuilder("warrior", 6, 6, 6, 6, 40, 30).createHero();

    int mCharStrength = character.getStrength();
     int mCharHitpoints = character.getHP();
     int mEnemyHitpoints = enemy.getHP();
     int mEnemyStr = enemy.getStr();
     String mEnemyName = enemy.getName();






    public void initiateCombat() {



        System.out.printf("A %s appears, it has %d hitpoints, and it's strength is %s \n", mEnemyName, mEnemyHitpoints, mEnemyStr);
    }
    public void playersTurn() {

        System.out.println("It is your turn, your available actions are attack, or use a skill");
        String actionAnswer = sc.nextLine();
        if (actionAnswer.equalsIgnoreCase("attack")) {
            charAttack();


        }


        else {
            System.out.println("Sorry, please choose attack or skill ");
            playersTurn();
        }
    }
    public void enemyTurn() {

        enemyAttack();


    }
    public void combat() {

        initiateCombat();
        do {


            playersTurn();
            if (mEnemyHitpoints <= 0) {
                System.out.println("You have defeated the enemy, congratulations");
                break;

            }
            enemyTurn();
        } while (mEnemyHitpoints >= 0 || mCharHitpoints >= 0);
    }

    private int enemyAttack() {

        mCharHitpoints -= mEnemyStr;
        System.out.printf("It is the enemy's turn, it attacks doing %s damage, your current hp is %s \n",
                mEnemyStr, mCharHitpoints);
        return mEnemyStr;
    }

    public int charAttack() {

        mEnemyHitpoints -= mCharStrength;
        System.out.printf("You attack the enemy, doing %s damage, the enemy currently has %s hp left \n", mCharStrength,
                mEnemyHitpoints);
        return mCharStrength;


    }





}
