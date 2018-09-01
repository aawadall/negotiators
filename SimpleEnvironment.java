package ca.aawadall.chapter4;

import java.util.Random;
import java.util.Arrays;

/**
 * Simple environment implementation
 */
public class SimpleEnvironment implements Environment {
    private double[] trace;
    private int currentStep;

    public SimpleEnvironment(int seed, int maxLength) {
        this.initialize(seed, maxLength);
    }

    public SimpleEnvironment() {
        this(3, 100);
    }

    /**
     * Retrieves trace history to decide on the next step
     *
     * @return populated sub-array from the trace array
     */
    @Override
    public double[] getTrace() {
        return Arrays.copyOfRange(trace, 0, currentStep + 1);
    }

    /**
     * an agent uses this method to submit its guess of the correct next value
     *
     * @param guess agent's guess of the next value
     */
    @Override
    public void submitGuess(double guess) {
        if (currentStep < trace.length)
            trace[++currentStep] = guess;
    }

    /**
     * used to initialize or reset a simple environment
     *
     * @param seed      number of populated elements in trace, initialized through a random generator
     * @param maxLength maximum allowed size of the trace array
     */
    @Override
    public void initialize(int seed, int maxLength) {
        Random rand = new Random();
        trace = new double[maxLength];
        for (int idx = 0; idx < seed && idx < maxLength; idx++) {
            trace[idx] = rand.nextFloat();
            currentStep = idx;
        }

    }

    /**
     * prints populated portion of the trace array
     */
    @Override
    public void print() {
        System.out.println("Simple Environment Negotation Trace Values");
        for (double element : this.getTrace()) {
            System.out.println(element);
        }
    }
}