package com.mycompany.zerosquares;
import java.util.*;
import java.util.stream.StreamSupport;

public class SimpleHillClimbing {
    public List<State> serach(State s){
        State currentState=s;
        List<State> visited = new ArrayList<>();


        while(true){
            visited.add(currentState);
            System.out.println("visited :"+visited.size());
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
            State s1=nextStates.get(0);
            int h1=State.calculateHeuristic(s1);
            if(h1<currentState.heuristic){
                currentState=s1;
            }
            else{
                System.out.println("no");
                break;
            }



        }
        return Collections.emptyList();
    }
}
