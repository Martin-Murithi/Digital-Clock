import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class timeSet{
	JFrame frame;
	JPanel panel;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	Calendar calendar;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	String time;
	String day;
	String date;
	private int Plain;
	public timeSet() {
		frame = new JFrame();
		panel = new JPanel();
		
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		timeFormat = new SimpleDateFormat("HH : mm: ss a");
		dayFormat = new SimpleDateFormat("EEEEE");
		

		timeLabel = new JLabel();
		timeLabel.setForeground(Color.green);
		timeLabel.setFont(new Font("Verdana" ,Plain, 40));
		
		dayLabel = new JLabel();
		dayLabel.setForeground(Color.green);
		dayLabel.setFont(new Font("Calibri", Plain, 38));
		
		dateLabel = new JLabel();
		dateLabel.setForeground(Color.green);
		dateLabel.setFont(new Font("Calibri", Plain, 38));
		
		panel.setSize(400, 290);
		panel.setBackground(Color.black);
		panel.add(dayLabel);
		panel.add(timeLabel);
		panel.add(dateLabel);	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 120, 400, 290);
		frame.setResizable(false);
		frame.setTitle("DIGITAL CLOCK");
		frame.setVisible(true);
		frame.add(panel);
		myTime();
	}
	public void myTime() {
		while(true) {
		time = timeFormat.format(Calendar.getInstance().getTime());
		timeLabel.setText(time);
		
		day = dayFormat.format(Calendar.getInstance().getTime());
		dayLabel.setText(day); 
		
		date = dateFormat.format(Calendar.getInstance().getTime());
		dateLabel.setText(date); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	
	
	
}
