package ca.aawadall.ai;

import java.util.Random;

/**
 * This Agent has an objective to reach
 */
public class ObjectiveAgent implements Agent {

    private double objective;  // Target value this agent wants to achieve
    private double valueOfLife; // Some parameter to specify when this agent will quit negotiating
    private int life; // an internal clock measuring life of this agent
    private double grace; // in 1 .. infinity (exclusive), how tolerant the agent is
    private double tolerance; // how far off from original value is this agent willing to accept the deal
    /**
     * Initializes a new Objective Driven Agent
     * @param objective target value to optimize negotiations towards
     * @param valueOfLife value of time, when the agent will get bored
     */
    public ObjectiveAgent(double objective, double valueOfLife) {
        Random rand = new Random();
        this.objective = objective;
        this.valueOfLife = valueOfLife;
        this.life = 0;
        this.grace = rand.nextFloat() + 1;
        this.tolerance = rand.nextDouble();
    }

    @Override
    public void guess(Environment env) {
        this.life++; // Advance internal clock
        if( Math.abs(calculateBid(env) - env.getLastBid()) <= this.tolerance)
        {
            System.out.println("I agree");
            env.agree();
        }
        else
        {
            System.out.println("Not fair, I bid "+calculateBid(env));
            env.bid(calculateBid(env));
        }

    }

    /**
     * Cost function
     * @return penality as a function of time value and internal clock value
     */
    private double getPenalty(){
        // Simple implementation as a linear function
        return this.life * this.valueOfLife;
    }

    /**
     * calculate next bid based on other agent bid and cost function
     * @param env is the environment containing the stack of bids
     * @return suggested bid
     */
    private double calculateBid(Environment env) {
        // Simple method, make bid = lastAgentBid + (desired - lastAgentBid) / const^costFunction

        double lastBid = env.getLastBid();
        return lastBid + (this.objective - lastBid) / Math.pow(this.grace, getPenalty());
    }
}
