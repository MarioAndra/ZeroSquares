package com.mycompany.zerosquares;

import java.util.*;

public class UCS {
    public List<State>  search(State s){
        PriorityQueue<State> queue = new PriorityQueue<>(new Comparator<State>(){
            @Override
            public int compare(State s1, State s2) {
                return Integer.compare(s1.cost, s2.cost);
            }
        });
        List<State> visited = new ArrayList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            State currentState = queue.poll();
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
           // visited.add(currentState);
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
                System.out.println("COST : "+cost);
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
                    //nextState.cost=0;
                    nextState.cost+=currentState.cost;
                    queue.add(nextState);

                }
            }
        }

        System.out.println("No Path");
        return Collections.emptyList();


        }

    }

