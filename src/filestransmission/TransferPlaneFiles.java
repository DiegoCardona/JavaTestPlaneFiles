package filestransmission;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransferPlaneFiles extends JPanel implements ActionListener{
	
	public JButton saveButton;
	private JTextField uploadedFileLabel;
	private JButton receiverButton;
	private JButton sendButton;
	private JTextField stateTextField;
	private JTextField receiverTextField;
	private JLabel receiverLabel;
	private JLabel stateLabel;
	private String[] sentStates = {"Sin programar","Pendiente de env�o", "Enviando", "Enviado"};
	
	public void create() {
        JPanel filePanel = createInternalPanel();
        
        configureButtons();
        configureLabels();
        configureTextFields();
        
        filePanel.add(saveButton);
        filePanel.add(uploadedFileLabel);
        filePanel.add(receiverButton);
        filePanel.add(sendButton);
        filePanel.add(receiverLabel);
        filePanel.add(receiverTextField);
        filePanel.add(stateLabel);
        filePanel.add(stateTextField);
        
        // General render
        this.setVisible(false);
        this.add(filePanel);
        this.setBackground(Color.WHITE);
        this.setBounds(50, 50, 500, 300);
	}
	
	private JPanel createInternalPanel() {
		JPanel filePanel = new JPanel(new GridLayout(0,2,80,10));
        filePanel.setBorder(BorderFactory.createTitledBorder("Env�ar Plano"));
        filePanel.setBackground(Color.WHITE);
        
        return filePanel;
	}
	
	private void configureButtons() {
		saveButton = new JButton("Seleccionar plano");
        saveButton.setBackground(Color.DARK_GRAY);
        saveButton.setForeground(Color.LIGHT_GRAY);
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        
        sendButton = new JButton("Enviar");
        sendButton.setBackground(Color.DARK_GRAY);
        sendButton.setForeground(Color.LIGHT_GRAY);
        sendButton.setFocusable(false);
        sendButton.addActionListener(this);
        
        receiverButton = new JButton("Agregar destinatario");
        receiverButton.setBackground(Color.DARK_GRAY);
        receiverButton.setForeground(Color.LIGHT_GRAY);
        receiverButton.setFocusable(false);
        receiverButton.addActionListener(this);
	}
	
	private void configureLabels() {
		uploadedFileLabel = new JTextField(":/__seleccione_archivo__");
        uploadedFileLabel.setEnabled(false);
        receiverLabel = new JLabel("Destinatario:");
        stateLabel = new JLabel("Estado:");
	}
	
	private void configureTextFields() {
		receiverTextField = new JTextField();
        stateTextField = new JTextField();
        stateTextField.setText(sentStates[1]);
        receiverTextField.setText("Ingresar IP");
        receiverTextField.setEnabled(false);
        stateTextField.setEnabled(false);
	}
	
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
