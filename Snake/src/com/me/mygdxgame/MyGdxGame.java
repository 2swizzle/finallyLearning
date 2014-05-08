package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;

	
	private Texture snakeTexture;
	private Sprite snake;
	private BitmapFont font;
	
	@Override
	public void create() {		
		Texture.setEnforcePotImages(false); 

		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(w, h);
		batch = new SpriteBatch();
		font = new BitmapFont();

		
		snakeTexture = new Texture(Gdx.files.internal("data/snake.png"));
		snake = new Sprite(snakeTexture);
		snake.setPosition(0, 0);

	}

	@Override
	public void dispose() {

	}

	@Override
	public void render() {		
		
		
		
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			
			if((snake.getX() + snake.getWidth()) < Gdx.graphics.getWidth())
			{
				snake.setX(snake.getX() + 1);
			}

		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			
			if(snake.getX() > 0)
			{
				snake.setX(snake.getX() - 1);
			}

		}
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		//batch.setProjectionMatrix(camera.combined);
		
		batch.begin();

		snake.draw(batch);
		font.draw(batch, snake.getX() + " " + snake.getY(), 50, 50);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
		
		
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
