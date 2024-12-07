/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zerosquares;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class State {
    //int size;
    int xx,yy;
    State parent;
    Squares[][] grid;
    int cost;
    int heuristic;
    public static List<Squares> goals=new ArrayList<Squares>(); 
        public State(int xx,int yy){
        this.xx=xx;
        this.yy=yy;
        grid=new Squares[xx][yy];
        init();
       this.parent=null;
       //this.cost=0;
       //this.heuristic=heuristic;
        }
    public void init(){
        for(int i=0;i<xx;i++){
            for(int j=0;j<yy;j++){
                grid[i][j]=new Squares(i,j,' ',".",false);
            }
        }
    }
    public void setSquare(int x,int y,char color,String type,boolean isMoving){
        grid[x][y]=new Squares(x, y, color, type,isMoving);
        if(type.equals("g")){
            goals.add(grid[x][y]);
        }
    }
    public boolean can_possible_actions(int x,int y,int moveX,int moveY){
        while(true){
            x+=moveX;
            y+=moveY;            
            if(x<0||x>=xx||y<0||y>=yy||grid[x][y].type=="#"){
                return false;
            }
             if (grid[x][y].type.equals("g") ) {
            return true;              
        }
            if(grid[x][y].color!=' '){
                return false;
            }
            return true;      
        }
    }
public State move(int moveX, int moveY) {
    State newState = new State(xx,yy);
    for (int i = 0; i < xx; i++) {
        for (int j = 0; j < yy; j++) {
            newState.grid[i][j] = new Squares(i, j, grid[i][j].color, grid[i][j].type, grid[i][j].isMoving);
        }
    }
    for (int i = 0; i < xx; i++) {
        for (int j = 0; j < yy; j++) {
            if (grid[i][j].isMoving) {
                int x = i;
                int y = j;
                while (can_possible_actions(x, y, moveX, moveY)) {
                     newState.setSquare(i, j, ' ', ".", false);
                    x += moveX;
                    y += moveY;
                    Squares moving = grid[i][j];
                    if (grid[x][y].type.equals("g") && moving.color==grid[x][y].color) {
                        newState.setSquare(x, y,' ', ".", false);
                          break;
                    }
                    newState.cost+=1;
                }

                newState.setSquare(x, y, grid[i][j].color, grid[i][j].type, true);
            }
        }
    }
    if (is_final(newState)) {
        //System.out.println("Win ");
    }
    //System.out.println("cost :"+newState.cost);
    return newState;
}


  public boolean is_final(State state) { 
    for (int i = 0; i < state.xx; i++) {
        for (int j = 0; j < state.yy; j++) {
            if (state.grid[i][j].isMoving) {
                Squares movingSquare = state.grid[i][j];
               for (int k = 0; k < goals.size(); k++){ 
                     Squares goal = goals.get(k);
                        if (movingSquare.x == goal.x&&movingSquare.y == goal.y&&movingSquare.color == goal.color)   {
                                movingSquare.isMoving = false;
                                movingSquare.color = ' ';
                                return true;
                                            }
                                        }
                                    }
                                }
                            }
    return false; 
}
  public boolean is_goal(State state){
            for(int i=0;i<state.xx;i++){
                for(int j=0;j<state.yy;j++){
                    if(state.grid[i][j].isMoving){
                        return false;
                    }
                }
            }
            return true;
  }

public static boolean equalsState(State s1,State s2){
       /* if(s1.size!=s2.size){
            return false;
        }*/
        for(int i=0;i<s1.xx;i++){
            for(int j=0;j<s1.yy;j++){
                if(s1.grid[i][j].isMoving!=s2.grid[i][j].isMoving){
                   // System.out.println("include for");
                    return false;
                }
            }
        }
        return true;
    }

    
public List<State> nextState(State s) {
        List<State> possibleStates = new ArrayList<>();
        int[][] moves = {
               {1,0},
                {-1,0},
                {0,-1},
                {0,+1},
        };        
        for (int[] move : moves) {
            int moveX = move[0];
            int moveY = move[1];           
            State newState = s.move(moveX, moveY);            
            if (!equalsState(s,newState)) {
                newState.parent = s;
                //newState.cost=1;
                possibleStates.add(newState);
            }
        }
        return possibleStates;
}

    public static int calculateHeuristic(State s) {
        int heuristic = 0;
        if (isDeadlock(s)) {
            return Integer.MAX_VALUE;
        }

        for (int i = 0; i < s.xx; i++) {
            for (int j = 0; j < s.yy; j++) {
                Squares square = s.grid[i][j];
                if (square.isMoving) {
                    int minDistance = Integer.MAX_VALUE;
                    for (Squares goal : goals) {
                        if (square.color == goal.color) {
                            int distance = Math.abs(square.x - goal.x) + Math.abs(square.y - goal.y);
                            minDistance = Math.min(minDistance, distance);
                        }
                    }
                    heuristic += minDistance;
                }
            }
        }
        //System.out.println("heuristic :"+heuristic);
        return heuristic;
    }
    private static boolean isDeadlock(State s) {
        for (int i = 0; i < s.xx; i++) {
            for (int j = 0; j < s.yy; j++) {
                Squares square = s.grid[i][j];
                if (square.isMoving) {
                    // Check if the square is blocked by walls or other squares
                    if (!canMoveToAnyDirection(s, square)) {
                        return true; // Deadlock detected
                    }
                }
            }
        }
        return false; // No deadlock found
    }
    private static boolean canMoveToAnyDirection(State s, Squares square) {
        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} }; // Down, Up, Right, Left
        for (int[] dir : directions) {
            int newX = square.x + dir[0];
            int newY = square.y + dir[1];
            if (newX >= 0 && newX < s.xx && newY >= 0 && newY < s.yy) {
                if (s.grid[newX][newY].color == ' ' || s.grid[newX][newY].type.equals("g")) {
                    return true; // Can move in this direction
                }
            }
        }
        return false; // No possible moves
    }






    public void print(State state){
        for(int i=0;i<xx;i++){
            for(int j=0;j<yy;j++){
                System.out.print(state.grid[i][j].type+" ");
            }
            System.out.println();
        }
    }
    
    

   
}
