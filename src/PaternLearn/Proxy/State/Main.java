package PaternLearn.Proxy.State;

public class Main {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine("Moskva" , 5);
        gumballMachine.refill(6);
        GumballMonitor monitor = new GumballMonitor(gumballMachine);
        System.out.println("Тестируем монитор:");
        monitor.report();

        System.out.println("\nТратим денежки");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("\nТестируем монитор");

        /*

        int count = 0;
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }
        count = Integer.parseInt(args[1]);
        gumballMachine = new GumballMachine(args[0], count);

         */

        // rest of test code here
        monitor.report();
    }
}
