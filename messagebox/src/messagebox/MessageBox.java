package messagebox;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.*;

public class MessageBox implements ActionListener{
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JButton ybutton, nbutton;
	
	public MessageBox() {
		frame = new JFrame();
		panel = new JPanel();
		ybutton = new JButton("Yes");
		ybutton.addActionListener(this);
		nbutton = new JButton("No");
		nbutton.addActionListener(this);
		label = new JLabel("Wanna play VALORANT??");
		
		panel.setBorder(BorderFactory.createEmptyBorder(100, 150, 100, 150));
		panel.setSize(200, 300);
		panel.setLayout(new GridLayout(0, 1));
		panel.add(ybutton);
		panel.add(nbutton);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("Kysymys");
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dimension.width - panel.getSize().width) / 2;
		int y = (dimension.height - panel.getSize().height) / 2;
		frame.setLocation(x, y);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MessageBox();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String button = ((JButton) event.getSource()).getActionCommand();

	    switch (button) {
	    case "Yes":
	    	label.setText("JEEEEEE!");
	    	frame.setVisible(false);
	    	frame.dispose();
	    	try {
	    		URI uri= new URI("https://playvalorant.com/en-us/");
	    		java.awt.Desktop.getDesktop().browse(uri);
	    		System.out.println("Web page opened in browser");
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	System.exit(0);
	    case "No":
	    	label.setText("Noob");
	    	break;
	    }
	}
}
