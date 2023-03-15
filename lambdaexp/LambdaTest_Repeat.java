package lambdaexp;

public class LambdaTest_Repeat {
    public static void repeat(int n, Runnable action) {
        for(int i=0; i<n; i++) {
            action.run();
        }
    }

    public static void main(String[] args) {
        repeat(6, () -> {
            System.out.println("Hello World");
        });
    }
}
