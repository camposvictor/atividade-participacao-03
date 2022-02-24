package questao1;

public class App {
  public static void main(String[] args) throws Exception {
    StudentRepository studentRepo = new StudentRepository();
    Menu menu = new Menu(studentRepo);

    menu.run();
  }
}
