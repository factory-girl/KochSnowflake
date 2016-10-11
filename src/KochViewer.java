
import javax.swing.JFrame;

/**
 * Viewer for KochFrame
 * @author softskeleton
 *
 */
public class KochViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new KochFrame();
      frame.setTitle("KochViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}