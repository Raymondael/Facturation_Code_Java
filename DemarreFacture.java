package donnees;
import java.awt.Dimension;
import java.awt.Toolkit;

import les_Fenetres.Login;

public class DemarreFacture {

	public static void main(String[] args) {
		Login framLogin = new Login();
		Dimension dmG = Toolkit.getDefaultToolkit().getScreenSize();
		    int large =  framLogin.getWidth();
			int haut = framLogin.getHeight();
			int X = (dmG.width - large )/2;
			int Y = (dmG.height - haut)/2;
			framLogin.setLocation(X, Y);
			framLogin.setVisible(true);

	}

}
