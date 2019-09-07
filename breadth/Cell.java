package projects.breadth;

public class Cell implements Comparable<Cell>
{
   public int i;
   public int j;
   public int color;
   public char type;
   public int distance;
  	
   public Cell(int x, int y)
   {
      i = x;
		j = y;
   }
   public int compareTo(Cell c)
   {
      return 0;
   }
   protected static final char SPACE = '-';
	protected static final char COMMA = ',';
	protected static final char WALL = '#';
	protected static final char START = 'S';
	protected static final char END = 'E';
}