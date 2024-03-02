import java.util.*;

import java.io.*;

class SolveMazes{
    public static void main(String[] args) throws FileNotFoundException
    {
        String fileName="stop";
        Scanner input=new Scanner(System.in);
        MazeSolver Solver=new MazeSolver();
        System.out.println("Enter a file name or stop: ");
        fileName=input.nextLine();
        while(!fileName.equals("stop"))
        {
            GridReader maze =new GridReader(fileName);
            char[][] m =maze.getCopy();
            
            if(Solver.solveMaze(m))
            {
                String[] path=Solver.getMoves();
                for(int i=0;i<path.length;i++)
                {
                    System.out.println(path[i]);
                }
                for(int i=0;i<m.length;i++){
                    for(int j=0;j<m[i].length;j++)
                    {
                        System.out.print(m[i][j]);
                    }
                    System.out.println();
                }
                System.out.println(Solver.getNumCellsVisited()+" cells visited.");
            }
            else {
                System.out.println("No Solution.");
            }
            System.out.println("Enter a file name or stop: ");
            fileName=input.nextLine();
        }
        System.out.println("Percent Correct: "+100*Solver.getPerformance()+"%");
        input.close();
    }
}