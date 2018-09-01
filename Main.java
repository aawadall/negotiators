package ca.aawadall.chapter4;


public class Main {

    public static void main(String[] args) {
        // write your code here
        Environment env = new SimpleEnvironment();
        Agent agent1 = new SimpleAgent();
        Agent agent2 = new SimpleAgent();
        for (int turn = 0; turn < 10; turn++) {
            env.print();
            System.out.println("Agent 1 Plays");
            agent1.guess(env);
            System.out.println("Agent 2 Plays");
            agent2.guess(env);
        }
        env.print();


    }
}
