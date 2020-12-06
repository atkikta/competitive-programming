
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] T = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                T[i][j] = sc.nextInt();
            }
        }
        
        List<Integer> pattern = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        step(pattern,N,K, result, T);
        int res = 0;
        for (Integer i : result) {
            res += i;
        }
        if(res > 0) System.out.println("Found");
        else System.out.println("Nothing");
    }
    public static void step(List<Integer> pattern, int n, int k, List<Integer> result, int[][] T){
        if(pattern.size()>=n){
            int val = T[0][pattern.get(0)];
            for (int i = 1; i < n; i++) {
                val = val ^ T[i][pattern.get(i)];
            }
            if(val==0){
                result.add(1);
            } 
            else result.add(0);
        }else{
            for (int i = 0; i < k; i++) {
                pattern.add(i);
                step(pattern, n, k, result, T);
                pattern.remove(pattern.size()-1);
            }
        }
    }
}