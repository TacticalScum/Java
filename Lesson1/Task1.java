package Lesson1;

public class Task1 {
    public static void main(String[] args) {

        int a = 2;
        int b = 20;
        int c = 2;
        int d = 3;

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
            for (int i = a; i <= b; i += c) {
                int x = 0;
                if (i % d == 0) {
                    count++;
                    x = i / d;

                    if (x % d == 0) {
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
                            num -= c;
                            System.out.print("k1, ");
                        }
                        System.out.println();
                        break;
                    case 2:
                        while (num > 0) {
                            if (num % d == 0) {
                                System.out.print("k2, ");
                                num /= d;
                            } else {
                                num -= c;
                                System.out.print("k1, ");
                            }
                        }
                        break;
                }
            }
        }
    }
}
