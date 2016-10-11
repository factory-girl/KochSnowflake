import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.awt.geom.GeneralPath;
import java.awt.Polygon;
import java.awt.Point;

/**
 * Class which recursively draws a Koch snowflake
 * @author softskeleton
 *
 */
public class KochSnowflakeComponent extends JComponent {
	
    private ArrayList<Point> points = null;
    private int numIterations = 0;
    
    /**
     * Method that creates initial triangle
     */
    private void createTriangle() {
        points = new ArrayList<Point>();
        
        int length = Math.min(getWidth(), getHeight())*2/3;
        int x1 = (getWidth()-length)/2;
        int y1 = length/2;
        
        points.add(new Point(x1, y1));
        int x2 = x1+length;
        int y2 = y1;
        
        points.add(new Point(x2, y2));
        int x3 = x1+(length/2);
        int y3 = y1+length;
        
        points.add(new Point(x3, y3));
    }
    
    /**
     * Increases iterations by one and re-draws snowflake
     */
    public void next() {
        numIterations = numIterations++;
        ArrayList<Point> newPoints = new ArrayList<Point>();
        
        	for(int i = 0; i<points.size(); i++) {
        		Point p1 = points.get(i);
        		Point p2 = i==points.size()-1 ? 
        				points.get(0) : points.get(i+1);
        		newPoints.add(p1);
        		newPoints.addAll(getKochPoints(p1, p2));
        }
        points = newPoints;
        repaint();
    }
    public void paintComponent(Graphics g) 
    {
        if(points==null) {
            createTriangle();
        }
        Graphics2D g2 = (Graphics2D)g;
         Polygon koch = new Polygon();
         for (Point p : points){
           koch.addPoint(p.x, p.y);
         }
         g2.draw(koch);
    }
    /** 
     * Generate the points to add for each segment for each iteration.
     */
    private ArrayList<Point> getKochPoints(Point p1, Point p2) {
        ArrayList<Point> kochPoints = new ArrayList<Point>();
        int dx = p2.x-p1.x;
        int dy = p2.y-p1.y;
        double xtra = dx / 3;
        double use = xtra * xtra;
        int test = (int)(Math.sqrt(use-(use/36)));
        int test2 = p1.y+dy/3-test;        
        
        Point kp1 = new Point(p1.x+dx/3, p1.y+dy/3);
        kochPoints.add(kp1);
       if(p1.y == p2.y)
        {
            Point kp2 = new Point((p1.x+dx/3)+((dx/3)/2), ((p1.y+dy/3)-test));
            kochPoints.add(kp2);
        }
        else if(p1.x > p1.y)
        {
            Point kp2 = new Point(p1.x, p1.y+(dy/3)+test+57);
            kochPoints.add(kp2); 
        }
        else
        {
            Point kp2 = new Point(p1.x+(dx), p1.y+(2*dy/3) + test+57);
            kochPoints.add(kp2);
       
  
        }
            
        
        Point kp3 = new Point((p1.x+2*dx/3), (p1.y+2*dy/3));
        kochPoints.add(kp3);
        return kochPoints;
    }
 }
