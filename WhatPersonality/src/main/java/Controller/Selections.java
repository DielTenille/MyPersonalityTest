/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Question;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrenell
 */
public class Selections {

// private String[] category = {"Dominant","Influential","Supportive","Compliant or Analytical"};
  private Question[] listQ = new Question[10];

  // Manage going to next question
  private int answered = 0;

  // Manage number of questions answered / total number of questions
  private int filled = 0;

  public void loadQuestions(String filename) {
    try {
      filled = 0;
      try (Scanner fin = new Scanner(new File(filename))) {
        while ((fin.hasNextLine()) && (filled < 10)) {
          String aLine = fin.nextLine();
          listQ[filled] = new Question(aLine);
          filled++;
        }
      }
    } catch (FileNotFoundException ex) {
      System.err.println("You have an error");
      //Logger.getLogger(Selections.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
//  public void loadQuestions() {
//    Question.resetScores();
//    try {
//      filled = 0;
//
//      try {
//        Class.forName("org.postgresql.Driver");
//      } catch (ClassNotFoundException ex) {
//        Logger.getLogger(Selections.class.getName()).log(Level.SEVERE, null, ex);
//      }
//      Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/public", "andrenell", "Tigger23!");
//      Statement stmt = conn.createStatement();
//      ResultSet rs = stmt.executeQuery("SELECT * FROM \"public\".assessment_questions");
//      while ((rs.next()) && (filled < 10)) {
//        String aLine = rs.getString("doption") + "#" + rs.getString("ioption") + "#" + rs.getString("soption") + "#" + rs.getString("coption") + "";
//        listQ[filled] = new Question(aLine);
//        filled++;
//      }
//      rs.close();
//    } catch (Exception ex) {
//      Logger.getLogger(Selections.class.getName()).log(Level.SEVERE, null, ex);
//    }
//
//  }

  public Question getQuestion() {
    return listQ[answered];
  }

  public void first() {
    answered = 0;
  }

  public void next() {
    if (answered < filled - 1) {
      answered++;
    }
  }

  public void last() {
    answered = filled - 1;
  }

  public boolean hasNext() {
    return answered < filled - 1;
  }

  @Override
  public String toString() {
    String result = "Assessment\n" + Question.getScores();
    return result;
  }

}
