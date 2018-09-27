package com.window;
 
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
 
/**
 * This class extends from OutputStream to redirect output to a JTextArrea
 * @author www.codejava.net
 *
 */
public class CustomOutputStream extends OutputStream {
    private JTextArea textArea;
     
    public CustomOutputStream(JTextArea textArea) {
    	
        this.textArea = textArea;
    }
     
    private void updateTextArea(final String text) {
    	  SwingUtilities.invokeLater(new Runnable() {
    	    public void run() {
    	      textArea.append(text);
    	    }
    	  });
    	}
    
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
    	//System.out.println("b : "+ String.valueOf((char)b));
    	//updateTextArea(String.valueOf((char)b));
    	textArea.append(String.valueOf((char)b));
        //textArea.append(String.valueOf((char)b));
        //textArea.setText(String.valueOf((char)b));

        //System.out.println("\n"+textArea_tmp.getText());
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}