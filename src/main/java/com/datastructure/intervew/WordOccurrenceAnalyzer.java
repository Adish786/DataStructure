package com.datastructure.intervew;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
//TODO Asked at Agoda - Streams & Multithreading | Find Nth Word Frequencies From Files
public class WordOccurrenceAnalyzer {
    //This is folder location where all files are located
    private static final String FOLDER_PATH = "/user/javafolder";

    //Get file from the foler
    public List<String> findNthOccurence(int rank, boolean highest) throws IOException {
        Map<String, Long> wordMap = new HashMap<>();
        List<Path> files = Files.walk(Paths.get(FOLDER_PATH)).filter(Files::isRegularFile).collect(Collectors.toList());
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        //read each file and directly update or store the frquency
        for (Path file : files) {
            executorService.execute(() -> {
                try {
                    Files.lines(file).flatMap(line -> Arrays.stream(line.split("\\W+")))
                            .filter(word -> !word.isEmpty())
                            .forEach(word -> wordMap.merge(word, 1L, Long::sum));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        }
        System.out.println(wordMap);
        //after process it shutdown it
        executorService.shutdown();
        //Handle ranking by groupingby words by their frequency
        Map<Long, List<String>> frequencyToworlds = wordMap.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(
                Map.Entry::getKey, Collectors.toList()
        )));
        System.out.println("frequency to worlds  " + frequencyToworlds);
        //sort the frequency based on user search
        List<Long> sortedFrequency = new ArrayList<>(frequencyToworlds.keySet());
        sortedFrequency.sort(highest ? Comparator.reverseOrder() : Comparator.naturalOrder());
        System.out.println("sortedFrequency " + sortedFrequency);
        //validation rank
        if (rank <= 0 || rank > sortedFrequency.size()) {
            throw new IllegalArgumentException("Rank is out of Range");
        }
        //get the frequency correstponding to the nth rank
        long targetRank = sortedFrequency.get(rank - 1);
        //return all the words
        return frequencyToworlds.getOrDefault(targetRank, Collections.emptyList());
    }


    public static void main(String[] args) throws IOException {
        WordOccurrenceAnalyzer wordOccurrenceAnalyzer = new WordOccurrenceAnalyzer();
        wordOccurrenceAnalyzer.findNthOccurence(1, true);
    }


}
