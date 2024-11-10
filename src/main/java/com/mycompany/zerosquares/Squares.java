/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zerosquares;

/**
 *
 * @author Mario
 */
public class Squares {
    public int x;
    public int y;
    public String type;
    public char color;
    public boolean isMoving;
    
      Squares(int x, int y, char color,String type,boolean isMoving) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.type=type;
        this.isMoving=isMoving;
    }
      
     
}
