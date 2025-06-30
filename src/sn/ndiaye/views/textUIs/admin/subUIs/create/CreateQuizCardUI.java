package sn.ndiaye.views.textUIs.admin.subUIs.create;

import sn.ndiaye.domain.QuizCard;

public final class CreateQuizCardUI extends CreateQuizUI{

    @Override
    public void start() {

    }

    public QuizCard createQuizCard() {
        QuizCard newCard = initializeQuestion();
        addAnswerToQuizCard(newCard);
        return newCard;
    }

    private QuizCard initializeQuestion() {
        QuizCard quizCard = new QuizCard();
        System.out.println("Enter a new Question:");
        quizCard.setQuestion(scanner.nextLine());
        return quizCard;
    }

    private void addAnswerToQuizCard(QuizCard quizCard) {
        System.out.println("Enter the correct answer:");
        quizCard.setCorrectAnswer(scanner.nextLine());
        addEnoughWrongAnswers(quizCard);
    }

    private void addEnoughWrongAnswers(QuizCard quizCard) {
        boolean hasEnoughAnswers;
        while (true) {
            System.out.println("Add a wrong answer:");
            quizCard.addWrongAnswer(scanner.nextLine());
            hasEnoughAnswers = quizCard.getWrongAnswers().size() > 1;
            if (!hasEnoughAnswers)
                continue;
            if (hasFinishedAdding())
                break;
        }
    }

    @Override
    public void stop() {

    }
}
