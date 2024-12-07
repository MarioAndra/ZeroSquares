/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zerosquares;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Mario
 */
public class Controle {
    State s;
    BFS B=new BFS();
    DFS D= new DFS();
    UCS U=new UCS();
    A_Star A=new A_Star();
    SimpleHillClimbing hill=new SimpleHillClimbing();
    SteepestHillclimbing s_hill=new SteepestHillclimbing();
    Recursive_DFS R_DFS=new Recursive_DFS();
    Scanner scanner = new Scanner(System.in);
    public static List<State> states = new ArrayList<>();
    public Controle(int size) {
       // s = new State(12);
    }
    public void start() {
        System.out.println("Select level");
        System.out.println("1 - Easy");
        System.out.println("2 - Medium");
        System.out.println("3 - Hard");
        int level = scanner.nextInt();
        switch (level) {
            case 1:
                System.out.println("Eeasy mood");
                
                setupEasyLevel(12);
                
                break;
            case 2:
                System.out.println("Medium mood");
               
                setupMediumLevel(9);
                break;
            case 3:
                System.out.println("Hard mood");
                
                setupHardLevel(6,16);
                break;
            default:
                System.out.println("Invalid ");
                 break;
        }
        System.out.println("-------------------");
        System.out.println("Select how to play");
        System.out.println("1-user");
        System.out.println("2-bfs");
        System.out.println("3-dfs");
        System.out.println("4-UCS");
        System.out.println("5-R_DFS");
        System.out.println("6-A*");
        System.out.println("7-SimpleHill");
        System.out.println("8-Hill");
        int select =scanner.nextInt();
        switch (select){
            case 1 :
                playGame();
                break;
            case 2:
                s.print(s);
                System.out.println("///////////");
                B.search(s);
                break;
            case 3:
                s.print(s);
                System.out.println("///////////");
                D.search(s);
                break;
            case 4:
                s.print(s);
                System.out.println("//////////");
                U.search(s);
                break;
            case 5:
                s.print(s);
                System.out.println("//////////");
                R_DFS.search(s);
                break;
            case 6:
                s.print(s);
                System.out.println("//////////");
                A.search(s);
                break;
            case 7:
                s.print(s);
                System.out.println("//////////");
                hill.serach(s);
                break;
            case 8:
                s.print(s);
                System.out.println("//////////");
                s_hill.search(s);
                break;
        }
    }

    public void setupEasyLevel(int size) {

      /*  s.setSquare(0, 0, ' ', "#", false);
        s.setSquare(0, 1, ' ', "#", false);
        s.setSquare(0, 2, ' ', "#", false);
        s.setSquare(0, 3, ' ', "#", false);
        s.setSquare(0, 4, ' ', "#", false);
        s.setSquare(0, 5, ' ', "#", false);
        s.setSquare(0, 6, ' ', "#", false);
        s.setSquare(0, 7, ' ', "#", false);
        s.setSquare(0, 8, ' ', "#", false);
        s.setSquare(0, 9, ' ', "#", false);
        s.setSquare(0, 10, ' ', "#", false);

        s.setSquare(1, 0, ' ', "#", false);
        s.setSquare(1, 1, ' ', "#", false);
        s.setSquare(1, 2, 'R', "R", true); // R بلون أخضر
        //s.setSquare(1, 3, ' ', "#", false);
        //s.setSquare(1, 4, ' ', "#", false);
        s.setSquare(1, 5, ' ', "#", false);
        s.setSquare(1, 6, ' ', "#", false);
        s.setSquare(1, 7, ' ', "#", false);
        s.setSquare(1, 8, ' ', "#", false);
        s.setSquare(1, 9, ' ', "#", false);
        s.setSquare(1, 10, ' ', "#", false);

        s.setSquare(2, 0, ' ', "#", false);
        //s.setSquare(2, 1, ' ', "#", false);
        //s.setSquare(2, 2, ' ', "#", false);
        //s.setSquare(2, 3, ' ', "#", false);
        //s.setSquare(2, 4, ' ', "#", false);
        s.setSquare(2, 5, ' ', "#", false);
        s.setSquare(2, 6, ' ', "#", false);
        s.setSquare(2, 7, 'B', "g", false); // T_B كهدف
        //s.setSquare(2, 8, ' ', "#", false);
        s.setSquare(2, 9, ' ', "#", false);
        s.setSquare(2, 10, ' ', "#", false);

        s.setSquare(3, 0, ' ', "#", false);
        //s.setSquare(3, 1, ' ', "#", false);
        //s.setSquare(3, 2, ' ', "#", false);
        //s.setSquare(3, 3, ' ', "#", false);
        //s.setSquare(3, 4, ' ', "#", false);
        //s.setSquare(3, 5, ' ', "#", false);
        //s.setSquare(3, 6, ' ', "#", false);
        //s.setSquare(3, 7, ' ', "#", false);
        //s.setSquare(3, 8, ' ', "#", false);
        s.setSquare(3, 9, ' ', "#", false);
        s.setSquare(3, 10, ' ', "#", false);

        s.setSquare(4, 0, ' ', "#", false);
        //s.setSquare(4, 1, ' ', "#", false);
        //s.setSquare(4, 2, ' ', "#", false);
        //s.setSquare(4, 3, ' ', "#", false);
        s.setSquare(4, 4, ' ', "#", false);
        s.setSquare(4, 5, ' ', "#", false);
        s.setSquare(4, 6, ' ', "#", false);
        //s.setSquare(4, 7, ' ', " ", false); // حقل فارغ
        //s.setSquare(4, 8, 'R', "R", true); // T_R كهدف
        s.setSquare(4, 9, 'R', "g", false);
        s.setSquare(4, 10, ' ', "#", false);

        s.setSquare(5, 0, ' ', "#", false);
        //s.setSquare(5, 1, ' ', " ", false);
        //s.setSquare(5, 2, ' ', " ", false);
        //s.setSquare(5, 3,' ', " ",false);
        //s.setSquare(5 ,4,' ', " ",false);
        //s.setSquare(5 ,5,' ', " ",false);
        //s.setSquare(5 ,6,' ', " ",false);
        //s.setSquare(5 ,7,' ', " ",false);
        //s.setSquare(5 ,8,' ', " ",false);
        s.setSquare(5 ,9,' ',"#",false);
        s.setSquare(5 ,10,' ',"#",false);

        s.setSquare(6 ,0,' ',"#",false);
        s.setSquare(6 ,1,' ',"#",false);
        s.setSquare(6 ,2,'B',"B",true); // B كهدف
        //s.setSquare(6 ,3,' ', " ",false);
        s.setSquare(6 ,4,' ',"#",false);
        s.setSquare(6 ,5,' ',"#",false);
        s.setSquare(6 ,6,' ',"#",false);
        s.setSquare(6 ,7,' ',"#",false);
        s.setSquare(6 ,8,' ',"#",false);
        s.setSquare(6 ,9,' ',"#",false);
        s.setSquare(6 ,10,' ',"#",false);

        //s.setSquare(7 ,0,' ',"#",false);
        s.setSquare(7 ,1,' ',"#",false);
        s.setSquare(7 ,2,' ',"#",false);
        s.setSquare(7 ,3,' ',"#",false);
        s.setSquare(7 ,4,' ',"#",false);*/
      ///////////////
        s.setSquare(0, 0, ' ', "#", false);
        s.setSquare(0, 1, ' ', "#", false);
        s.setSquare(0, 2, ' ', "#", false);
        s.setSquare(0, 3, ' ', "#", false);
        s.setSquare(0, 4, ' ', "#", false);
        s.setSquare(0, 5, ' ', "#", false);
        s.setSquare(0, 6, ' ', "#", false);
        s.setSquare(0, 7, ' ', "#", false);
        s.setSquare(0, 8, ' ', "#", false);
        s.setSquare(0, 9, ' ', "#", false);
        s.setSquare(0, 10, ' ', "#", false);
        s.setSquare(0, 11, ' ', "#", false);

        s.setSquare(1, 0, ' ', "#", false);
        s.setSquare(1, 1, ' ', "#", false);
        s.setSquare(1, 2, ' ', "#", false);
        s.setSquare(1, 3, ' ', "#", false);
        s.setSquare(1, 4, ' ', "#", false);
        s.setSquare(1, 5, ' ', "#", false);
        s.setSquare(1, 6, ' ', "#", false);
        s.setSquare(1, 7, ' ', "#", false);
        s.setSquare(1, 8, ' ', "#", false);
        s.setSquare(1, 9, ' ', "#", false);
        s.setSquare(1, 10, ' ', "#", false);
        s.setSquare(1, 11, ' ', "#", false);

        s.setSquare(2, 0, ' ', "#", false);
        s.setSquare(2, 1, ' ', "#", false);
        s.setSquare(2, 2, ' ', "#", false);
        s.setSquare(2, 3, ' ', "#", false);
        s.setSquare(2, 4, ' ', "#", false);
        s.setSquare(2, 5, ' ', "#", false);
        s.setSquare(2, 6, ' ', "#", false);
        s.setSquare(2, 7, ' ', "#", false);
        s.setSquare(2, 8, ' ', "#", false);
        s.setSquare(2, 9, ' ', "#", false);
        s.setSquare(2, 10, ' ', "#", false);
        s.setSquare(2, 11, ' ', "#", false);
        s.setSquare(3, 0, ' ', "#", false);
        s.setSquare(3, 1, ' ', "#", false);
        s.setSquare(3, 2, ' ', "#", false);
        s.setSquare(3, 3, ' ', "#", false);
        s.setSquare(3, 4, ' ', "#", false);
        s.setSquare(3, 5, ' ', "#", false);
        s.setSquare(3, 6, ' ', "#", false);
        s.setSquare(3, 7, ' ', "#", false);
        s.setSquare(3, 8, ' ', "#", false);
        s.setSquare(3, 9, ' ', "#", false);
        s.setSquare(3, 10, ' ', "#", false);
        s.setSquare(3, 11, ' ', "#", false);
        //s.setSquare(3, 0, ' ', "#", false);
        s.setSquare(1, 11, ' ', "#", false);
        s.setSquare(2, 11, ' ', "#", false);
        s.setSquare(3, 11, ' ', "#", false);


        s.setSquare(4, 0, ' ', "#", false);
        s.setSquare(4, 1, ' ', "#", false);
        s.setSquare(4, 2, ' ', "#", false);
        s.setSquare(4, 3, ' ', "#", false);
        s.setSquare(4, 4, ' ', "#", false);
        s.setSquare(4, 5, ' ', "#", false);
        s.setSquare(4, 6, ' ', "#", false);
        s.setSquare(4, 7, ' ', "#", false); // حقل فارغ
        s.setSquare(4, 8, ' ', "#", true); // T_R كهدف
        s.setSquare(4, 9, ' ', "#", false);
        s.setSquare(4, 10, ' ', "#", false);
        s.setSquare(4, 11, ' ', "#", false);
        s.setSquare(5, 0, ' ', "#", false);
        s.setSquare(5, 1, ' ', "#", false);
        s.setSquare(5, 2, ' ', "#", false);
        //s.setSquare(5, 3,' ', " ",false);
        //s.setSquare(5 ,4,' ', " ",false);
        //s.setSquare(5 ,5,' ', " ",false);
        //s.setSquare(5 ,6,' ', " ",false);
        //s.setSquare(5 ,7,' ', " ",false);
        //s.setSquare(5 ,8,' ', " ",false);
        //s.setSquare(5 ,9,' ',"#",false);
        s.setSquare(5 ,11,' ',"#",false);

        s.setSquare(6 ,0,' ',"#",false);
        s.setSquare(6 ,1,' ',"#",false);
       // s.setSquare(6 ,2,'B',"B",true); // B كهدف
        //s.setSquare(6 ,3,' ', " ",false);
        s.setSquare(6 ,4,' ',"#",false);
       // s.setSquare(6 ,5,' ',"#",false);
        s.setSquare(6 ,6,'B',"g",false);
        //s.setSquare(6 ,7,' ',"#",false);
        s.setSquare(6 ,8,' ',"#",false);
        //s.setSquare(6 ,9,' ',"#",false);
        s.setSquare(6 ,10,' ',"#",false);
        s.setSquare(6 ,11,' ',"#",false);

        s.setSquare(7 ,0,' ',"#",false);
       // s.setSquare(7 ,1,' ',"#",false);
        //s.setSquare(7 ,2,' ',"#",false);
        s.setSquare(7 ,3,' ',"#",false);
        s.setSquare(7 ,5,'R',"g",false);
        s.setSquare(7 ,8,' ',"#",false);
        s.setSquare(7 ,11,' ',"#",false);
        //s.setSquare(7 ,4,' ',"#",false);

        s.setSquare(8 ,0,' ',"#",false);
        s.setSquare(8 ,5,' ',"#",false);
        s.setSquare(8 ,8,' ',"#",false);
        s.setSquare(8 ,9,' ',"#",false);
        s.setSquare(8 ,11,' ',"#",false);

        s.setSquare(9 ,0,' ',"#",false);
        s.setSquare(9 ,1,'R',"R",true);
        s.setSquare(9 ,2,' ',"#",false);
        s.setSquare(9 ,4,' ',"#",false);
        s.setSquare(9 ,5,' ',"#",false);
        s.setSquare(9 ,9,' ',"#",false);
        s.setSquare(9 ,10,'B',"B",true);
        s.setSquare(9 ,11,' ',"#",false);

        s.setSquare(10 ,0,' ',"#",false);
        s.setSquare(10 ,0,' ',"#",false);
        s.setSquare(10 ,4,' ',"#",false);
        s.setSquare(10 ,11,' ',"#",false);

        s.setSquare(11 ,0,' ',"#",false);
        s.setSquare(11 ,1,' ',"#",false);
        s.setSquare(11 ,2,' ',"#",false);
        s.setSquare(11 ,3,' ',"#",false);
        s.setSquare(11 ,4,' ',"#",false);
        s.setSquare(11 ,5,' ',"#",false);
        s.setSquare(11 ,6,' ',"#",false);
        s.setSquare(11 ,7,' ',"#",false);
        s.setSquare(11 ,8,' ',"#",false);
        s.setSquare(11 ,9,' ',"#",false);
        s.setSquare(11 ,10,' ',"#",false);
        s.setSquare(11 ,11,' ',"#",false);

        states.add(s);
        //State.calculateHeuristic(s);
    }

    public void setupMediumLevel(int size) {
       // s = new State(size);
        /*s.setSquare(0, 0, ' ', "#", false);
        s.setSquare(0, 1, ' ', "#", false);
        s.setSquare(0, 2, ' ', "#", false);
        s.setSquare(0,3, ' ', "#", false);
        s.setSquare(0,4, ' ', "#", false);
        s.setSquare(1, 0, ' ', "#", false);
        s.setSquare(2,0, ' ', "#", false);
        s.setSquare(3,0, ' ', "#", false);
        s.setSquare(4,0, ' ', "#", false);
        s.setSquare(4, 1, ' ', "#", false);
        s.setSquare(4, 2, ' ', "#", false);
        s.setSquare(4, 3, ' ', "#", false);
        s.setSquare(4,4, ' ', "#", false);
        s.setSquare(2,2, ' ', "#", false);
        s.setSquare(3,4, ' ', "#", false);
        s.setSquare(2,4, ' ', "#", false);
        s.setSquare(1,4, ' ', "#", false);
        s.setSquare(3,3, 'R', "R", true);
        s.setSquare(1,2, 'R', "g", false);
        s.setSquare(1,1, 'B', "B", true);
        s.setSquare(3,2, 'B', "g", false);*/

        s.setSquare(0,0, ' ', "#", false);
        s.setSquare(0,1, ' ', "#", false);
        s.setSquare(0,2, ' ', "#", false);
        s.setSquare(0,3, ' ', "#", false);
        s.setSquare(0,4, ' ', "#", false);
        s.setSquare(0,5, ' ', "#", false);
        s.setSquare(0,6, ' ', "#", false);
        s.setSquare(0,7, ' ', "#", false);
        s.setSquare(0,8, ' ', "#", false);

        s.setSquare(1,0, ' ', "#", false);
        s.setSquare(2,0, ' ', "#", false);
        s.setSquare(3,0, ' ', "#", false);
        s.setSquare(4,0, ' ', "#", false);
        s.setSquare(5,0, ' ', "#", false);
        s.setSquare(6,0, ' ', "#", false);
        s.setSquare(7,0, ' ', "#", false);
        s.setSquare(8,0, ' ', "#", false);

        s.setSquare(8,1, ' ', "#", false);
        s.setSquare(8,2, ' ', "#", false);
        s.setSquare(8,3, ' ', "#", false);
        s.setSquare(8,4, ' ', "#", false);
        s.setSquare(8,5, ' ', "#", false);
        s.setSquare(8,6, ' ', "#", false);
        s.setSquare(8,7, ' ', "#", false);
        s.setSquare(8,8, ' ', "#", false);

        s.setSquare(7,8, ' ', "#", false);
        s.setSquare(6,8, ' ', "#", false);
        s.setSquare(5,8, ' ', "#", false);
        s.setSquare(4,8, ' ', "#", false);
        s.setSquare(3,8, ' ', "#", false);
        s.setSquare(2,8, ' ', "#", false);
        s.setSquare(1,8, ' ', "#", false);

        s.setSquare(1,1, ' ', "#", false);
        s.setSquare(1,2, ' ', "#", false);
        s.setSquare(1,3, ' ', "#", false);
        s.setSquare(1,4, ' ', "#", false);
        s.setSquare(1,5, ' ', "#", false);
        s.setSquare(1,6, ' ', "#", false);
        s.setSquare(1,7, ' ', "#", false);
        s.setSquare(1,8, ' ', "#", false);
        s.setSquare(2,1, ' ', "#", false);
        s.setSquare(2,2, ' ', "#", false);
        s.setSquare(2,3, ' ', "#", false);
        s.setSquare(2,4, ' ', "#", false);
        s.setSquare(2,5, ' ', "#", false);
        s.setSquare(2,6, ' ', "#", false);
        s.setSquare(2,7, ' ', "#", false);
        s.setSquare(2,8, ' ', "#", false);
        s.setSquare(3,1, ' ', "#", false);
        s.setSquare(3,2, ' ', "#", false);
        s.setSquare(3,3, ' ', "#", false);
        s.setSquare(3,4, ' ', "#", false);
        s.setSquare(3,5, ' ', "#", false);
        s.setSquare(3,6, ' ', "#", false);
        s.setSquare(3,7, ' ', "#", false);
        s.setSquare(3,8, ' ', "#", false);

        s.setSquare(7,1, 'G', "G", true);
        s.setSquare(7,2, 'P', "g", false);
        s.setSquare(7,3, ' ', "#", false);
        s.setSquare(7,4, 'R', "g", false);
        s.setSquare(7,6, ' ', "#", false);
        s.setSquare(7,7, 'G', "g", false);

        s.setSquare(6,1, 'B', "g", false);
        s.setSquare(6,2, 'P', "P", true);
        s.setSquare(6,3, 'B', "B", true);

        s.setSquare(5,1, ' ', "#", false);
        s.setSquare(5,2, ' ', "#", false);
        s.setSquare(5,3, ' ', "#", false);
        s.setSquare(4,3, ' ', "#", false);
        s.setSquare(4,4, ' ', "#", false);
        s.setSquare(4,5, ' ', "#", false);
        s.setSquare(4,6, ' ', "#", false);
        s.setSquare(5,3, ' ', "#", false);
        s.setSquare(5,4, 'R', "R", true);
        s.setSquare(5,5, 'Y', "g", false);
        s.setSquare(6,7, 'Y', "Y", true);
        s.setSquare(5,6, ' ', "#", false);
        s.setSquare(5,7, ' ', "#", false);





        //s.setSquare(9,0, ' ', "#", false);




        states.add(s);
      // System.out.println("calculateHeuristic:"+State.calculateHeuristic(s)) ;
    }

    public void setupHardLevel(int xx,int yy) {
         s = new State(xx,yy);
        /*s.setSquare(0, 0, ' ', "#", false);
        s.setSquare(0, 1, ' ', "#", false);
        s.setSquare(0, 2, ' ', "#", false);
        s.setSquare(0,3, ' ', "#", false);
        s.setSquare(0,4, ' ', "#", false);
        s.setSquare(0,5, ' ', "#", false);
        s.setSquare(0,6, ' ', "#", false);
      
        
        s.setSquare(1, 0, ' ', "#", false);
        s.setSquare(2,0, ' ', "#", false);
        s.setSquare(3,0, ' ', "#", false);
        s.setSquare(4,0, ' ', "#", false);
        s.setSquare(5,0, ' ', "#", false);
        s.setSquare(6,0, ' ', "#", false);
        
        s.setSquare(6, 1, ' ', "#", false);
        s.setSquare(6, 2, ' ', "#", false);
        s.setSquare(6, 3, ' ', "#", false);
        s.setSquare(6,4, ' ', "#", false);
        s.setSquare(6,5, ' ', "#", false);
        s.setSquare(6,6, ' ', "#", false);
        
        
        s.setSquare(1,6, ' ', "#", false);
        s.setSquare(2,6, ' ', "#", false);
        s.setSquare(3,6, ' ', "#", false);
        s.setSquare(4,6, ' ', "#", false);
        s.setSquare(5,6, ' ', "#", false);
        
        s.setSquare(5,1, ' ', "#", false);
        s.setSquare(4,2, ' ', "#", false);
        s.setSquare(3,4, ' ', "#", false);
        
        s.setSquare(4,1, 'R', "g", false);
        s.setSquare(1,1, 'B', "B", true);
        s.setSquare(4,3, 'R', "R", true);
        
        
        s.setSquare(1,5, 'B', "g", false);*/

        //s.setSquare(0, 0, ' ', "#", false);
        //s.setSquare(0, 1, ' ', "#", false);
        //s.setSquare(0, 2, ' ', "#", false);
        s.setSquare(0, 3, ' ', "#", false);
        s.setSquare(0, 4, ' ', "#", false);
        s.setSquare(0, 5, ' ', "#", false);
        s.setSquare(0, 6, ' ', "#", false);
        s.setSquare(0, 7, ' ', "#", false);
        s.setSquare(0, 8, ' ', "#", false);
        //s.setSquare(0, 9, ' ', "#", false);
        s.setSquare(0, 10, ' ', "#", false);
        s.setSquare(0, 11, ' ', "#", false);
        s.setSquare(0, 12, ' ', "#", false);
        s.setSquare(0, 13, ' ', "#", false);
        s.setSquare(0, 14, ' ', "#", false);
        s.setSquare(0, 15, ' ', "#", false);

        s.setSquare(1, 0, ' ', "#", false);
        s.setSquare(1, 1, ' ', "#", false);
        s.setSquare(1, 2, ' ', "#", false);
        s.setSquare(1, 3, ' ', "#", false);
        s.setSquare(1, 4, ' ', "#", false);
        s.setSquare(1, 7, 'P', "g", false);
        s.setSquare(1, 8, ' ', "#", false);
        s.setSquare(1, 9, ' ', "#", false);
        s.setSquare(1, 10, ' ', "#", false);
        s.setSquare(1, 11, 'Y', "g", false);
        s.setSquare(1, 12, ' ', "#", false);
        s.setSquare(1, 13, ' ', "#", false);
        s.setSquare(1, 14, 'G', "g", false);
        s.setSquare(1, 15, ' ', "#", false);
        s.setSquare(2, 0, ' ', "#", false);
        s.setSquare(2, 1, 'R', "R", true);
        s.setSquare(2, 2, 'B', "B", true);
        s.setSquare(2, 3, 'G', "G", true);
        s.setSquare(2, 6, ' ', "#", false);
        s.setSquare(2, 15, ' ', "#", false);

        s.setSquare(3, 0, ' ', "#", false);
        s.setSquare(3, 1, 'Y', "Y", true);
        s.setSquare(3, 2, 'P', "P", true);
        s.setSquare(3, 12, ' ', "#", false);
        s.setSquare(3, 15, ' ', "#", false);
        s.setSquare(4, 0, ' ', "#", false);
        s.setSquare(4, 0, ' ', "#", false);
        s.setSquare(4, 1, ' ', "#", false);
        s.setSquare(4, 2, ' ', "#", false);
        s.setSquare(4, 3, ' ', "#", false);
        s.setSquare(4, 4, ' ', "#", false);
        s.setSquare(4, 5, 'R', "g", false);
        s.setSquare(4, 6, ' ', "#", false);
        s.setSquare(4, 7, ' ', "#", false);
        s.setSquare(4, 8, 'B', "g", false);
        s.setSquare(4, 9, ' ', "#", false);
        s.setSquare(4, 10, ' ', "#", false);
        s.setSquare(4, 11, ' ', "#", false);
        s.setSquare(4, 12, ' ', "#", false);
        s.setSquare(4, 13, ' ', "#", false);
        s.setSquare(4, 14, ' ', "#", false);
        s.setSquare(4, 15, ' ', "#", false);
        s.setSquare(5, 4, ' ', "#", false);
        s.setSquare(5, 5, ' ', "#", false);
        s.setSquare(5, 6, ' ', "#", false);
        s.setSquare(5, 7, ' ', "#", false);
        s.setSquare(5, 8, ' ', "#", false);
        s.setSquare(5, 9, ' ', "#", false);
        s.setSquare(5, 10, ' ', "#", false);


        /*s.setSquare(2, 0, ' ', "#", false);
        s.setSquare(3, 0, ' ', "#", false);
        s.setSquare(4, 0, ' ', "#", false);
        s.setSquare(5, 0, ' ', "#", false);
        s.setSquare(6, 0, ' ', "#", false);
        s.setSquare(7, 0, ' ', "#", false);
        s.setSquare(8, 0, ' ', "#", false);
        s.setSquare(9, 0, ' ', "#", false);
        s.setSquare(10, 0, ' ', "#", false);
        s.setSquare(11, 0, ' ', "#", false);
        s.setSquare(12, 0, ' ', "#", false);
        s.setSquare(13, 0, ' ', "#", false);
        s.setSquare(14, 0, ' ', "#", false);
        s.setSquare(14, 1, ' ', "#", false);
        s.setSquare(14, 2, ' ', "#", false);
        s.setSquare(14, 3, ' ', "#", false);
        s.setSquare(14, 4, ' ', "#", false);
        s.setSquare(14, 5, 'R', "g", false);
        s.setSquare(14, 6, ' ', "#", false);
        s.setSquare(14, 7, ' ', "#", false);
        s.setSquare(14, 8, 'B', "g", false);
        s.setSquare(14, 9, ' ', "#", false);
        s.setSquare(14, 10, ' ', "#", false);
        s.setSquare(14, 11, ' ', "#", false);
        s.setSquare(14, 12, ' ', "#", false);
        s.setSquare(14, 13, ' ', "#", false);
        s.setSquare(14, 14, ' ', "#", false);

        s.setSquare(13, 12, ' ', "#", false);

        s.setSquare(13, 1, 'Y', "Y", true);
        s.setSquare(13, 2, 'P', "P", true);
        s.setSquare(12, 1, 'R', "R", true);
        s.setSquare(12, 2, 'B', "B", true);
        s.setSquare(12, 3, 'G', "G", true);
        s.setSquare(12, 6, ' ', "#", false);
        s.setSquare(11, 1, ' ', "#", false);
        s.setSquare(11, 2, ' ', "#", false);
        s.setSquare(11, 3, ' ', "#", false);
        s.setSquare(11, 4, ' ', "#", false);

        s.setSquare(11, 7, 'P', "g", false);
        s.setSquare(11, 8, ' ', "#", false);
        s.setSquare(11, 9, ' ', "#", false);
        s.setSquare(11, 10, ' ', "#", false);
        s.setSquare(11, 11, 'Y', "g", false);
        s.setSquare(11, 12, ' ', "#", false);
        s.setSquare(11, 13, ' ', "#", false);
        s.setSquare(11, 14, 'G', "g", false);
        s.setSquare(10, 3, ' ', "#", false);
        s.setSquare(10, 4, ' ', "#", false);
        s.setSquare(10, 5, ' ', "#", false);
        s.setSquare(10, 6, ' ', "#", false);
        s.setSquare(10, 7, ' ', "#", false);
        s.setSquare(10, 8, ' ', "#", false);
        s.setSquare(10, 10, ' ', "#", false);
        s.setSquare(10, 11, ' ', "#", false);
        s.setSquare(10, 12, ' ', "#", false);
        s.setSquare(10, 13, ' ', "#", false);
        s.setSquare(10, 14, ' ', "#", false);



        //s.setSquare(14, 0, ' ', "#", false);

        //s.setSquare(15, 0, ' ', "#", false);

        //s.setSquare(15, 1, ' ', "#", false);
        //s.setSquare(15, 2, ' ', "#", false);
       // s.setSquare(15, 3, ' ', "#", false);
        s.setSquare(15, 4, ' ', "#", false);
        s.setSquare(15, 5, ' ', "#", false);
        s.setSquare(15, 6, ' ', "#", false);
        s.setSquare(15, 7, ' ', "#", false);
        s.setSquare(15, 8, ' ', "#", false);
        s.setSquare(15, 9, ' ', "#", false);
        //s.setSquare(15, 10, ' ', "#", false);
        //s.setSquare(15, 11, ' ', "#", false);
        //s.setSquare(15, 12, ' ', "#", false);
        //s.setSquare(15, 13, ' ', "#", false);
        //s.setSquare(15, 14, ' ', "#", false);
       // s.setSquare(15, 15, ' ', "#", false);

        s.setSquare(14, 15, ' ', "#", false);
        s.setSquare(13, 15, ' ', "#", false);
        s.setSquare(12, 15,' ', "#", false);
        s.setSquare(11, 15, ' ', "#", false);
        s.setSquare(10, 15, ' ', "#", false);
        s.setSquare(9, 15, ' ', "#", false);
        s.setSquare(8, 15, ' ', "#", false);
        s.setSquare(7, 15, ' ', "#", false);
        s.setSquare(6, 15, ' ', "#", false);
        s.setSquare(5, 15, ' ', "#", false);
        s.setSquare(4, 15, ' ', "#", false);
        s.setSquare(3, 15, ' ', "#", false);
        s.setSquare(2, 15, ' ', "#", false);
        s.setSquare(1, 15, ' ', "#", false);

        s.setSquare(1, 1, ' ', "#", false);
        s.setSquare(1, 2, ' ', "#", false);
        s.setSquare(1, 3, ' ', "#", false);
        s.setSquare(1, 4, ' ', "#", false);
        s.setSquare(1, 5, ' ', "#", false);
        s.setSquare(1, 6, ' ', "#", false);
        s.setSquare(1, 7, ' ', "#", false);
        s.setSquare(1, 8, ' ', "#", false);
        s.setSquare(1, 9, ' ', "#", false);
        s.setSquare(1, 10, ' ', "#", false);
        s.setSquare(1, 11, ' ', "#", false);
        s.setSquare(1, 12, ' ', "#", false);
        s.setSquare(1, 13, ' ', "#", false);
        s.setSquare(1, 14, ' ', "#", false);

        s.setSquare(2, 1, ' ', "#", false);
        s.setSquare(2, 2, ' ', "#", false);
        s.setSquare(2, 3, ' ', "#", false);
        s.setSquare(2, 4, ' ', "#", false);
        s.setSquare(2, 5, ' ', "#", false);
        s.setSquare(2, 6, ' ', "#", false);
        s.setSquare(2, 7, ' ', "#", false);
        s.setSquare(2, 8, ' ', "#", false);
        s.setSquare(2, 9, ' ', "#", false);
        s.setSquare(2, 10, ' ', "#", false);
        s.setSquare(2, 11, ' ', "#", false);
        s.setSquare(2, 12, ' ', "#", false);
        s.setSquare(2, 13, ' ', "#", false);
        s.setSquare(2, 14, ' ', "#", false);

        s.setSquare(3, 1, ' ', "#", false);
        s.setSquare(3, 2, ' ', "#", false);
        s.setSquare(3, 3, ' ', "#", false);
        s.setSquare(3, 4, ' ', "#", false);
        s.setSquare(3, 5, ' ', "#", false);
        s.setSquare(3, 6, ' ', "#", false);
        s.setSquare(3, 7, ' ', "#", false);
        s.setSquare(3, 8, ' ', "#", false);
        s.setSquare(3, 9, ' ', "#", false);
        s.setSquare(3, 10, ' ', "#", false);
        s.setSquare(3, 11, ' ', "#", false);
        s.setSquare(3, 12, ' ', "#", false);
        s.setSquare(3, 13, ' ', "#", false);
        s.setSquare(3, 14, ' ', "#", false);

        s.setSquare(4, 1, ' ', "#", false);
        s.setSquare(4, 2, ' ', "#", false);
        s.setSquare(4, 3, ' ', "#", false);
        s.setSquare(4, 4, ' ', "#", false);
        s.setSquare(4, 5, ' ', "#", false);
        s.setSquare(4, 6, ' ', "#", false);
        s.setSquare(4, 7, ' ', "#", false);
        s.setSquare(4, 8, ' ', "#", false);
        s.setSquare(4, 9, ' ', "#", false);
        s.setSquare(4, 10, ' ', "#", false);
        s.setSquare(4, 11, ' ', "#", false);
        s.setSquare(4, 12, ' ', "#", false);
        s.setSquare(4, 13, ' ', "#", false);
        s.setSquare(4, 14, ' ', "#", false);


        s.setSquare(5, 1, ' ', "#", false);
        s.setSquare(5, 2, ' ', "#", false);
        s.setSquare(5, 3, ' ', "#", false);
        s.setSquare(5, 4, ' ', "#", false);
        s.setSquare(5, 5, ' ', "#", false);
        s.setSquare(5, 6, ' ', "#", false);
        s.setSquare(5, 7, ' ', "#", false);
        s.setSquare(5, 8, ' ', "#", false);
        s.setSquare(5, 9, ' ', "#", false);
        s.setSquare(5, 10, ' ', "#", false);
        s.setSquare(5, 11, ' ', "#", false);
        s.setSquare(5, 12, ' ', "#", false);
        s.setSquare(5, 13, ' ', "#", false);
        s.setSquare(5, 14, ' ', "#", false);


        s.setSquare(6, 1, ' ', "#", false);
        s.setSquare(6, 2, ' ', "#", false);
        s.setSquare(6, 3, ' ', "#", false);
        s.setSquare(6, 4, ' ', "#", false);
        s.setSquare(6, 5, ' ', "#", false);
        s.setSquare(6, 6, ' ', "#", false);
        s.setSquare(6, 7, ' ', "#", false);
        s.setSquare(6, 8, ' ', "#", false);
        s.setSquare(6, 9, ' ', "#", false);
        s.setSquare(6, 10, ' ', "#", false);
        s.setSquare(6, 11, ' ', "#", false);
        s.setSquare(6, 12, ' ', "#", false);
        s.setSquare(6, 13, ' ', "#", false);
        s.setSquare(6, 14, ' ', "#", false);

        s.setSquare(7, 1, ' ', "#", false);
        s.setSquare(7, 2, ' ', "#", false);
        s.setSquare(7, 3, ' ', "#", false);
        s.setSquare(7, 4, ' ', "#", false);
        s.setSquare(7, 5, ' ', "#", false);
        s.setSquare(7, 6, ' ', "#", false);
        s.setSquare(7, 7, ' ', "#", false);
        s.setSquare(7, 8, ' ', "#", false);
        s.setSquare(7, 9, ' ', "#", false);
        s.setSquare(7, 10, ' ', "#", false);
        s.setSquare(7, 11, ' ', "#", false);
        s.setSquare(7, 12, ' ', "#", false);
        s.setSquare(7, 13, ' ', "#", false);
        s.setSquare(7, 14, ' ', "#", false);

        s.setSquare(8, 1, ' ', "#", false);
        s.setSquare(8, 2, ' ', "#", false);
        s.setSquare(8, 3, ' ', "#", false);
        s.setSquare(8, 4, ' ', "#", false);
        s.setSquare(8, 5, ' ', "#", false);
        s.setSquare(8, 6, ' ', "#", false);
        s.setSquare(8, 7, ' ', "#", false);
        s.setSquare(8, 8, ' ', "#", false);
        s.setSquare(8, 9, ' ', "#", false);
        s.setSquare(8, 10, ' ', "#", false);
        s.setSquare(8, 11, ' ', "#", false);
        s.setSquare(8, 12, ' ', "#", false);
        s.setSquare(8, 13, ' ', "#", false);
        s.setSquare(8, 14, ' ', "#", false);


        s.setSquare(9, 1, ' ', "#", false);
        s.setSquare(9, 2, ' ', "#", false);
        s.setSquare(9, 3, ' ', "#", false);
        s.setSquare(9, 4, ' ', "#", false);
        s.setSquare(9, 5, ' ', "#", false);
        s.setSquare(9, 6, ' ', "#", false);
        s.setSquare(9, 7, ' ', "#", false);
        s.setSquare(9, 8, ' ', "#", false);
        s.setSquare(9, 9, ' ', "#", false);
        s.setSquare(9, 10, ' ', "#", false);
        s.setSquare(9, 11, ' ', "#", false);
        s.setSquare(9, 12, ' ', "#", false);
        s.setSquare(9, 13, ' ', "#", false);
        s.setSquare(9, 14, ' ', "#", false);*/





        states.add(s);
        //B.search(s);
    }

    private void playGame() {
        while (true) {
            s.print(s);
            System.out.println("Enter the action (w/a/s/d): ");
            String action = scanner.nextLine();

            switch (action) {
                case "w":
                    s = s.move(-1, 0);
                    states.add(s);
                    break;
                case "s":
                    s = s.move(1, 0);
                    states.add(s);
                    break;
                case "a":
                    s = s.move(0, -1);
                    states.add(s);
                    break;
                case "d":
                    s = s.move(0, 1);
                   states.add(s);
                    break;
                case "print":
                    for(int i=0;i<states.size();i++){
                State s1 = states.get(i);
                s1.print(s1);
                        System.out.println();
                        System.out.println();
                    }
                    break;
                case "new":
                    s.nextState(s);
                    break;
            }
             //states.add(s);
        }
    }
}

