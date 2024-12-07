package com.mycompany.zerosquares;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
public class BFS {
    public List<State> search(State s) {
        Queue<State> queue = new LinkedList<>();
        List<State> visited = new LinkedList<>();

        queue.add(s);
        long startTime = System.currentTimeMillis();
        while (!queue.isEmpty()) {
            System.out.println("visited:"+visited.size());
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
            if (currentState.is_goal(currentState)) {
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                int memoryUsed = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
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
                try (FileWriter writer = new FileWriter("log.txt", true)) {
                    writer.write("BFS"+"\n");
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
                    queue.add(nextState);
                }
            }
        }
        System.out.println("No Path");
        return Collections.emptyList();
    }
}

