package filestransmission;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingUtilities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.awt.FlowLayout;

public class ScheduledTransfer extends JFrame{
	
	private JButton openButton;
	private JLabel uploadedFileLabel;
	
	public void run() { 
		
		Runnable app = new Runnable() {
	            
	            private String[] sent_states = {"Sin programar","Pendiente de envío", "Enviando", "Enviado"};

				public void run() {
					// upload files section
	                JPanel filePanel = new JPanel(new GridLayout(0,2,40,10));
	                filePanel.setBorder(BorderFactory.createTitledBorder("Subir Plano"));
	                filePanel.setBackground(Color.WHITE);
	                
	                openButton = new JButton("Buscar plano ...");
	                openButton.setBackground(Color.DARK_GRAY);
	                openButton.setForeground(Color.LIGHT_GRAY);
	                JButton saveButton = new JButton("Guardar plano");
	                saveButton.setBackground(Color.DARK_GRAY);
	                saveButton.setForeground(Color.LIGHT_GRAY);
	                JLabel fileLabel = new JLabel("Ruta archivo:");
	                uploadedFileLabel = new JLabel(":/__seleccione_archivo__");
	            
	                ButtonsListener buttonListener = new ButtonsListener();
	        		openButton.addActionListener(buttonListener);
	                
	                filePanel.add(fileLabel);
	                filePanel.add(uploadedFileLabel);
	                filePanel.add(openButton);
	                filePanel.add(saveButton);
	                
	                // Set schedule section
	                JPanel scheduledPanel = new JPanel(new GridLayout(0,2,5,10));
	                scheduledPanel.setBorder(BorderFactory.createTitledBorder("Programar envío"));
	                scheduledPanel.setBackground(Color.WHITE);
	                
	                JLabel receiverLabel = new JLabel("Destinatario:");
	                JTextField receiverTextField = new JTextField();
	                JLabel scheduleLabel = new JLabel("Horario");
	                JTextField scheduleTextField = new JTextField();
	                JLabel stateLabel = new JLabel("Estado:");
	                JTextField stateTextField = new JTextField();
	                stateTextField.setText(this.sent_states[0]);
	                scheduleTextField.setText("Sin seleccionar");
	                receiverTextField.setText("Sin Seleccionar");
	                
	                receiverTextField.setEnabled(false);
	                scheduleTextField.setEnabled(false);
	                stateTextField.setEnabled(false);
	                
	                JButton scheduledButton = new JButton("Programar horario");
	                scheduledButton.setBackground(Color.DARK_GRAY);
	                scheduledButton.setForeground(Color.LIGHT_GRAY);
	                
	                JButton receiverButton = new JButton("Agregar destinatario");
	                receiverButton.setBackground(Color.DARK_GRAY);
	                receiverButton.setForeground(Color.LIGHT_GRAY);
	                
	                scheduledPanel.add(scheduledButton);
	                scheduledPanel.add(receiverButton);
	                scheduledPanel.add(receiverLabel);
	                scheduledPanel.add(receiverTextField);
	                scheduledPanel.add(scheduleLabel);
	                scheduledPanel.add(scheduleTextField);
	                scheduledPanel.add(stateLabel);
	                scheduledPanel.add(stateTextField);
	                
	                // General render
	                JPanel mainPanel = new JPanel();
	                mainPanel.add(filePanel);
	                mainPanel.setBackground(Color.WHITE);
	                mainPanel.add(scheduledPanel);
	                
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
			if (e.getSource() == openButton) {
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


