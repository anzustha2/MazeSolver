//package projects.depth;

import java.util.Scanner;
import java.io.*;        
import javax.swing.JFrame; 
import java.awt.Color;

public class DMazeApp
{
   static Display display;
	public static void main(String[] args) throws IOException
	{
		Scanner conIn = new Scanner(System.in);
		boolean haveMaze;
		String filename;
		int n;
      boolean recurse = false;

		System.out.print("Enter the input file name:  ");
		filename = conIn.nextLine();
		System.out.print("Solve recursively?:  ");
      if( conIn.nextLine().toUpperCase().charAt(0) == 'Y' ) 
      {
         recurse = true;
      }      

      JFrame frame = new JFrame("Depth First Search");
      display = new Display();
      display.setBackground(new Color(255,255,255));
      frame.add(display);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //frame.setLocationRelativeTo(null);
      frame.setSize(800, 800);
      frame.setVisible(true);
      
      frame.setBackground(new Color(0,0,128));

		DMaze m = new DMaze("projects/depth/" + filename);
      
		haveMaze = m.getMaze();
      
      display.setDMaze(m);
		while (haveMaze)
		{
			System.out.println("\nHere is the maze:");
						
			System.out.println(m);

			System.out.print("\nHit <Enter> to solve this maze...");
			conIn.nextLine();

			n = m.solveMaze(recurse);

			System.out.println("\nDone with this maze.  It has " + n + " solution(s).\n");

			System.out.print("\nHit <Enter> to get the next maze...");
			conIn.nextLine();
			
			haveMaze = m.getMaze();
         display.setDMaze(m);
		}
	   display.setDMaze(null);
		System.out.println("\nNo more mazes in the file...Bye!\n");
      System.exit(0);
	}
}