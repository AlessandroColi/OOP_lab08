package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
	
	private static final String TITLE = "A very simple GUI application";
	private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame(TITLE);
    
    SimpleGUI(){
    	final Controller file = new Controller();
    	final JPanel main = new JPanel();
    	final JTextArea box = new JTextArea();
    	final JButton save = new JButton("save");
    	final BorderLayout layout = new BorderLayout();
    	frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	main.setLayout(layout);
    	main.add(box, BorderLayout.CENTER);
    	main.add(save, BorderLayout.PAGE_END);
    	save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					file.PrintOnFile(box.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}    		
    	});
    }
    
    @SuppressWarnings("unused")
	private void display() {
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
    }
    /*
    public static void main(final String... args) {
        new SimpleGUI().display();
     } */
}
