package ca.aawadall.ai;

/**
 * Exposes typical environment methods
 */
public interface Environment {
    /**
     * used to get populated portion of the negotiation trace
     *
     * @return populated sub-array of negotiation array
     */
    double[] getTrace();

    /**
     * used to submit a guess at the end of the negotiation trace
     *
     * @param guess agent's guess
     */
    void submitGuess(double guess);

    /**
     * used to reset an environment
     *
     * @param seed      number of random seeds
     * @param maxLength maximum length of negotiation array
     */
    void initialize(int seed, int maxLength);

    /**
     * prints visible trace
     */
    void print();
}
