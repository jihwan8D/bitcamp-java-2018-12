package jihwan_practice;

import java.util.ArrayList;

public class Algo {

  public static void main(String[] args) {

    Algo a = new Algo();
    int[] answers = {11,22,33,44,55,66};
    int[] best = a.solution(answers);

    for(int b : best) {
      System.out.print(b + " ");
    }

  }

  public int[] solution(int[] answers) {
    int[] answer1 = {1, 2, 3, 4, 5};
    int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


    int[] score = {0, 0, 0};
    int bsetScore = 0;
    ArrayList<Integer> bestStudent = new ArrayList<>();
    
    for (int i = 0; i <answers.length; i++) {

      if (answers[i] == answer1[i % 5]) {
        score[0]++;
      }

      if (answers[i] == answer2[i % 8]) {
        score[1]++;
      }

      if (answers[i] == answer3[i % 10]) {
        score[2]++;
      }
    }

    for (int i = 0; i < score.length; i++) {
      if (bsetScore < score[i]) {
        bsetScore = score[i];
      }
    }
    
    for(int i = 0; i < score.length; i++) {
      if (bsetScore == score[i]) {
        bestStudent.add(i+1);
      }
    }
    
    int[] returnValue = new int[bestStudent.size()];
    
    for(int i = 0; i < bestStudent.size(); i++) {
      returnValue[i] = bestStudent.get(i);
    }
    
    return returnValue;
  }
}
