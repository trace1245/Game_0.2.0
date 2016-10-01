package ru.java2e;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener, Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Timer mainTimer = new Timer(20, this);
	
	Image img = new ImageIcon("res/Road.png").getImage();
	
	int speed =300;
	
	public int level = 1;
	public int kills,bkills = 0;
	
	
	Player p = new Player();
	
	
    List<Fire> Fires = new ArrayList<Fire>();
    
    List<Enemy> Enemies = new ArrayList<Enemy>();
    
	public Road()
	{
		mainTimer.start();
		addKeyListener(new MyKeyAdapter());
		setFocusable(true);
		
		 new Thread (this) {
				public void run(){
		    		while (true)
		    		{
					try {
						Thread.sleep(speed);
						Fires.add(new Fire(p.x + 122, p.y + 19, null));
					} catch (InterruptedException e) {
						e.printStackTrace();
						
					
					}
		    	}
		    	}

		 }.start();
	    new Thread(this) {
			public void run(){
	    		
	    		while (true)
	    		{
	    		Random rand = new Random();
	            try {
	          	Thread.sleep(rand.nextInt(2000));
		
	        	Enemies.add(new Enemy(1100, rand.nextInt(550), null));
	           } catch (InterruptedException e) {
	          	e.printStackTrace();
	           }
	            
	    		}
	    	}
	    }.start();
	    
	}
	
	
	private class MyKeyAdapter extends KeyAdapter
	{	
		
		public void keyPressed(KeyEvent e)
		{
			p.keyPressed(e);
			
		}
		public void keyReleased(KeyEvent e)
		{
			p.keyReleased(e);
		}
		
	}
	
	public void paint (Graphics g){
		g = (Graphics2D) g;
		
		p.keymove();
		g.drawImage(img, p.layer1, 0, null);
		g.drawImage(img, p.layer2, 0, null);
		g.drawImage(p.img, p.x, p.y, null); 
		Font myFont = new Font("TimesRoman", Font.BOLD|Font.ITALIC, 20);
		g.setFont(myFont);
		g.setColor(Color.white);
		g.drawString("Health : " + Integer.toString(p.health), 40, 20);
		g.drawString("Kills : " + Integer.toString(kills), 200, 20);
		g.drawString("Level : " + Integer.toString(level), 400, 20);
		
		testColisionWithFire();
		Iterator<Fire> i = Fires.iterator();
		while(i.hasNext())
		{
			Fire e = i.next();
			if (e.x >= 1000)
			{
				i.remove();
			}
			e.move();
			g.drawImage(e.img, e.x, e.y, null); 
		}
		Iterator<Enemy> t = Enemies.iterator();
		while(t.hasNext())
		{
			Enemy k = t.next();
			if (k.x <= -50)
			{
				t.remove();
			}
			k.move();
			g.drawImage(k.img, k.x, k.y, null); 
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		p.move();
		repaint();
		testofend();
	}
	private void testColisionWithFire(){

			for(int i=0;i<Fires.size();i++)
			{
				for(int j=0;j<Enemies.size();j++)
				{
					if(Fires.get(i).getRect().intersects(Enemies.get(j).getRect()))
					{
						
						Enemies.get(j).health -= Fires.get(i).damage;
						Fires.remove(i);
						if(Enemies.get(j).health == 0)
						{
						   Enemies.remove(j);
						   kills++;
						}
						
					}
				}
			}
			for(int s= 0;s<Enemies.size();s++)
			{
				
				if(p.getRect().intersects(Enemies.get(s).getRect()))
				{
					
					if (p.health > 0){
					p.health -= 50;
					Enemies.remove(s);
					}
				}
			}
	}
	
	public void testofend()
	{
		if(kills == (5*level) + bkills)
		{
			bkills += kills;
			level++;
		}
		if (p.health <= 0 )
		{
			int selection = JOptionPane.showConfirmDialog(null, "Продолжить?", "Вы Проиграли!", JOptionPane.YES_NO_OPTION);
			
			
			if (selection == JOptionPane.YES_OPTION) {
				p.health = 100;
			}
			if (selection == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
			
		}
		
	}
			
		
	@Override
	public void run() {
		while(true)
		{
			
		}
	}
	
}


