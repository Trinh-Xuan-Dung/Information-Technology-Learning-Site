/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Question;
import java.util.List;

/**
 *
 * @author HP
 */
public interface QuestionDAO {
   public int addListQuestTionByQuizID(int qId,List<Question> listq); 
   public  List<Question> getAllQuestInQuizbyQizID(int id);
    
}
