//Count the Inversion 

import java.io.*;
import java. util.*;
public class Task3A {
public static void mergeSort (int arr[], int s, int e){
  if(s>=e) {
    return;
  }
  int mid  = s+ (e-s)/2;
  mergeSort(arr, s,mid);
  mergeSort ( arr, mid+1, e);
  merge (arr, s, mid, e);
}
static long count=0;
public static void merge ( int arr[], int s, int mid , int e){
 
  int temp[]= new int[e-s+1];
  int i= s;
  int j= mid+1;
  int k= 0;
  while(i<=mid && j<=e){
    if(arr[i]<arr[j]){
      temp[k++]= arr[i++];
    }
    else{
      temp[k++] = arr[j++];
      count+= (mid -i+1);
    }
  }
  while(i<= mid){
    temp[k++]= arr [i++];
  }
  while(j<=e){
    temp[k++]= arr[j++];
  }
  for( k=0, i =s; k<temp.length ; k++,i++){
    arr[i]= temp[k];
  }


}


    public static void main(String[]args)throws Exception{
     
        BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
         int x = Integer.parseInt(br.readLine());
 
        StringTokenizer st = new StringTokenizer (br.readLine());
    int arr[] = new int [x];
    for(int i=0; i<x;i++){
      arr[i]= Integer.parseInt(st.nextToken());
    }
    mergeSort( arr, 0,x-1);
    pw.println(count);


for(int i=0; i<x;i++){
  pw.print( arr[i] + " ");
}




     pw.flush();
    }
    }
 


//Count the Inversion Revisited 

import java.io.*;
import java. util.*;
public class Task3A {
    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) return;


        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }


    static long count = 0;
    public static void merge(int arr[], int si, int mid, int ei) {
        int split = mid + 1;
        while (split <= ei && arr[split] < 0) {
            split++;
        }


        int neg = split - 1;
        int pos = split;
        for (int i = si; i <= mid; i++) {
            while (neg >= mid + 1 && (long) arr[neg] * arr[neg] < arr[i]) {
                neg--;
            }
            while (pos <= ei && (long) arr[pos] * arr[pos] < arr[i]) {
                pos++;
            }
            count += (split - 1 - neg) + (pos - split);
        }




        int temp[] = new int[ei - si + 1];


        int i = si;
        int j = mid + 1;
        int k = 0;


        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }


        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }


        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);


        int n = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        mergeSort(arr, 0, n - 1);
        pw.println(count);
        pw.flush();
    }
}




// Fast Power Drift 

import java.io.*;
import java. util.*;
public class Task3C {
    public static long sol(long a, long b){
        long MOD= 107;
        long ans= 1;
        a%=MOD;
        while(b>0){
            if (b%2==1){
                ans= (ans*a)%MOD;
            }
            a=(a*a)% MOD;
            b/=2;
        }
        return ans;
    }


    public static void main(String[]args)throws Exception{
        BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer (br.readLine());
        long a= Long.parseLong(st.nextToken());
        long b= Long.parseLong(st.nextToken());
        pw.println(sol(a,b));
        pw.flush();
    }
    }




//Fast Matrix Drift 

import java.io.*;
import java. util.*;
public class Task3D {
static long mod = 1000000007L;
public static class Matrix{
   long a00, a01, a10, a11;
   public Matrix(){


   }


   Matrix (long a11, long a12, long a21, long a22){
    this.a00= a11% mod;
    this. a01= a12% mod;
     this.a10= a21% mod;
      this.a11= a22% mod;
   }
}
public static Matrix multiply(Matrix A, Matrix B){
  Matrix C = new Matrix();
  C.a00 = (A.a00* B.a00+ A.a01* B.a10) % mod;
  C.a01 = (A.a00* B.a01+ A.a01* B.a11) % mod;
  C.a10 = (A.a10* B.a00+ A.a11* B.a10) % mod;
  C.a11 = (A.a10* B.a01+ A.a11* B.a11) % mod;
  return C;
}
public static Matrix solv ( Matrix base, long exp){
  Matrix ans = new Matrix( 1,0,0,1);
  while (exp>0){
    if(exp%2==1){
      ans= multiply (ans, base);
    }
    base = multiply (base, base);
    exp= exp/2;
  }
  return ans;
}


    public static void main(String[]args)throws Exception{
     
        BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
         int x = Integer.parseInt(br.readLine());
 
     for(int i=0; i<x;i++){
 
        StringTokenizer st = new StringTokenizer (br.readLine());
     Matrix A = new Matrix(
                Long.parseLong(st.nextToken()),
                Long.parseLong(st.nextToken()),
                Long.parseLong(st.nextToken()),
                Long.parseLong(st.nextToken())
            );


            long T = Long.parseLong(br.readLine());


            Matrix mul = solv(A, T);
            pw.println(mul.a00 + " " + mul.a01);
            pw.println(mul.a10 + " " + mul.a11);
   
     }
     pw.flush();
    }
    }



// Fast Series Drift 


import java.io.*;
import java. util.*;
public class Task3E {
static long mod;
public static long[]multiply(long a , long n ){
  if(n==0) return new long []{1,0};
  long half[] = multiply (a, n/2);
  long p= half[0];
  long s = half[1];
  long newp =(p*p)% mod;
  long news = (s*(1+p)%mod)%mod;
  if(n% 2 ==1){
    newp = (newp * a)% mod;
    news = (news * a+ a)% mod;


  }
return new long[] {newp, news};
}


    public static void main(String[]args)throws Exception{
     
        BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
         int x = Integer.parseInt(br.readLine());
 
     for(int i=0; i<x;i++){
 
        StringTokenizer st = new StringTokenizer (br.readLine());
     long a = Long.parseLong(st.nextToken());
     long n =  Long.parseLong(st.nextToken());
     mod = Long. parseLong(st.nextToken());
     pw.println (multiply(a,n)[1]);
     }
     pw.flush();
    }
    }


//Ordering Binary Tree 


import java.io.*;
import java. util.*;
public class Task3F {
  static int arr[];
  static StringBuilder ans= new StringBuilder();
  public static void solve(int left, int right){
    if(left>right) return;
    int mid= left+(right-left)/2;


    ans.append(arr[mid]).append("  ");
    solve(left,mid-1);
    solve(mid+1,right);
    }


    public static void main(String[]args)throws Exception{
        BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer (br.readLine());
      arr= new int [n];
      for( int i=0;i<n;i++){
        arr[i]= Integer.parseInt(st1.nextToken());
      }
      solve(0,n-1);
      pw.println(ans.toString().trim());
        pw.flush();
    }
    }




//220 Trees Reassessed 


import java.io.*;
import java. util.*;
public class Task3H {
  static int n;
  static int idx;
    static int preIdx;
  static int[]postOrder;
  static int[]preOrder;
  static int[]inOrder;
  public static void solve(int l, int r){
    if(l>r) return;
    int root= postOrder[idx--];
    int pos=1;
    for(int i=l;i<=r;i++){
        if(inOrder[i]==root){
            pos=i;
            break;
        }
    }
   solve(pos+1,r);
    solve(l, pos-1);
  preOrder[preIdx++]= root;
    }


    public static void main(String[]args)throws Exception{
     
        BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
         n= Integer.parseInt(br.readLine());
     
        inOrder= new int[n];
        postOrder= new int[n];
      preOrder = new int[n];
      idx= n-1;
 
        StringTokenizer st1 = new StringTokenizer (br.readLine());
      for( int i=0;i<n;i++){
       inOrder[i]= Integer.parseInt(st1.nextToken());
      }
        StringTokenizer st2 = new StringTokenizer (br.readLine());
      for( int i=0;i<n;i++){
       postOrder[i]= Integer.parseInt(st2.nextToken());
      }
     solve(0, n-1);
     for(int i=n-1; i>=0;i--){
        pw.print(preOrder[i]+ "  ");
     }
     pw.flush();
    }
    }


//220 Trees 

import java.io.*;
import java. util.*;
public class Task3G {
  static int n;
  static int idx;
  static int[]preOrder;
  static int[]inOrder;
  public static void solve(int l, int r){
    if(l>r) return;
    int root= preOrder[idx++];
    int pos=1;
    for(int i=l;i<=r;i++){
        if(inOrder[i]==root){
            pos=i;
            break;
        }
    }
   solve(l,pos-1);
    solve(pos+1,r);
    System.out.print(root+ "  ");
    }


    public static void main(String[]args)throws Exception{
     
        BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
         n= Integer.parseInt(br.readLine());
     
        inOrder= new int[n];
      preOrder = new int[n];
 
        StringTokenizer st1 = new StringTokenizer (br.readLine());
      for( int i=0;i<n;i++){
       inOrder[i]= Integer.parseInt(st1.nextToken());
      }
        StringTokenizer st2 = new StringTokenizer (br.readLine());
      for( int i=0;i<n;i++){
       preOrder[i]= Integer.parseInt(st2.nextToken());
      }
     solve(0, n-1);
    }
    }

