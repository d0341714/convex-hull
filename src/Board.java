import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends  MouseAdapter{
	private JFrame f = new JFrame();
	Graphics g;
	private JPanel jp;
	int select = 0;
	Rand[] rand;
	
	public Board(Rand[] r) {
		this.rand = r;
		this.initUI();
	}
	
	void initUI() {
		f.setSize(new Dimension(700, 715));
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setTitle("Convex Hull");
		f.addMouseListener(this);
		f.setDefaultCloseOperation(3);
		
		jp = new JPanel() {
			public void paint(Graphics G) {
				G.setColor(Color.BLACK);
				super.paint(G);
				draw(G);
			}
		};
		
		f.setBackground(new Color(209, 167, 78));
		jp.setBackground(new Color(209, 167, 78));
		jp.setBounds(0, 0, 700, 700);

		f.add(jp);
	
		f.setVisible(true);
		g = jp.getGraphics();
	}
	
	public void draw(Graphics G){
		G.setColor(Color.BLACK);
		int ovalfat = 4;
		
		for (int i = 0; i < rand.length; i++) {
			G.fillOval(rand[i].x-2, rand[i].y-2, ovalfat, ovalfat);
		}
	}
}