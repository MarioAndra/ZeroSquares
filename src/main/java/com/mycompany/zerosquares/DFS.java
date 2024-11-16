package com.mycompany.zerosquares;

import java.util.*;

public class DFS {
    public List<State> search(State s) {
        Stack<State> stack = new Stack<>();
        List<State> visited = new ArrayList<>();
        stack.push(s);
        //visited.add(s);
        while (!stack.isEmpty()) {
            State currentState = stack.pop();

            boolean exist=false;
            for(State v: visited){
                if(State.equalsState(v,currentState)){
                    exist=true;
                    break;
                }
            }
            if(exist){
                continue;
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
                System.out.println("Path Size :"+path.size());
                System.out.println("End path");
                return path;
            }
            List<State> nextStates = currentState.nextState(currentState);
            for (State nextState : nextStates) {
                boolean isUnique = true;
                for (State visitedState : visited) {
                    if (State.equalsState(visitedState, nextState)) {
                        isUnique = false;
                        break;
                    }
                }
                if (isUnique) {
                    //visited.add(nextState);
                    stack.push(nextState);
                }
            }
        }
        System.out.println("No Path");
        return Collections.emptyList();
    }
}



