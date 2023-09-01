package src;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SaveChart {

    public static void save(Integer[] Arr,String data) throws IOException {
        double[] xAxis = {512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};
        double[][] yAxis = new double[3][10];
        yAxis[0] = new double[10];
        yAxis[1] = new double[10];
        yAxis[2] = new double[10];

        System.out.println(data);
        for (int i = 0; i < 10; i++) {
            int size = (int) xAxis[i];
            Integer[] tempArr = new Integer[size];
            double avg = 0;

            for (int j = 0; j < 11; j++) {

                tempArr = Arrays.copyOf(Arr,size);
                Long clockIn = System.nanoTime();
                Quick.sort(tempArr,0,tempArr.length-1);
                Long clockOut = System.nanoTime();
                if (j != 0) {

                    avg += (((double) clockOut - (double) clockIn) / 1000000) / 10;
                }
            }
            System.out.print("Quick" +i+ ":" +avg+ "\n");
            yAxis[0][i] = avg;

            avg = 0;
            for (int j = 0; j < 11; j++) {

                tempArr = Arrays.copyOf(Arr,size);
                Long clockIn = System.nanoTime();
                Bucket.sort(tempArr);
                Long clockOut = System.nanoTime();
                if (j != 0) {

                    avg += (((double) clockOut - (double) clockIn) / 1000000) / 10;
                }
            }
            System.out.print("Bucket"+(i)+":" + avg + "\n");
            yAxis[1][i] = avg;
            avg = 0;

            for (int j = 0; j < 11; j++) {

                tempArr = Arrays.copyOf(Arr,size);
                Long clockIn = System.nanoTime();
                Selection.sort(tempArr,tempArr.length);
                Long clockOut = System.nanoTime();
                if (j != 0) {

                    avg += (((double) clockOut - (double) clockIn) / 1000000) / 10;
                }
            }
            System.out.print("Selection" +i+":"+ avg + "\n");
            yAxis[2][i] = avg;

        }
        Main.showAndSaveChart(data,xAxis,yAxis);
    }


    public static void save(Integer[] arr,Integer[] sortedArr) throws IOException {
        Random rd = new Random();
        double[] xAxis = {512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};
        double[][] yAxis = new double[3][10];
        yAxis[0] = new double[10];
        yAxis[1] = new double[10];
        yAxis[2] = new double[10];

        long avg = (long) 0;
        for(int j=0;j<10;j++){
            Integer[] tempArr = Arrays.copyOfRange(arr,0, (int) xAxis[j]);

            for(int i=0;i<1000;i++){
                long clockIn = System.nanoTime();
                SearchAlgorithms.linearSearch(tempArr,rd.nextInt(tempArr.length));
                long clockOut = System.nanoTime();
                avg += (clockOut-clockIn);
                }
            System.out.println("Test"+(j+1)+":"+(double)avg / (double)1000);
            yAxis[0][j] = (double)avg / (double)1000;
            }

        avg = 0;
        for(int j=0;j<10;j++){
            Integer[] tempArr = Arrays.copyOfRange(sortedArr,0, (int) xAxis[j]);

            for(int i=0;i<1000;i++){


                long clockIn = System.nanoTime();
                SearchAlgorithms.linearSearch(tempArr,rd.nextInt(tempArr.length-1));
                long clockOut = System.nanoTime();
                avg += (clockOut-clockIn);
            }
            System.out.println("Test"+(j+1)+":"+(double)avg / (double)1000);
            yAxis[1][j] = (double)avg / (double)1000;
        }
        avg = 0;
        for(int j=0;j<10;j++){

            Integer[] tempArr = Arrays.copyOfRange(sortedArr,0, (int) xAxis[j]);

            for(int i=0;i<1000;i++){

                long clockIn = System.nanoTime();
                SearchAlgorithms.binarySearch(tempArr,rd.nextInt(tempArr.length-1));
                long clockOut = System.nanoTime();
                avg += (clockOut-clockIn);
            }
            System.out.println("Test"+(j+1)+":"+(double)avg / (double)1000);
            yAxis[2][j] = (double)avg / (double)1000;
        }
        showAndSaveChart("Searching Algorithms",xAxis,yAxis);
        }

    public static void showAndSaveChart(String title, double[] xAxis, double[][] yAxis) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Nanoseconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries("LinearSearch(unsorted)", xAxis, yAxis[0]);
        chart.addSeries("LinearSearch(sorted)", xAxis, yAxis[1]);
        chart.addSeries("BinarySearch", xAxis, yAxis[2]);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }
    }

