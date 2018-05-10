package Interface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import Domain.BoardPanelOne;
import Domain.BoardPanelTwo;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Principal {
	OpenFileImage openFileImage;
	private JFrame frame;
	private JButton btnCargarImagen;
	private JLabel lblPixels;
	public JScrollPane scrollImageSec;
	private JTextField textFieldPixels;
	private JScrollPane scrollImagePrin;
	private boolean condition = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 * 
	 */
	public Principal() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setBounds(100, 100, 946, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnCargarImagen = new JButton("Cargar Imagen");
		btnCargarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (getValid() == false) {
					openFileImage = new OpenFileImage();
					try {
						BoardPanelOne f = new BoardPanelOne(Integer.parseInt(textFieldPixels.getText()),
								openFileImage.OpenImagePanel());
						scrollImagePrin.setViewportView(f);
						textFieldPixels.setEnabled(false);
						if (condition) {
							BoardPanelTwo f2 = new BoardPanelTwo(f.pixels, f.figureWidth, f.figureHeight);
							scrollImageSec.setViewportView(f2);
							condition = false;
						}
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "No se seleccionó un archivo");
					}
				}
			}
		});
		btnCargarImagen.setBounds(395, 405, 129, 23);
		frame.getContentPane().add(btnCargarImagen);

		scrollImagePrin = new JScrollPane();
		scrollImagePrin.setBounds(32, 85, 353, 369);
		frame.getContentPane().add(scrollImagePrin);

		scrollImageSec = new JScrollPane();
		scrollImageSec.setBounds(550, 85, 353, 369);
		frame.getContentPane().add(scrollImageSec);

		textFieldPixels = new JTextField();
		textFieldPixels.setBounds(413, 366, 86, 20);
		frame.getContentPane().add(textFieldPixels);
		textFieldPixels.setColumns(10);

		lblPixels = new JLabel("Pixels");
		lblPixels.setBounds(437, 341, 46, 14);
		frame.getContentPane().add(lblPixels);

		JButton btnGuardarImagen = new JButton("Guardar Imagen");
		btnGuardarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					openFileImage.saveImagePanel();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGuardarImagen.setBounds(395, 439, 129, 23);
		frame.getContentPane().add(btnGuardarImagen);

	}

	/**
	 * Validación de espacios en blanco y enteros
	 * 
	 * @return boolean
	 */
	public Boolean getValid() {
		try {
			if (Integer.parseInt(textFieldPixels.getText()) == 0) {
				JOptionPane.showMessageDialog(null, "Ingresar valores mayores cero");
				textFieldPixels.setText("");
				return true;
			}
			return false;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Ingresar valores númericos");
			textFieldPixels.setText("");
			return true;
		}

	}
}
