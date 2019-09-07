package projects.breadth;

import java.util.Scanner; 
import java.io.*;         

public class FileInput
{
   public static char [][] getNextGrid(BufferedReader scan) throws IOException
   {
      int rows, cols, i, j;
		char [][] a;
		String line;

		line = scan.readLine();
		rows = Integer.parseInt(line);

		if (rows > 0)				
		{	
			line = scan.readLine();
			cols = Integer.parseInt(line);
		
			a = new char [rows][cols];

     		for (i = 0; i < rows; i++)
			{
				line = scan.readLine();
				for (j = 0; j < cols; j++)
				{ 
				   a[i][j] = line.charAt(j);
				}
			 }
		}
			
		else
			a = new char [0][0];
  
      
     return a;
   }
}
