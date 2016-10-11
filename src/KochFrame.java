import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
/**
 * Constructs a frame for KochSnowflakeComponent
 * @author softskeleton
 *
 */
public class KochFrame extends JFrame {


   private KochSnowflakeComponent component;
   private static final int FRAME_WIDTH = 1000;
   private static final int FRAME_HEIGHT = 1000;
   private static final int COMPONENT_WIDTH = 500;
   private static final int COMPONENT_HEIGHT = 500;

   public KochFrame()

   {

      setSize(FRAME_WIDTH, FRAME_HEIGHT);

      setTitle("KochViewer");

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 

      JPanel panel = new JPanel();

      panel.add(makeNextButton());

 

      component = new KochSnowflakeComponent();

      component.setPreferredSize(new Dimension(COMPONENT_WIDTH, COMPONENT_HEIGHT));

      panel.add(component);

 

      add(panel);

   }

 

   private JButton makeNextButton()

   {

      JButton button = new JButton("Next");

      class ButtonListener implements ActionListener

      {
         public void actionPerformed(ActionEvent event)

        {

            component.next();

         }
      }

      button.addActionListener(new ButtonListener());

      return button;

   }

}
