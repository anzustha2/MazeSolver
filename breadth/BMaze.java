//Anju Shrestha
//cs304
package projects.breadth;

import java.io.*;         
import java.util.Scanner;
import collections.list.generics.Queue;

public class BMaze
{
	
	protected int numRows;        
	protected int numCols;        

	protected int startRow;
	protected int startCol;
	protected int endRow;
	protected int endCol;

	protected BufferedReader input;

	protected Cell [][] grid;  
   BDisplay bdisplay;


//************************************************************************************
  // Constructor -- opens files, initializes arrays
	public BMaze(String inputFileName)  throws IOException
	{
      FileReader f = new FileReader(inputFileName);
      input = new BufferedReader(f);
		
		getMaze();
	}
	public void setBDisplay(BDisplay d)
   {
      bdisplay = d;
   }

//************************************************************************************
	public void getMaze() throws IOException
	{
		String line;
		int i, j;
		
		line = input.readLine();
		numRows = Integer.parseInt(line);
		line = input.readLine();
		numCols = Integer.parseInt(line);
		line = input.readLine();
		startRow = Integer.parseInt(line);
		line = input.readLine();
		startCol = Integer.parseInt(line);
		line = input.readLine();
		endRow = Integer.parseInt(line);
		line = input.readLine();
		endCol = Integer.parseInt(line);

		grid = new Cell[numRows][numCols];

  		for (i = 0; i < numRows; i++)
		{
			line = input.readLine();
			for (j = 0; j < numCols; j++)
			{
            grid[i][j] = new Cell(i, j);
            grid[i][j].distance = -1;
				grid[i][j].type = line.charAt(j);
            if( grid[i][j].type == Cell.START )
            {
               startRow = i;
               startCol = j;
            }
            if( grid[i][j].type == Cell.END )
            {
               endRow = i;
               endCol = j;
            }
			}
		}
	} // public Maze()
	
//************************************************************************************
  // This method returns the String representation of the original, unsolved maze.
	public String toString()
	{
		String mazeString = "\n";
      /*for(int i = 0; i < numRows; i++)
      {
         for(int j = 0; i < numColumns; j++)
         {
            mazeString += String.valueOf(grid[i][j]);
         }
      }*/

//WRITE THIS METHOD--IT RETURNS THE STRING OF THE ORIGINAL, UNSOLVED MAZE.
		return mazeString;
	} // 	public String toString()
			
   public void sleep(int t)
   {
         try
         {
            Thread.sleep(t);
         }
         catch(InterruptedException ie)
         {
            System.out.println(ie);
         }
   }
   
//************************************************************************************
// This method will use a queue to solve the maze.  You will enqueue the start cell
// and then as long as the queue is not empty, dequeue a cell, check if it is the end cell (if 
// it is, you will call generate solution and return the length of the solution).  If it
// is not, you will visit the bordering cells, enqueueing them if they have not been visited.
// and updating the distance array.
	public int solveMaze()
   {
      Queue <Cell> q = new Queue<>();
      q.enqueue(grid[startRow][startCol]);
      grid[startRow][startCol].distance = 0;
      
      while(!q.isEmpty())
      {
         
         
         Cell c = q.dequeue();
         sleep(20);
         int d = c.distance + 1;
         if(grid[c.i+1][c.j].type != Cell.WALL && grid[c.i + 1][c.j].distance == -1)
         {
            grid[c.i + 1][c.j].distance = d;
            q.enqueue(grid[c.i + 1][c.j]);
            
         }
         
         if(grid[c.i][c.j-1].type != Cell.WALL && grid[c.i][c.j - 1].distance == -1)
         {
            grid[c.i][c.j-1].distance = d;
            q.enqueue(grid[c.i][c.j - 1]);
         }
         
         if(grid[c.i-1][c.j].type != Cell.WALL && grid[c.i - 1][c.j].distance == -1)
         {
            grid[c.i - 1][c.j].distance = d;
            q.enqueue(grid[c.i - 1][c.j]);
         }
         if(grid[c.i][c.j+1].type != Cell.WALL && grid[c.i][c.j + 1].distance == -1)
         {
            grid[c.i][c.j + 1].distance = d;
            q.enqueue(grid[c.i][c.j + 1]);
            
         }
         
         
         
                  
      }
                  
            
     return grid[endRow][endCol].distance;
	}	// 	public int solveMaze()

//************************************************************************************
// This method finds a shortest path from the start cell to the end cell, given the
// filled out distance array.  

	public void generateSolution()
	{
      int dist = grid[endRow][endCol].distance;
      int i=endRow, j=endCol;
      grid[i][j].color = 1;
      
      while(dist > 0 ) 
      {
         if(grid[i-1][j].type != Cell.WALL && grid[i-1][j].distance < dist)
         {
            dist = grid[i-1][j].distance;
            grid[i-1][j].color = 1;
            i=i-1;
         }
         else if(grid[i+1][j].type != Cell.WALL && grid[i+1][j].distance < dist)
         {
            dist = grid[i+1][j].distance;
            grid[i+1][j].color = 1;
            i=i+1;
         }
         else if(grid[i][j-1].type != Cell.WALL && grid[i][j - 1].distance < dist)
         {
            dist = grid[i][j - 1].distance;
            grid[i][j - 1].color = 1;
            j=j-1;
         }
         else if(grid[i][j+1].type != Cell.WALL && grid[i][j + 1].distance < dist)
         {
            dist = grid[i][j + 1].distance;
            grid[i][j + 1].color = 1;
            j=j+1;
         }
         
      }   
	} // end public void generateSolution(int i, int j)
//************************************************************************************
} //public class Maze
