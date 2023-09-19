# 本软件是用来方便写线代作业的，只是练手

令人悲伤的是，所有数据类型都是int，所以可能会有很多限制（

开放的方法：

public static int calculateDeterminant(int[][] determinant)：计算n阶行列式

public static int[][] transpose(int[][] matrix)：转置矩阵

public static int calculateAlgebraicCongruent(int[][] matrix,int row,int col)：*计算代数余子式*

public static int calculateCofactor(int[][] matrix,int row,int col)：计算余子式

public static int[][] getAdjointMatrix(int[][] matrix)：返回伴随矩阵

public static void getInverseMatrix(int[][] matrix)：返回逆矩阵，由于只支持整数运算，所以会输出伴随矩阵和一个正数。将伴随矩阵和这个数相除，即为逆矩阵

public static void matrixAdd(int[][] matrix,int num)：矩阵和常数加法

public static int[][] matrixAdd(int[][] matrix1,int[][] matrix2)：矩阵相加，不改变原矩阵，返回新矩阵

public static void matrixTimes(int[][] matrix,int num)：矩阵和常数乘法

public static int[][] matrixTimes(int[][] matrix1,int[][] matrix2)：矩阵和矩阵乘法，不改变原矩阵，返回新矩阵

public static int[][] matrixCopy(int[][] matrix)：复制矩阵，返回新矩阵

public static void printDeterminant(int[][] determinant)：打印矩阵



