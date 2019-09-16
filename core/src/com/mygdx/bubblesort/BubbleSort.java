package com.mygdx.bubblesort;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Timer;

import java.util.ArrayList;
import java.util.Random;

public class BubbleSort extends ApplicationAdapter {


    private ArrayList<Vector4> list;
    private ShapeRenderer renderer;
    private MyTask task;
    Timer timer;


    @Override
    public void create() {

        Gdx.graphics.setWindowedMode(1080, 720);
        renderer = new ShapeRenderer();
        list = fillList(100);
        task = new MyTask(list);
        timer = new Timer();
    }

    @Override
    public void render() {

		timer.postTask(task);
    	list = task.getList();

		renderer.begin(ShapeType.Line);
		renderer.setColor(Color.BLACK);

		for (Vector4 vector : list) {
			System.out.println(vector.getHeight());
			renderer.line(vector.getX1(), vector.getY1(), vector.getX2(), vector.getY2());
		}

		renderer.end();

		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


    @Override
    public void dispose() {

        renderer.dispose();
    }


	ArrayList<Vector4> fillList(int intensity) {

		// The higher intensity gets, less values are displayed
		ArrayList<Vector4> list = new ArrayList<>();
		Random random = new Random();


		for (int i = 0; i < Gdx.graphics.getWidth() / intensity; i++) {

			Vector4 vector4 = new Vector4();

			vector4.setX1(intensity * i);
			vector4.setY1(0);
			vector4.setX2(vector4.getX1());
			vector4.setY2(random.nextInt(Gdx.graphics.getHeight()));

			list.add(vector4);
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
//					Gdx.gl.glClearColor(1, 1, 1, 1);
//					Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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








