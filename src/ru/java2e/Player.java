package ru.java2e;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img = new ImageIcon("res/Player.gif").getImage();
	int x = 0;
	int y = 250;
	int v = 3;
	int s = 0;
	int layer1 = 0;
	int layer2 = 1100;
	int health = 100;
	boolean p1,p2,p3,p4;

	public void move(){
		s += v;
		if(layer2 - v <= 0)
		{
			layer1 = 0;
			layer2 = 1100;
			
		}
		
		layer1 -= v;
		layer2 -= v;
	}
	
	
	public Rectangle getRect(){
		return new Rectangle (x, y, 122, 30);
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT)
		{			
			p2=true;
		}
		if(key == KeyEvent.VK_LEFT)
		{			
			p4=true;
		}
		if(key == KeyEvent.VK_DOWN)
		{			
			p3=true;
		}
		if(key == KeyEvent.VK_UP)
		{			
			p1=true;
		}
	}
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT)
		{			
			p2=false;
		}
		if(key == KeyEvent.VK_LEFT)
		{			
			p4=false;
		}
		if(key == KeyEvent.VK_DOWN)
		{			
			p3=false;
		}
		if(key == KeyEvent.VK_UP)
		{			
			p1=false;
		}
	}
	public void keymove()
	{

		if(p1)
		{
			y -= 8;
			if(y < 5)
				y = 5;
		}
		if(p2)
		{
			x += 8;
			if(x > 870)
				x = 870;
		}
		if(p3)
		{
			y += 8;
			if(y > 530)
				y = 530;
		}
		if(p4)
		{
			x -= 8;
			if(x < -20)
				x = -20;
		}
	}
}
