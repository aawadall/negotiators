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
    double[] getBidsTrace();

    /**
     * used to get last bid
     * @return latest bid from bids trace
     */
    double getLastBid();

    /**
     * used to submit a guess at the end of the negotiation trace
     *
     * @param guess agent's guess
     */
    void bid(double guess);

    /**
     * used to declare agreement
     */
    void agree();

    /**
     * inquires on agreement status
     * @return agreement status true for agreement and false for disagreement
     */
    boolean isAgreed();

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
