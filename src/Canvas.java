
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



/**
 * trida pro kresleni na platno:
 * zobrazeni  pixelu 
 * @author PGRF FIM UHK
 * @version 2015
 */

public class Canvas {

	private JFrame frame;
	private JPanel panel;
	private BufferedImage img;
	private ArrayList<Point> listOfPoints = new ArrayList<>();
	int startX, startY;
	LineRenderer lineRenderer;
	CircleRenderer cr;
	SeedFill seedfill;
	

	public Canvas(int width, int height) {
		frame = new JFrame();
		frame.setTitle("UHK FIM PGRF : Canvas");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		lineRenderer = new LineRenderer(img);
		cr = new CircleRenderer(img);
		seedfill = new SeedFill(img);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));	
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
				
			}
		});	
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(e.getButton() == MouseEvent.BUTTON1) {
					listOfPoints.add(new Point(e.getX(), e.getY()));
					//lineRenderer.drawLineTrivial(startX, startY, e.getX(), e.getY());
					clear(0x2f2f2f);
					drawPolygon();
					//cr.drawCircle(e.getX(), e.getY(), 20);
				} else {
					seedfill.fill(e.getX(), e.getY(), img.getRGB(e.getX(), e.getY()));	
				}

				present();
			}
		});
		/*
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				clear(0x2f2f2f);
				lineRenderer.drawLineTrivial(startX, startY, e.getX(), e.getY());
				present();
			}
		});
		*/
	}

	public void clear(int color) {
		Graphics gr = img.getGraphics();
		gr.setColor(new Color(color));
		gr.fillRect(0, 0, img.getWidth(), img.getHeight());
	}

	public void present() {
		if (panel.getGraphics() != null)
			panel.getGraphics().drawImage(img, 0, 0, null);
	}

	public void draw() {
		clear(0x2f2f2f);
		
		/*
		img.setRGB(10, 10, 0xffff00);
		int xA = 300;
		int yA = 500;
		int xB = 400;
		int yB = 100;

		Line.drawLine(xA, xB, yA, yB, img);
		LineImage line2 = new LineImage(xA, xB, yA, yB);
		line2.draw(img);
		lineRenderer.drawLine(xA, xB, yA, yB);
		lineRenderer.setColor(0x00ffff);
		lineRenderer.drawLine(50, xB, yA, yB);
		*/

	}
	
	public void drawPolygon() {
		if(listOfPoints.size() == 0) {
			//listOfPoints.add(new Point());
		} else {										
			for(int i = 1; i < listOfPoints.size(); i++) {
				int startX = (int) listOfPoints.get(i-1).getX();
				int startY = (int) listOfPoints.get(i-1).getY();
				int endX = (int) listOfPoints.get(i).getX();
				int endY = (int) listOfPoints.get(i).getY();
				lineRenderer.drawLineTrivial(startX, startY, endX, endY);							
		    }
			int startX = (int) listOfPoints.get(0).getX();
			int startY = (int) listOfPoints.get(0).getY();
			int endX = (int) listOfPoints.get(listOfPoints.size()-1).getX();
			int endY = (int) listOfPoints.get(listOfPoints.size()-1).getY();
			lineRenderer.drawLineTrivial(startX, startY, endX, endY);				
		}
	}
	
	public void start() {
		draw();
		present();
	}

	public static void main(String[] args) {
		Canvas canvas = new Canvas(800, 600);
		SwingUtilities.invokeLater(() -> {
			SwingUtilities.invokeLater(() -> {
				SwingUtilities.invokeLater(() -> {
					SwingUtilities.invokeLater(() -> {
						canvas.start();
					});
				});
			});
		});
	}

}