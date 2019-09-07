package projects.breadth;

import java.util.Scanner;
import java.io.*;   
import javax.swing.JFrame; 
import javax.swing.JOptionPane; 
import java.awt.Color;   
import java.awt.Font;  
// THIS IS YOUR QUEUE!
import collections.list.generics.Queue;

public class BMazeApp
{
   static BDisplay display;
	public static void main(String[] args) throws IOException
	{
		int length;
		BMaze m;

		Scanner conIn = new Scanner(System.in);
		
      System.out.print("Enter the input file name:  ");
		String filename = conIn.nextLine();
		
      JFrame frame = new JFrame("Breadth First Search");
      display = new BDisplay();
      frame.add(display);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800, 800);
      frame.setVisible(true);
      
      frame.setBackground(new Color(0,0,128));

		m = new BMaze(filename);

      JOptionPane.showMessageDialog(frame,
          "I have the maze, Hit <OK> to see it...",
          "Breadth First", JOptionPane.PLAIN_MESSAGE);						

      display.setBMaze(m);

      JOptionPane.showMessageDialog(frame,
          "Hit <OK> to solve this maze using breadth first search...",
          "Breadth First", JOptionPane.PLAIN_MESSAGE);						

		length = m.solveMaze();

		if (length >= 0)
		{
         JOptionPane.showMessageDialog(frame,
          "The shortest path through this maze has length " + length + ".",
          "Breadth First", JOptionPane.PLAIN_MESSAGE);						

			//System.out.println("\nThe shortest path through this maze has length " + length + ".");
			//System.out.println("Here it is:  \n");
   		//conIn.nextLine();
			m.generateSolution(); 
		}
		else
			System.out.println("There is no solution to this maze!");

		System.out.println("\nBye!\n");
      conIn.nextLine();
      System.exit(0);
	}
}		