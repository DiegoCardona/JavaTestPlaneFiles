package filestransmission;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TransferPlaneFiles{
	
	private JButton saveButton;
	private JLabel uploadedFileLabel;
	public void run() { 
		Runnable app = new Runnable() {
	            
	            private String[] sent_states = {"Sin programar","Pendiente de envío", "Enviando", "Enviado"};

				public void run() {
				
	                JPanel filePanel = new JPanel(new GridLayout(0,2,40,10));
	                filePanel.setBorder(BorderFactory.createTitledBorder("Envíar Plano"));
	                filePanel.setBackground(Color.WHITE);
	                ButtonsListener eventListener = new ButtonsListener();

	                saveButton = new JButton("Seleccionar plano");
	                saveButton.setBackground(Color.DARK_GRAY);
	                saveButton.setForeground(Color.LIGHT_GRAY);
	                uploadedFileLabel = new JLabel(":/__seleccione_archivo__");
	                
	                filePanel.add(saveButton);
	                filePanel.add(uploadedFileLabel);
	                
	                saveButton.addActionListener(eventListener);
	                
	                JLabel receiverLabel = new JLabel("Destinatario:");
	                JTextField receiverTextField = new JTextField();
	                JLabel stateLabel = new JLabel("Estado:");
	                JTextField stateTextField = new JTextField();
	                stateTextField.setText(this.sent_states[0]);
	                receiverTextField.setText("Sin Seleccionar");
	                
	                receiverTextField.setEnabled(false);
	                stateTextField.setEnabled(false);
	                
	                JButton sendButton = new JButton("Enviar");
	                sendButton.setBackground(Color.DARK_GRAY);
	                sendButton.setForeground(Color.LIGHT_GRAY);
	                
	                JButton receiverButton = new JButton("Agregar destinatario");
	                receiverButton.setBackground(Color.DARK_GRAY);
	                receiverButton.setForeground(Color.LIGHT_GRAY);
	                
	                filePanel.add(receiverButton);
	                filePanel.add(sendButton);
	                filePanel.add(receiverLabel);
	                filePanel.add(receiverTextField);
	                filePanel.add(stateLabel);
	                filePanel.add(stateTextField);
	                
	                // General render
	                JPanel mainPanel = new JPanel();
	                mainPanel.add(filePanel);
	                mainPanel.setBackground(Color.WHITE);
	                
	                JFrame guiFrame = new JFrame("Gestor de archivos planos DIAN");
	                guiFrame.add(mainPanel);
	                guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                guiFrame.setBackground(Color.WHITE);
	                
	                guiFrame.setBounds(50, 50, 600, 400);
	                guiFrame.setVisible(true);
	            }
	        };
	        SwingUtilities.invokeLater(app);
	  }
	
	private class ButtonsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == saveButton) {
				final JFileChooser fc = new JFileChooser();
				 int returnVal = fc.showOpenDialog(fc);

			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            uploadedFileLabel.setText(file.getPath());
			        }
			}
			
		}
	}
}
