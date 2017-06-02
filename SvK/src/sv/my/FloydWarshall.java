package sv.my;

public class FloydWarshall {
    public static int[][] FloydWarshall(int[][] C) {
        int[][] A = new int[C.length][C.length];
        int n = C.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = C[i][j];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = Math.min(A[i][j], A[i][k] + A[k][j]);
                }
            }
        }
        return A;
    }
    public static int[][] FloydWarshall_NoInit(int [][]C){
        int length=C.length;

        for(int k=0;k<length;k++){
            for(int i=0;i<length;i++){
                for(int j=0;j<length;j++){
                        C[i][j]=Math.min(C[i][j],C[i][k]+C[k][j]);
                }
            }
        }return C;
    }

}
