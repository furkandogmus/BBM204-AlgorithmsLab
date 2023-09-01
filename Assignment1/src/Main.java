package src;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {

        DataSet dataSet = new DataSet(args[0]);
        Integer[] data = dataSet.getData();
        Integer[] sortedData = data;
        Arrays.sort(sortedData);
        SaveChart.save(data,sortedData);
        // Sorting
        SaveChart.save(data,"Random Data");
        Arrays.sort(data);
        SaveChart.save(data,"Sorted Data");
        Arrays.sort(data, Collections.reverseOrder());
        SaveChart.save(data,"Reversly Sorted Data");

    }
    public static void showAndSaveChart(String title, double[] xAxis, double[][] yAxis) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries("QuickSort", xAxis, yAxis[0]);
        chart.addSeries("BucketSort", xAxis, yAxis[1]);
        chart.addSeries("SelectionSort", xAxis, yAxis[2]);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }











    public static void swap(int[] arr, int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


}
