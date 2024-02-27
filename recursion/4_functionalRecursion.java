class HelloWorld {
    static void reverse(int[] a, int i) {
        int n = a.length;
        if(i >= n/2) return;
        int temp = a[i];
        a[i] = a[n-1-i];
        a[n-1-i] = temp;
        reverse(a, i+1);
    }
    static boolean isPal(int[] a, int i) {
        int n = a.length;
        if(i >= n/2) return true;
        if(a[i] != a[n-1-i]) return false;
        return isPal(a,i+1);
    }
    static boolean isPalString(String s, int i) {
        int n = s.length();
        if(i >= n/2) return true;
        if(s.charAt(i) != s.charAt(n-1-i)) return false;
        return isPalString(s, i+1);
    }
    public static void main(String[] args) {
        int[] a = {1,1,2,1,1};
        String s = "MADaM";
        // reverse(a, 0);
        // for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
        System.out.print(isPalString(s,0));
    }
}