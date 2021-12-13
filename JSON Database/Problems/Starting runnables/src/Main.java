class Starter {

    public static void startRunnables(Runnable[] runnables) {
        // implement the method
        for(Runnable r : runnables){
            Thread th = new Thread(r);
            th.start();
        }
    }
}