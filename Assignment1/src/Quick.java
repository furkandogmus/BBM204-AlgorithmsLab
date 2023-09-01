package src;

public class Quick  {
    public static void sort(Integer[] arr, int l, int r)
    {
        while(l<r)
        {
            int q=partition(arr,l,r);
            if (q-l <= r-(q+1))
            {
                sort(arr,l,q);
                l=q+1;
            }
            else
            {
                sort(arr,q+1,r);
                r=q;
            }
        }
    }
    private static int partition(Integer[] arr, int l, int r) {

        int x = arr[l],i=l,j=r;
        while (true) {
            do {
                i++;
            } while (i < r && arr[i] < x);
            do {
                j--;
            } while (j > l && arr[j] > x);

            if (i < j) {
                swap(arr,i,j);
                i++;
                j--;
            } else {
                return j;
            }
        }
    }

    public static void swap(Integer[] arr, int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
