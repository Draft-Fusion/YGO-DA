import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> deck = new ArrayList<>();

        // Read from the file and populate the deck
        try (BufferedReader br = new BufferedReader(new FileReader("deck.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                deck.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test the hand over 1000 iterations to count the occurrences of each card
        Map<String, Integer> cardOccurrences = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            ArrayList<String> testHand = new ArrayList<>();
            Random random = new Random();
            for (int j = 0; j < 5; j++) {
                int randomIndex = random.nextInt(deck.size());
                String card = deck.get(randomIndex);
                testHand.add(card);
                cardOccurrences.put(card, cardOccurrences.getOrDefault(card, 0) + 1);
            }
        }

        // Print the occurrences of each card
        System.out.println("Occurrences of each card in the hand:");
        for (Map.Entry<String, Integer> entry : cardOccurrences.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}