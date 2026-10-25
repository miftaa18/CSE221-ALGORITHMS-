//ODD OR EVEN ?


import java.io.*;
import java.util.*;
public class solA{
    public static void main (String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            if (n%2==0){
                pw.println(n + " is an Even number.");
            }
            else {
                 pw.println(n + " is an Odd number.");
            }
        }
        pw.flush();
    }


    }




//Arithmetic Expression (Calculator )


import java.io.*;
import java.util.*;
public class B_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            long first = Long.parseLong(st.nextToken());
            String oper = st.nextToken();
            long second = Long.parseLong(st.nextToken());
            
            if (oper.equals("+")) {
                pw.println(first + second);
            }
            else if (oper.equals("-")) {
                pw.println(first - second);
            }
            else if (oper.equals("*")) {
                pw.println(first * second);
            }
            else if (oper.equals("/")) {
                pw.println((float)first / (float)second);
            }
            else if (oper.equals("%")) {
                pw.println(first % second);
            }
            else if (oper.equals("&")) {
                pw.println(first & second);
            }
            else if (oper.equals("|")) {
                pw.println(first | second);
            }
            else if (oper.equals("^")) {
                pw.println(first ^ second);
            }
            else if (oper.equals("<<")) {
                pw.println(first << second);
            }
            else if (oper.equals(">>")) {
                pw.println(first >> second);
            }
        }
        pw.flush();
    }
}






//fast sum 


import java.io.*;
import java.util.*;


public class C_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(br.readLine());
            pw.println((a * (a + 1)) / 2);
        }
        pw.flush();
    }
}




// Is Sorted?


import java.io.*;
import java.util.*;
public class taskD {
    public static void main (String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n= Integer.parseInt(br.readLine());
        for (int i =0; i<n;i++){
            int a = Integer.parseInt(br.readLine());
StringTokenizer st = new StringTokenizer (br.readLine());
int prev=-1;
 boolean sorted= true;
 for (int j=0;j<a;j++){
    int x= Integer.parseInt(st.nextToken());
    if(j!=0){
        if(prev>x){
            sorted= false;
            break;
        }
    }
    prev=x;


 }
 if (sorted){
    pw.println("YES");
 }
 else {
    pw.println("NO");
 }
        }
        pw.flush();
    }
   
}






//Reverse Sort


import java.io.*;
import java.util.*;
public class taskE {
     public static void main (String[]args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter (System.out);
        int n = Integer.parseInt(br.readLine());


    StringTokenizer st = new StringTokenizer(br.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
    arr[i] = Integer.parseInt(st.nextToken());
    }


    ArrayList<String> swap = new ArrayList<>();
      for(int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length - 2 - i; j++) {
        if (arr[j] > arr[j + 2]) {
    int temp = arr[j];
    arr[j] = arr[j + 2];
    arr[j + 2] = temp;
    swap.add((j + 1) + " " + (j + 3));
      }
     }
 }


       boolean flag = true;
    for (int i = 0; i < n - 1; i++) {
     if(arr[i] > arr[i + 1]) {
      flag = false;
    break;
        }
    }


    if (flag) {
         pw.println("YES");
        pw.println(swap.size());
    for (int i = 0; i < swap.size(); i++) {
        pw.println(swap.get(i));
    }
    }
    else {
        pw.println("NO");
    }
        pw.flush();
    }
    }








// An Ancient Sorting Algorithm


import java.io.*;
import java.util.*;
public class taskf {
    public static void main (String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n= Integer.parseInt(br.readLine());
     StringTokenizer st = new StringTokenizer(br.readLine());
     int arr[]= new int [n];
     for (int i =0;i<n;i++){
        arr[i] = Integer.parseInt(st.nextToken());


     }
     for (int i =0;i< arr.length-1;i++){
        for (int j=0;j<arr.length-1-i;j++){
            int p= arr[j];
            int q= arr[j+1];
            if ((p%2==0 && q%2==0) || (p%2!=0 && q%2!=0)){
                if (p>q){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    for (int i =0;i<arr.length;i++){
        pw.print(arr[i]+ " ");
     }
pw.flush();
    }
}






//Sorting Again??




import java.io.*;
import java.util.*;
public class taskg {
    public static void main (String[]args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter (System.out);
        int n = Integer.parseInt(br.readLine());
        for (int i =0; i<n ;i++){
            int b = Integer.parseInt(br.readLine());
            int id [] = new int [b];
            int num []= new int [b];
            StringTokenizer s1 = new StringTokenizer(br.readLine());
            for (int j =0;j <b;j++){
                id[j]= Integer.parseInt(s1.nextToken());
            }
            StringTokenizer s2= new StringTokenizer(br.readLine());
            for(int j =0; j<b; j++){
                num[j]= Integer.parseInt(s2.nextToken());
            }
int swap=0;
for (int j=0;j<b-1;j++){
    int maxindex= j;
    for (int k=j+1; k<b;k++){
        if (num[k]>num[maxindex]){
            maxindex= k;
        }
        else if (num[k]== num[maxindex] && id [k]< id [maxindex]) {
            maxindex =k;
        }
    }


if (maxindex != j){
    int temp = num [j];
    num[j] = num [maxindex];
    num[maxindex] = temp;


int temp2 = id [j];
id[j] = id [maxindex];
id [maxindex] = temp2 ;
swap++;
}


}
pw.println ("Minimun swaps :" + swap);
for (int x =0; x< b; x++){
    pw.println( "ID: " + id[x] + "Mark :" + num[x]);
}
pw.flush ();


        }
    }


}




//Trains?




import java.io*;
import java.util.*;


public class H_Solution {
    static class Train {
        String line;
        String name;
        int minuteTime;
        int index;


        public Train(String ln, int idx) {
            line = ln;
            index = idx;


            String[] lineParts = line.split(" ");
            name = lineParts[0];


            String time = lineParts[lineParts.length - 1];
            String[] timeParts = time.split(":");
            minuteTime = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);


        int n = Integer.parseInt(br.readLine());
        Train[] trains = new Train[n];


        for(int i = 0; i < n; i++) {
            trains[i] = new Train(br.readLine(), i);
        }


        Arrays.sort(trains, (Train a, Train b) -> {
            int cmp = a.name.compareTo(b.name);
           
            if (cmp != 0) return cmp;
            if(a.minuteTime != b.minuteTime) return b.minuteTime - a.minuteTime;
            return a.index - b.index;
        });


        for (int i = 0; i < n; i++) {
            pw.println(trains[i].line);
        }
        pw.flush();
    }
}
