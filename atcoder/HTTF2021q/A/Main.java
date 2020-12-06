import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        cx = 0;
        cy = 0;
        a = new int[20][20];
        for (int i = 0; i < 20; i++) {
            Arrays.fill(a[i], -1);
        }
        x = new int[100];
        y = new int[100];
        for (int i = 0; i < 100; i++) {
            int Y = ni();
            int X = ni();
            a[Y][X] = i;
            x[i]=X; 
            y[i]=Y; 
        }

        
        ans = takeall(0, 0);
        out.println(ans);
    }
    int[][] a;
    int[] x;
    int[] y;
    int cx;
    int cy;
    String ans ;
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    in(){
        if(a[cx][cy]>-1){
            stack.addFirst(a[cx][cy]);
            a[cx][cy] = -1;
            ans += "I";
        }
    }
    out(){
        if(a[cx][cy] == -1 && stack.size()>0){
            a[cx][cy] = stack.pollFirst();
            ans += "O";
        }
    }
    sweep(){
        while(cx<19) {
            if(a[cx][cy]>50){
                in();
            }
            if(stack.peekFirst()<=50){
                out();
            }
            cx++;
            ans += "R";
        }
        while(0<cx){
            if(a[cx][cy]<=50){
                in();
            }
            if(stack.peekFirst()>50){
                out();
            }
        }
    }
    takeall(){
        for (int i = 0; i < 100; i++) {
            if(x[i]<cx){
                ans += String.join("", Collections.nCopies(cx-x[i], "L"));
            }else{
                ans += String.join("", Collections.nCopies(x[i]-cx, "R"));
            }
            if(y[i]<cy){
                ans += String.join("", Collections.nCopies(cy-y[i], "U"));
            }else{
                ans += String.join("", Collections.nCopies(y[i]-cy, "D"));
            }
            ans += "I";
            cx = x[i];
            cy = y[i];
        }

        return ans;
    }

    String ns() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine(), " ");
        }
        return tok.nextToken();
    }
 
    int ni() throws IOException {
        return Integer.parseInt(ns());
    }
 
    long nl() throws IOException {
        return Long.parseLong(ns());
    }
 
    double nd() throws IOException {
        return Double.parseDouble(ns());
    }
 
    String[] nsa(int n) throws IOException {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = ns();
        }
        return res;
    }
 
    int[] nia(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ni();
        }
        return res;
    }
 
    long[] nla(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nl();
        }
        return res;
    }
 
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
 
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        tok = new StringTokenizer("");
        Main main = new Main();
        main.solve();
        out.close();
    }
}