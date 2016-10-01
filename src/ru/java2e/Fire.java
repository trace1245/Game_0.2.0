package ru.java2e;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Fire {
	
	int x = 0;
	int y = 0;
	int speed = 0;
	Image img = new ImageIcon("res/Fire.png").getImage();
	Road road;
    int damage = 50;
	
	public Fire (int x, int y, Road road)
	{
		this.x = x;
		this.y = y;
		speed = 10;
		this.road = road;
	}
	public Rectangle getRect(){
		return new Rectangle (x, y, 20, 13);
	}
	public void move()
	{
		x += speed;
	}
	
}
