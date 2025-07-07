package org.example.studycards;

public class Card {
    private String question;
    private String answer;

    public Card(String question, String answer) {
        setQuestion(question);
        setAnswer(answer);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = validateAndTrim(question, "A pergunta não pode ser vazia.");
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = validateAndTrim(answer, "A resposta não pode ser vazia.");
    }

    public Card edit(String newQuestion, String newAnswer) {
        setQuestion(newQuestion);
        setAnswer(newAnswer);
        return this;
    }

    public boolean matches(String search) {
        if (search == null || search.trim().isEmpty()) {
            return false;
        }
        return question.contains(search) || answer.contains(search);
    }

    private String validateAndTrim(String text, String errorMessage) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        return text.trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card)) return false;
        Card other = (Card) obj;
        return question.equals(other.question) && answer.equals(other.answer);
    }

    @Override
    public int hashCode() {
        return question.hashCode() + 31 * answer.hashCode();
    }
}
