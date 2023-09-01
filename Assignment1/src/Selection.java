package src;

public class Selection {
    public static void sort(Integer[] arr,int n){
        int min;
        int max;
        for(int i=0;i<n-1;i++){
            min = i;
            max = i;
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[min]) {
                    min = j;
                }
                else if(arr[j] > arr[max]) {
                    max = j;
                }
            }

            if (min!=i){
                swap(arr,min,i);
            }

        }
    }
    public static void swap(Integer[] arr, int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
