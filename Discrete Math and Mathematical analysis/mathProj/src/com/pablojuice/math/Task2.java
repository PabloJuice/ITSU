package com.pablojuice.math;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введіть текст для кодування: ");
            String line = scanner.nextLine();
            line = line.trim();
            //line = line.toUpperCase(Locale.ROOT);//.replaceAll(" ","")
            Map<String, Double> lettersFrequency = calculateFrequency(line);
            System.out.println("Ймовірності символів: " + lettersFrequency);
            Map<String, String> lettersBinary = calculateBinary(lettersFrequency);
            System.out.println("Коди символів: " + lettersBinary);
            String resultLine = calculateResult(lettersBinary, line);
            System.out.println("Закодований текст: " +resultLine);
        }

    }
    public static Map<String, Double> calculateFrequency(String line){
        Map<String, Double> letters = new HashMap<>();
        for(char c : line.toCharArray()){
            letters.putIfAbsent(String.valueOf(c), 0.0);
            letters.put(String.valueOf(c), letters.get(String.valueOf(c)) + 1);
        }
        double sum = letters.values().stream().reduce(Double::sum).get();
        for (Object key : letters.keySet().toArray()){
            letters.put((String) key, letters.get(key)/sum);
        }
        return letters;
    }
public static Map<String, String> calculateBinary(Map<String, Double> lettersFrequency){
    Map<String, String> lettersBinary = new HashMap<>();
    lettersFrequency.keySet().forEach(key -> lettersBinary.put(key, ""));
    NodeList nodeList = new NodeList();
    lettersFrequency.keySet().forEach(key -> nodeList.addNode(new Node(key, lettersFrequency.get(key))));
    double length = 0;
    while (nodeList.lastNode().getFrequency() != 1){
        Node firstElement = nodeList.removeLastNode();

        double lastElementSum = firstElement.getFrequency();
        String lastElementLetters = firstElement.getLetter();

        Node secondElement = nodeList.removeLastNode();

        lastElementSum += secondElement.getFrequency();
        lastElementLetters += secondElement.getLetter();

        nodeList.addNode(new Node(lastElementLetters, lastElementSum));

        for (char c : firstElement.getLetter().toCharArray()){
            lettersBinary
                    .put(String.valueOf(c),
                            lettersBinary.get(String.valueOf(c)) +
                                    (firstElement.getFrequency() >= secondElement.getFrequency() ? "1" : "0"));
        }
        for (char c : secondElement.getLetter().toCharArray()){
            lettersBinary
                    .put(String.valueOf(c),
                            lettersBinary.get(String.valueOf(c)) +
                                    (firstElement.getFrequency() >= secondElement.getFrequency() ? "0" : "1"));
        }

        length += lastElementSum;
    }
    for (String key : lettersBinary.keySet()){
        lettersBinary.put(key, new StringBuilder(lettersBinary.get(key)).reverse().toString());
    }
    lettersBinary.put("середня довжина", String.format("%.3f", length));
    return lettersBinary;
}
    public static String calculateResult(Map<String, String> lettersBinary, String line){
        StringBuilder result = new StringBuilder();
        for (char c : line.toCharArray()){
            result.append(lettersBinary.get(String.valueOf(c)));
        }
        return result.toString();
    }
}
class Node{
    private String letter;
    private Double frequency;

    public Node(String letter, Double frequency){
        this.letter = letter;
        this.frequency = frequency;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return letter.equals(node.letter) && frequency.equals(node.frequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, frequency);
    }
}
class NodeList{
    private List<Node> list;
    public NodeList(){
        this.list = new ArrayList<>();
    }
    public List<Node> addNode(Node node){
        this.list.add(node);
        this.list.sort(Comparator.comparingDouble(Node::getFrequency));
        return this.list;
    }
    public Node removeNode(Node node){
        this.list.remove(node);
        this.list.sort(Comparator.comparingDouble(Node::getFrequency));
        return node;
    }
    public Node lastNode(){
        return this.list.get(0);
    }
    public Node removeLastNode(){
        return this.removeNode(lastNode());
    }
}
