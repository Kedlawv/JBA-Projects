class Problem {
    public static void main(String[] args) {
        int testOccurrences = 0;
        int testIndex = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("test")) {
                testOccurrences++;
                testIndex = i;
            }
        }

        if (testOccurrences == 1 || testOccurrences == 0) {
            System.out.println(testIndex);
        } else {
            System.out.println("Problem description unclear");
        }
    }
}