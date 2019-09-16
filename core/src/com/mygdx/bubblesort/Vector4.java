package com.mygdx.bubblesort;

import com.badlogic.gdx.math.Vector2;

public class Vector4 {

    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public Vector4(){

        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;

    }

    public Vector4(int x1, int y1, int x2, int y2){

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }

    public int getX1() {

        return x1;
    }

    public void setX1(int x1) {

        this.x1 = x1;
    }

    public int getY1() {

        return y1;
    }

    public void setY1(int y1) {

        this.y1 = y1;
    }

    public int getX2() {

        return x2;
    }

    public void setX2(int x2) {

        this.x2 = x2;
    }

    public int getY2() {

        return y2;
    }

    public void setY2(int y2) {

        this.y2 = y2;
    }

    public int getHeight(){
        return y2 - y1;
    }
}
