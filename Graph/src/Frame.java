import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Frame extends JFrame {
	
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Philippe Girard - webstep.ca");
		setSize(600,600);
		Panel panel = new Panel();
		add(panel);
		
		// contruct control panel 
		JButton button = new JButton("New vertice");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.addVertice();
			}
			
		});
		JButton rbutton = new JButton("Remove vertice");
		rbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeVertice();
			}
			
		});
		JButton re = new JButton("Remove edge");
		re.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeEdge();
			}
			
		});
		JPanel p = new JPanel();
		p.add(button);
		p.add(rbutton);
		p.add(re);
		add(p, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
	}

}
