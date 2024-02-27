import java.util.*;
public class HelloWorld
{
    static void subsequense(int[] a, ArrayList<Integer> ds, int ind) {
        int n = a.length;
        if (ind == n) {
            System.out.println(ds);
            return;
        }
        subsequense(a, ds, ind + 1);
        ds.add(a[ind]);
        subsequense(a, ds, ind + 1);
        ds.remove(ds.size() - 1);
    }
    public static void main(String[] args) {
	int[] a = {3,1,2};
	ArrayList<Integer> ds = new ArrayList<Integer>();
        subsequense(a,ds,0);
    }
}