public class Main {

    //Client
    public static void main(String[] args) {

        Broker broker = new Broker();
        Command buyCommand = new BuyCommand(new Stock());
        Command sellCommand = new SellCommand(new Stock());

        broker.setCommand(buyCommand);
        broker.executeCommand();

        broker.setCommand(sellCommand);
        broker.executeCommand();
    }
}

// Receiver
class Stock {

    public void buy() {
        System.out.println("Stock was bought");
    }

    public void sell() {
        System.out.println("Stock was sold");
    }
}

interface Command {
    void execute();
}

//Concrete commands
class BuyCommand implements Command {
    private Stock stock;

    public BuyCommand(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.buy();
    }
}

class SellCommand implements Command {
    private Stock stock;

    public SellCommand(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.sell();
    }
}

// Invoker
class Broker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}