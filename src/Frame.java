import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//Time rlated varibles
	int waveTimer = 5;
	int ellapseTime = 0;
	int score = 0;
	Font timeFont = new Font("Courier", Font.BOLD, 70);
	
	
	
	
	Music backgroundMusic = new Music("Pac-Man-Theme-Song.wav", false);
	//Music missSound = new Music("", false);
	//Music hitSound = new Music("", false);
	
	
	//frame width/height
	int width = 1000;
	int height = 934;
	
	
	
	//Add your object declaration and instantiations here
	Ghosts ClydeL = new Ghosts("clydeL.png");
	Background b = new Background("background.png");
	Pacman Pac = new Pacman("pacman.png");
	Orb orb = new Orb("orb.png");
	Orb orb2 = new Orb("orb.png");
	Orb orb3 = new Orb("orb.png");
	Orb orb4 = new Orb("orb.png");
	Orb orb5 = new Orb("orb.png");
	Orb orb6 = new Orb("orb.png");
	Orb orb7 = new Orb("orb.png");
	Orb orb8 = new Orb("orb.png");
	Orb orb9 = new Orb("orb.png");
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//Call the paint method of your objects here
		b.paint(g);
		
		
		orb.paint(g);
		orb2.paint(g);
		orb3.paint(g);
		orb4.paint(g);
		orb5.paint(g);
		orb6.paint(g);
		orb7.paint(g);
		orb8.paint(g);
		orb9.paint(g);
		
		ClydeL.paint(g);
		
		
		//Wave timer
		g.setFont(timeFont);
		g.setColor(Color.WHITE);
		g.drawString("Score: "+score, 375, 100);
		
		g.drawString(""+waveTimer, 375, 100);
		
		/* update time */
		 ellapseTime += 20;
		if(ellapseTime % 1000 == 0) {
			waveTimer--;
			ellapseTime=0;
		}
		
		if(waveTimer == 0 ) {
				/*
				 * What happens if the wave time hits 0?
				 * maybe there's a level counter?*/
		}
		
		
		
		
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(width, height));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
 		f.addMouseListener(this);
 		
 		
 		
 		orb2.x = 450;
 		orb3.x = 850;
 		orb4.y = 400;
 		orb5.x = 450;
 		orb5.y = 400;
 		orb6.x = 850;
 		orb6.y = 400;
 		orb7.y = 800;
 		orb8.x = 450;
 		orb8.y = 800;
 		orb9.x = 850;
 		orb9.y = 800;
 		
 		
 		
 		
 		
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		backgroundMusic.play();
		
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub
		System.out.println("print event block of code");
		System.out.println(m.getX() + ":"+m.getY());
		
		System.out.println(ClydeL.x+":"+ClydeL.y);
		System.out.println(ClydeL.width + ":" + ClydeL.height);
		
		//rectangle collision 
		Rectangle rectA = new Rectangle(m.getX() - 75, m.getY() - 75, 50, 50);
		
		//rectangle representation of my ghost object
		Rectangle rectB = new Rectangle(ClydeL.x - 20, ClydeL.y , ClydeL.width + 50, ClydeL.height + 60);
		
		//check for collision using intersect method
		if(rectA.intersects(rectB)) {
			
			System.out.println("OUCH");
			// lets fake respawning by teleporting the object back to some starting value
			Random r = new Random();
			int i = r.nextInt(0,16);
			
			if (i == 0){ 
				ClydeL.y = 50;
				ClydeL.x = 50;
			} else if (i == 1) {
				ClydeL.y = 100;
				ClydeL.x = 50;
			} else if (i == 2) {
				ClydeL.y = 150;
				ClydeL.x = 50;
			} else if (i == 3) {
				ClydeL.y = 200;
				ClydeL.x = 50;
			} else if (i == 4) {
				ClydeL.y = 250;
				ClydeL.x = 50;
			} else if (i == 5) {
				ClydeL.y = 300;
				ClydeL.x = 50;
			} else if (i == 6) {
				ClydeL.y = 350;
				ClydeL.x = 50;
			} else if (i == 7) {
				ClydeL.y = 400;
				ClydeL.x = 50;
			} else if (i == 8) {
				ClydeL.y = 450;
				ClydeL.x = 50;
			} else if (i == 9) {
				ClydeL.y = 500;
				ClydeL.x = 50;
			} else if (i == 10) {
				ClydeL.y = 550;
				ClydeL.x = 50;
			} else if (i == 11) {
				ClydeL.y = 600;
				ClydeL.x = 50;
			} else if (i == 12) {
				ClydeL.y = 650;
				ClydeL.x = 50;
			} else if (i == 13) {
				ClydeL.y = 700;
				ClydeL.x = 50;
			} else if (i == 14) {
				ClydeL.y = 750;
				ClydeL.x = 50;
			} else if (i == 15) {
				ClydeL.y = 790;
				ClydeL.x = 50;
			} 
			
			score += 200;
			
			ClydeL.vx += 10;
			ClydeL.vy += 10;
			
			
			
		}
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		if(key.getKeyCode() == 83 ) {
			//83 is the keycode for 's'
			
		}
			
		if(key.getKeyCode() == 87 ) {
			//87 is the keycode for 'w'
		}
		
		if(key.getKeyCode() == 40  ) {
			//83 is the keycode for 'arrow down'
		}
			
		if(key.getKeyCode() == 38 ) {
			//87 is the keycode for 'arrow up'
		} 
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
