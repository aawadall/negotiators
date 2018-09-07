package ca.aawadall.ai;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int iterations = 1000;
        Environment env = new SimpleEnvironment( 1, iterations);
        Agent agent1 = new ObjectiveAgent(1000, 1.5);
        Agent agent2 = new ObjectiveAgent(-1000, 1.5);
        for (int turn = 0; turn < 99; turn++) {
            env.print();
            System.out.println("Agent 1 Plays");
            agent1.guess(env);
            System.out.println("Agent 2 Plays");
            agent2.guess(env);
        }
        env.print();


    }
}
