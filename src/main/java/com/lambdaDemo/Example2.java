package com.lambdaDemo;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Alin
 * 使用Lambdas排序集合
 */
public class Example2 {

    public static void main(String[] args) {

        String[] players = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner"};

        // Show the list of players
        System.out.print("Show the list of players:\n");
        Arrays.asList(players).forEach((player) -> System.out.println(player));

        // 1.1 使用匿名内部类根据 name 排序 players 
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });

        // 1.2 使用 lambda expression 排序 players 
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);
        // or this
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));

        System.out.print("\nShow the list of players after sorting by name:\n");
        Arrays.asList(players).forEach((player) -> System.out.println(player));

        // 1.1 使用匿名内部类根据 surname 排序 players 
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
            }
        });

        // 1.2 使用 lambda expression 排序,根据 surname  
        Comparator<String> sortBySurname = (String s1, String s2) -> (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
        Arrays.sort(players, sortBySurname);
        // or this
        Arrays.sort(players, (String s1, String s2) -> (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" ")))));

        System.out.print("\nShow the list of players after sorting by surname:\n");
        Arrays.asList(players).forEach((player) -> System.out.println(player));

        //  2.1 使用匿名内部类根据 name lenght 排序 players 
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.length() - s2.length());
            }
        });

        // 2.2 使用 lambda expression 排序,根据 name lenght 
        Comparator<String> sortByNameLenght = (String s1, String s2) -> (s1.length() - s2.length());
        Arrays.sort(players, sortByNameLenght);
        // or this
        Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));

        System.out.print("\nShow the list of players after sorting by length:\n");
        Arrays.asList(players).forEach((player) -> System.out.println(player));

        // 3.1 使用匿名内部类排序 players, 根据最后一个字母 
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
            }
        });

        // 3.2 使用 lambda expression 排序,根据最后一个字母
        Comparator<String> sortByLastLetter = (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
        Arrays.sort(players, sortByLastLetter);
        // or this
        Arrays.sort(players, (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)));

        System.out.print("\nShow the list of players after sorting by last letter:\n");
        Arrays.asList(players).forEach((player) -> System.out.println(player));
    }

}
