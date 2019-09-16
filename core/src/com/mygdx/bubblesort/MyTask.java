package com.mygdx.bubblesort;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;

import java.util.ArrayList;

public class MyTask extends Timer.Task {

    private ArrayList<Rectangle> list;
    private int i = 0;
    private int j = 0;

    public MyTask (ArrayList<Rectangle> list){
        this.list = list;
    }

    @Override
    public void run() {

        sort(list);
    }

    void sort (ArrayList<Rectangle> list) {

        if (i < list.size() - 1) {
            if (j < list.size() - 1 - i) {

                if (list.get(j).getHeight() > list.get(j + 1).getHeight()) {

                    Rectangle temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);

                }

                j++;
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
}
