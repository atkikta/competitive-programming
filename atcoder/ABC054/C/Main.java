package ABC054.C;

import java.util.*;

public class Main {
    public static int count;
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            final int a = sc.nextInt() - 1;
            final int b = sc.nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        count = 0;
        final ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        step(0, graph, path);
        System.out.println(count);
    }
    public static void step(
        int u, 
        ArrayList<ArrayList<Integer>> graph, 
        ArrayList<Integer> path){
        // System.out.println(u);
        // System.out.println(path.toString());
        if(path.size() >= graph.size()){
            count ++ ;
            return;
        }else {
            for (Integer next : graph.get(u)) {
                if( ! path.contains(next)){
                    path.add(next);
                    step(next,graph,path);
                    path.remove(path.size()-1);
                }
            }
        }
    }
}   