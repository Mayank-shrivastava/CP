/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static int[] arr = new int[100001]; // 10^4
    static int n;
    static int q;
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0) {
		    n = scn.nextInt();
		    q = scn.nextInt();
		    for(int i = 1; i <= n; i++) arr[i] = scn.nextInt();
		    while(q-->0) {
		        int i = scn.nextInt();
		        int x = scn.nextInt();
		        arr[i] = x;
		      int l = 0;
		      int r = 1000000000;
		      while(Math.abs(l-r) >= 4) {
		          int mid = (l+r)/2;
		          if(isSubarray(mid)) {
		              r = mid + 1;
		          } else {
		              l = mid - 1;
		          }
		      }
		      for(int j = l; j <= r; j++) {
		          if(isSubarray(j)) {
		              System.out.println(j);
		              break;
		          }
		      }
		      
		    
		       //System.out.println(ans);
		   }
        }
		   
    }
		
		public static boolean isSubarray(int x) {
		    for(int i = 2; i <= n; i++) {
		        if(arr[i]+x*i < arr[i-1]+x*(i-1)) return false;
		    }
		    return true;
		}
	
}
