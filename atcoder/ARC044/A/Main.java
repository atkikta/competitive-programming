    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.PrintWriter;
    import java.util.*;
    
    public class Main {
    
        void solve() throws IOException {
            int N = ni();
            if(N==1){
                out.println("Not Prime");
                return;
            }
            boolean isPrime = true;
            boolean isPrimeLike = false;
            for (int i = 2; i < Math.sqrt(N+1); i++) {
                if(N%i==0){
                    isPrime = false;
                }
            }
            if(!isPrime){
                if((N%10)%2!=0 && N%10!=5){
                    if(sumdig(N)%3 != 0){
                        isPrimeLike=true;
                    }
                }
            }else{
                isPrimeLike=true;
            }
            if(isPrimeLike){
                out.println("Prime");
            }else{
                out.println("Not Prime");
            }
        }
        int sumdig(int n){
            int res = 0;
            while(n>0){
                res += n%10;
                n = n/10;
            }
            return res;
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