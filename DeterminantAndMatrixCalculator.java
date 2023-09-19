

import org.junit.Assert;

public class DeterminantAndMatrixCalculator {
    /**
     * @param determinant
     * @return integer
     *
     *
     * */

    /*计算二维行列式 */
    private static int calculateTwoDimensionDeterminant(int[][] determinant){
        int width = determinant.length;
        int height = determinant[0].length;
        if(width!=2 || height!=2){
            Assert.fail("this should be a 2*2 determinant");
        }
        return determinant[0][0] * determinant[1][1] - determinant[0][1] * determinant[1][0];
    }

    /*计算多维行列式 */
    public static int calculateDeterminant(int[][] determinant){
        int width = determinant.length;
        int height = determinant[0].length;
        if(width!=height){
            Assert.fail("This is not a determinant");
        }
        if(width==1){
            return determinant[0][0];
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

    /*去除指定元素所处的行和列 */
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


    /*转置矩阵，不改变原矩阵，返回新矩阵 */
    public static int[][] transpose(int[][] matrix){
        int width = matrix.length;
        int height = matrix[0].length;
        int[][] newDeterminant = new int[height][width];
        for(int i = 0 ;i < height;i++){
            for(int j = 0;j<width;j++){
                newDeterminant[i][j] = matrix[j][i];
            }
        }
        return newDeterminant;
    }


    /*计算代数余子式 */
    public static int calculateAlgebraicCongruent(int[][] matrix,int row,int col){
        if((row+col)%2==0){
            return calculateDeterminant(thinDeterminant(matrix,row,col));
        }else{
            return -1 * calculateDeterminant(thinDeterminant(matrix,row,col));
        }
    }

    /*计算余子式 */
    public static int calculateCofactor(int[][] matrix,int row,int col){
        return calculateDeterminant(thinDeterminant(matrix,row,col));
    }


    /*返回伴随矩阵 */
    public static int[][] getAdjointMatrix(int[][] matrix){
        int width = matrix.length;
        int height = matrix[0].length;
        int[][] tempMatrix = new int[width][height];
        for(int i = 0;i<width;i++){
            for(int j = 0;j<height;j++){
                tempMatrix[i][j] = calculateAlgebraicCongruent(matrix,i,j);
            }
        }
        return transpose(tempMatrix);
    }

    /*返回逆矩阵，由于只支持整数运算，所以会输出伴随矩阵和一个正数
    * 将伴随矩阵和这个数相除，即为逆矩阵 */
    public static void getInverseMatrix(int[][] matrix){
        int width = matrix.length;
        int height = matrix[0].length;
        if(width!=height || calculateDeterminant(matrix)==0){
            Assert.fail("It has no inverse matrix");
        }
        int A = calculateDeterminant(matrix);
        System.out.println("The adjoint matrix is:");
        printDeterminant(getAdjointMatrix(matrix));
        System.out.println("The number to divide:");
        System.out.print(A);
    }



    /*矩阵和常数加法*/
    public static void matrixAdd(int[][] matrix,int num){
        int width = matrix.length;
        int height = matrix[0].length;
        for(int i = 0;i<width;i++){
            for(int j = 0 ;j<height;j++){
                matrix[i][j] += num;
            }
        }
    }
    /*矩阵相加，不改变原矩阵，返回新矩阵 */
    public static int[][] matrixAdd(int[][] matrix1,int[][] matrix2){
        int width1 = matrix1.length;
        int height1 = matrix1[0].length;
        int width2 = matrix2.length;
        int height2 = matrix2[0].length;
        if(width1!=width2 || height1!=height2){
            Assert.fail("They could not be added");
        }
        int[][] newMatrix = new int[width1][height1];
        for(int i = 0;i<width1;i++){
            for(int j = 0;j<height1;j++){
                newMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return newMatrix;
    }

    /*矩阵和常数乘法 */
    public static void matrixTimes(int[][] matrix,int num){
        int width = matrix.length;
        int height = matrix[0].length;
        for(int i = 0;i<width;i++){
            for(int j = 0;j<height;j++){
                matrix[i][j] *=num;
            }
        }
    }
    /*矩阵和矩阵乘法，不改变原矩阵，返回新矩阵 */
    public static int[][] matrixTimes(int[][] matrix1,int[][] matrix2){
        int width1 = matrix1.length;
        int height1 = matrix1[0].length;
        int width2 = matrix2.length;
        int height2 = matrix2[0].length;
        if(height1!=width2){
            Assert.fail("They could not be multiplied");
        }
        int[][] newMatrix = new int[width1][height2];
        for (int row = 0; row < width1; row++) {
            for (int col = 0; col < height2; col++) {
                //具体到某一个元素
                for (int i = 0; i < height1; i++) {
                    newMatrix[row][col] += (matrix1[row][i] * matrix2[i][col]);
                }
            }
        }
        return newMatrix;
    }

    /*复制矩阵，返回新矩阵 */
    public static int[][] matrixCopy(int[][] matrix){
        int width = matrix.length;
        int height = matrix[0].length;
        int[][] newMatrix = new int[width][height];
        for(int i = 0;i<width;i++){
            for(int j = 0;j<height;j++){
                newMatrix[i][j] = matrix[i][j];
            }
        }
        return newMatrix;
    }


    /*打印矩阵 */
    public static void printDeterminant(int[][] determinant){
        int width = determinant.length;
        int height = determinant[0].length;
        for(int i = 0;i<width;i++){
            for(int j = 0;j<height;j++){
                System.out.print(determinant[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }


}
