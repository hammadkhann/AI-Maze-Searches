package cs401.k142145.a1p5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 *
 * @author hammadkhan
 */
public class GBFS {


    //Attributes
    private Priority_Queue frontier ; //GBFS uses priority queue to keep frontier
    private int[][] maze ;
    private int[][] visitedNode ;
    private int[][] exploredNode ;
    private int[][] heuristic ;
    private final int row ;
    private final int column ;
    private final State goalState ;
    private final State initialState ;
    private Node goalNode ;

        
    
    
    public GBFS ( int[][] m , State i , State g , int r , int c  )
    {
        this.row = r ;
        this.column = c ;
        maze = new int [row][column] ;
        visitedNode = new int [row][column] ;
        exploredNode = new int [row][column] ;
        heuristic = new int [row][column];
        frontier = new Priority_Queue();
        
        maze = m ;
        
        this.initialState = i ;
        this.goalState = g ;
        setHeuristic();
    }
    
    
    
    public void setHeuristic ()
    {
        int g_x , g_y , h ;
        for ( int i = 0 ; i < row ; i++ )
        {
            for ( int j = 0 ; j < column ; j++ )
            {
                g_x = Math.abs( goalState.getState_X() - i );
                g_y = Math.abs( goalState.getState_Y() - j );
                
                h = Math.max(g_x, g_y);
                
                heuristic[i][j] = h ;
                
            }
        }
    }
    
    public void printHeuristic()
    {
        for ( int i = 0 ; i < row ; i++ )
        {
            for ( int j = 0 ; j < column ; j++ )
            {
                System.out.print(heuristic[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    
    
    public void GBFS_Run ( )
    {
        
        for(int j = 0 ; j < row ; j++ )
        {
            for ( int k = 0 ; k < column ; k++ )
            {
                visitedNode[j][k] = 0 ;
                exploredNode[j][k] = 0 ;
            }
        }
        
        int fn = heuristic[initialState.getState_X()][initialState.getState_Y()];
        // f(n) = h(n)
        
        
        Node initial = new Node ( initialState ,1, fn ) ;
        frontier.push(initial);
        
        Queue<Integer> child_x = new LinkedList<>();
        Queue<Integer> child_y = new LinkedList<>();
        
        int x , y , i , j ;
        
        while ( frontier.size() != 0 )
        {
            
            Node DD = frontier.pop() ;
            
            
            if ( DD.checkGoal(goalState) == true )
            {
                System.out.println("Goal Reached");
                goalNode = DD ;
                return ;
            }
            
            x = DD.getState_x() ;
            y = DD.getState_y() ;
            
            
            exploredNode[x][y] = 1 ;
            visitedNode[x][y] = 1 ;
            
            //Right Down
            child_x.add(x + 1);
            child_y.add(y + 1);
            //Right Up
            child_x.add(x - 1);
            child_y.add(y + 1);
            //Left Down
            child_x.add(x + 1);
            child_y.add(y - 1);
            //Left Up
            child_x.add(x - 1);
            child_y.add(y - 1);
            //Left
            child_x.add(x);
            child_y.add(y - 1);
            //Right
            child_x.add(x);
            child_y.add(y + 1);
            //Down
            child_x.add(x + 1);
            child_y.add(y);
            //Up
            child_x.add(x - 1);
            child_y.add(y);
            
            
            while ( child_x.size() != 0 && child_y.size() != 0 )
            {
                i = child_x.remove();
                j = child_y.remove();
                
                if ( ( i >= 0 && i < row ) && ( j >= 0 && j < column ) && (maze[i][j] == 0) && (x != i || y != j) && (exploredNode[i][j] != 1) )
                {
                    exploredNode[i][j] = 1 ;
                    
                    State s1 = new State ( i , j ) ;
                    
                    fn = heuristic[i][j];
                   
                    // f(n)=h(n)
        
        
                    
                    Node DD1 = new Node ( s1 , DD,DD.getCost()+1, fn) ;
                    
                    frontier.push(DD1);
                    
                }
                
            }
            
        }
        
    }
   

    
    public void Path () throws IOException
    {
          //Writing to a file
            FileWriter outfile = new FileWriter("A1P5out1.txt", false);
            PrintWriter print = new PrintWriter(outfile);
        Stack<Node> print_reverse = new Stack();
           
        Node temp = goalNode ;
        
        print_reverse.push(temp);
        
        while ( temp.getState_x() != initialState.getState_X() || temp.getState_y() != initialState.getState_Y()  )
        {
            temp = temp.getParent();
            print_reverse.push(temp);
        }
        
        while ( print_reverse.size() != 0 )
        {
            temp = print_reverse.pop();
            print.print(temp.getState_x() + " " + temp.getState_y());
            print.print("\r\n");
            System.out.println(temp.getState_x() + " " + temp.getState_y());
        }
        print.print(temp.getCost());
        System.out.println(temp.getCost());
        print.close();
       
    }
    
    
    public void printMaze ()
    {
        for ( int i = 0 ; i < row ; i++ )
        {
            for ( int j = 0 ; j < column ; j++ )
            {
                System.out.print(this.maze[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}

