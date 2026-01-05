package com.rosokha;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static final String DATA = "src\\com\\rosokha\\BoardGame.csv";

    public static void main(String[] args) {
        BoardGame game = new BoardGame();
        List<BoardGame> listGames = null;
        try {
            listGames = game.loadFromCsv(Paths.get(DATA), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //task1(listGames);
        //task2(listGames);
        //task3(listGames);
        //task4(listGames);
        //task5(listGames);
        //task6(listGames);
        task7(listGames);
    }

    public static void task1(List<BoardGame> listGames) {
        listGames.stream()
                .filter(g -> g.getRatingAverage() > 8.0)
                .filter(g -> g.getComplexityAverage() < 2.0)
                .map(BoardGame::getName)
                .forEach(System.out::println);
    }

    public static void task2(List<BoardGame> listGames) {
        listGames.stream()
                .filter(g -> g.getMinAge() > 15)
                .map(BoardGame::getName)
                .forEach(System.out::println);
    }

    public static void task3(List<BoardGame> listGames) {
        listGames.stream()
                .filter(g -> g.getMaxPlayers() >= 10)
                .forEach(g -> System.out.println("Name: " + g.getName() + "\tMax players: " + g.getMaxPlayers()));
    }

    public static void task4(List<BoardGame> listGames) {
        Long sum = listGames.stream().mapToLong(BoardGame::getPlayTime).sum();
        Long amount = listGames.stream().count();
        System.out.println("Average play time for all the games is: " + sum / amount);
    }

    public static void task5(List<BoardGame> listGames) {
        List<BoardGame> mostComplexGames = listGames.stream()
                .sorted(Comparator.comparing(BoardGame::getComplexityAverage).reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top 5 games by complexity:");
        mostComplexGames.forEach(g -> System.out.println("Name: " + g.getName() + "\tMax players: " + g.getComplexityAverage()));
    }

    public static void task6(List<BoardGame> listGames) {
        Map<Integer, List<BoardGame>> gamesByYears = listGames.stream()
                .collect(Collectors.groupingBy(BoardGame::getYearPublished));

        for(Map.Entry<Integer, List<BoardGame>> gamesByYear : gamesByYears.entrySet()){
            Integer year = gamesByYear.getKey();
            List<BoardGame> games = gamesByYear.getValue();
            System.out.println("- - - - - " + year + " - - - - -");
            games.stream()
                    .map(BoardGame::getName)
                    .forEach(System.out::println);
        }

    }

    public static void task7(List<BoardGame> listGames) {
        Optional<BoardGame> mostUsersRatedGame = listGames.stream()
                .filter(g -> g.getYearPublished() > 2015)
                .max(Comparator.comparing(BoardGame::getUsersRated));
        mostUsersRatedGame.ifPresent(
                g -> System.out.println("The most users rated (" + g.getUsersRated() + ") game is: " + g.getName())
        );
    }
}
