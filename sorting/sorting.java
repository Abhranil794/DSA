public class main {
    public static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    public static void bubbleSort(int[] a) {
        for(int i=0;i<a.length-1;i++) {
            boolean swapped = false;
            for (int j=0;j<a.length-1;j++) {
                if (a[j]>a[j+1]) {
                    swap(a,j,j+1)
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    public static void selectionSort(int[] a) {
        for (int i=0;i<a.length;i++) {
            int minIdx = i;
            for(int j=i+1;j<a.length;i++) {
                if(a[i]>a[j]) {
                    minIdx = j;
                }
            }
            swap(a,i,minIdx);
        }
    }
    public static void main(String[] args) {
        int[] a = {2,10,8,7};
        bubbleSort(a);
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+ " ");
        }
    }
}