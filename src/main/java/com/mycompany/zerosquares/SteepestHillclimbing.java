package com.mycompany.zerosquares;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
public class SteepestHillclimbing {
    public List<State> search(State s) {
        State currentState = s;
        List<State> visited = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        while (true) {
            visited.add(currentState);
            System.out.println("visited size :" + visited.size());
            if (currentState.is_goal(currentState)) {
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                int memoryUsed = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
                System.out.println("visited list");
                for (State v : visited) {
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
                int cost = 0;
                for (State state : path) {
                    state.print(state);
                    //cost += state.cost;
                    //System.out.println("cost :" + state.cost);
                    System.out.println("////////////////////");
                }
                System.out.println("Path Size :" + path.size());
                System.out.println("End path");
                try (FileWriter writer = new FileWriter("log.txt", true)) {
                    writer.write("Steepest_Hill_Climbing"+"\n");
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
            State bestState = null;
            int bestH = Integer.MAX_VALUE;
            for (State nextState : nextStates) {
                boolean isUnique = true;
                for (State visitedState : visited) {
                    if (State.equalsState(visitedState, nextState)) {
                        isUnique = false;
                        break;
                    }
                }

                if (isUnique) {
                    int heuristic = State.calculateHeuristic(nextState);
                    if (heuristic < bestH) {
                        bestH = heuristic;
                        bestState = nextState;
                    }
                }
            }
            if (bestState == null || bestH >= currentState.heuristic) {
                return Collections.emptyList();
            }
            currentState = bestState;
            currentState.heuristic = bestH;
        }
    }
    }