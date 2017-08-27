package filestransmission;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Transfer implements ActionListener{
	
	public static void main(String[] args) {
		JFrame view = new JFrame();
		
		TransferPlaneFiles transferView = new TransferPlaneFiles();
		transferView.create();
		
		view.add(transferView);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setBackground(Color.WHITE);
        view.setBounds(50, 50, 600, 400);
        view.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
