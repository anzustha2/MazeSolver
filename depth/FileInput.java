//package projects.depth;
import java.util.Scanner; 
import java.io.*;         

public class FileInput
{
   public static Cell [][] getNextGrid(BufferedReader scan) throws IOException
   {
      int rows, cols, i, j;
		Cell [][] a;
		String line;

		line = scan.readLine();
		rows = Integer.parseInt(line);

		if (rows > 0)				
		{	
			line = scan.readLine();
			cols = Integer.parseInt(line);
		
			a = new Cell[rows][cols];

     		for (i = 0; i < rows; i++)
			{
				line = scan.readLine();
				for (j = 0; j < cols; j++)
				{ 
				   a[i][j] = new Cell();
               a[i][j].type = line.charAt(j);
               a[i][j].y = i;
               a[i][j].x = j;
				}
			}
		}
		else
			a = new Cell [0][0];
     return a;
   }
}
