/**
 * Nombre clase: OpenFileImage
 * @version 1.0
 * @author JesusTorres
 * Fecha: 18/04/2018 
 */
package Interface;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import File.SerializableFile;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OpenFileImage extends JPanel {

	JFileChooser file_chooser = new JFileChooser();
	Principal princFrame = new Principal();
	private JFrame frmSeleccinDeImagen;
	BufferedImage img;
	SerializableFile fileSeralization = new SerializableFile();

	public OpenFileImage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeleccinDeImagen = new JFrame();
		frmSeleccinDeImagen.setTitle("Selección de Imagen");
		frmSeleccinDeImagen.setBounds(100, 100, 514, 371);
		frmSeleccinDeImagen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FileNameExtensionFilter searchFomat = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
		file_chooser.setFileFilter(searchFomat);
		frmSeleccinDeImagen.getContentPane().add(file_chooser);
	}

	/**
	 * Envía la imagen seleccionada por el JFileChooser, a ser cargada en el label
	 * 
	 * @return
	 */
	public BufferedImage OpenImagePanel() throws IOException {
		File archiveImage = null;
		int controller = -1;
		controller = file_chooser.showOpenDialog(null);
		if (JFileChooser.APPROVE_OPTION == controller) {
			archiveImage = file_chooser.getSelectedFile();
			if (archiveImage.getName().endsWith("jpg") || archiveImage.getName().endsWith("png")) {
				img = ImageIO.read(file_chooser.getSelectedFile());
			} else {
				JOptionPane.showMessageDialog(null, "El archivo no es una imagen");
				OpenImagePanel();
			}
			try {
				return img;
			} catch (Exception exImage) {
				JOptionPane.showMessageDialog(null, "Error al cargar imagen " + "OFI#01");
			}
		}
		return img;
	}
	/**
	 * Guardado de la imagen terminada
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void saveImagePanel() throws IOException, ClassNotFoundException {
		File archiveImage = null;
		archiveImage = new File("CAMBIAR NOMBRE ");
		file_chooser.setSelectedFile(archiveImage);
		if (file_chooser.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
			archiveImage = file_chooser.getSelectedFile();
			if (archiveImage.getName().endsWith("jpg") || archiveImage.getName().endsWith("png")) {
				// realizar accion
				fileSeralization.saveFile(archiveImage);
			}
		}
	}
	
}
