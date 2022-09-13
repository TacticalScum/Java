package Lesson3;

public class Task1 {
    public static void main(String[] args) {
        playHanoi(5, "1", "2", "3");
    }

    private static void playHanoi(int n, String from, String other, String to) {
        if (n == 0)
            return;
        if (n > 0) {
            playHanoi(n - 1, from, to, other);
            System.out.printf("Переносим диск со стержня %s на стержень %s \n", from, to);
            playHanoi(n - 1, other, from, to);
        }

    }
}
