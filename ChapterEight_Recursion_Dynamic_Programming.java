import java.util.*;
public class ChapterEight_Recursion_Dynamic_Programming {
    /*
     * Tips for recursion(largely personal)
     * Think about what each call is doing to the previous call(e.g. in the triple step, each call is simulating a step: n-1 is a step of 1, n-2 is a step of 2, etc. going backwards. Think about which cases this covers. On every step, every type of step is simulated, which is what we want.)
     * 
     */
    public static void main(String[] args){
        int[][] map = new int[50][50];
        map[20][20] = -1;
        map[20][21] = -1;
        map[3][20] = -1;
        System.out.println(robotinAGrid(map, new Position(0, 0), 0));
    }

    public static int tripleStep(int n){
        if(n < 0){
            return 0;
        }
        else if (n ==0){
            return 1;
        }
        else{
            return tripleStep(n-1) + tripleStep(n-2) + tripleStep(n-3);
        }
    }
    public static Position robotinAGrid(int[][] map, Position pos){
        int row = pos.row;
        int col = pos.col;
        if(row == 49 && col == 49){
            System.out.println("End achieved");
            return null;
        }
        if(row+1 < map.length && map[row+1][col] != -1 ){
            robotinAGrid(map, new Position(row+1, col));
        }
        else if(col+1 < map.length && map[row][col+1] != -1){
            robotinAGrid(map, new Position(row, col+1));
        }
        return null;
    }

}
