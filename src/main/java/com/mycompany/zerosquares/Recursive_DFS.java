package com.mycompany.zerosquares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recursive_DFS {
  List<State> visited = new ArrayList<>();
    public void search(State s){
        for(State v:visited){
            if(State.equalsState(s,v)){
                return;
            }
        }
        visited.add(s);
        if(s.is_goal(s)){
            System.out.println("goal");
            System.out.println("Visited size: " + visited.size());
            List<State> path = new ArrayList<>();
            State current = s;
            while (current != null) {
                path.add(current);
                current = current.parent;
            }
            Collections.reverse(path);
            System.out.println("PATH");
            for (State state : path) {
                state.print(state);
                System.out.println("////////////////////");
            }
            System.out.println("Path Size :" + path.size());
            System.out.println("End path");
        }
        List<State> nextStates = s.nextState(s);
        for (State nextState : nextStates) {
            boolean isUnique = true;
            for (State visitedState : visited) {
                if (State.equalsState(visitedState, nextState)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                search(nextState);
            }
        }
        System.out.println("NO Path");

    }


}
