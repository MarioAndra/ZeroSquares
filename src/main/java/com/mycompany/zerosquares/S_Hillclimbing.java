package com.mycompany.zerosquares;
import java.util.*;
public class S_Hillclimbing {
    public List<State> serach(State s){
        State currentState=s;
        List<State> visited = new ArrayList<>();


        while(true){
            visited.add(currentState);
            System.out.println("visited size :"+visited.size());
            if(currentState.is_goal(currentState)){
                System.out.println("visited list");
                for(State v: visited){
                    v.print(v);
                    System.out.println("/////");

                }
                System.out.println("end visited");
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
                int cost=0;
                for (State state : path) {
                    state.print(state);
                    cost+=state.cost;
                    System.out.println("cost :"+state.cost);
                    System.out.println("////////////////////");
                }
                System.out.println("Path Size :"+path.size());
                System.out.println("End path");
                return path;
            }
            List<State> nextStates = currentState.nextState(currentState);
            State bestState=null;
            int bestH= Integer.MAX_VALUE;
            for(State nextState : nextStates){
                boolean isUnique = true;
                for (State visitedState : visited) {
                    if (State.equalsState(visitedState, nextState)) {
                        isUnique = false;
                        break;
                    }
                }
                if (isUnique) {
                    visited.add(nextState);
                    int heuristic = State.calculateHeuristic(nextState);
                    if(heuristic<bestH){
                        //visited.add(nextState);
                        //System.out.println("visited :"+visited.size());
                        bestH=heuristic;
                        bestState=nextState;


                    }
                    if(heuristic>= currentState.heuristic){
                        return Collections.emptyList();
                    }


                }

                }

            currentState=bestState;
            currentState.heuristic=bestH;

        }

        //return Collections.emptyList();
    }
    }
