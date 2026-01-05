package com.rosokha;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //task1(Paths.get("src"), Paths.get("src", "big_file.txt"));
        //task2(Paths.get("src", "journal.txt"), scan);
        //task3(Paths.get("src", "task3.txt"), "Hello");
        //task4(scan);
        //task5(scan);
        //task6(scan);
        task7(scan);
        scan.close();
    }

    public static void task1(Path directoryPath, Path fileToSave) {
        File directory = directoryPath.toFile();
        File[] allFiles = directory.listFiles();
        if (allFiles == null) {
            return;
        }
        List<File> files = Arrays.stream(allFiles)
                .filter(File::isFile)
                .filter(f -> f.length() > 2048)
                .toList();
        if (files.isEmpty()) {
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToSave.toString()))) {
            for (File file : files) {
                bw.write(file.getAbsolutePath());
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void task2(Path fileToSave, Scanner scan) {
        System.out.print("What's your name?: ");
        String name = scan.nextLine();
        System.out.println("Describe your day:");
        String message = scan.nextLine();
        LocalDate date = LocalDate.now();
        String dateFormatted = date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToSave.toString(), true))) {
            bw.append(dateFormatted).append(" | ").append(name).append(" | ").append(message);
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void task3(Path file, String word) {
        try (BufferedReader br = new BufferedReader(new FileReader(file.toString()))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void task4(Scanner scan) {
        System.out.println("Enter file path: ");
        String path = scan.nextLine();
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("This file doesn't exit");
            return;
        }
        try {
            System.out.println("File is " + file.length() + " bites");
            System.out.println(Files.lines(file.toPath()).count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task5(Scanner scan) {
        System.out.println("Enter file path: ");
        String path = scan.nextLine();
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Write your text. To exit press enter");
        String text = "";
        boolean isRunning = true;
        while (isRunning) {
            String line = scan.nextLine();
            text += line + '\n';
            if (line.equals("")) {
                isRunning = false;
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath(), true))) {
            bw.write(text);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task6(Scanner scan) {
        System.out.println("Enter file path: ");
        String path = scan.nextLine();
        File file = new File(path);
        String text = "";
        int shift = 15;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Enter your text: ");
        text = scan.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath()))) {
            bw.write(encrypt(text, shift));
            bw.newLine();
            bw.write(Integer.toHexString(shift));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';

                char encrypted = (char) (((character - base + shift) % 26) + base);
                encryptedText.append(encrypted);
            } else {
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }

    public static void task7(Scanner scan) {
        System.out.println("Enter file path: ");
        String path = scan.nextLine();
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("This file doesn't exit");
            return;
        }

        String lastLine = null;
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            String currentLine;
            while((currentLine = br.readLine()) != null){
                lastLine = currentLine;
                text.append(currentLine).append('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        if (lastLine == null) {
            System.out.println("File is empty");
            return;
        }

        int index = text.lastIndexOf(lastLine);
        text.delete(index, text.length());

        int shift = Integer.parseInt(lastLine, 16);
        System.out.println(decrypt(text.toString(), shift));
    }

    public static int hexToDec(String n)
    {
        int l = n.length();
        int base = 1;
        int dec_val = 0;

        for (int i = l - 1; i >= 0; i--) {
            if (n.charAt(i) >= '0'
                    && n.charAt(i) <= '9') {
                dec_val += (n.charAt(i) - 48) * base;

                base = base * 16;
            }
            else if (n.charAt(i) >= 'A'
                    && n.charAt(i) <= 'F') {
                dec_val += (n.charAt(i) - 55) * base;

                base = base * 16;
            }
        }
        return dec_val;
    }

    public static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, 26 - (shift % 26));
    }
}
