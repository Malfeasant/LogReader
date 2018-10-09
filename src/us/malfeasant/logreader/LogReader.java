package us.malfeasant.logreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LogReader {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new LogReader(args);
		});
	}
	
	private JFrame frame;
	private File file;
	
	private LogReader(String[] args) {
		// TODO	Parse args for file and/or options
		
		frame = new JFrame("LogReader");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// set up menus
		JMenuItem item  = new JMenuItem("Open");
		item.addActionListener(event -> showOpen());
		JMenu menu = new JMenu("File");
		menu.add(item);
		
		JMenuBar bar = new JMenuBar();
		bar.add(menu);
		frame.setJMenuBar(bar);
		
		frame.setVisible(true);
	}

	private void showOpen() {
		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			File chosen = chooser.getSelectedFile();
			// TODO	check if file exists, etc
			SwingUtilities.invokeLater(() -> openFile(chosen));
		}
	}
	
	private void openFile(File f) {
		// Check if there is a currently open file...
		if (file != null) {
			// TODO	cleanup, close
			file = null;
		}
		
		// Open file
		try {
			FileReader fr = new FileReader(f);
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(frame, "File not found, please try again.");
			return;
		}
	}
}
