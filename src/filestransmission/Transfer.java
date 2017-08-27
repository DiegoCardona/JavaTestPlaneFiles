package filestransmission;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Transfer {
	
	public static void main(String[] args) {
		JFrame view = new JFrame("Sistema de transferencia de archivos");
		JPanel buttonsPanel = new JPanel();
		
		TransferPlaneFiles transferView = new TransferPlaneFiles();
		transferView.create();
		
		JButton transferButton = new JButton("Envíar Plano");
		JButton scheduledButton = new JButton("Programar Envío");
		buttonsPanel.add(transferButton);
		buttonsPanel.add(scheduledButton);
		
		transferButton.addActionListener(new ActionListener() {
		    public void actionPerformed( ActionEvent event ) {
		    	if (transferView.isVisible()) {
		    		transferView.setVisible(false);
		    	} else {
		    		transferView.setVisible(true);
		    	}
		    }
		});
		
		transferButton.addActionListener(new ActionListener() {
		    public void actionPerformed( ActionEvent aActionEvent ) {
		      //do something here
		    }
		});
		
		view.add(transferView);
		view.add(buttonsPanel);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setBackground(Color.WHITE);
        view.setBounds(50, 50, 600, 400);
        view.setVisible(true);
	}

}
