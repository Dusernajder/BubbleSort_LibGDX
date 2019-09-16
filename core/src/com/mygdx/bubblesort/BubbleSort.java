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


    @Override
    public void create() {

        Gdx.graphics.setWindowedMode(1080, 720);
        renderer = new ShapeRenderer();
        list = fillList(10);
        task = new MyTask(list);
        timer = Timer.instance();
        timer.scheduleTask(task, 0.2f, 0.2f);
    }

    @Override
    public void render() {

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    	list = task.getList();

		renderer.begin(ShapeType.Filled);
		renderer.setColor(Color.BLACK);

		for (Rectangle rectangle : list) {
			System.out.println(rectangle.getHeight());
			renderer.rect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
		}

		renderer.end();


		System.out.println("\n");


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



//    void sort(ArrayList<Vector4> list) {
//
//        if (i < list.size()) {
//            for (int j = 0; j < list.size() - 1 - i; j++) {
//
//
//                if (list.get(j).getHeight() > list.get(j + 1).getHeight()) {
//
//
//
//                    Vector4 temp = list.get(j);
//                    list.set(j, list.get(j + 1));
//                    list.set(j + 1, temp);
//
//                    for (Vector4 vector : list) {
//						System.out.println(vector.getHeight());
//
//                        renderer.line(vector.getX1(), vector.getY1(), vector.getX2(), vector.getY2());
//                    }
//
//                    timer.delay(1000);
//
//                }
//            }
//            i++;
//        }
//        else {
//            System.out.println("Finished");
//            System.exit(0);
//        }
//    }




//	void swap(ArrayList<Vector4> list, int a, int b){
//		Vector4 temp = list.get(a);
//		list.set(a, list.get(b));
//		list.set(b, temp);
//	}

}








