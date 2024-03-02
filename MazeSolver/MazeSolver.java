

import java.util.*;

public class MazeSolver{
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
        mazePath=new ArrayList<String>();
        numCellsVisited=0;
        int startx=0, starty=0;
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
        boolean solved=findPath(starty,startx);
        if(solved)
            mazesSolved++;
        mazesTried++;
        maze[starty][startx]=start;
        return solved;
    }
    private boolean findPath(int y, int x)
    {
        if(x<0||x>=maze[0].length||y<0||y>=maze.length)
        {
            return false;
        }
        else if(maze[y][x]==goal)
        {
            return true;
        }
        else if(maze[y][x]==blocked||maze[y][x]==marked)
        {
            return false;
        }
        maze[y][x]=marked;
        numCellsVisited++;
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
        //mazePath.remove(numCellsVisited-1);
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