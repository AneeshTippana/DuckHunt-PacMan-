import java.awt.Graphics;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Ghosts{
	private Image img; 	
	private Image left, right, up, down;
	private AffineTransform tx;
	int width, height;
	int x, y;						//position of the object
	int vx, vy;						//movement variables
	double scaleWidth = 0.07;		 //change to scale image
	double scaleHeight = 0.07; //change to scale image

	public Ghosts(String filename) {
		img = getImage("/imgs/"+filename); //load the image for Tree
		
		left = getImage("/imgs/"+"clydeL.png"); //load the image for Tree
		right = getImage("/imgs/"+"ClydeR.png"); //load the image for Tree
		up = getImage("/imgs/"+"ClydeU.png"); //load the image for Tree
		down = getImage("/imgs/"+"ClydeD.png"); //load the image for Tree
		

		
		
		
		
		//alter these
		width = 5;
		height = 5;
		x = 50;
		y = 50;
		vx = 10;
		vy = 10;
		       

		    
		
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(0, 0);
	}
	
	
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		
		
		
		
	
		
		
		
		
		if(x > 900 || x < 0) {
			vx *= -1;
		}
		if(y > 850 || y < 0) {
			vy *= -1;
		}
	
		
		
		x+=vx;
		y+=vy;
		
		
	
		
		
		
		init(x,y);
		
		if (vy >= 0) {
			g2.drawImage(down, tx, null);
		} else if (vx < 0) {
			g2.drawImage(left, tx, null);
		} else if (vy < 0) {
			g2.drawImage(up, tx, null);
		} else if (vx > 0){
			g2.drawImage(right, tx, null);
		}
		
		//g2.drawImage(img, tx, null);

	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Ghosts.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	

}
