package Lesson1;

public class Task1 {
    public static void main(String[] args) {

        int a = 2;
        int b = 20;
        int c = 3;
        int d = 2;

        int y = a;
        while (y < b) {
            y += c;
        }

        if (a > b) {
            System.out.println("Решений нет");
        }

        else if (a == b) {
            System.out.println("Всего решений: 1");
        }

        if (y > b) {
            System.out.println("Решений нет");
        }

        else {
            int count = 1;
            for (int i = a; i <= b; i += d) {
                int x = 0;
                if (i % c == 0) {
                    count++;
                    x = i / c;

                    if (x % c == 0) {
                        count++;
                    }
                }
            }
            System.out.printf("Всего решений: %d\n", count);

            System.out.println("Наборы комманд:");
            for (int j = 1; j < 3; j++) {
                int num = b;
                switch (j) {
                    case 1:
                        while (num > 0) {
                            num -= d;
                            System.out.print("k2, ");
                        }
                        System.out.println();
                        break;
                    case 2:
                        while (num > 0) {
                            if (num % c == 0) {
                                System.out.print("k1, ");
                                num /= c;
                            } else {
                                num -= d;
                                System.out.print("k2, ");
                            }
                        }
                        break;
                }
            }
        }
    }
}
