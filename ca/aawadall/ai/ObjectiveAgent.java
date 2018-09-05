package ca.aawadall.ai;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * This Agent has an objective to reach
 */
public class ObjectiveAgent implements Agent {

    private double objective;
    private double valueOfLife;
    private int life;

    /**
     * Initializes a new Objective Driven Agent
     * @param objective target value to optimize negotiations towards
     * @param valueOfLife value of time, when the agent will get bored
     */
    public ObjectiveAgent(double objective, double valueOfLife) {
        this.objective = objective;
        this.valueOfLife = valueOfLife;
        this.life = 0;
    }

    @Override
    public void guess(Environment env) {
        //TODO: not implemented yet
        throw new NotImplementedException();
    }

    //TODO: Define objective function
    //TODO: Define learning function utilizing objective
    //TODO: Define
}
