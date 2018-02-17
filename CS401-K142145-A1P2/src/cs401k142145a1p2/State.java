
package cs401k142145a1p2;

/**
 *
 * @author hammadkhan
 */



public class State {
    
    private final  int x ; //x-cordinate
    private final int y ; //y-cordinate
    
    public State( int a , int b )
    {
        this.x = a ;
        this.y = b ;
    }
    
    public int getState_X ()
    {
        return x;
    }
    
    public int getState_Y ()
    {
        return y;
    }
    
    public void printState ()
    {
        System.out.println(x + "  " + y);
    }
    
    public boolean checkState ( State s )
    {
        return ( s.getState_X() == x && s.getState_Y() == y ) ;
    }
}
