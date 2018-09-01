package ca.aawadall.chapter4;

import java.util.Random;

import Jama.*;

/**
 * Simple negotiation agent, using monomial
 */
public class SimpleAgent implements Agent {
    private static final int maxOrder = 7;
    private double alpha; // Stubborn factor (inverse)
    private int order; // monomial order
    private double[] coeff; // monomial coefficients

    /**
     * Randomly generated simple agent
     */
    public SimpleAgent() {
        Random rand = new Random();
        this.order = rand.nextInt(maxOrder);
        this.alpha = rand.nextFloat();

        // Build coefficients
        for (int idx = 0; idx < this.order; idx++)
            this.coeff[idx] = rand.nextDouble();
    }


    /**
     * Given an environment, the agent will pull data points from its trace and attempt to enhance its model
     *
     * @param env
     */
    @Override
    public void guess(Environment env) {
        learn(env);
        env.submitGuess(calculate(env));

    }

    private void learn(Environment env) {
        double[] trace = env.getTrace();
        double[][] input = new double[trace.length][order];
        double[][] seq = new double[trace.length][1];
        double[][] thetaArray = new double[coeff.length][1];
        for (int traceIdx = 0; traceIdx < trace.length; traceIdx++) {
            seq[traceIdx][0] = traceIdx;
            for (int pwr = 0; pwr < order; pwr++) {
                input[traceIdx][pwr] = Math.pow(trace[traceIdx], pwr);
                thetaArray[pwr][0] = coeff[pwr];
            }

        }
        Matrix X = new Matrix(input);
        Matrix b = new Matrix(seq);
        Matrix oldTheta = new Matrix(thetaArray);
        Matrix newTheta = X.transpose().solve(b);
        newTheta = newTheta.times(alpha).plus(oldTheta.times(1 - alpha));


        for (int idx = 0; idx < order; idx++)
            coeff[idx] = newTheta.get(idx, 0);

    }

    private double calculate(Environment env) {
        double[] trace = env.getTrace();
        double result = 0;
        for (int idx = 0; idx < order; order++)
            result += Math.pow(trace[trace.length - 1], idx);
        return result;
    }
}
