package com.javarush.task.task21.task2113;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hippodrome {
    private List<Horse> horses = new ArrayList();
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }


    public void run() throws InterruptedException {
        int count = 1;
        while (count <= 100) {
            move();
            print();
            Thread.sleep(200);
            count++;
        }

    }

    public Horse getWinner() {
        if ( horses.size() > 0) {
            double maxDistance = 0.;
            for (Horse horse : horses) {
                if (horse.getDistance() > maxDistance) maxDistance = horse.getDistance();
            }

            for (Horse horse : horses) {
                if (horse.getDistance() == maxDistance) return horse;
            }
        }
        return null;
    }

    public void printWinner() {
        if ( horses.size() > 0) {
            //System.out.println("Winner is " + game.getWinner().getName() + "!");  не прошел!!
            System.out.printf("Winner is %s!%n",getWinner().getName());
        }

    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList());
        //  лошади пошли
        game.getHorses().add(new Horse("Black", 3, 0));
        game.getHorses().add(new Horse("Red", 3, 0));
        game.getHorses().add(new Horse("GrayInApples", 3, 0));
    /**    красиво ! увидел в обсуждении
        game = new Hippodrome(Stream.of(
                new Horse("Billy", 3, 0),
                new Horse("Jelly", 3, 0),
                new Horse("Roadster", 3, 0)
        ).collect(Collectors.toList()));
    */

        game.run();
        game.printWinner();


    }
}
