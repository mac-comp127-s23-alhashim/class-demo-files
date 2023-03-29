package src.polymorphism;

public class Test {
    public static void main(String[] args) {
        // A a = new A();
        // a.action();

        A a = new B();
        a.action();

        a = new C();
        a.action();

        // ====================================================================
        // B b = new A();
        // b.action();

        B b = new B();
        b.action();

        b = new C();
        b.action();

        // ====================================================================
        // C c = new A();
        // c.action();
        
        // c = new B();
        // c.action();
        
        C c = new C();
        c.action();
    }
}
