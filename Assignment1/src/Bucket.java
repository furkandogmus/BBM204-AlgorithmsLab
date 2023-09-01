package src;

import java.util.Collections;
import java.util.Vector;

public class Bucket {

    static int[] sort(Integer arr[])
    {

        int max = -1;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        int numberOfBuckets = (int) Math.sqrt(arr.length);
        Vector<Integer>[] buckets = new Vector[numberOfBuckets];

        for (int i = 0; i < numberOfBuckets; i++) {
            buckets[i] = new Vector<Integer>();
        }

        for (int i:arr){
            buckets[hash(i,max,numberOfBuckets)].add(i);
        }

        for (int i = 0; i < numberOfBuckets; i++) {
            Collections.sort(buckets[i]);
        }
        int index = 0;
        int[] sortedArr = new int[arr.length];
        for (int i = 0; i <numberOfBuckets ; i++) {
            for (int j = 0 ; j < buckets[i].size(); j++) {
                sortedArr[index++] = buckets[i].get(j);

            }
        }
        return sortedArr;
    }
    private static int hash(int i, int max, int numberOfBuckets) {
        return (int) Math.floor((double)i / (double)max * (double)(numberOfBuckets-1) );
    }
}
