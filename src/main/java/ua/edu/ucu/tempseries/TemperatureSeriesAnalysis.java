package ua.edu.ucu.tempseries;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.lang.Math;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    private int len;
    private int capacity;

    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[8];
        len = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) throws InputMismatchException {
        isValid(temperatureSeries);
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
        len = temperatureSeries.length;
        capacity = temperatureSeries.length;

    }
    private void isValid(double... temps) throws InputMismatchException() {
        for (double temp: temps) {
            if (temp < -273) {
                throw new InputMismatchException();
            }
        }
    }
    private void isEmpty() throws IllegalArgumentException {
        if (len == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double average() throws IllegalArgumentException() {
        isEmpty();
        double av = 0;
        for (int i = 0; i < len; i++) {
            av += (float) temperatureSeries[i];
        }
        return av/len;
    }

    public double deviation() throws IllegalArgumentException() {
        isEmpty();
        double av = average();
        double sgm = 0;
        for (int i = 0; i < len; i++){
            sgm += Math.pow((temperatureSeries[i] - av), 2);
        }
        sgm /= len;
        return Math.sqrt(sgm);
    }

    public double min() throws IllegalArgumentException() {
        isEmpty();
        double minim = temperatureSeries[0];
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] < minim) {
                minim = temperatureSeries[i];
            }
        }
        return minim;
    }

    public double max() throws IllegalArgumentException {
        isEmpty();
        int max = temperatureSeries[0];
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] > max) {
                max = temperatureSeries[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() throws IllegalArgumentException {
        isEmpty();
        double mod = Math.abs(temperatureSeries[0]);
        int ind;
        for (int i = 0; i < len; i++) {
            if (Math.abs(temperatureSeries[i]) < mod) {
                mod = temperatureSeries[i];
                ind = i;
            }
            else if (Math.abs(temperatureSeries[i]) == mod && temperatureSeries[i] > temperatureSeries[ind]) {
                mod = temperatureSeries[i];
                ind = i;
            }
        }
        return temperatureSeries[ind];
    }

    public double findTempClosestToValue(double tempValue) throws IllegalArgumentException {
        isEmpty();
        double mod = Math.abs(temperatureSeries[0] - tempValue);
        int ind = 0;
        for (int i = 0; i < len; i++) {
            if (Math.abs(temperatureSeries[i]) < mod) {
                mod = temperatureSeries[i];
                ind = i;
            }
        }
        return temperatureSeries[ind];
    }

    public double[] findTempsLessThen(double tempValue) throws IllegalArgumentException() {
        isEmpty();
        double[] output = new double[len];
        int curr = 0;
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] < tempValue) {
                output[curr++] = temperatureSeries[i];
            }
        }
        return Arrays.copyOfRange(output, 0, curr);
    }

    public double[] findTempsGreaterThen(double tempValue) throws IllegalArgumentException() {
        isEmpty();
        double[] output = new double[len];
        int curr = 0;
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] > tempValue) {
                output[curr++] = temperatureSeries[i];
            }
        }
        return Arrays.copyOfRange(output, 0, curr);
    }

    public TempSummaryStatistics summaryStatistics() throws IllegalArgumentException() {
        isEmpty();
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        isValid(temps);

        if (temps.length < len + temps.length) {
            int newSize = Math.max(len + temps.length, capacity * 2);
            double[] newTemperatures = new double[newSize];
            System.arraycopy(temperatureSeries,0, newTemperatures,0, temperatureSeries.length);
            temperatureSeries = newTemperatures;
            System.gc();
        }
        System.arraycopy(temps,0, temperatureSeries, len, temps.length);

        len += temps.length;

        return len;
    }
}
