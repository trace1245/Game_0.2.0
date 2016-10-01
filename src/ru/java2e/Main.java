package ru.java2e;
import javax.swing.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("Java Game");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 600);
		f.add(new Road());
		f.setVisible(true);
		f.setResizable(false);

	}

}
