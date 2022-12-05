package com.epam.training.student_aleksandr_maksakov.words;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int word_Count = 0;
        if (words == null || sample == null) {
            return 0;
        }
        for (String word: words) {
            if (sample.trim().equalsIgnoreCase(word.trim())) {
                word_Count++;
            }
        }
        return word_Count;
    }

    public static String[] splitWords(String text) {
        if (text == null) {
            return null;
        }
        String regEx = "\\W";
        text = text.replaceAll(regEx, " ").trim();
        regEx = "\\s+";
        String[] str = text.split(regEx);
        if (str[0].isEmpty()) {
            return null;
        }
        return str;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.isEmpty() || !(isWindowsMatches(path) || isUnixMatches(path))) {
            return null;
        }
        if ((isWindowsMatches(path) && toWin) || (isUnixMatches(path) && !toWin)) {
            return path;
        }
        String resultPath;
        if (toWin) {
            resultPath = convertPathToWindows(path);
        } else {
            resultPath = convertPathToUnix(path);
        }
        return resultPath;
    }

    private static boolean isUnixMatches(String path) {
        return path.matches("([/~])?([\\w.\\-\\s/]*)");
    }

    private static boolean isWindowsMatches(String path) {
        return path.matches("(C:\\\\)?([\\w.\\-\\s\\\\]*)");
    }

    private static String convertPathToUnix(String path) {
        if (path.startsWith("C:\\User")) {
            path = path.replace("C:\\User", "~");
        } else if (path.startsWith("C:\\")) {
            path = path.replace("C:\\", "/");
        }
        return path.replace("\\", "/");
    }

    private static String convertPathToWindows(String path) {
        if (path.startsWith("~")) {
            path = path.replace("~", "C:\\User");
        } else if (path.startsWith("/")) {
            path = path.replaceFirst("/", "C:\\\\");
        }
        return path.replace("/", "\\");
    }

    public static String joinWords(String[] words) {
        if (words == null) {
            return null;
        }
        StringBuilder resWord = new StringBuilder();
        for (String word: words) {
            resWord.append(word);
        }
        if (resWord.length() == 0) return null;
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (String word: words) {
            if (!Objects.equals(word, "")) {
                joiner.add(word);
            }
        }
        return joiner.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}