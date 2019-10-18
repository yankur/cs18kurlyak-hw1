package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testAverageEmptyArray() throws IllegalArgumentException {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.average();
    }

    @Ignore
    @Test
    public void testAverageOneElementArray() {
        double[] temperatureSeries = {3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.7416573867739;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testDeviationOneElementArray() {
        double[] temperatureSeries = {3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testDeviationEmptyArray() throws IllegalArgumentException {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();
    }

    @Ignore
    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testMinEmptyArray() throws IllegalArgumentException {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }

    @Ignore
    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testMaxEmptyArray() throws IllegalArgumentException {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();
    }

    @Ignore
    @Test
    public void testTempClosestToZero() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testTempClosestToValue() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(4.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testTempsLessThan() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[] {-5.0};

        double[] actualResult = seriesAnalysis.findTempsLessThen(0.5);

        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Ignore
    @Test
    public void testTempsGreaterThan() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[] {3.0, 1.0, 5.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(0.5);

        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Ignore
    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double avgTemp = 1.0;
        double devTemp = 3.7416573867739413;
        double minTemp = -5.0;
        double maxTemp = 5.0;

        TempSummaryStatistics expResult = new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();

        assertTrue(expResult.getAvgTemp() == actualResult.getAvgTemp()
                    && expResult.getDevTemp() == actualResult.getDevTemp()
                    && expResult.getMinTemp() == actualResult.getMinTemp()
                    && expResult.getMaxTemp() == actualResult.getMaxTemp());
    }

    @Ignore
    @Test
    public void testTempSummaryStatisticsEmptyConstructor() {
        TempSummaryStatistics tss = new TempSummaryStatistics();
    }

    @Ignore
    @Test
    public void testAddTempsNoFreeCapacity() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] toAdd = {1.0, 2.0};
        int expResult = 6;

        int actualResult = seriesAnalysis.addTemps(toAdd);
        assertEquals(expResult, actualResult);
    }
}
