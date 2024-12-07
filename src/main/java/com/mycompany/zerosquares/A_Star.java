package com.mycompany.zerosquares;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class A_Star {
    public List<State> search(State s){
        PriorityQueue<State> queue = new PriorityQueue<>(1000000,new Comparator<State>(){
            @Override
            public int compare(State s1, State s2) {
                return Integer.compare((s1.cost+s1.heuristic), (s2.cost+s2.heuristic));
            }
        });
        List<State> visited = new ArrayList<>(1000000);
        queue.add(s);
        long startTime = System.currentTimeMillis();
        while(!queue.isEmpty()){
            State currentState = queue.poll();
            System.out.println("Visited size: " + visited.size());
            boolean exist=false;
            /*for(State v: visited){
                if(State.equalsState(v,currentState)){
                    exist=true;
                    break;
                }
            }
            if(exist){
                continue;
            }*/
            visited.add(currentState);
            if(currentState.is_goal(currentState)){
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                int memoryUsed = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
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
                    System.out.println("////////////////////");
                }
                System.out.println("Path Size :"+path.size());
                System.out.println("End path");
                try (FileWriter writer = new FileWriter("log.txt", true)) {
                    writer.write("A_Star"+"\n");
                    writer.write("visited size: " +visited.size() + "\n");
                    writer.write("path size: " + path.size() + "\n");
                    writer.write("Execution Time: " + executionTime + " ms\n");
                    writer.write("memoryUsed: " + memoryUsed+ " byte"+"\n");
                    writer.write("---------------------------\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                    nextState.cost+=currentState.cost;
                    nextState.heuristic = State.calculateHeuristic(nextState);
                    queue.add(nextState);
                }
            }
        }
        System.out.println("No Path");
        return Collections.emptyList();
    }
}
