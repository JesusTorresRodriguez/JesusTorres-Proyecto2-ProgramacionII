package Events;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.channels.NetworkChannel;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Domain.BoardPanelOne;
import Domain.BoardPanelTwo;
import Interface.Principal;
/**
 * Clase encargada de escuchar y accionar loseventos del mouse
 * @author JesusTorres
 * @version 1.0
 */
public class Events extends MouseAdapter  {
	@Override
	public void mouseClicked(MouseEvent e) {

		BoardPanelOne f = new BoardPanelOne();
		BoardPanelTwo f2 = new BoardPanelTwo();
		BoardPanelOne fTemp = new BoardPanelOne();
		f = (BoardPanelOne) e.getSource();
		if (f.isCondition()) {
			for (int i = 0; i < f.subImage.length; i++) {
				for (int j = 0; j < f.subImage[0].length; j++) {
					if ((f.subImage[i][j].x0Pos < e.getX() && f.subImage[i][j].getX1Pos() > e.getX())
							&& (f.subImage[i][j].y0Pos< e.getY() && f.subImage[i][j].getY1Pos() > e.getY())) {
						fTemp = f.subImage[i][j];
						JOptionPane.showMessageDialog(null, fTemp.getSubimages());
					}//fin de condicion de seleccion
				}//fin de segndo for
			}//fin del primer for
		}//fin de condicion
		else {
			JOptionPane.showMessageDialog(null, "espera");
		}
	}//fin del método

   

}
