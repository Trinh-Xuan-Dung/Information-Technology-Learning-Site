/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportQuest;

import Entity.Question;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author HP
 */
public class GetListToImportQuest {

    public List<Question> processFile(Part filePart,int qid) throws IOException {
        List<Question> questions = new ArrayList<>();

        // Get the InputStream from the file part
        InputStream fileContent = filePart.getInputStream();

        // Read the data from the file
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
        String line;
        while ((line = reader.readLine()) != null) {
            // Read the question content
            String questContent = line;

            // Read the number of answers/options
            int numAnswers = Integer.parseInt(reader.readLine());

            // Read the answer options
            List<String> options = new ArrayList<>();
            for (int i = 0; i < numAnswers; i++) {
                options.add(reader.readLine());
            }

            // Read the true answer(s)
            String trueAnswerLine = reader.readLine();
            String[] trueAnswers = trueAnswerLine.split("/");

            // Create a new Question object
            Question question = new Question();
            question.setQestId(0); // Assuming questionId is set to 0
            question.setQuizId(qid); // Assuming quizId is set to 0
            question.setQuestContent(questContent);

            // Set options and determine correct answers
            for (int i = 0; i < numAnswers; i++) {
                String option = options.get(i);
                boolean isCorrect = false;
                for (String trueAnswer : trueAnswers) {
                    int trueAnswerIndex = Integer.parseInt(trueAnswer) - 1;
                    if (trueAnswerIndex == i) {
                        isCorrect = true;
                        break;
                    }
                }
                // Set options and correctness for each answer
                switch (i) {
                    case 0:
                        question.setOptionA(option);
                        question.setAnswerA(isCorrect);
                        break;
                    case 1:
                        question.setOptionB(option);
                        question.setAnswerB(isCorrect);
                        break;
                    case 2:
                        question.setOptionC(option);
                        question.setAnswerC(isCorrect);
                        break;
                    case 3:
                        question.setOptionD(option);
                        question.setAnswerD(isCorrect);
                        break;
                    // Add more cases if needed for additional answer options
                }
            }

            // Add the question to the list
            questions.add(question);
        }

        // Close the reader and InputStream
        reader.close();
        fileContent.close();

        return questions;
    }
}
