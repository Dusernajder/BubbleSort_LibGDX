package com.mygdx.bubblesort;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;

import java.util.ArrayList;

public class MyTask extends Timer.Task {

    private ArrayList<Rectangle> list;
    private int i = 0;

    public MyTask (ArrayList<Rectangle> list){
        this.list = list;
    }

    @Override
    public void run() {

        sort(list);
    }

    void sort (ArrayList<Rectangle> list) {

        if (i < list.size()) {
            for (int j = 0; j < list.size() - 1 - i; j++) {


                if (list.get(j).getHeight() > list.get(j + 1).getHeight()) {

                    float tempX = list.get(j).getX();
                    list.get(j).setX(list.get(j + 1).getX());
                    list.get(j + 1).setX(tempX);


                }
            }
        }
        else {
            System.out.println("Finished");
            System.exit(0);
        }
        i++;
    }

    public ArrayList<Rectangle> getList() {

        return list;
    }

    void print(){

        System.out.println(i);
    }
}
