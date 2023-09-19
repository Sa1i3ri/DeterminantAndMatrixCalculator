import org.junit.Test;

public class Main {
    @Test
    public void test1(){
        int[][] determinant = {
                {3,-1,2},
                {-5,3,-4},
                {1,3,-3}
        };

        System.out.println(DeterminantAndMatrixCalculator.calculateDeterminant(determinant));

    }


    public static void main(String[] args){

    }
}
