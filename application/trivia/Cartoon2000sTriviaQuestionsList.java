// Tyler Johnson
// April 11th, 2025
// Tjj29@njit.edu
// IT114 - 004
// Phase 4 Assignment: GUI Trivia Game Flow
package application.trivia;
import java.util.ArrayList;

public class Cartoon2000sTriviaQuestionsList {
    private ArrayList<Cartoon2000sTriviaQuestion> questions;

    public Cartoon2000sTriviaQuestionsList() {
        questions = new ArrayList<>();
        
        questions.add(new Cartoon2000sTriviaQuestion(
            "In 'Avatar: The Last Airbender', what is the name of Aang's flying bison?", 
            "Appa"
        ));

        questions.add(new Cartoon2000sTriviaQuestion(
            "Which 2000s cartoon follows the adventures of a boy genius named Dexter and his secret laboratory?", 
            "Dexter's Laboratory"
        ));

        questions.add(new Cartoon2000sTriviaQuestion(
            "In 'Teen Titans', which member of the team has the ability to transform into animals?", 
            "Beast Boy"
        ));

        questions.add(new Cartoon2000sTriviaQuestion(
            "What is the name of the school that Jake Long attends in 'American Dragon: Jake Long'?", 
            "Millard Fillmore Middle School"
        ));

        questions.add(new Cartoon2000sTriviaQuestion(
            "In 'Codename: Kids Next Door', what is the codename of the team's leader?", 
            "Numbuh One"
        ));
    }

    public Cartoon2000sTriviaQuestion get(int currentQuestionIndex) {
        return questions.get(currentQuestionIndex);
    }

    public int size() {
        return questions.size();
    }
}
