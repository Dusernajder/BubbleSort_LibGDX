package com.mygdx.bubblesort;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;

import java.util.ArrayList;
import java.util.Random;

public class BubbleSort extends ApplicationAdapter {


    private ArrayList<Rectangle> list;
    private ShapeRenderer renderer;
    private MyTask task;
    Timer timer;

    private float speed = 0.01f;


    @Override
    public void create() {

        Gdx.graphics.setWindowedMode(1400, 720);
        renderer = new ShapeRenderer();
        list = fillList(1);
        task = new MyTask(list);
        timer = Timer.instance();
        timer.scheduleTask(task, speed, speed);
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        list = task.getList();

        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.BLACK);

        for (Rectangle rectangle : list) {
            renderer.rect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        }

        renderer.end();
    }


    @Override
    public void dispose() {

        renderer.dispose();
    }


    ArrayList<Rectangle> fillList(int intensity) {

        ArrayList<Rectangle> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < Gdx.graphics.getWidth() / intensity; i++) {

            Rectangle rect = new Rectangle();
            rect.setX(i * intensity);
            rect.setY(0);
            rect.setWidth(intensity);
            rect.setHeight(random.nextInt(Gdx.graphics.getHeight()));

            list.add(rect);
        }
        return list;
    }
}