package com.mycompany.zerosquares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Recursive_DFS {
    List<State> visited = new ArrayList<>();
    public void search(State s) {
        for (State v : visited) {
            if (State.equalsState(s, v)) {
                return;
            }
        }
        long startTime = System.nanoTime();
        visited.add(s);
        if (s.is_goal(s)) {
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            int memoryUsed = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            System.out.println("Goal found!");
            System.out.println("Visited size: " + visited.size());

            List<State> path = new ArrayList<>();
            State current = s;
            while (current != null) {
                path.add(current);
                current = current.parent;
            }
            Collections.reverse(path);
            System.out.println("PATH:");
            for (State state : path) {
                state.print(state);
                System.out.println("////////////////////");
            }
            System.out.println("Path Size: " + path.size());
            System.out.println("End path");
            try (FileWriter writer = new FileWriter("log.txt", true)) {
                writer.write("Recursive_DFS\n");
                writer.write("Visited size: " + visited.size() + "\n");
                writer.write("Path size: " + path.size() + "\n");
                writer.write("Execution Time: " + executionTime + " ms\n");
                writer.write("memoryUsed: " + memoryUsed + " bytes\n");
                writer.write("---------------------------\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        List<State> nextStates = s.nextState(s);
        for (State nextState : nextStates) {
            boolean isUnique = true;
            for (State visitedState : visited) {
                if (State.equalsState(visitedState, nextState)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                search(nextState);
            }
        }
        //System.out.println("NO Path found");
    }
}
