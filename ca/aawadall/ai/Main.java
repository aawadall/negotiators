package ca.aawadall.ai;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int iterations = 1000;
        Environment env = new SimpleEnvironment( 1, iterations);
        Agent agent1 = new ObjectiveAgent(100, random.nextDouble());
        Agent agent2 = new ObjectiveAgent(-100, random.nextDouble());
        //for (int turn = 0; turn < 99 || !env.isAgreed(); turn++) {
        int nextPlayer = 1;
        while(!env.isAgreed())
        {
            System.out.print(env.isAgreed());
            System.out.println(env.getLastBid());
            System.out.print("Agent " + nextPlayer+ " plays: ");
            if (nextPlayer == 1)
                agent1.guess(env);
            else
                agent2.guess(env);


            nextPlayer = nextPlayer == 1 ? 2 : 1;

            System.out.println();
        }
        //env.print();


    }
}
