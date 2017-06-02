package sv.my.trees;

/**
 * Created by Surya Vamsi on 18-Jul-15.
 */
public class Matrices {
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] tmatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                tmatrix[j][i] = matrix[i][j];

        /*for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.format("%.3f ", tmatrix[i][j]);
            }
            System.out.println();
        }*/
        return tmatrix;
    }

    public static double determinant(double[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        if (r != c) return Double.MIN_VALUE;
        if (r == 2) {
            return matrix[0][0] * matrix[1][1] - (matrix[0][1] * matrix[1][0]);
        }
        double sum = 0.0;
        for (int i = 0; i < c; i++) {
            sum += changeSign(i) * matrix[0][i] * determinant(subMatrix(matrix, 0, i));
        }
        return sum;
    }

    static void print(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static double[][] Inverse(double [][]matrix){
        double determinant=determinant(matrix);
        double[][]transcofactor=transpose(coFactorMatrix(matrix));
        return multiplyByConstant(transcofactor,1.0/determinant);
    }
    public static double[][] multiplyByConstant(double [][]matrix,double constant){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=matrix[i][j]*constant;
            }
        }return matrix;
    }
    public static double [][] coFactorMatrix(double [][]matrix){
        double [][]coMat=new double[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                coMat[i][j]=changeSign(i)*changeSign(j)*determinant(subMatrix(matrix,i,j));
            }
        }return coMat;
    }
    public static boolean isSingular(double[][]matrix){return determinant(matrix)==0?true:false;}

    static double[][] subMatrix(double[][] matrix, int exrow, int excol) {
        double[][] newMatrix = new double[matrix.length - 1][matrix[0].length - 1];
        int r = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (i == exrow) continue;
            r++;
            int c = -1;
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == excol) continue;
                newMatrix[r][++c] = matrix[i][j];
            }
        }
         return newMatrix;
    }

    static int changeSign(int i) {
        return i % 2 == 0 ? 1 : -1;
    }

}
