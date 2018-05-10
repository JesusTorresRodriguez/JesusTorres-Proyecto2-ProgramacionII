package Domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Events.Events;
import Interface.Principal;
/**
 * Clase que se comporta como un panel, para 
 * cargar la imagen seleccionadad y seccionarla
 * @author Jesus Torres
 * @version1.0
 */
public class BoardPanelOne extends JPanel {

	private int x;
	private int y;
	public static BoardPanelOne subImage[][];
	public  Graphics2D graphics2D;
	public int x0Pos;
	public int y0Pos;
	public int x1Pos;
	public int y1Pos;
	public static int pixels;
	public static int figureWidth;
	public static int figureHeight;
	public static BufferedImage bufferImage;
	public boolean condition;
	ImageIcon subimages;
	

	public BoardPanelOne(int pixels, BufferedImage imageBuffer) {
		super();
		addMouseListener(new Events());
		this.pixels = pixels;
		this.bufferImage = imageBuffer;
		this.figureWidth = bufferImage.getWidth();
		this.figureHeight = bufferImage.getHeight();
		this.setPreferredSize(new Dimension(figureWidth, figureHeight));
		this.setBackground(Color.lightGray);
		condition = true;
	}

	public BoardPanelOne() {
		super();
		addMouseListener(new Events());
		this.setPreferredSize(new Dimension(bufferImage.getWidth(), bufferImage.getHeight()));
		this.setBackground(Color.lightGray);
		condition = false;
	}

	public BoardPanelOne(int x0Pos, int x1Pos, int y0Pos, int y1Pos, int pixels, ImageIcon subimage) {
		super();
		this.x0Pos = x0Pos;
		this.y0Pos = y0Pos;
		this.x1Pos = x1Pos;
		this.y1Pos = y1Pos;
		this.pixels = pixels;
		this.subimages = subimage;
	}

	/**
	 * Inserta las imagenes al panel
	 */
	public void insertLines() {
		graphics2D.setColor(Color.BLACK);
		for (int y = 0; y < this.getWidth(); y++) {
			for (int x = 0; x < this.getHeight(); x++) {
				graphics2D.drawLine(y * pixels, 0, y * pixels, this.getHeight()); /* manejo de asintotas verticales */
				graphics2D.drawLine(0, x * pixels, this.getWidth(), x * pixels); /* manejo de asintotas horizontales */
			}
		}
	}// fin del método insertLines

	/**
	 * Selecciona la imagen selecciona del tamaño de los pixeles ingresados
	 */
	public void subImage() {
		x = 0;
		y = 0;
		this.subImage = new BoardPanelOne[this.getWidth() / pixels][this.getHeight() / pixels];
		for (int i = 0; i < subImage.length; i++) {
			for (int j = 0; j < subImage[0].length; j++) {
				if (x <= bufferImage.getWidth() && y <= bufferImage.getHeight()) {
					this.subImage[i][j] = new BoardPanelOne(x, x + pixels, y, y + pixels, pixels,
							new ImageIcon (bufferImage.getSubimage(x, y, pixels, pixels)));
				}
				x += pixels;
			}
			x = 0;
			y += pixels;
		}
	}
	/**
	 * Pinta la imagen y las líneas en el panel
	 */
	public void paint(Graphics g) {
		super.paint(g);
		graphics2D = (Graphics2D) g;
		if (!condition) {
			insertLines();
			
		}
		if (condition) {
			graphics2D.drawImage(bufferImage, null, 0, 0);
			subImage();
			insertLines();
		}

	}

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	public int getX0Pos() {
		return x0Pos;
	}

	public void setX0Pos(int x0Pos) {
		this.x0Pos = x0Pos;
	}

	public int getY0Pos() {
		return y0Pos;
	}

	public void setY0Pos(int y0Pos) {
		this.y0Pos = y0Pos;
	}

	public int getX1Pos() {
		return x1Pos;
	}

	public void setX1Pos(int x1Pos) {
		this.x1Pos = x1Pos;
	}

	public int getY1Pos() {
		return y1Pos;
	}

	public void setY1Pos(int y1Pos) {
		this.y1Pos = y1Pos;
	}

	public ImageIcon getSubimages() {
		return subimages;
	}

	public void setSubimages(ImageIcon subimages) {
		this.subimages = subimages;
	}

	public static BoardPanelOne[][] getSubImage() {
		return subImage;
	}

	public static void setSubImage(BoardPanelOne[][] subImage) {
		BoardPanelOne.subImage = subImage;
	}

	public static BufferedImage getBufferImage() {
		return bufferImage;
	}

	public static void setBufferImage(BufferedImage bufferImage) {
		BoardPanelOne.bufferImage = bufferImage;
	}

	public Graphics2D getGraphics2D() {
		return graphics2D;
	}

	public void setGraphics2D(Graphics2D graphics2d) {
		graphics2D = graphics2d;
	}
	
	

}
