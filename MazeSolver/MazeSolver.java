

import java.util.*;

public class MazeSolver{
    //These characters are the different parts of the maze, such as walls and the goal
    final char open='.', blocked='#',start='S', goal='G', marked='+', unmarked='x';
    private int numCellsVisited=0, mazesSolved=0, mazesTried=0;
    private char[][] maze;
    public ArrayList<String> mazePath = new ArrayList<String>();

    public MazeSolver()
    {
        
    }
    public boolean solveMaze(char[][] m)
    {
        maze=m;
        //mazePath is a string array list of the cardinal directions that make up the solved path of the maze
        mazePath=new ArrayList<String>();
        numCellsVisited=0;
        int startx=0, starty=0;
        //The start and end are dependent on the maze, so the porgram has to find them first
        for(int y=0;y<maze.length;y++)
        {
            for(int x=0;x<maze[y].length;x++)
            {
                if(maze[y][x]==start)
                {
                    startx=x;
                    starty=y;
                }
            }
        }
        //findPath is the recursive method for finding the solution to the maze
        boolean solved=findPath(starty,startx);
        if(solved)
            mazesSolved++;
        mazesTried++;
        maze[starty][startx]=start;
        return solved;
    }
    private boolean findPath(int y, int x)
    {
        //This makes sure the algorithm says in bounds
        if(x<0||x>=maze[0].length||y<0||y>=maze.length)
        {
            return false;
        }
        //Checks if the algorithm has reached the goal
        else if(maze[y][x]==goal)
        {
            return true;
        }
        //Checks to make sure that the algorithm isn't traveling somewhere that has been crossed off or
        //isn't inside a wall
        else if(maze[y][x]==blocked||maze[y][x]==marked)
        {
            return false;
        }
        //THis bit of code keeps track of where it has been by editing the 2D array with the "marked" field
        maze[y][x]=marked;
        numCellsVisited++;
        //This is where the recursion comes in. It checks each direction recursively which 
        //usually results in branches being explored entirely before moving on
        if(findPath(y-1, x))
        {
            mazePath.add(0,"North");
            return true;
        }
        if(findPath(y+1, x))
        {
            mazePath.add(0,"South");
            return true;
        }
        if(findPath(y, x-1))
        {
            mazePath.add(0,"West");
            return true;
        }
        if(findPath(y, x+1))
        {
            mazePath.add(0,"East");
            return true;
        }
        maze[y][x]=unmarked;
        numCellsVisited--;
        return false;
    }
 
    public String[] getMoves(){
        if(mazePath.size()==0)
            return null;
        String[] array=new String[mazePath.size()];
        for(int i=0;i<array.length;i++)
        {
            array[i]=mazePath.get(i);
        }
        return array;
    }
    public int getNumCellsVisited()
    {
        return numCellsVisited;
    }
    public double getPerformance()
    {
        if(mazesTried!=0)
            return (double)mazesSolved/mazesTried;
        else return 0;
    }

    
}
