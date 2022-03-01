package questao1;

import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    StudentRepository studentRepo = new StudentRepository();
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu(studentRepo, scanner);

    menu.run();
    scanner.close();
  }
}
