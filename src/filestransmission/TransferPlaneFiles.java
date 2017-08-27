package filestransmission;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	public JButton saveButton;
	private JTextField uploadedFileLabel;
	private JButton receiverButton;
	private JButton sendButton;
	private JTextField stateTextField;
	private JTextField receiverTextField;
	private String[] sentStates = {"Sin programar","Pendiente de envío", "Enviando", "Enviado"};
	
	public void run() { 
		Runnable app = new Runnable() {

				public void run() {
				
	                JPanel filePanel = new JPanel(new GridLayout(0,2,80,10));
	                filePanel.setBorder(BorderFactory.createTitledBorder("Envíar Plano"));
	                filePanel.setBackground(Color.WHITE);
	                ButtonsListener eventListener = new ButtonsListener();

	                saveButton = new JButton("Seleccionar plano");
	                saveButton.setBackground(Color.DARK_GRAY);
	                saveButton.setForeground(Color.LIGHT_GRAY);
	                saveButton.setFocusable(false);
	                saveButton.addActionListener(eventListener);
	                
	                uploadedFileLabel = new JTextField(":/__seleccione_archivo__");
	                uploadedFileLabel.setEnabled(false);
	                
	                filePanel.add(saveButton);
	                filePanel.add(uploadedFileLabel);
	                
	                JLabel receiverLabel = new JLabel("Destinatario:");
	                receiverTextField = new JTextField();
	                JLabel stateLabel = new JLabel("Estado:");
	                stateTextField = new JTextField();
	                stateTextField.setText(sentStates[1]);
	                receiverTextField.setText("Ingresar IP");
	                
	                receiverTextField.setEnabled(false);
	                stateTextField.setEnabled(false);
	                
	                sendButton = new JButton("Enviar");
	                sendButton.setBackground(Color.DARK_GRAY);
	                sendButton.setForeground(Color.LIGHT_GRAY);
	                sendButton.setFocusable(false);
	                sendButton.addActionListener(eventListener);
	                
	                receiverButton = new JButton("Agregar destinatario");
	                receiverButton.setBackground(Color.DARK_GRAY);
	                receiverButton.setForeground(Color.LIGHT_GRAY);
	                receiverButton.setFocusable(false);
	                receiverButton.addActionListener(eventListener);
	                
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
	                mainPanel.setBounds(50, 50, 500, 300);
	                
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

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == saveButton) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(fc);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            uploadedFileLabel.setText(file.getPath());
		            uploadedFileLabel.setDisabledTextColor(Color.BLACK);
		        }
			} else if(event.getSource() == receiverButton) {
				receiverTextField.setEnabled(true);
				receiverTextField.setText("");
			} else if(event.getSource() == sendButton) {
				stateTextField.setText(sentStates[2]);
				stateTextField.setDisabledTextColor(Color.ORANGE);
			}
			
		}
	}
}
