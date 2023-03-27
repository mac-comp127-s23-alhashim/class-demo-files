package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import stream.Dish.Type;

import java.util.Comparator;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Want to get the dishes with low calogies sorted starting from lowest
 * Source: Raoul-Gabriel Urma, Mario Fusco, Alan Mycroft (2018) Modern Java in Action: Lambda, streams, functional and reactive programming-Manning (Chapter 4: Introduction to Streams)
 */

 class Dish {
    private final String name;
    private final int calories;
    private final Type type;

    public Dish(String name, int calories, Type type) {
        this.name = name;
        this.calories = calories;
        this.type = type;
    }

    int getCalories() {
        return this.calories;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return getType() + ":" + getName() + ":" + getCalories();
    }

    public enum Type {MEAT, FISH, OTHER}
}

class Prep {
    public static List<Dish> getMenu() {
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("A", 500, Type.FISH));
        menu.add(new Dish("B", 100, Type.MEAT));
        menu.add(new Dish("C", 50, Type.OTHER));
        menu.add(new Dish("D", 500, Type.FISH));
        return menu;
    }
}


class SteamTest_NoStreams {
    public static void main(String[] args) {
        List<Dish> menu = Prep.getMenu();
        System.out.println("Full Menu: " + menu.toString());
        
        // get the low calogies dishes
        List<Dish> lowCaloriesdishes = new ArrayList<>();
        for(Dish dish : menu) {
            if(dish.getCalories() < 400) {
                lowCaloriesdishes.add(dish);
            }
        }
        System.out.println("Low Cal" + lowCaloriesdishes.toString());
        
        // sort them
        Collections.sort(lowCaloriesdishes, new Comparator<Dish>() {
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });
        System.out.println("Sorted Low Cal: " + lowCaloriesdishes.toString());
        
        // get the names
        List<String> lowCaloriesDishesName = new ArrayList<>();
        for(Dish dish : lowCaloriesdishes) {
            lowCaloriesDishesName.add(dish.getName());
        }
        
        System.out.println("Sorted Low Cal Names: " + lowCaloriesDishesName.toString());
    }
}


class StreamTest_Stream {
    public static void main(String[] args) {
        List<Dish> menu = Prep.getMenu();
        System.out.println("Full Menu: " + menu.toString());
        
        List<String> lowCaloriesDishesName = 
        menu.stream()
        .filter(d -> d.getCalories() < 400)
        .sorted(comparing(Dish::getCalories))
        .map(Dish::getName)
        .collect(toList());
        
        System.out.println("Sorted Low Cal Names: " + lowCaloriesDishesName.toString());
    }
}


class StreamTest_StreamParallel {
    public static void main(String[] args) {
        List<Dish> menu = Prep.getMenu();
        System.out.println("Full Menu: " + menu.toString());
        
        List<String> lowCaloriesDishesName = 
        menu.parallelStream() // this waht makes it parallel
        .filter(d -> d.getCalories() < 400)
        .sorted(comparing(Dish::getCalories))
        .map(Dish::getName)
        .collect(toList());
        
        System.out.println("Sorted Low Cal Names: " + lowCaloriesDishesName.toString());
    }
}


/*
 * Testing the order in which stream execute the intermediate operations
 * TRY: commenting some of the intermediate operations such as sort and notice
 *      the order of operations--the Stream library is performing some optimizations
 */
class StreamTest_Stream2 {
    public static void main(String[] args) {
        List<Dish> menu = Prep.getMenu();
        System.out.println("Full Menu: " + menu.toString());
        
        List<String> lowCaloriesDishesName = 
        menu.stream()
        .filter(d -> {
            System.out.println("F::" + d);
            return d.getCalories() < 400;})
        // .sorted(comparing(d -> {
            //     System.out.println("S::" + d);
        //     return d.getCalories();}))
        .map(d -> {
            System.out.println("M::" + d);
            return d.getName();})
        .limit(3)
        .collect(toList());
        
        System.out.println("Sorted Low Cal Names: " + lowCaloriesDishesName.toString());
    }
}

/*
 * Using the termianl operation forEach to print the results directly
 */
class StreamTest_Stream3 {
    public static void main(String[] args) {
        List<Dish> menu = Prep.getMenu();
        System.out.println("Full Menu: " + menu.toString());
        
        menu.stream()
        .filter(d -> d.getCalories() < 400)
        .sorted(comparing(Dish::getCalories))
        .map(Dish::getName)
        .forEach(System.out::println);        
    }
}