
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;


// Feedback: 
//  Everything looks good! You could probably drop that import on line 5 as it may add a little bit of weight to your memory load
//  but otherwise everything looks good. Your code is reasonably tidy and I would say that I wouldn't have any problem contributing
//  to it. it could be useful to implement a more strict tabbing practice to increase readabiliyt to avoid situations like on 
//  line 116-118 or 132-134 where it may be difficult to immediatly understand the layering of the method and could lead to difficulty
//  when trying to contribute and layer further in those methods.


public class Cube {

	public static void main(String[] args){

     String[][] cube ={{"o","o","o", // String[][] is a two dimensional array
                        "o","o","o",
                        "o","o","o"},//Top 0
                       {"r","r","r",
                        "r","r","r",
                        "r","r","r"},//Bottom 1
                       {"b","b","b",
                        "b","b","b", 
                        "b","b","b"},//Right 2
                       {"g","g","g",
                        "g","g","g",
                        "g","g","g"},//Left 3
                       {"w","w","w",
                        "w","w","w",
                        "w","w","w"},//front 4
                       {"y","y","y",
                        "y","y","y",
                        "y","y","y"}};//back 5

                          
    Scanner in = new Scanner(System.in);//user input

    System.out.println("Welcome to the rubix cube, enter one of the different moves to start scrambling.");

    ArrayList<String> list = new ArrayList<>();

    int i = 1;
    while(i > 0){

      System.out.println("List of different moves: U, UPrime, D, DPrime, R, RPrime, L, LPrime, F, FPrime, B, BPrime");
      String input = in.next();
      if(input.equals("U")){
        cube = moveU(cube);
        list.add("UPrime");
      }
      else if(input.equals("UPrime")){
        cube = moveUPrime(cube);
        list.add("U");
      }
      else if(input.equals("D")){
        cube = moveD(cube);
        list.add("DPrime");
      }
      else if(input.equals("DPrime")){
        cube = moveDPrime(cube);
        list.add("D");
      }  
      else if(input.equals("R")){
        cube = moveR(cube);
        list.add("RPrimse");
      }
      else if(input.equals("RPrime")){
        cube = moveRPrime(cube);
        list.add("R");
      }
      else if(input.equals("L")){
        cube = moveL(cube);
        list.add("LPrime");
      }
      else if(input.equals("LPrime")){
        cube = moveLPrime(cube);
        list.add("L");
      }
      else if(input.equals("F")){
        cube = moveF(cube);
        list.add("FPrimse");
      }
      else if(input.equals("FPrime")){
        cube = moveFPrime(cube);
        list.add("F");
      }
      else if(input.equals("B")){
        cube = moveB(cube);
        list.add("BPrime");
      }
      else if(input.equals("BPrime")){
        cube = moveBPrime(cube);
        list.add("B");
      }
      else if(input.equals("Quit"))
        break;

      else 
      System.out.println("That is not a valid input, Try again." );

      print(cube);

    }
  
    int j = list.size()-1;

    System.out.println("To get the cube back to its origin make these moves" );

    while(j >= 0){
      System.out.println(list.get(j));
      j--;
    }

  }


  public static void print(String[][] array){
    for(int i = 0; i < array.length; i++){
      for(int j = 0; j < array[i].length; j+=3){
        System.out.print(array[i][j] +" | " + array[i][j+1] + " | " + array[i][j+2]);
        System.out.println();
      }
  
      System.out.println();
  
    
  
    }
      
  }

  public static String[][] moveU(String[][] array){
      //Get a copy to switch around
      String[][] copy = new String[6][9];

      for (int i = 0; i < copy.length; i++) {
        for (int j = 0; j < copy[i].length; j++) {
          copy[i][j] = array[i][j];
        }
      }

      //moveU top of cube clockwise
      //middle does not change
      array[0][0] = copy[0][6];
      array[0][1] = copy[0][3];
      array[0][2] = copy[0][0];
      array[0][3] = copy[0][7];
      array[0][5] = copy[0][1];
      array[0][6] = copy[0][8];
      array[0][7] = copy[0][5];
      array[0][8] = copy[0][2];

      //right side of cube, not what is moving but what is replacing it.
      //getting values from the back
      array[2][0] = copy[5][8];
      array[2][1] = copy[5][7];
      array[2][2] = copy[5][6];
      
      //left side of cube
      //gets values from front
      array[3][0] = copy[4][0];
      array[3][1] = copy[4][1];
      array[3][2] = copy[4][2];

      //back side
      //gets values from left
      array[5][8] = copy[3][0];
      array[5][7] = copy[3][1];
      array[5][6] = copy[3][2];

      //front side
      //gets values from the right
      array[4][0] = copy[2][0];
      array[4][1] = copy[2][1];
      array[4][2] = copy[2][2];

      return array;

    }

  public static String[][] moveUPrime(String[][] array){
      //Get a copy to switch around
      String[][] copy = new String[6][9];

      for (int i = 0; i < copy.length; i++) {
        for (int j = 0; j < copy[i].length; j++) {
          copy[i][j] = array[i][j];
        }
      }

      //moveU top of cube clockwise
      //middle does not change
      array[0][0] = copy[0][2];
      array[0][1] = copy[0][5];
      array[0][2] = copy[0][8];
      array[0][3] = copy[0][1];
      array[0][5] = copy[0][7];
      array[0][6] = copy[0][0];
      array[0][7] = copy[0][3];
      array[0][8] = copy[0][6];

      //right side of cube, not what is moving but what is replacing it.
      //getting values from the front
      array[2][0] = copy[4][0];
      array[2][1] = copy[4][1];
      array[2][2] = copy[4][2];
      
      //left side of cube
      //gets values from back
      array[3][0] = copy[5][8];
      array[3][1] = copy[5][7];
      array[3][2] = copy[5][6];

      //back side
      //gets values from right
      array[5][8] = copy[2][0];
      array[5][7] = copy[2][1];
      array[5][6] = copy[2][2];

      //front side
      //gets values from the left
      array[4][0] = copy[3][0];
      array[4][1] = copy[3][1];
      array[4][2] = copy[3][2];

      return array;
  }

  public static String[][] moveD(String[][] array){
    //Get a copy to switch around
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = array[i][j];
      }
    }

    //moveD bottom of cube clockwise
    //middle does not change
    array[1][0] = copy[1][2];
    array[1][1] = copy[1][5];
    array[1][2] = copy[1][8];
    array[1][3] = copy[1][1];
    array[1][5] = copy[1][7];
    array[1][6] = copy[1][0];
    array[1][7] = copy[1][3];
    array[1][8] = copy[1][6];

    //right side of cube, not what is moving but what is replacing it.
    //getting values from the back
    array[2][6] = copy[5][2];
    array[2][7] = copy[5][1];
    array[2][8] = copy[5][0];
    
    //left side of cube
    //gets values from front
    array[3][6] = copy[4][6];
    array[3][7] = copy[4][7];
    array[3][8] = copy[4][8];

    //back side
    //gets values from left
    array[5][2] = copy[3][6];
    array[5][1] = copy[3][7];
    array[5][0] = copy[3][8];

    //front side
    //gets values from the right
    array[4][6] = copy[2][6];
    array[4][7] = copy[2][7];
    array[4][8] = copy[2][8];

    return array;
  }

  public static String[][] moveDPrime(String[][] array){
    //Get a copy to switch around
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = array[i][j];
      }
    }

    //moveU top of cube clockwise
    //middle does not change
    array[1][0] = copy[1][6];
    array[1][1] = copy[1][3];
    array[1][2] = copy[1][0];
    array[1][3] = copy[1][7];
    array[1][5] = copy[1][1];
    array[1][6] = copy[1][8];
    array[1][7] = copy[1][5];
    array[1][8] = copy[1][2];

    //right side of cube, not what is moving but what is replacing it.
    //getting values from the front
    array[2][6] = copy[4][6];
    array[2][7] = copy[4][7];
    array[2][8] = copy[4][8];
    
    //left side of cube
    //gets values from back
    array[3][6] = copy[5][2];
    array[3][7] = copy[5][1];
    array[3][8] = copy[5][0];

    //back side
    //gets values from right
    array[5][2] = copy[2][6];
    array[5][1] = copy[2][7];
    array[5][0] = copy[2][8];

    //front side
    //gets values from the left
    array[4][6] = copy[3][6];
    array[4][7] = copy[3][7];
    array[4][8] = copy[3][8];

    return array;
  }

  public static String[][] moveR(String[][] array){
    //Get a copy to switch around
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = array[i][j];
      }
    }

    //moveU right side of cube clockwise
    //middle does not change
    array[2][0] = copy[2][6];
    array[2][1] = copy[2][3];
    array[2][2] = copy[2][0];
    array[2][3] = copy[2][7];
    array[2][5] = copy[2][1];
    array[2][6] = copy[2][8];
    array[2][7] = copy[2][5];
    array[2][8] = copy[2][2];

    //top(orange) side of cube, not what is moving but what is replacing it.
    //getting values from the front white side
    array[0][2] = copy[4][2];
    array[0][5] = copy[4][5];
    array[0][8] = copy[4][8];
    
    //left(white) side of cube 
    //gets values from front red side(bottom)
    array[4][2] = copy[1][2];
    array[4][5] = copy[1][5];
    array[4][8] = copy[1][8];

    //back side
    //gets values from top(orange)
    array[5][8] = copy[0][2];
    array[5][5] = copy[0][5];
    array[5][2] = copy[0][8];

    //front bottom
    //gets values from the back
    array[1][2] = copy[5][2];
    array[1][5] = copy[5][5];
    array[1][8] = copy[5][8];

    return array;
  }
 
  public static String[][] moveRPrime(String[][] array){
    //Get a copy to switch around
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = array[i][j];
      }
    }

    //move right side of cube counter clockwise
    //middle does not change
    array[2][0] = copy[2][2];
    array[2][1] = copy[2][5];
    array[2][2] = copy[2][8];
    array[2][3] = copy[2][1];
    array[2][5] = copy[2][7];
    array[2][6] = copy[2][0];
    array[2][7] = copy[2][3];
    array[2][8] = copy[2][6];

    //top side of cube, not what is moving but what is replacing it.
    //getting values from the back
    array[0][2] = copy[5][2];
    array[0][5] = copy[5][5];
    array[0][8] = copy[5][8];
    
    //front side of cube
    //gets values from top
    array[4][2] = copy[0][2];
    array[4][5] = copy[0][5];
    array[4][8] = copy[0][8];

    //bottom
    //gets values from front
    array[1][2] = copy[4][2];
    array[1][5] = copy[4][5];
    array[1][8] = copy[4][8];

    //back side 
    //gets values from the bottom
    array[5][2] = copy[1][2];
    array[5][5] = copy[1][5];
    array[5][8] = copy[1][8];

    return array;
  }

  public static String[][] moveL(String[][] array){
    //Get a copy to switch around
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = array[i][j];
      }
    }

    //moveU top of cube clockwise
    //middle does not change
    array[3][0] = copy[3][6];
    array[3][1] = copy[3][3];
    array[3][2] = copy[3][0];
    array[3][3] = copy[3][7];
    array[3][5] = copy[3][1];
    array[3][6] = copy[3][8];
    array[3][7] = copy[3][5];
    array[3][8] = copy[3][2];

    //top of cube, not what is moving but what is replacing it.
    //getting values from the back
    array[0][0] = copy[5][0];
    array[0][3] = copy[5][3];
    array[0][6] = copy[5][6];
    
    //front side of cube
    //gets values from top
    array[4][0] = copy[0][0];
    array[4][3] = copy[0][3];
    array[4][6] = copy[0][6];

    //bottom side
    //gets values from fron
    array[1][0] = copy[4][0];
    array[1][3] = copy[4][3];
    array[1][6] = copy[4][6];

    //back side
    //gets values from the bottom
    array[5][0] = copy[1][0];
    array[5][3] = copy[1][3];
    array[5][6] = copy[1][6];

    return array;
  }

  public static String[][] moveLPrime(String[][] array){
    //Get a copy to switch around
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = array[i][j];
      }
    }

    //moveU top of cube clockwise
    //middle does not change
    array[3][0] = copy[3][2];
    array[3][1] = copy[3][5];
    array[3][2] = copy[3][8];
    array[3][3] = copy[3][1];
    array[3][5] = copy[3][7];
    array[3][6] = copy[3][0];
    array[3][7] = copy[3][3];
    array[3][8] = copy[3][6];

    //top side of cube, not what is moving but what is replacing it.
    //getting values from the front
    array[0][0] = copy[4][0];
    array[0][3] = copy[4][3];
    array[0][6] = copy[4][6];
    
    //front side of cube
    //gets values from bottom
    array[4][0] = copy[1][0];
    array[4][3] = copy[1][3];
    array[4][6] = copy[1][6];

    //bottom side
    //gets values from back
    array[1][0] = copy[5][0];
    array[1][3] = copy[5][3];
    array[1][6] = copy[5][6];

    //back side
    //gets values from the top
    array[5][0] = copy[0][0];
    array[5][3] = copy[0][3];
    array[5][6] = copy[0][6];

    return array;
  }

  public static String[][] moveF(String[][] array){
    //Get a copy to switch around
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = array[i][j];
      }
    }

    //moveU top of cube clockwise
    //middle does not change
    array[4][0] = copy[4][6];
    array[4][1] = copy[4][3];
    array[4][2] = copy[4][0];
    array[4][3] = copy[4][7];
    array[4][5] = copy[4][1];
    array[4][6] = copy[4][8];
    array[4][7] = copy[4][5];
    array[4][8] = copy[4][2];

    //top side of cube, not what is moving but what is replacing it.
    //getting values from the left side
    array[0][6] = copy[3][8];
    array[0][7] = copy[3][5];
    array[0][8] = copy[3][2];
    
    //left side of cube
    //gets values from bottom
    array[3][2] = copy[1][0];
    array[3][5] = copy[1][1];
    array[3][8] = copy[1][2];

    //bottom side
    //gets values from right
    array[1][0] = copy[2][6];
    array[1][1] = copy[2][3];
    array[1][2] = copy[2][0];

    //front right
    //gets values from the top
    array[2][6] = copy[0][8];
    array[2][3] = copy[0][7];
    array[2][0] = copy[0][6];

    return array;
  }

  public static String[][] moveFPrime(String[][] array){
    //Get a copy to switch around
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = array[i][j];
      }
    }

    //moveFprime top of cube clockwise
    //middle does not change
    array[4][0] = copy[4][2];
    array[4][1] = copy[4][5];
    array[4][2] = copy[4][8];
    array[4][3] = copy[4][1];
    array[4][5] = copy[4][7];
    array[4][6] = copy[4][0];
    array[4][7] = copy[4][3];
    array[4][8] = copy[4][6];

    //top side of cube, not what is moving but what is replacing it.
    //getting values from the right
    array[0][6] = copy[2][0];
    array[0][7] = copy[2][3];
    array[0][8] = copy[2][6];
    
    //right side of cube
    //gets values from bottom
    array[2][0] = copy[1][2];
    array[2][3] = copy[1][1];
    array[2][6] = copy[1][0];

    //bottom side
    //gets values from left
    array[1][2] = copy[3][8];
    array[1][1] = copy[3][6];
    array[1][0] = copy[3][2];

    //left side
    //gets values from the top
    array[3][8] = copy[0][6];
    array[3][5] = copy[0][7];
    array[3][2] = copy[0][8];

    return array;
  }

  public static String[][] moveB(String[][] array){
    //Get a copy to switch around
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = array[i][j];
      }
    }

    //moveB back of cube clockwise
    //middle does not change
    array[5][0] = copy[5][6];
    array[5][1] = copy[5][3];
    array[5][2] = copy[5][0];
    array[5][3] = copy[5][7];
    array[5][5] = copy[5][1];
    array[5][6] = copy[5][8];
    array[5][7] = copy[5][5];
    array[5][8] = copy[5][2];

    //top side of cube, not what is moving but what is replacing it.
    //getting values from the right side
    array[0][0] = copy[2][2];
    array[0][1] = copy[2][5];
    array[0][2] = copy[2][8];
    
    //right side of cube
    //gets values from bottom
    array[2][2] = copy[1][6];
    array[2][5] = copy[1][7];
    array[2][8] = copy[1][8];

    //bottom side
    //gets values from left
    array[1][6] = copy[3][0];
    array[1][7] = copy[3][3];
    array[1][8] = copy[3][6];

    //left side
    //gets values from the top
    array[3][0] = copy[0][2];
    array[3][3] = copy[0][1];
    array[3][6] = copy[0][0];

    return array;
  }

  public static String[][] moveBPrime(String[][] array){
    //Get a copy to switch around
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = array[i][j];
      }
    }

    //moveU top of cube clockwise
    //middle does not change
    array[5][0] = copy[5][2];
    array[5][1] = copy[5][5];
    array[5][2] = copy[5][8];
    array[5][3] = copy[5][1];
    array[5][5] = copy[5][7];
    array[5][6] = copy[5][0];
    array[5][7] = copy[5][3];
    array[5][8] = copy[5][6];

    //top side of cube, not what is moving but what is replacing it.
    //getting values from the left
    array[0][0] = copy[3][6];
    array[0][1] = copy[3][3];
    array[0][2] = copy[3][0];
    
    //left side of cube
    //gets values from bottom
    array[3][0] = copy[1][6];
    array[3][3] = copy[1][7];
    array[3][6] = copy[1][8];

    //bottom side
    //gets values from right
    array[1][6] = copy[2][8];
    array[1][7] = copy[2][5];
    array[1][8] = copy[2][2];

    //right side
    //gets values from the top
    array[2][8] = copy[0][2];
    array[2][5] = copy[0][1];
    array[2][2] = copy[0][0];

    return array;
  }

}