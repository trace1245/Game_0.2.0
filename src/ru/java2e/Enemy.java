package ru.java2e;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy {
	int x = 0;
	int y = 0;
	int speed = 0;
	int health = 100;
	String Enemy1Pic = "res/Enemy1.gif";
	Image img = new ImageIcon(Enemy1Pic).getImage();
	Road road;
    
	public Enemy (int x, int y, Road road)
	{
		this.x = x;
		this.y = y;
		speed = 8;
		this.road = road;
	}
	public void move(){
		x -= speed;
	}
	public Rectangle getRect(){
		return new Rectangle (x, y,65, 40);
	}

}
