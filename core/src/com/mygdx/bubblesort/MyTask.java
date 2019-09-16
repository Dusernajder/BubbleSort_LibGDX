package com.mygdx.bubblesort;


import com.badlogic.gdx.utils.Timer;

import java.util.ArrayList;

public class MyTask extends Timer.Task {

    private ArrayList<Vector4> list;
    private int i = 0;

    public MyTask (ArrayList<Vector4> list){
        this.list = list;
    }

    @Override
    public void run() {

        sort(list);
    }

    void sort (ArrayList<Vector4> list) {

        if (i <= list.size()) {
            for (int j = 0; j < list.size() - 1 - i; j++) {

                if (list.get(j).getHeight() > list.get(j + 1).getHeight()) {

                    Vector4 temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);

                }
            }
        }
        else {
            System.out.println("Finished");
            System.exit(0);
        }

        i++;

        return;
    }

    public ArrayList<Vector4> getList() {

        return list;
    }
}
