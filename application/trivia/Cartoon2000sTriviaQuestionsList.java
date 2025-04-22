// Tyler Johnson
// April 11th, 2025
// Tjj29@njit.edu
// IT114 - 004
// Phase 4 Assignment: GUI Trivia Game Flow
package application.trivia;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Cartoon2000sTriviaQuestionsList {
    private static ArrayList<Cartoon2000sTriviaQuestion> questions;
    private LinkedList<Cartoon2000sTriviaQuestion> roundQuestions;
    private static int QUESTIONS_PER_ROUND = 5;
    private static final String QUESTIONS_FILENAME = "application/trivia/resources/Cartoon2000sTriviaQuestions.csv";

    public Cartoon2000sTriviaQuestionsList() {
        if (questions.isEmpty()) {
           try (
               InputStream inputStream = getClass().getClassLoader().getResourceAsStream(QUESTIONS_FILENAME);
               BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
           ) {
               String line;
               while ((line = reader.readLine()) != null) {
                   String[] parts = line.split(",", 2);
                   if (parts.length == 2) {
                       questions.add(new Cartoon2000sTriviaQuestion(parts[0].trim(), parts[1].trim()));
                   }
               }
           } catch (Exception e) {
               e.printStackTrace(); // Log error if file not found or reading fails
           }

    
         Collections.shuffle(questions);
        // Create a LinkedList to hold random questions for one round
        roundQuestions = new LinkedList<>();        
        // Add random questions to the roundQuestions list
        for (int i = 0; i < QUESTIONS_PER_ROUND; i++) {
            roundQuestions.add(questions.get(i));
        }
    }
    }

    public Cartoon2000sTriviaQuestion get(int currentQuestionIndex) {
        return questions.get(currentQuestionIndex);
    }

    public int size() {
        return questions.size();
    }
}


