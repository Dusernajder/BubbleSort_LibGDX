package com.mygdx.bubblesort;


import com.badlogic.gdx.Gdx;
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

                    Rectangle rect1 = list.get(j);
                    Rectangle rect2 = list.get(j + 1);


                    float tempX = rect1.getX();
                    rect1.setX(rect2.getX());
                    rect2.setX(tempX);


                    Rectangle temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);

                }
            }
        }
        else {
            System.out.println("Finished");
        }

        i++;
    }

    public ArrayList<Rectangle> getList() {

        return list;
    }
}
