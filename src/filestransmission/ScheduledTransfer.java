package filestransmission;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ScheduledTransfer extends JPanel implements ActionListener{
	
	private JButton saveButton;
	private JButton openButton;
	private JButton scheduledButton;
	private JTextField uploadedFileLabel;
	private JButton receiverButton;
	private JButton sendButton;
	private JTextField stateTextField;
	private JTextField receiverTextField;
	private JTextField scheduleTextField;
	private JLabel receiverLabel;
	private JLabel stateLabel;
	private JLabel fileLabel;
	private JLabel scheduleLabel;
    private String[] sentStates = {"Sin programar","Pendiente de env�o", "Enviando", "Enviado"};

	public void create() {
        JPanel filePanel = createFilePanel();
        JPanel scheduledPanel = createScheduledPanel();
        
        configureButtons();
        configureLabels();
        configureTextFields();
        
        filePanel.add(fileLabel);
        filePanel.add(uploadedFileLabel);
        filePanel.add(openButton);
        filePanel.add(saveButton);
        
        filePanel.add(fileLabel);
        filePanel.add(uploadedFileLabel);
        filePanel.add(openButton);
        filePanel.add(saveButton);
        
        scheduledPanel.add(scheduledButton);
        scheduledPanel.add(receiverButton);
        scheduledPanel.add(receiverLabel);
        scheduledPanel.add(receiverTextField);
        scheduledPanel.add(scheduleLabel);
        scheduledPanel.add(scheduleTextField);
        scheduledPanel.add(stateLabel);
        scheduledPanel.add(stateTextField);
        
        // General render
        this.setVisible(false);
        this.add(filePanel);
        this.add(scheduledPanel);
        this.setBackground(Color.WHITE);
        this.setBounds(50, 50, 500, 300);
	}
	
	private JPanel createFilePanel() {
		JPanel filePanel = new JPanel(new GridLayout(0,2,80,10));
        filePanel.setBorder(BorderFactory.createTitledBorder("Subir Plano"));
        filePanel.setBackground(Color.WHITE);
        
        return filePanel;
	}
	
	private JPanel createScheduledPanel() {
		JPanel filePanel = new JPanel(new GridLayout(0,2,5,10));
		filePanel.setBorder(BorderFactory.createTitledBorder("Programar env�o"));
        filePanel.setBackground(Color.WHITE);
        
        return filePanel;
	}
	
	private void configureButtons() {
		saveButton = new JButton("Guardar plano");
        saveButton.setBackground(Color.DARK_GRAY);
        saveButton.setForeground(Color.LIGHT_GRAY);
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        
        openButton = new JButton("Buscar plano ...");
        openButton.setBackground(Color.DARK_GRAY);
        openButton.setForeground(Color.LIGHT_GRAY);
        
        sendButton = new JButton("Guardar Plano");
        sendButton.setBackground(Color.DARK_GRAY);
        sendButton.setForeground(Color.LIGHT_GRAY);
        sendButton.setFocusable(false);
        sendButton.addActionListener(this);
        
        receiverButton = new JButton("Agregar destinatario");
        receiverButton.setBackground(Color.DARK_GRAY);
        receiverButton.setForeground(Color.LIGHT_GRAY);
        receiverButton.setFocusable(false);
        receiverButton.addActionListener(this);
        
        scheduledButton = new JButton("Programar horario");
        scheduledButton.setBackground(Color.DARK_GRAY);
        scheduledButton.setForeground(Color.LIGHT_GRAY);
	}
	
	private void configureLabels() {
		uploadedFileLabel = new JTextField(":/__seleccione_archivo__");
        uploadedFileLabel.setEnabled(false);
        receiverLabel = new JLabel("Destinatario:");
        stateLabel = new JLabel("Estado:");
        fileLabel = new JLabel("Ruta archivo:");
        scheduleLabel = new JLabel("Horario");
	}
	
	private void configureTextFields() {
		receiverTextField = new JTextField();
        stateTextField = new JTextField();
        stateTextField.setText(sentStates[1]);
        receiverTextField.setText("Ingresar IP");
        receiverTextField.setEnabled(false);
        stateTextField.setEnabled(false);
        stateTextField = new JTextField();
        stateTextField.setText(this.sentStates[0]);
        scheduleTextField = new JTextField();
        scheduleTextField.setText("Sin seleccionar");
        scheduleTextField.setEnabled(false);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == openButton) {
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


