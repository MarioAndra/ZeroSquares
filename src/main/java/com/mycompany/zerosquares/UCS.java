package com.mycompany.zerosquares;

import java.util.*;

public class UCS {
    public List<State>  search(State s){
        PriorityQueue<State> queue = new PriorityQueue<>(new Comparator<State>);
        List<State> visited = new ArrayList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            State currentState = queue.poll();
            visited.add(currentState);
            if(currentState.is_goal(currentState)){
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
                    int cost=nextState.cost+ currentState.cost;
                    queue.add(nextState);

                }
            }
        }


        }

    }




}
