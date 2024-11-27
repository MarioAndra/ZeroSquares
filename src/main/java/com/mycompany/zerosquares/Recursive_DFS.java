package com.mycompany.zerosquares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recursive_DFS {
    public List<State> search(State s) {
        List<State> visited = new ArrayList<>();
        return R_dfs(s, visited);
    }

    private List<State> R_dfs(State currentState, List<State> visited) {
        for (State v : visited) {
            if (State.equalsState(v, currentState)) {
                return Collections.emptyList();
            }
        }
        visited.add(currentState);
        if (currentState.is_goal(currentState)) {
            System.out.println("goal");
            System.out.println("Visited size: " + visited.size());
            List<State> path = new ArrayList<>();
            State current = currentState;
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
            return path;
        }
        List<State> nextStates = currentState.nextState(currentState);
        for (State nextState : nextStates) {
            R_dfs(nextState, visited);
        }

        return Collections.emptyList();
    }
}
