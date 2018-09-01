package ca.aawadall.chapter4;

import java.util.Random;


/**
 * Simple negotiation agent, using monomial
 */
public class SimpleAgent implements Agent {
    private static final int maxOrder = 7;
    private double alpha; // Stubborn factor (inverse)
    private int order; // monomial order
    private double[] coeff; // monomial coefficients
    private String agentType = "Simple Agent";
    /**
     * Randomly generated simple agent
     */
    public SimpleAgent() {
        Random rand = new Random();
        this.order = rand.nextInt(maxOrder) + 1;
        this.alpha = rand.nextFloat();

        this.alpha = Math.pow(this.alpha / 20, this.order);
        this.coeff = new double[order];
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
        System.out.println(agentType + ": Guessing Next Value");
        learn(env);
        env.submitGuess(calculate(env));

    }

    /**
     * fit curve, find next step
     *
     * @param env
     */
    private void learn(Environment env) {
        System.out.println(agentType + ": Learning to guess new value");

        double[] trace = env.getTrace();

        System.out.println(agentType + ": Order = " + order);
        for (int idx = 0; idx < trace.length; idx++) {
            for (int pwr = 0; pwr < order; pwr++) {

                coeff[pwr] -= -alpha * (trace[idx] - calculate(idx));
            }
            //System.out.println( idx + " ->" + calculate(idx) + " actual:" + trace[idx]);
        }

    }

    /**
     * similar to forward propagation
     * @param env
     * @return
     */
    private double calculate(Environment env) {
        double[] trace = env.getTrace();
        return calculate(trace.length);

    }

    /**
     * Calculates value of a sequence entry based on coefficients
     *
     * @param seq double representing index
     * @return value predicted
     */
    private double calculate(double seq) {
        double output = 0d;
        for (int pwr = 0; pwr < order; pwr++) {

            output += Math.pow(seq, pwr) * this.coeff[pwr];
        }
        return output;
    }
}
