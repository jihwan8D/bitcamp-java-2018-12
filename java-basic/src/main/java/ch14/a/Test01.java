package ch14.a;

public class Test01 {

  public static void main(String[] args) {
 Score2 score = new Score2();
    
    score.kor = 100;
    score.eng = 100;
    score.math =100;
    score.music = 100;
    score.art = 100;
    
    score.compute();
    
    System.out.printf("%d(%f)\n", score.getSum(), score.getAver());
    
  }

}
