package missionariesandcannibals;

/**
 * @author Burakcan Timuçin
 */

public class State {
    
    int m;  // Number of missionaries on the left bank
    int c;  // Number of cannibals on the left bank
    int b;  // 0 for boat on left bank, 1 for boat on the right
    State p;  // predecessor, what state we came from.
    
    // construct the start state (3,3,L)
    State(){ m = 3; c = 3; b = 0; }
    
    State(State s){ m = s.m; c = s.c; b = s.b; }
    
    State(int m, int c, int b){ this.m = m; this.c = c; this.b = b; }
    
    boolean Legal(){
        /* test legality of this */
        if (m < 0 || m > 3 || c < 0 || c > 3) return false;
        if (3-m < 0 || 3-m > 3 || 3-c < 0 || 3-c > 3) return false;
        if (m > 0 && c > m) return false;
        if (3-m >0 && 3-c > 3-m) return false;
        return true;
    }
    
    /** return state resulting from this by moving 
    *   Mis and Can across the river.
    */
    
    State Move(int Mis, int Can)
    { State ans = new State(this);
      if (b == 0) { ans.m = m - Mis; ans.c = c - Can; ans.b = 1; }
      else { ans.m = m + Mis; ans.c = c + Can; ans.b = 0; }
      ans.p = this;
      return ans;
    }
    
    /* display this on the screen */
    void Display() { System.out.println(m + " " + c + " " + (b == 0 ? 'L' : 'R')); }
}
