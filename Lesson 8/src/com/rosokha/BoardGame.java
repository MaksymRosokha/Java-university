package com.rosokha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardGame {

    private int id;
    private String name;
    private int yearPublished;
    private int minPlayers;
    private int maxPlayers;
    private int playTime;
    private double minAge;
    private int usersRated;
    private double ratingAverage;
    private int bggRank;
    private double complexityAverage;
    private int ownedUsers;
    private List<String> mechanics;
    private List<String> domains;

    public BoardGame(){}

    public BoardGame(int id, String name, int yearPublished, int minPlayers,
                     int maxplayers, int playTime, double minAge, int usersRated,
                     double ratingAverage, int bggRank, double complexityAverage,
                     int ownedUsers, List<String> mechanics, List<String> domains){
        this.id = id;
        this.name = name;
        this.yearPublished = yearPublished;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxplayers;
        this.playTime = playTime;
        this.minAge = minAge;
        this.usersRated = usersRated;
        this.ratingAverage = ratingAverage;
        this.bggRank = bggRank;
        this.complexityAverage = complexityAverage;
        this.ownedUsers = ownedUsers;
        this.mechanics = mechanics;
        this.domains = domains;
        
    }

    public int getId() { return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getYearPublished() {return yearPublished;}
    public void setYearPublished(int yearPublished) {this.yearPublished = yearPublished;}

    public int getMinPlayers() {return minPlayers;}
    public void setMinPlayers(int minPlayers) {this.minPlayers = minPlayers;}

    public int getMaxPlayers() {return maxPlayers;}
    public void setMaxPlayers(int maxPlayers) {this.maxPlayers = maxPlayers;}

    public int getPlayTime() {return playTime;}
    public void setPlayTime(int playTime) {this.playTime = playTime;}

    public double getMinAge() {return minAge;}
    public void setMinAge(double minAge) {this.minAge = minAge;}

    public int getUsersRated() {return usersRated;}
    public void setUsersRated(int usersRated) {this.usersRated = usersRated;}

    public double getRatingAverage() {return ratingAverage;}
    public void setRatingAverage(double ratingAverage) {this.ratingAverage = ratingAverage;}

    public int getBggRank() {return bggRank;}
    public void setBggRank(int bggRank) {this.bggRank = bggRank;}

    public double getComplexityAverage() {return complexityAverage;}
    public void setComplexityAverage(double complexityAverage) {this.complexityAverage = complexityAverage;}

    public int getOwnedUsers() {return ownedUsers;}
    public void setOwnedUsers(int ownedUsers) {this.ownedUsers = ownedUsers;}

    public List<String> getMechanics() {return mechanics;}
    public void setMechanics(List<String> mechanics) {this.mechanics = mechanics;}

    public List<String> getDomains() {return domains;}
    public void setDomains(List<String> domains) {this.domains = domains;}

    public List<BoardGame> loadFromCsv(Path path, Charset charset) throws IOException {
        List<BoardGame> games = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(path.toString(),charset ))) {
            String line;

            // Pierwsza linia to nagłówek – pomijamy
            line = reader.readLine();
            System.out.println(line);
            if (line == null) {
                return games; // pusty plik
            }

            // Kolejne linie to dane
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                BoardGame game = fromCsvLine(line);
                games.add(game);
            }
        }

        return games;
    }


    public BoardGame fromCsvLine(String line) {
        // split(";", -1) – -1 powoduje, że puste kolumny na końcu nie znikają
        String[] parts = line.split(";", -1);

        if (parts.length < 13) {
            throw new IllegalArgumentException("Niepoprawna liczba kolumn: " + parts.length +
                    " w linii: " + line);
        }

        int id = parseLongSafe(parts[0]);
        String name = parts[1].trim();
        int yearPublished = parseIntSafe(parts[2]);
        int minPlayers = parseIntSafe(parts[3]);
        int maxPlayers = parseIntSafe(parts[4]);
        int playTime = parseIntSafe(parts[5]);
        int minAge = parseIntSafe(parts[6]);
        int usersRated = parseIntSafe(parts[7]);
        double ratingAverage = parseDoubleSafe(parts[8]);
        int bggRank = parseIntSafe(parts[9]);
        double complexityAverage = parseDoubleSafe(parts[10]);
        int ownedUsers = parseIntSafe(parts[11]);

        List<String> mechanics = splitToList(parts[12]);
        List<String> domains = parts.length > 13 ? splitToList(parts[13]) : Collections.emptyList();

        return new BoardGame(
                id,
                name,
                yearPublished,
                minPlayers,
                maxPlayers,
                playTime,
                minAge,
                usersRated,
                ratingAverage,
                bggRank,
                complexityAverage,
                ownedUsers,
                mechanics,
                domains
        );
    }

    // ======================
    //  Metody pomocnicze
    // ======================

    private static int parseIntSafe(String value) {
        String v = value.trim();
        if (v.isEmpty()) {
            return 0;
        }
        // Na wszelki wypadek zamieniamy przecinek na kropkę
        v = v.replace(',', '.');
        try {
            return Integer.parseInt(v);
        } catch (NumberFormatException ex) {
            // Jeśli np. dostaniemy "2017.0", parsujemy jako double i rzutujemy
            double d = Double.parseDouble(v);
            return (int) Math.round(d);
        }
    }

    private static int parseLongSafe(String value) {
        String v = value.trim();
        if (v.isEmpty()) {
            return 0;
        }
        v = v.replace(',', '.');
        try {
            return Integer.parseInt(v);
        } catch (NumberFormatException ex) {
            double d = Double.parseDouble(v);
            return (int) Math.round(d);
        }
    }

    private static double parseDoubleSafe(String value) {
        String v = value.trim();
        if (v.isEmpty()) {
            return 0.0;
        }
        v = v.replace(',', '.');
        return Double.parseDouble(v);
    }

    private static List<String> splitToList(String value) {
        String v = value.trim();
        if (v.isEmpty()) {
            return Collections.emptyList();
        }

        String[] tokens = v.split(",");
        List<String> result = new ArrayList<>();
        for (String token : tokens) {
            String t = token.trim();
            if (!t.isEmpty()) {
                result.add(t);
            }
        }
        return result;
    }

}
