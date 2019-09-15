package com.mygdx.bubblesort;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class BubbleSort extends ApplicationAdapter {


	private ArrayList<Rectangle> list;
	private ShapeRenderer renderer;
	private int i = 0;

	@Override
	public void create() {

		Gdx.graphics.setWindowedMode(1080, 720);
		list = fillList();
		renderer = new ShapeRenderer();
	}

	@Override
	public void render() {

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderer.begin(ShapeType.Filled);
		renderer.setColor(Color.BLACK);

		sort(list);

		for (Rectangle rectangle : list) {
			System.out.println(rectangle.getHeight());
			renderer.rect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
		}
		renderer.end();
	}

	@Override
	public void dispose() {

		renderer.dispose();
	}

	void sort(ArrayList<Rectangle> list) {

		if (i < list.size()) {
			for (int j = 0; j < list.size() - 1 - i; j++) {

				if (list.get(j).getHeight() > list.get(j + 1).getHeight()) {

					Rectangle temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
			i++;
		}
		else {
			System.out.println("Finished");
			System.exit(0);
		}
	}

	ArrayList<Rectangle> fillList() {

		int intensity = 10;
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

//	void swap(ArrayList<Rectangle> list, int a, int b){
//		Rectangle temp = list.get(a);
//		list.set(a, list.get(b));
//		list.set(b, temp);
//	}

}








