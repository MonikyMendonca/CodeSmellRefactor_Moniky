package org.example.studycards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeitnerSystem extends StudyMethod {
    private List<Box> boxes;

    public LeitnerSystem(String methodName) {
        super(methodName);
        initializeBoxes();
    }

    private void initializeBoxes() {
        boxes = new ArrayList<>(Arrays.asList(new Box(), new Box(), new Box(), new Box(), new Box()));
    }

    @Override
    public String getMethodName() {
        return this.methodName;
    }

    @Override
    void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return buildBoxesSummary();
    }

    private String buildBoxesSummary() {
        StringBuilder response = new StringBuilder();
        int index = 0;
        for (Box box : boxes) {
            response.append("Box ").append(index).append(": ").append(box.toString()).append("\n");
            index++;
        }
        return response.toString();
    }

    public void clearBoxes() {
        initializeBoxes();
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public String getRandomCard(List<Box> otherBoxes) {
        if (areBoxesInvalid(otherBoxes)) {
            return null;
        }
        Box combinedBox = combineBoxes(otherBoxes);
        Integer cardId = combinedBox.getRandomCard();
        return buildRandomCardResponse(cardId);
    }

    private boolean areBoxesInvalid(List<Box> otherBoxes) {
        return otherBoxes == null || otherBoxes.isEmpty();
    }

    private Box combineBoxes(List<Box> boxes) {
        Box combined = new Box();
        for (Box box : boxes) {
            combined.addCards(box.getCards());
        }
        return combined;
    }

    private String buildRandomCardResponse(Integer cardId) {
        if (cardId == null) {
            return "No card found";
        }
        CardManager manager = CardManager.getCardManager();
        Card card = manager.getCard(cardId);
        return String.format("[%d] The random question was: %s | The answer is: %s",
                cardId, card.getQuestion(), card.getAnswer());
    }

    // ✅ Corrigido: método público com parâmetros primitivos
    public void addCardToBox(int id, int boxId) {
        boxes.get(boxId).addCard(id);
    }

    public void removeCardFromBox(int id, int boxId) {
        boxes.get(boxId).removeCard(id);
    }

    public Card takeCardFromBox(int boxId) {
        Integer cardId = boxes.get(boxId).getRandomCard();
        return this.cardManager.getCard(cardId);
    }

    public void boxIdValidation(int boxId) throws Exception {
        if (boxId < 0 || boxId >= boxes.size()) {
            throw new Exception("Invalid box ID");
        }
    }

    public void upgradeCard(int cardId, int boxId) throws Exception {
        boxIdValidation(boxId);
        moveCardBetweenBoxes(cardId, boxId, Math.min(boxId + 1, 4));
    }

    public void downgradeCard(int cardId, int boxId) throws Exception {
        boxIdValidation(boxId);
        moveCardBetweenBoxes(cardId, boxId, Math.max(boxId - 1, 0));
    }

    private void moveCardBetweenBoxes(int cardId, int fromBox, int toBox) throws Exception {
        Box currentBox = boxes.get(fromBox);
        if (!currentBox.hasCard(cardId)) {
            throw new Exception("No card Found");
        }
        currentBox.removeCard(cardId);
        boxes.get(toBox).addCard(cardId);
    }
}