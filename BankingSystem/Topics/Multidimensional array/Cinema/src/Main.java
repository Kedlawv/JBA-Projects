import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nRows = scanner.nextInt();
        int nSeats = scanner.nextInt();
//        int nRows = 3;
//        int nSeats = 4;

        int[][] cinema = new int[nRows][nSeats];
//        int[][] cinema = {
//                {0, 1, 0, 1},
//                {1, 1, 0, 1},
//                {1, 0, 0, 1}
//        };

        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                cinema[i][j] = scanner.nextInt();
            }
        }

        int reqNumSeats = scanner.nextInt();
//        int reqNumSeats = 2;
        int consNumSeats = 0;

        for (int i = 0; i < cinema.length; i++) {
            int[] row = cinema[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {
                    for (int k = j; k < row.length; k++) {
                        if (row[k] == 0) {
                            consNumSeats++;
                        } else {
                            j = k + 1;
                            break;
                        }
                    }
                    if (consNumSeats >= reqNumSeats) {
                        System.out.println(i + 1);
                        return;
                    } else {
                        consNumSeats = 0;
                    }
                }
            }
        }
        System.out.println(0);
    }
}