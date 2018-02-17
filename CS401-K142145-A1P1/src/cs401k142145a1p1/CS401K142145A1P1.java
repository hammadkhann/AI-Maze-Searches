package cs401k142145a1p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author hammadkhan
 */
public class CS401K142145A1P1 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
      
File File1 = new File("A1-in1.txt");
          
            Scanner sc = new Scanner(File1);
         int m = sc.nextInt(); // column
        
         int n = sc.nextInt(); // row
         
        
         //checking constraints
         if((m<0 || m>=500) || (n<0 || n>=500)){
             System.out.println("Constraints voilated");
             return;
         }
         
         int s1 = sc.nextInt();// source x
         int s2= sc.nextInt();  // source y
         int d1 = sc.nextInt();  // destination x
         int d2 = sc.nextInt();   // destination y
      
         
         //reading maze
         int [][] maze = new int[n][m];
         for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                 maze[i][j]=sc.nextInt();                 
             }
         }
         
         //printing maze
          for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                 System.out.print(maze[i][j]+" ");           
             }
             System.out.println();
         }
    
   
     //Writing to file
        FileWriter outfile = new FileWriter("A1P1out1.txt", false);
        PrintWriter print = new PrintWriter(outfile);
     
        //Writing maze
        
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<m;j++)
             {
                 
                 print.print(maze[i][j]+" ");           
             
             }
              print.print("\r\n");
         }
          print.close();
        
    }
}

