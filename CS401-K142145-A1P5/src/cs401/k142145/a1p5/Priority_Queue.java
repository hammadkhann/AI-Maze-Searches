/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401.k142145.a1p5;

/**
 *
 * @author hammadkhan
 */

public class Priority_Queue {

    private int size ;
   
    private Node[] arrayy ;

    public Priority_Queue() 
    {
        size = 0 ;
        arrayy = new Node[1000000];
    }
    
    public Node pop ()
    {
        size--;
        return arrayy[size];
    }
    
    public int size()
    {
        return size;
    }
   
    public void print()
    {
        for ( int i = 0 ; i < size ; i++ )
        {
            System.out.println(arrayy[i].getHeuristicCost());
        }
    } 
    
    
    public void push (Node u)
    {
        if (size == 0)
        {
            size++;
            arrayy[0] = u ;
            return;
        }
        
        int x = u.getHeuristicCost();
        int x1 = arrayy[size-1].getHeuristicCost();
        
        if ( x1 > x )
        {
            size++ ;
            arrayy[size-1] = u ;
            return;
        }
        
        int temp = arrayy[0].getHeuristicCost() , index = 0;
        size++;
        
        while ( x < temp )
        {
            index++;
            temp = arrayy[index].getHeuristicCost();
        }
        
        for ( int i = (size-1) ; i > index ; i-- )
        {
            arrayy[i] = arrayy[i-1];
        }
        
        arrayy[index] = u;
        
    }
    
}
