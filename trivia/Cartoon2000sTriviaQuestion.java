// Tyler Johnson
// April 11th, 2025
// Tjj29@njit.edu
// IT114 - 004
// Phase 4 Assignment: GUI Trivia Game Flow
package trivia;

public record Cartoon2000sTriviaQuestion(String question, String answer) {
    public boolean isCorrectAnswer(String userAnswer) {
        return this.answer.equalsIgnoreCase(userAnswer);
    }
}
