import java.io.*;
import java.util.*;

//This class is designed to read in the game file and store it in a 2D array
//We coded it as a separate assignment, but it works well for Maze Solver
public class GridReader{
    private char[][] grid;
    private String fileName;
    public GridReader(String game) throws FileNotFoundException
    {
        fileName=game;
        File file=new File(game);
        Scanner reader=new Scanner(file);
        int inc=0;
        while(reader.hasNext())
        {
            reader.nextLine();
            inc++;
        }
        reader.close();
        grid=new char[inc][];
        inc=0;
        //In order to get the dimentions of the array correct, I had to make two scanners, one for counting and
        //one for actually reading in the file
        Scanner reader2=new Scanner(file);
        while(reader2.hasNext())
        {
            char[] temp=reader2.nextLine().toCharArray();
            grid[inc]=temp;
            inc++;
        }
        reader2.close();
    }
    public String toString()
    {
        //This method just allows you to output the game board
        String string="";
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<this.grid[i].length;j++)
            {
                string+=grid[i][j];
            }
            string+="\n";
        }
        return string;
    }
    public String getFileName()
    {
        return fileName;
    }
    public char[][] getCopy()
    {
        //This method is meant to creat a deep copy of the game board
        char[][] copy=new char[grid.length][];
        for(int i=0;i<grid.length;i++)
        {
            copy[i]=new char[grid[i].length];
            for(int j=0;j<copy[i].length;j++)
            {
                copy[i][j]=grid[i][j];
            }
        }
        return copy;
    }
    
    
}
