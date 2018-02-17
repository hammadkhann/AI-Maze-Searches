/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401k142145a1p4;

/**
 *
 * @author hammadkhan
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class IDS {


    //Attributes
    private Stack<Node> frontier;       //Depth-first search implements a stack for frontier
    private int[][] maze ;
    private int[][] visitedNode ;
    private int[][] exploredNode ;
    private final int row ;
    private final int column ;
    private final State goalState ;
    private final State initialState ;
    private Node goalNode ;
    private boolean route ;
   

    public IDS ( int[][] m , State i , State g , int r , int c)
    {
        frontier = new Stack();
        this.row = r ;
        this.column = c ;
        maze = new int [row][column] ;
        visitedNode = new int [row][column] ;
        exploredNode = new int [row][column] ;
        route = false ;
        
        for(int j = 0 ; j < row ; j++ )
        {
            for ( int k = 0 ; k < column ; k++ )
            {
                visitedNode[j][k] = 0 ;
                exploredNode[j][k] = 0 ;
            }
        }
        
        maze = m ;
        
        this.initialState = i ;
        this.goalState = g ;
    }
    
    
    
    public void IDSRun (int depth)
    {
        
        Node initial = new Node ( initialState , 1 ) ;
        frontier.add(initial);
        
        if ( initial.checkGoal(goalState) == true )
        {
            System.out.println("Goal Reached");
            route = true;
            return;
        }
        Queue<Integer> child_x = new LinkedList<>();
        Queue<Integer> child_y = new LinkedList<>();
        
        int x , y , i , j ;
     
        while ( frontier.size() != 0 )
        {
            
            Node u = frontier.pop() ;
            if(depth>=0){
        System.out.println("depth :"+depth);
            x = u.getState_x() ;
            y = u.getState_y() ;
            
            
            exploredNode[x][y] = 1 ;
            visitedNode[x][y] = 1 ;
            
            
            //Up
            child_x.add(x - 1);
            child_y.add(y);
            //Down
            child_x.add(x + 1);
            child_y.add(y);
            //Right
            child_x.add(x);
            child_y.add(y + 1);
            //Left
            child_x.add(x);
            child_y.add(y - 1);
            //Left Up
            child_x.add(x - 1);
            child_y.add(y - 1);
            //Left Down
            child_x.add(x + 1);
            child_y.add(y - 1);
            //Right Up
            child_x.add(x - 1);
            child_y.add(y + 1);
            //Right Down
            child_x.add(x + 1);
            child_y.add(y + 1);
            
            
            while ( child_x.size() != 0 && child_y.size() != 0 )
            {
                i = child_x.remove();
                j = child_y.remove();
                
                if ( ( i >= 0 && i < row ) && ( j >= 0 && j < column ) && (maze[i][j] == 0) && (x != i || y != j) && (exploredNode[i][j] != 1) )
                {
                    exploredNode[i][j] = 1 ;
                    
                    State s1 = new State ( i , j ) ;
                    Node u1 = new Node ( s1 , u , u.getCost()+1 ) ;
                    
                    if ( u1.checkGoal(goalState) == true )
                    {
                        System.out.println("Goal Reached");
                        goalNode = u1 ;
                        route = true ;
                        return;
                    }
                    
                    frontier.add(u1);
                  
                
                }
                
            }
       
               
            
            exploredNode[x][y]=1;
            visitedNode[x][y] = 1;
            //System.out.println("Index depth :"+depth + " Max depth :"+maxdepth);
        }
            
             depth++;
         
        }
       
    }
    
    
     public void OptimalPath () throws IOException
       {
           //Writing to a file
            FileWriter outfile = new FileWriter("A1P4out1.txt", false);
            PrintWriter print = new PrintWriter(outfile);
        if ( route == false ) 
        {
            System.out.println("No Route Found!");
            return;
        }
        
        
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

    
    
    
    

        

