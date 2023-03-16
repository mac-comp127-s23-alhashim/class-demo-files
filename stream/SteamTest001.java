package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Want to get the dishes with low calogies sorted starting from lowest
 * Source: Raoul-Gabriel Urma, Mario Fusco, Alan Mycroft (2018) Modern Java in Action: Lambda, streams, functional and reactive programming-Manning (Chapter 4: Introduction to Streams)
 */

 class Dish {
    private String name;
    private int calories;

    public Dish(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    int getCalories() {
        return this.calories;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() + ":" + getCalories();
    }
}

class Prep {
    public static List<Dish> getMenu() {
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("A", 500));
        menu.add(new Dish("B", 100));
        menu.add(new Dish("C", 50));
        menu.add(new Dish("D", 500));
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