package com.company;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String text = "There is a house in New Orleans\n" +
                "They call the Rising Sun\n" +
                "And it's been the ruin of many a poor boy\n" +
                "And God I know I'm one\n" +
                "My mother was a tailor\n" +
                "She sewed my new blue jeans\n" +
                "My father was a gamblin' man\n" +
                "Down in New Orleans\n" +
                "Now the only thing a gambler needs\n" +
                "Is a suitcase and trunk\n" +
                "And the only time he's satisfied\n" +
                "Is when he's all drunk\n" +
                "Oh mother tell your children\n" +
                "Not to do what I have done\n" +
                "Spend your lives in sin and misery\n" +
                "In the House of the Rising Sun\n" +
                "Well, I got one foot on the platform\n" +
                "The other foot on the train\n" +
                "I'm goin' back to New Orleans\n" +
                "To wear that ball and chain\n" +
                "Well, there is a house in New Orleans\n" +
                "They call the Rising Sun\n" +
                "And it's been the ruin of many a poor boy\n" +
                "And God I know I'm one ";


        LinkedList<Word> result = findRepeatingWords(text);

        showResult(result);

    }


    public static LinkedList<Word> findRepeatingWords(String text) {
        LinkedList<Word> result = new LinkedList<>();
        String[] words = text.toLowerCase().replaceAll("[!@#$%^&*()_+'?]", "").split("\\s");
        if (words.length < 3) {
            return new LinkedList<>();
        }
        Map<String, Integer> counterMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                Integer count = counterMap.get(word);
                if (count == null) {
                    count = 0;
                }
                counterMap.put(word, ++count);
            }
        }
        counterMap.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .limit(3)
                .forEach(k ->
                        result.add(new Word(k.getKey(), k.getValue()))
                );
        return result;
    }

    public static void showResult(LinkedList<Word> result) {
        for (Word res : result) {

            System.out.println(res.toString());
        }
    }
}
