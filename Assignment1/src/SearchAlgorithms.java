package src;

public class SearchAlgorithms {
    public static int linearSearch(Integer[] arr,int target){
        int res = -1;
        for(int i=0;i<arr.length;i++){

            if (arr[i] == target){
                res = i;
                break;
            }
        }
        return res;
    }

    public static int binarySearch(Integer[] arr, int target){
        int low = 0,high=arr.length-1;
        while(high-low>1){
            int mid = (high+low) /2;
            if (arr[mid]<target)
                low = mid +1;
            else
                high = mid;
        }
        if(arr[low] == target)
            return low;
        else if(arr[high]== target)
            return high;
        return -1;
    }
}
