/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401k142145a1p3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author hammadkhan
 */

public class CS401K142145A1P3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        File infile = new File("A1-in3.txt");
        //File infile = new File("text.txt");
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
        
        DFS P3 = new DFS( mazeGame , initial , destination , m , n  );
        
        P3.printMaze();
        long start = System.currentTimeMillis();
        P3.DFSRun();
        long end = System.currentTimeMillis();
        System.out.println("DFS algorithm took " + (end - start) + " milliseconds to reach the goal.");
        P3.OptimalPath();
    }
    
    
}
