package com.window;

import java.io.PrintStream;

import javax.swing.JTextArea;

public class Threadrunner extends Thread {

	 private Thread t;
	 JTextArea textArea_new = new JTextArea();
	  public Threadrunner(JTextArea new_textarea) {
		// TODO Auto-generated constructor stub
		  this.textArea_new = new_textarea;
	}
	
	public void run() {
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea_new));
		System.setOut(printStream);
		System.setErr(printStream); 
	   }
	   
	   public void start ()
	   {
		   t.start();
	   }
}
