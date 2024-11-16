/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zerosquares;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario
 *///
public class State {
    int size;
    State parent;
    Squares[][] grid;
    public static List<Squares> goals=new ArrayList<Squares>(); 
        public State(int size){
        this.size=size;
        grid=new Squares[size][size];
        init();
       this.parent=null;
        }
    
    public void init(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
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
            if(x<0||x>=size||y<0||y>=size||grid[x][y].type=="#"){
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
    State newState = new State(size);
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            newState.grid[i][j] = new Squares(i, j, grid[i][j].color, grid[i][j].type, grid[i][j].isMoving);
        }
    }
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
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
                }                
                newState.setSquare(x, y, grid[i][j].color, grid[i][j].type, true);
            }
        }
    }
    if (is_final(newState)) {
        System.out.println("Win ");
    }
    return newState;
}
  public boolean is_final(State state) { 
    for (int i = 0; i < state.size; i++) {
        for (int j = 0; j < state.size; j++) {
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
            for(int i=0;i<state.size;i++){
                for(int j=0;j<state.size;j++){
                    if(state.grid[i][j].isMoving){
                        return false;
                    }
                }
            }
            return true;
  }

public static boolean equalsState(State s1,State s2){
        if(s1.size!=s2.size){
            return false;
        }
        for(int i=0;i<s1.size;i++){
            for(int j=0;j<s1.size;j++){
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
            {0, 1},
            {0,-1},
            {-1,0},
            {1, 0}
        };        
        for (int[] move : moves) {
            int moveX = move[0];
            int moveY = move[1];           
            State newState = s.move(moveX, moveY);            
            if (!equalsState(s,newState)) {
                newState.parent = s;
                possibleStates.add(newState);
            }
        }
        /*for(int i=0;i<possibleStates.size();i++){
            State s1=possibleStates.get(i);
            s1.print(s1);
            System.out.println(" ");
        }*/

        return possibleStates;
}


    
    
    
    public void print(State state){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(state.grid[i][j].type+" ");
            }
            System.out.println();
        }
    }
    
    

   
}
