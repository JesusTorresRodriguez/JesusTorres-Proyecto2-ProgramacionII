package Domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Events.Events;
/**
 * Clase heredada de BoardPanelOne, tambien se comporta como un panel y es la 
 * encargada de lo relacionado al panel dos
 * @author Jesus Torres
 * @version 1.0
 *
 */
public class BoardPanelTwo extends BoardPanelOne{

	private int x;
	private int y;
	public  Graphics2D graphics2D;

	public BoardPanelTwo() {
		super();
	}
	
	public BoardPanelTwo(int pixels,int figureWidth, int figureHeigth) {
		super();
		this.setPreferredSize(new Dimension(figureWidth, figureHeigth));
		this.figureWidth = figureWidth;
		this.figureHeight = figureHeigth;
		this.condition = false;
		this.pixels = pixels;
	}
	
}
