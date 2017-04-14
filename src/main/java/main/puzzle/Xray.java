/*
 * AUTHOR: Alejandro Aguilera Vega
 * EMAIL: alejandro.aguilera.vega@gmail.com
 * WHAT CAN YOU DO WITH THIS CODE?: Whatever you want, the only condition is to at least mention its origin.
 */
package main.puzzle;

import java.util.ArrayList;

public class Xray {

    private int[][] negativeFactory() {
        return new int[][]{
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}};
    }

    /*
    ARRAY m :

      0   1   2      j-1  j
    +---+---+---+ . +---+---+
  0 |0,0|   |   |   |   |0,j|
    +---+---+---+ . +---+---+
  1 |   |   |   |   |   |   |
    +---+---+---+ . +---+---+
  2 |   |   |   |   |   |   |
    +---+---+---+ . +---+---+
    .   .   .   .   .   .   .
    +---+---+---+ . +---+---+
i-1 |   |   |   |   |   |   |
    +---+---+---+ . +---+---+
  i |i,0|   |   |   |   |i,j|
    +---+---+---+ . +---+---+
    */
    private void regionGrowing(
            int i, 
            int j, 
            int[][] m, 
            int[][] negative) {
        negative[i][j] = 0;

        /*
          j=0  j+1
          +---+---+---
      i=0 |0,0| x |
          +---+---+
      i+1 | x |   |
          +---+---+
          |          
         */
        if (i == 0 && j == 0) {
            if (m[i+1][j] == 0 && negative[i+1][j] == 1) 
                regionGrowing(i+1, j, m, negative);
            if (m[i][j+1] == 0 && negative[i][j+1] == 1)
                regionGrowing(i, j+1, m, negative);
        /*
           j=0 j+1
          +---+---+---
        0 |0,0|   |
          +---+---+
          .   .   .
          +---+---+
      i-1 | x |   |
          +---+---+
      i   |   | x |
          +---+---+
      i+1 | x |   |
          +---+---+
          |          
         */
        } else if ((i > 0 && i < PuzzleSolution.PLAYGROUNG_ROW_COUNT - 1 ) && j == 0) {
            if (m[i+1][j] == 0 && negative[i+1][j] == 1) 
                regionGrowing(i+1, j, m, negative);
            if (m[i][j+1] == 0 && negative[i][j+1] == 1) 
                regionGrowing(i, j+1, m, negative);
            if (m[i-1][j] == 0 && negative[i-1][j] == 1) 
                regionGrowing(i-1, j, m, negative);
        /*
            0    j-1  j  j+1
          +---+.+---+---+---+
      i=0 |0,0| | x |   | x |
          +---+.+---+---+---+
      i+1 |   | |   | x |
          +---+.+---+---+
          |           
         */
        } else if (i == 0 && (j > 0 && j < PuzzleSolution.PLAYGROUNG_COL_COUNT - 1)) {
            if (m[i+1][j] == 0 && negative[i+1][j] == 1) 
                regionGrowing(i+1, j, m, negative);
            if (m[i][j+1] == 0 && negative[i][j+1] == 1) 
                regionGrowing(i, j+1, m, negative);
            if (m[i][j-1] == 0 && negative[i][j-1] == 1) 
                regionGrowing(i, j-1, m, negative);
        /*
            0    j-1  j  j+1
          +---+.+---+---+---+---
        0 |0,0| |   |   |   |
          +---+.+---+---+---+
          .   . .   .   .   .
          +---+.+---+---+---+
      i-1 |   | |   | x |   |
          +---+.+---+---+---+
       i  |   | | x |   | x |
          +---+.+---+---+---+
      i+1 |   | |   | x |   |
          +---+.+---+---+---+
          |           
         */
        } else if ((i > 0 && i < PuzzleSolution.PLAYGROUNG_ROW_COUNT - 1 ) && (j > 0 && j < PuzzleSolution.PLAYGROUNG_COL_COUNT - 1)) {
            if (m[i-1][j] == 0 && negative[i-1][j] == 1) 
                regionGrowing(i-1, j, m, negative);
            if (m[i][j+1] == 0 && negative[i][j+1] == 1) 
                regionGrowing(i, j+1, m, negative);
            if (m[i+1][j] == 0 && negative[i+1][j] == 1) 
                regionGrowing(i+1, j, m, negative);
            if (m[i][j-1] == 0 && negative[i][j-1] == 1) 
                regionGrowing(i, j-1, m, negative);
        /*
                            |
           ---+.+---+---+---+
              . .   .   .   .
           ---+.+---+---+---+
              | |   | x |   | i-1
           ---+.+---+---+---+
              | | x |   | x | i = MAX_R - 1       
           ---+.+---+---+---+
                 j-1  j  j+1
                        MAX_C
         */
        } else if (i == PuzzleSolution.PLAYGROUNG_ROW_COUNT - 1 && (j > 0 && j < PuzzleSolution.PLAYGROUNG_COL_COUNT - 1)) {
            if (m[i-1][j] == 0 && negative[i-1][j] == 1) 
                regionGrowing(i-1, j, m, negative);
            if (m[i][j+1] == 0 && negative[i][j+1] == 1) 
                regionGrowing(i, j+1, m, negative);
            if (m[i][j-1] == 0 && negative[i][j-1] == 1) 
                regionGrowing(i, j-1, m, negative);

        /*
                           |
          ---+.+---+---+---+
             . .   |   | x | i-1
          ---+.+---+---+---+
             | |   | x |   | i
          ---+.+---+---+---+
             | |   |   | x | i+1, MAX_R
          ---+.+---+---+---+
                    j-1  j=MAX_C - 1
         */
        } else if ((i > 0 && i < PuzzleSolution.PLAYGROUNG_ROW_COUNT - 1 ) && j == PuzzleSolution.PLAYGROUNG_COL_COUNT - 1) {
            if (m[i-1][j] == 0 && negative[i-1][j] == 1) 
                regionGrowing(i-1, j, m, negative);
            if (m[i][j-1] == 0 && negative[i][j-1] == 1) 
                regionGrowing(i, j-1, m, negative);
            if (m[i+1][j] == 0 && negative[i+1][j] == 1) 
                regionGrowing(i+1, j, m, negative);
        /*
                           |
          ---+.+---+---+---+
             . .   |   |   | 
          ---+.+---+---+---+
             | |   |   | x | i-1
          ---+.+---+---+---+
             | |   | x |i,j| i = MAX_R - 1
          ---+.+---+---+---+
                    j-1  j=MAX_C - 1
         */
        } else if (i == PuzzleSolution.PLAYGROUNG_ROW_COUNT - 1 && j == PuzzleSolution.PLAYGROUNG_COL_COUNT - 1) {
            if (m[i-1][j] == 0 && negative[i-1][j] == 1) 
                regionGrowing(i-1, j, m, negative);
            if (m[i][j-1] == 0 && negative[i][j-1] == 1) 
                regionGrowing(i, j-1, m, negative);
        /*
                  j-1 j=MAX_C - 1
        ---+.+---+---+---+
           . .   | x |0,j| i=0
        ---+.+---+---+---+
           . .   |   | x | i+1   
        ---+.+---+---+---+
           . .   .   .   .
        ---+.+---+---+---+
                         |
         */
        } else if (i == 0 && j == PuzzleSolution.PLAYGROUNG_COL_COUNT - 1) {
            if (m[i][j-1] == 0 && negative[i][j-1] == 1) 
                regionGrowing(i, j-1, m, negative);
            if (m[i+1][j] == 0 && negative[i+1][j] == 1) 
                regionGrowing(i+1, j, m, negative);    
        /*
         |
         +---+---+---+.+---
         .   .   .   . . 
         +---+---+---+.+---
     i-1 | x |   |   . . 
         +---+---+---+.+---
i=MAX_R-1|i,0| x |   . .
         +---+---+---+.+---
          j=0 j+1
         */
        } else if (i == PuzzleSolution.PLAYGROUNG_ROW_COUNT - 1 && j == 0) {
            if (m[i-1][j] == 0 && negative[i-1][j] == 1) 
                regionGrowing(i-1, j, m, negative);
            if (m[i][j+1] == 0 && negative[i][j+1] == 1) 
                regionGrowing(i, j+1, m, negative);
        }
    }

    public ArrayList<int[][]> obtainNegatives(int[][] playground) {
        
        ArrayList<int[][]> negatives = new ArrayList<int[][]>();
        for (int i=0; i<PuzzleSolution.PLAYGROUNG_ROW_COUNT; i++) {
            for (int j=0; j<PuzzleSolution.PLAYGROUNG_COL_COUNT; j++) {

                boolean pixelAlreadyAnalized = false;
                for (int[][] neg: negatives) {
                    if (neg[i][j] == 0) {
                        pixelAlreadyAnalized = true;
                        break;
                    }
                }
                if (playground[i][j] == 0 && !pixelAlreadyAnalized) {
                    int[][] negative = this.negativeFactory();
                    regionGrowing(i, j, playground, negative);
                    negatives.add(negative);
                }
            }
        }
        return negatives;
    }
}
