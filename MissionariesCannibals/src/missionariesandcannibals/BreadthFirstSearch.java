package missionariesandcannibals;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author BurakcanPc
 */

public class BreadthFirstSearch {

    /*  The purpose of "Visited" variable is to control 
        every situation that the missionary, 
        monster and bot can get.
    */
    
    static boolean[][][] Visited = new boolean[4][4][2];
    
    /* return the minimum "distance" from (3,3,0) to the goal state (0,0,R).
       Here "distance" is the number of river crossings.
       Print out the solution (in reverse order)
    */
    
    static int BreadthFirstSearch()
    {
        Queue<State> q;
        q = new LinkedList<>();
        State start = new State(3, 3, 0);
        q.add(start);
        while (q.peek() != null) {
            State next = q.poll();
            /*
                If it's required, can be used
                System.out.print("Dequeing "); p.Display();
            */
            
            // BFS always finds the shortest solution first
            if(next.m == 0 && next.c == 0 && next.b == 1) {
               State d;
               int count = 0;
               for(d = next; d != null; d = d.p) { 
                   d.Display(); ++count; 
               }
               return count - 1;
            }
            
            // Generate neighbors and enqueue nonvisited neighbors
            for(int i=0; i<=2; i++) {
               for(int j=0; i+j<=2; j++) {
                   if(i == 0 && j == 0) continue; // Someone has to row
                   State p = next.Move(i, j);
                   if(!p.Legal()) continue;
                   if(Visited[p.m][p.c][p.b]) continue;
                   Visited[p.m][p.c][p.b] = true;
                   /*
                       If it's required, can be used
                       System.out.print("Enqueing "); p.Display();
                   */
                   q.add(p);
               } 
            }
       }
       // We would get here if there were no solution,
       // but we know that there is a solution.
       System.out.println("There is an error being fault");
       return -1; // Can't get here
    } // End BFS
    
    public static void main(String[] args) {
        int ans = BreadthFirstSearch();
        System.out.println("It required " + ans + " boat trips");
    }
}
