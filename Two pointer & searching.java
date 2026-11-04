// 2 SUM TROUBLE

import java.io.*;
import java.util.*;
public class Task2A {
     public static void main (String[]args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter (System.out);
        StringTokenizer st1 = new StringTokenizer (br.readLine());
        int n = Integer.parseInt(st1.nextToken());
int target = Integer.parseInt(st1.nextToken());


    StringTokenizer st2 = new StringTokenizer(br.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
    arr[i] = Integer.parseInt(st2.nextToken());
    }


    boolean found = false;
    int start =0, end =n-1;
    while(start <end){
        int sum = arr[start] + arr[end];
        if (sum==target){
            pw.println((start+1)+ "  " + (end+1));
            found = true ;
            break;
        }


        else if(sum<target){
            start ++;
        }
        else {
            end --;
        }


        }
        if (!found ){
            pw.println("-1");
        }
        pw.flush();
    }
}




   


//Two Sum Revisited 


import java.io.*;
import java. util.*;
public class Task2B {
 public static void main (String []args) throws Exception{
BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
PrintWriter pw = new PrintWriter (System.out);
 StringTokenizer st = new StringTokenizer(br.readLine());
         int firstArr =  Integer .parseInt(st.nextToken());
        int secArr =  Integer. parseInt (st.nextToken());
        int n = Integer. parseInt (st.nextToken());
   
        int arr1[] = new int [firstArr];
        int arr2[]=new int [secArr];
 StringTokenizer st1 = new StringTokenizer (br.readLine());
        for (int i=0; i<firstArr;i++){
            arr1[i]=  Integer. parseInt (st1.nextToken());
        }
StringTokenizer st2 = new StringTokenizer (br.readLine());
        for (int i=0; i<secArr;i++){
            arr2[i]=  Integer. parseInt (st2.nextToken());
        }
int pair []= new int [2];
int lowsum = Integer.MAX_VALUE;
int start=0,end= secArr-1;
while (start < firstArr && end >= 0) {
int sum = arr1[start] + arr2[end] - n;
int absSum = Math.abs(sum);
    if (absSum < lowsum) {
    lowsum = absSum;
    pair[0] = start + 1;
    pair[1] = end + 1;
 }
else if (sum > 0) {
      end--;
  }
    else {
                start++;
            }
        }
 pw.println(pair[0] + " " + pair[1]);
    pw.flush();
    }
}


//A Beautiful Sorted List 

import java.io.*;
import java. util.*;
public class Task2C {
 public static void main (String []args) throws Exception{
BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
PrintWriter pw = new PrintWriter (System.out);
int n = Integer. parseInt(br.readLine());
int arr[] = new int [n];
StringTokenizer st1 = new StringTokenizer(br.readLine());
for (int i=0; i<n;i++){
    arr[i]= Integer.parseInt(st1.nextToken());
}


int m = Integer.parseInt(br.readLine());
int arr2[]= new int[m];
StringTokenizer st2= new StringTokenizer(br.readLine());
for (int i=0; i<m;i++){
    arr2[i]= Integer.parseInt(st2.nextToken());
}


int arr3[] = new int[n+m];
int position =0, a=0,b=0;
while (a<n && b<m){
    if (arr[a]<=arr2[b]){
        arr3[position++]= arr[a++];
}
else {
    arr3[position++]= arr2[b++];
}
}
while(a<n){
    arr3[position++] = arr[a++];
}
while(b<m){
    arr3[position++] = arr2[b++];
}
for (int i=0; i<arr3.length;i++){
    pw.print(arr3[i]+  "  ");
}
pw.flush();
 }
}




//Longest Subarray Sum 

import java.io.*;
import java. util.*;
public class Task2D {
    public static void main (String []args) throws Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter (System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
         int n =  Integer .parseInt(st.nextToken());
        int k =  Integer. parseInt (st.nextToken());
        StringTokenizer st1 = new StringTokenizer (br.readLine());
        int arr[] = new int [n];
        for (int i=0; i<n;i++){
            arr[i]=  Integer. parseInt (st1.nextToken());
        }


        int left =0; long sum=0;
        int len =0;
        for (int right=0; right<n; right++){
            sum+= arr[right];
            while (sum>k){
                sum-= arr[left];
                left++;
            }
            len = Math.max (len, right-left +1);
        }
        pw.println(len);
        pw.flush ();
    }
}



//Longest K-Distinct Subarray 


import java.io.*;
import java. util.*;
public class Task2E {
    public static void main (String []args) throws Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter (System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
 int n =  Integer .parseInt(st.nextToken());
        int k =  Integer. parseInt (st.nextToken());
        StringTokenizer st1 = new StringTokenizer (br.readLine());
        int arr[] = new int [n];
        for (int i=0; i<n;i++){
            arr[i]=  Integer. parseInt (st1.nextToken());


        }
         int freq []= new int [n+1];
         int left = 0;
         int dist= 0;
         int sublen =0;
          for (int right =0; right < n; right++){
            if (freq[arr[right]]==0){
                dist++;
            }


freq[arr[right]]++;
while (dist>k){
    freq[arr[left]]--;
    if (freq [arr[left]]==0){
        dist--;
    }
    left++;
}
sublen = Math.max(sublen, right-left+1);


          }
          pw.println(sublen);
pw.flush();


    }
   
}




// Count the Numbers 

import java.io.*;
import java .util.*;
public class Task2F{
    public static int bound(int[]arr,int target,boolean upper){
        int start=0,end=arr.length-1;
        int boundval=arr.length;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(upper?arr[mid]>target:arr[mid]>=target){
                boundval=mid;
                end=mid-1;


            }
            else{
                start=mid+1;


            }
        }
        return boundval;
    }
      public static void main (String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st1 = new StringTokenizer (br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int q= Integer.parseInt(st1.nextToken());
            int arr[]= new int [n];
          StringTokenizer st2 = new StringTokenizer (br.readLine()) ;
          for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st2.nextToken());
          }
for(int i=0;i<q;i++){
StringTokenizer st3 = new StringTokenizer (br.readLine()) ;
int pair[]= new int[2];
pair[0]= Integer.parseInt(st3.nextToken());
pair[1]= Integer.parseInt(st3.nextToken());
pw.println(bound(arr, pair[1], true) - bound(arr, pair[0], false));
}
pw.flush();
}
}




//Can You Split the Array? 
import java.io.*;
import java .util.*;
public class Task2G{
    public static  boolean isValid(int[]arr,int n, int k,long maxval){
int parts=1;
long sum=0;
for(int i=0;i<n;i++){
    if(arr[i]>maxval){
        return false;
    }
    if(sum+arr[i]<=maxval){
        sum+=arr[i];
    }
    else{
        parts++;
        sum=arr[i];
    }
}
return parts<=k;
    }
public static long splitArray(int[]arr,int n, int k){
    if(k>n){
        return -1;
    }
long totalSum=0;
for (int i=0;i<n;i++){
   totalSum+=arr[i];


}
long left=0;
long right= totalSum;
long ans=-1;
while(left<=right){
    long mid = left+(right-left)/2;
if (isValid(arr,n,k,mid)){
    ans= mid;
    right=mid -1;


}
else{
    left=mid+1;
}
}
return ans;


}
      public static void main (String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st1 = new StringTokenizer (br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int k= Integer.parseInt(st1.nextToken());
            int arr[]= new int [n];
          StringTokenizer st2 = new StringTokenizer (br.readLine()) ;
          for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st2.nextToken());
          }


pw.println(splitArray(arr,n,k));


pw.flush();
}
}






//Can You Cut the Ropes? 


import java.io.*;
import java .util.*;
public class Task2H{
    public static boolean split(int rope[], long k, int size){
        long totalPieces=0;
        for (int i=0;i<rope.length;i++){
          totalPieces+=  rope[i]/size;
          if( totalPieces>=k){
            return true;
          }
        }
        return false;
    }
public static int findMaxlen(int rope[],int n,long k){
    int low=1;
    int high=0;
    for (int i=0;i<n;i++){
        high= Math.max(high,rope[i]);
    }
    int ans =-1;
    while(low<=high){
        int mid=low+(high-low)/2;
        if( split(rope,k,mid)){
            ans= mid;
            low=mid+1;
        }
        else{
            high=mid-1;
        }
    }
    return ans;
}
    public static void main (String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer (br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k= Long.parseLong(st.nextToken());
            int rope[]= new int [n];
          StringTokenizer input = new StringTokenizer (br.readLine()) ;
          for(int i=0;i<n;i++) {
            rope[i]= Integer.parseInt(input.nextToken());
          }


          pw.println(findMaxlen(rope,n,k));
          pw.flush();
        }
   
    }











































