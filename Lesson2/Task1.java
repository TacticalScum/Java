package Lesson2;

public class Task1 {
    public static void main(String[] args) {
        
        int n = 8;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}