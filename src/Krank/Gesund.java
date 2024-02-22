package Krank;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class Text extends JFrame {
	JLabel lblText;

	Text() {
		setTitle("gute Besserung");
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\dame\\Downloads\\bg_01.jpg")));
		lblText = new JLabel(
				"<html><p style='color: #ffffff; font-family:Archivo; font-size:30pt'>Lieber Paul,<br>Wir wünschen dir viel Kraft und Durchhaltevermögen, bis du wieder gesund bist. Gute Besserung und wir freuen uns darauf, dich bald in alter Frische wiederzusehen.<br> Dein Tanzer Team.</p></html>");
		lblText.setSize(600, 500);
		setSize(1550, 850);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(lblText);
		setVisible(true);
		doText();
	}

	public void doText() {
		int x = 1;
		int y = 5;
		try {
			while (x < 800) {
				lblText.setLocation(x, y);
				Thread.sleep(200);
				x += 5;
				y += 5;
				if (x > 800)
					x = 1;
				if (y > 500)
					y = 5;

			}

		} catch (InterruptedException ie) {
			System.out.println("Interrupted...");
		}
	}

}

public class Gesund {

	public static void main(String args[]) {

		String name = JOptionPane.showInputDialog(null, "Gib deinen Namen ein");
		if (name.equals("Paul")) {
			JOptionPane.showMessageDialog(null, "Darf ich Sie überraschen?, " + name + "?");
			new Text();
		} else {
			JOptionPane.showMessageDialog(null, "Sorry! Sie dürfen den Inhalt nicht sehen, " + name);

		}
	}
}
