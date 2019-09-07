package projects.breadth;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.Font;

public class BDisplay extends JPanel implements ActionListener
{
   BMaze  m;
   Timer timer;

   Font fontBig = new Font("Verdana", Font.BOLD, 30);

   public BDisplay()
   {
      timer = new Timer(100, this);
      timer.start();       
      setFont(fontBig);
   }
   
   public void setBMaze(BMaze b)
   {
      m = b;
   }
   
   public void actionPerformed(ActionEvent e) 
   {
      repaint();
   }

   public void paint (Graphics g)
   {
      //System.out.println( "Painting!");
      super.paint(g);
      if( m == null || m.numRows == 0 || m.numCols == 0) 
      {
         return;
      }
      int hStep = getHeight() / m.numRows;
      int wStep = getWidth() / m.numCols;
      for( int i=0; i<m.numRows; i++ )
      {
         for( int j=0; j<m.numCols; j++ )
         {
            if( m.grid[i][j].type == Cell.WALL )
            {
               Color c = new Color( 100, 50, 255 );
               g.setColor(c);
               g.fillRect(wStep * j + 1, hStep * i + 1, wStep-2, hStep-2);
            }          
            else if( m.grid[i][j].type == Cell.START )
            {
               Color c = new Color( 100, 255, 100 );
               g.setColor(c);
               g.fillRect(wStep * j + 1, hStep * i + 1, wStep-2, hStep-2);
            }          
            else if( m.grid[i][j].type == Cell.END )
            {
               Color c = new Color( 255, 100, 100 );
               g.setColor(c);
               g.fillRect(wStep * j + 1, hStep * i + 1, wStep-2, hStep-2);
            }          
            else if( m.grid[i][j].distance > 0 )
            { 
               int indent = wStep/8;
               if( m.grid[i][j].distance < 10 ) 
                  indent = wStep/3;
                  
               Color c = new Color( 150, 150, 255 );
               if( m.grid[i][j].color > 0 )
                  c = new Color(0, 255, 0);
               g.setColor(c);
               g.drawString("" + m.grid[i][j].distance,wStep * j + indent, hStep * (i) + (int)(hStep*.75));
            }          
         }
      }
   } 
}