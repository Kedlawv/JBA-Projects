class MessageNotifier extends Thread {

    // write fields to store variables here
    private final String message;
    private final int repetitions;

    public MessageNotifier(String msg, int repeats) {
        // implement the constructor
        this.message = msg;
        this.repetitions = repeats;
    }

    @Override
    public void run() {
        // implement the method to print the message stored in a field
        for (int i = 1; i <= repetitions; i++) {
            System.out.println(message);
        }
    }
}