/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401.k142145.a1p6;

/**
 *
 * @author hammadkhan
 */
public class Node {

    private final State state ;
    private final Node parent ;
    private final int cost ;
    private final int heuristic_cost ;
    
    public Node ( State s , int c , int h )
    {
        this.parent = null ;
        this.state = s ;
        this.cost = c ;
        this.heuristic_cost = h;
    }
    
    public Node ( State s , Node p , int c ,  int h )
    {
        this.state = s ;
        this.parent = p ;
        this.cost = c ;
        this.heuristic_cost = h;
    }
    
    public boolean checkGoal ( State s )
    {
        return (s.getState_X() == state.getState_X() && s.getState_Y() == state.getState_Y()) ;
    }
    
    public State getState ()
    {
        return this.state;
    }
    
    public int getCost ()
    {
        return this.cost;
    }
    
    public int getHeuristicCost ()
    {
        return this.heuristic_cost;
    }
    
    public Node getParent ()
    {
        return this.parent;
    }
    
    
    public int getState_x ()
    {
        return state.getState_X() ;
    }
    
    public int getState_y ()
    {
        return state.getState_Y();
    }
    
}