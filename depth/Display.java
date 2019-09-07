//package projects.depth;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Display extends JPanel implements ActionListener
{
   DMaze  m;
   Timer timer;
   
   public Display()
   {
      timer = new Timer(100, this);
      timer.start();       
   }
   
   public void setDMaze(DMaze d)
   {
      m = d;
   }
   
   public void actionPerformed(ActionEvent e) 
   {
      repaint();
   }

   public void paint (Graphics g)
   {
      super.paint(g);
      if( m == null || m.numRows == 0 || m.numCols == 0) 
      {
         return;
      }
      int hStep = getHeight() / m.numRows;
      int wStep = getWidth() / m.numCols;
      //System.out.println( hStep + ", " + wStep );
      for( int i=0; i<m.numRows; i++ )
      {
         for( int j=0; j<m.numCols; j++ )
         {
            if( m.grid[i][j].type == m.WALL )
            {
               Color c = new Color( 100, 50, 255 );
               g.setColor(c);
               g.fillRect(wStep * j + 1, hStep * i + 1, wStep-2, hStep-2);
            }          
            else if( m.grid[i][j].type == m.START )
            {
               Color c = new Color( 100, 255, 100 );
               g.setColor(c);
               g.fillRect(wStep * j + 1, hStep * i + 1, wStep-2, hStep-2);
            }          
            else if( m.grid[i][j].type == m.END )
            {
               Color c = new Color( 255, 100, 100 );
               g.setColor(c);
               g.fillRect(wStep * j + 1, hStep * i + 1, wStep-2, hStep-2);
            }          
            else if( m.grid[i][j].visited == true )
            {
               Color c = new Color( 50, 150, 50 );
               g.setColor(c);
               g.fillOval(wStep * j + 4, hStep * i + 4, wStep-8, hStep-8);
            }          
            /*else if( m.grid[i][j].type == m.SPACE )
            {
               Color c = new Color( 255, 255, 255 );
               g.setColor(c);
               g.fillRect(wStep * j + 1, hStep * i + 1, wStep-2, hStep-2);
            }*/
         }
      }
   } 
}