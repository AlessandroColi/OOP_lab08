package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 1.Add a JTextField and a button "Browse..." on the upper part of the graphical interface. Suggestion: use a second JPanel with a second BorderLayout, put the panel in the North of the main panel, put the text field in the center of the new panel and put the button in the line_end of the new panel.
	2.The JTextField should be non modifiable. And, should display the current selected file.
	3.On press, the button should open a JFileChooser. The program should use the method showSaveDialog() to display the file chooser, and if the result is equal to JFileChooser.APPROVE_OPTION the program should set as new file in the Controller the file chosen. If CANCEL_OPTION is returned, then the program should do nothing. Otherwise, a message dialog should be shown telling the user that an error has occurred (use JOptionPane.showMessageDialog()).
	4.When in the controller a new File is set, also the graphical interface must reflect such change. Suggestion: do not force the controller to update the UI: in this example the UI knows when should be updated, so try to keep things separated.

 */
public final class SimpleGUIWithFileChooser {
	
	private static final String TITLE = "A very simple GUI application";
	private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame(TITLE);
    
    SimpleGUIWithFileChooser(){
    	final Controller file = new Controller();
    	final JPanel main = new JPanel();
    	final JTextArea box = new JTextArea();
    	final JButton save = new JButton("save");
    	frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	main.setLayout(new BorderLayout());
    	main.add(box, BorderLayout.CENTER);
    	main.add(save, BorderLayout.PAGE_END);
    	
    	

    	final JPanel barra = new JPanel();
    	barra.setLayout(new BorderLayout());
    	main.add(barra,BorderLayout.PAGE_START);
    	final JTextField path = new JTextField(file.GetPath());
    	final JButton browse = new JButton("browse");
    	barra.add(path);
    	barra.add(browse,BorderLayout.LINE_END);
    	
    	browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser scegli = new JFileChooser("Choose where to save");
				
				switch(scegli.showSaveDialog(path)) {
					case JFileChooser.APPROVE_OPTION:
						file.SetFile(scegli.getSelectedFile());
						path.setText(file.GetPath());
						break;
	                case JFileChooser.CANCEL_OPTION:
	                    break;
	                default:
	                	JOptionPane.showMessageDialog(frame, JOptionPane.ERROR_MESSAGE);
				}
				
				
			}  		
    	});
    	
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
    
    private void display() {
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
    }
    
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
     }
    
    
    
}
