import java.util.*;
class HelloWorld {
    // this function is printing all the sub sequence that sum == 2.
    static void print(int ind, ArrayList<Integer> ds, int[] a, int s, int cs) {
        int n = a.length;
        if(ind == n) {
            if(s == cs) {
                System.out.println(ds);
            }
            return;
        }
        //pick the index.
        ds.add(a[ind]);
        cs += a[ind];
        print(ind + 1, ds, a, s, cs);
        ds.remove(ds.size() - 1);
        cs -= a[ind];
        //not picking the index.
        print(ind + 1, ds, a, s, cs);
    }
    // this function prints only one sub sequence where sum == 2.
    static boolean printone(int ind, ArrayList<Integer> ds, int[] a, int s, int cs) {
        int n = a.length;
        if(ind == n) {
            if(s == cs) {
                System.out.print(ds);
                return true;
            }
            else return false;
        }
        //pick case
        ds.add(a[ind]);
        cs += a[ind];
        if(printone(ind + 1, ds, a, s, cs) == true) return true;
        ds.remove(ds.size() - 1);
        cs -= a[ind];
        //not pick case
        if(printone(ind + 1, ds, a, s, cs) == true) return true;
        return false;
    }
    static int printcount(int ind, int[] a, int s, int cs) {
        int n = a.length;
        if(ind == n) {
            if(s == cs) return 1;
            else return 0;
        }
        // pick case
        cs += a[ind];
        int l = printcount(ind + 1, a, s, cs);
        cs -= a[ind];
        // not pick case
        int r = printcount(ind + 1, a, s, cs);
        return l + r;
    }
    public static void main(String[] args) {
        int[] a = {1,2,1};
        int sum = 2;
        ArrayList<Integer> ds = new ArrayList<Integer>();
        int count = printcount(0,a,sum,0);
        System.out.println(count);
    }
}