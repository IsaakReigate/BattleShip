package battleship;

import java.util.Scanner;

public class BattleShip {
    
    static Scanner scan = new Scanner(System.in);
    static int turn = 0;
    static int winCount = 24;
    
    public static void intro(){
        System.out.println("There lies 7 ships on a 10x10 grid.\n");
        System.out.println("They are \n2 ships 2 long\n2 ships 3 long\n2 ships 4 long\n1 ship 6 long.\n");
        System.out.println("You will have unlimited guesses to hit all of these ships, and therefore sink them");
        System.out.println("Try to sink all the ships in the least amount of moves.");
    }
    
    public static void main(String[] args) {
        
        
        //I Initially put grid and game into their own methods, but struggled to use grid when testing each coordinate so I just put it under the main.
        int[][] grid = new int[10][10];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j]=0;
                grid[0][0]=1;
                grid[0][1]=1;
                grid[0][7]=1;
                grid[1][7]=1;
                grid[2][1]=1;
                grid[2][2]=1;
                grid[2][3]=1;
                grid[2][4]=1;
                grid[2][7]=1;
                grid[3][7]=1;
                grid[4][3]=1;
                grid[4][7]=1;
                grid[5][3]=1;
                grid[5][7]=1;
                grid[5][9]=1;
                grid[6][3]=1;
                grid[6][9]=1;
                grid[7][9]=1;
                grid[8][5]=1;
                grid[8][6]=1;
                grid[8][9]=1;
                grid[9][1]=1;
                grid[9][2]=1;
                grid[9][3]=1;
                //System.out.print(grid[i][j]+" ");
                
            }
            //System.out.println("");
        }
        
        intro();
        
        boolean gameOver=false;
        while(gameOver==false){
            try{
            System.out.println("Please enter a capital letter for the y-axis (A-J)");
            char yCoord = scan.next().charAt(0);
            System.out.println("\nPlease enter a number for the x-axis (1-10)");
            int yCoordInt = yCoord-65;
            int xCoord = scan.nextInt()-1;
            
            if(grid[yCoordInt][xCoord]==2){
                System.out.println("\nYou already guessed here! What a waste of a shot.");
            }
            if(grid[yCoordInt][xCoord]==1){
                System.out.println("Hit!\n");
                grid[yCoordInt][xCoord]=2;
                winCount--;
            } else{
                System.out.println("Miss!\n");
            }
            turn++;
            
            if(winCount==0){
                break;
            }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("You entered a value outside of the grid. Doesn't count!\n");
            }
        }
        System.out.println("\n\nCongratualations you have sunk all the ships!");
        System.out.println("It took you: "+turn+" shots!");
        
        
    }
    
}
