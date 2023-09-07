import org.junit.Test;

public class Main {
    @Test
    public void test1(){
        int[][] determinant = {
                {4,2,5,1},
                {6,3,9,10},
                {1,5,3,7},
                {7,2,13,17}
        };

        System.out.println(DeterminantCalculator.calculateDeterminant(determinant));

    }


    public static void main(String[] args){

    }
}
