

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class DeterminantCalculator {
    /**
     * @param determinant
     * @return integer
     *
     *
     * */

    private static int calculateTwoDimensionDeterminant(int[][] determinant){
        int width = determinant.length;
        int height = determinant[0].length;
        if(width!=2 || height!=2){
            Assert.fail("this should be a 2*2 determinant");
        }
        return determinant[0][0] * determinant[1][1] - determinant[0][1] * determinant[1][0];
    }

    public static int calculateDeterminant(int[][] determinant){
        int width = determinant.length;
        int height = determinant[0].length;
        if(width!=height){
            Assert.fail("This is not a determinant");
        }
        if(width == 2){
            return calculateTwoDimensionDeterminant(determinant);
        }

        int result =0;

        for(int j = 0;j<width;j++){
            if(j%2==0){
                result += determinant[0][j] * calculateDeterminant(thinDeterminant(determinant,0,j));
            }else{
                result -= determinant[0][j] * calculateDeterminant(thinDeterminant(determinant,0,j));
            }
        }
        return result;
    }

    private static int[][] thinDeterminant(int[][] determinant,int row,int col){
        int width = determinant.length;
        int height = determinant[0].length;
        if(width!=height){
            Assert.fail("This is not a determinant");
        }
        if(row<0 || col<0 || row>width-1 || col>height-1){
            Assert.fail("row or col is illegal");
        }

        int[][] newDeterminant = new int[width-1][height-1];
        int oriRow =0;

        for(int curRow = 0;curRow<width-1;curRow++){
            if(curRow==row){
                oriRow++;
            }
            int oriCol =0;
            for(int curCol = 0;curCol<height-1;curCol++){
                if(curCol==col){
                    oriCol++;
                }
                newDeterminant[curRow][curCol] = determinant[oriRow][oriCol];
                oriCol++;
            }
            oriRow++;
        }
        return newDeterminant;
    }


    public static void main(String[] args){
        int[][] determinant = {{1,2},{3,4}};
    }
}
