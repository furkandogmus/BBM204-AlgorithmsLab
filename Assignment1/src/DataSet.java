package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class DataSet {
    String fileName;
    Integer[] data;
    public DataSet(String fileName){
        this.fileName = fileName;
    }

    public Integer[] getData() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src/TrafficFlowDataset.csv"));
        data = new Integer[251282];
        Arrays.fill(data,0);
        String x;
        int i = 0;
        bf.readLine();
        while ((x = bf.readLine()) != null) {
            if (x.split(",")[6] != null) {
                int res = Integer.parseInt(x.split(",")[6]);
                data[i++] = res;
            }}
            return data;


        }
    }
