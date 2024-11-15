package com.mycompany.zerosquares;

import java.util.*;

public class BFS {
    public List<State> search(State s) {
        Queue<State> queue = new LinkedList<>();
        List<State> visited = new ArrayList<>();
        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            State currentState = queue.poll();
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
                System.out.println("Path Size :"+path.size());
                System.out.println("End path");
                return path;
            }
            List<State> nextStates = currentState.nextState(currentState);
            for (State nextState : nextStates) {
                boolean isUnique = true;
                for (State visitedState : visited) {
                    if (visitedState.equalsState(visitedState, nextState)) {
                        isUnique = false;
                        break;
                    }
                }
                if (isUnique) {
                    visited.add(nextState);
                    queue.add(nextState);
                }
            }
        }
        System.out.println("No Path");
        return Collections.emptyList();
    }
}

