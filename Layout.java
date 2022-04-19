import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Layout implements ActionListener {

	 JFrame myFrame;
	 JPanel myPanel;
	 JLabel myLabel;
	 JButton resetButton;
	 JButton startButton;
	 long elapsed = 0;
	 long seconds = 0;
	 long minutes = 0;
	 long hours = 0;
	 boolean start = false;
	 Timer timer;
	 String stringSeconds = String.format("%02d", seconds);
	 String stringMinutes = String.format("%02d",minutes);
	 String stringHours = String.format("%02d",hours);
	
	public Layout() {
		myFrame = new JFrame();
		myPanel = new JPanel();
		resetButton = new JButton();
		startButton = new JButton();
		myLabel = new JLabel();
		
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				elapsed = elapsed + 1000;
				hours = (elapsed / 3600000) % 60;
				minutes = (elapsed / 60000) % 60;
				seconds = (elapsed / 1000) % 60;
				
				stringSeconds = String.format("%02d", seconds);
				stringMinutes = String.format("%02d", minutes);
				stringHours = String.format("%02d", hours);
				myLabel.setText(stringHours+ " : "+ stringMinutes+ " : "+ stringSeconds);
			}
			
		});
		
		
		
		myLabel.setText(stringHours+ " : "+ stringMinutes+ " : " +stringSeconds);
		myLabel.setForeground(Color.green);
		myLabel.setVerticalAlignment(JLabel.CENTER);
		myLabel.setFont(new Font("Calibri", Font.PLAIN, 45));
		
		startButton.setText("START");
		startButton.setFocusable(false);
		startButton.setVerticalAlignment(JButton.BOTTOM);
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.green);
		startButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		startButton.addActionListener(this);
		
		resetButton.setText("RESET");resetButton.setFocusable(false);
		resetButton.setBackground(Color.black);
		resetButton.setForeground(Color.green);
		resetButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		resetButton.addActionListener(this);
		
		myPanel.setBounds(0, 0, 400, 250);
		myPanel.setBackground(Color.black);
		myPanel.add(myLabel);
		myPanel.add(startButton);
		myPanel.add(resetButton);
		
		myFrame.setTitle("STOPWATCH");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myFrame.setBounds(120, 100, 300, 150);
		myFrame.setVisible(true);
		myFrame.add(myPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == startButton) {
				if(start == false) {
					start = true;
					startButton.setText("STOP");
					start();
				}
				else {
					start = false;
					startButton.setText("START");
					stop();
				}
			}
			
			if(e.getSource() == resetButton) {
				start = false;
				reset();
			}
	}
	
	public void start() {
		timer.start();
	}
	 public void stop() {
		timer.stop();
	 }
	 void reset() {
		  timer.stop();
		  elapsed = 0;
		  seconds = 0;
		  minutes = 0;
		  hours = 0;
		  stringSeconds = String.format("%02d", seconds);
		  stringMinutes = String.format("%02d",minutes);
		  stringHours = String.format("%02d",hours);
		 myLabel.setText(stringHours+ " : "+ stringMinutes+ " : "+ stringSeconds);
		startButton.setText("START");
	}
	

}

