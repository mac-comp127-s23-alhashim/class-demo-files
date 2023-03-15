package lambdaexp;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntConsumer;

interface MyI {
    void myIMethod(int i);
}

class MyC {
    void myCMethod(int i, MyI mi) {
        mi.myIMethod(i);
    }
}

class MyIC implements MyI {
    @Override
    public void myIMethod(int n) {
        System.out.println(n);
    }
}

class Tester {
    public static void main(String[] args) {
        MyI myI = new MyIC();

        MyC myC = new MyC();
        myC.myCMethod(10, myI);
    }
}

class TesterLE {
    public static void main(String[] args) {
        MyC myC = new MyC();
        myC.myCMethod(10, (int n) -> { 
            System.out.println(n);
        });
    }
}

class TesterLE2 {
    public static void main(String[] args) {
        MyC myC = new MyC();
        myC.myCMethod(10, (n) -> { 
            System.out.println(n);
        });
    }
}

class TesterLE3 {
    public static void main(String[] args) {
        MyC myC = new MyC();
        myC.myCMethod(10, n -> { 
            System.out.println(n);
        });
    }
}

class TesterLE4 {
    public static void main(String[] args) {
        MyC myC = new MyC();
        myC.myCMethod(10, n -> 
            System.out.println(n)
        );
    }
}

class TesterLE5 {
    public static void main(String[] args) {
        MyC myC = new MyC();
        myC.myCMethod(10, n -> System.out.println(n));
    }
}

class TesterLE6 {
    public static void main(String[] args) {
        MyC myC = new MyC();
        myC.myCMethod(10, System.out::println);
    }
}


class TesterLE7 {
    public static void main(String[] args) {
        MyC myC = new MyC();
        MyI myI = n -> System.out.println(n);
        myC.myCMethod(10, myI);
        myC.myCMethod(5, myI);
    }
}


class MyC2 {
    void myCMethod(int i, IntConsumer iC) {
        iC.accept(i);
    }
}

class TesterLE8 {
    public static void main(String[] args) {
        MyC2 myC2 = new MyC2();
        myC2.myCMethod(10, n -> System.out.println(n));
    }
}

class MyC3 {
    void myCMethod(int x, Function<Integer, Integer> f) {
        System.out.println(f.apply(x));
    }
}

class TesterLE9 {
    public static void main(String[] args) {
        MyC3 myC3 = new MyC3();
        myC3.myCMethod(10, t -> 10*t);
    }
}

class MyC4 {
    void myCMethod(int x, int y, BiFunction<Integer, Integer, Integer> f) {
        System.out.println(f.apply(x, y));
    }
}

class TesterLE10 {
    public static void main(String[] args) {
        MyC4 myC4 = new MyC4();
        myC4.myCMethod(10, 20, (t, u) -> t*u);
    }
}

class MyC5 {
    void myCMethod(int x, BiFunction<Integer, Integer, Integer> f) {
        System.out.println(f.apply(x, x));
    }
}

class TesterLE11 {
    public static void main(String[] args) {
        MyC5 myC5 = new MyC5();
        myC5.myCMethod(10, (t, u) -> t*u);
    }
}