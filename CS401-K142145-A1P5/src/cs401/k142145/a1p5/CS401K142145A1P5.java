
package cs401.k142145.a1p5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author hammadkhan
 */
public class CS401K142145A1P5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        File infile = new File("A1-in5.txt");
           
        
        Scanner in = new Scanner(infile);
   
        int m , n , s1 , s2 , d1 , d2 ;
        m = in.nextInt();  // row
        n = in.nextInt();  //column
        s1 = in.nextInt(); // source x
        s2 = in.nextInt(); // source y
        d1 = in.nextInt(); // destination x
        d2 = in.nextInt(); // destination y
        
        int[][] mazeGame = new int[m][n];
        
        for ( int i = 0 ; i < m ; i++ )
        {
            for ( int j = 0 ; j < n ; j++ )
            {
                mazeGame[i][j] = in.nextInt();
            }
        }
        
        State initial = new State ( s1 , s2 ) ;
        State destination = new State ( d1 , d2 ) ;
     
       GBFS P5 = new GBFS ( mazeGame , initial , destination , m , n  );
        
        System.out.println("Heuristic Values:");
        P5.printHeuristic();
        System.out.println("\n");
        System.out.println("Maze:");
        P5.printMaze();
        long start = System.currentTimeMillis();
        P5.GBFS_Run();
        long end = System.currentTimeMillis();
        System.out.println("GBFS algorithm took " + (end - start) + " milliseconds to reach the goal.");
        P5.Path();
    }
    
}
