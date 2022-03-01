package questao1;

import java.util.Scanner;

public class Menu {
  private IStudentRepository studentRepo;
  Scanner scanner;

  public Menu(IStudentRepository studentRepo, Scanner scanner) {
    this.studentRepo = studentRepo;
    this.scanner = scanner;
  }

  private void printStudent(Student student) {
    System.out.println(student.getName() + ", " + student.getAge() + " anos");
  }

  private void showMenu() {
    System.out.println("\n---- Menu ----\n");
    System.out.println("1 - Adicionar aluno");
    System.out.println("2 - Listar alunos mais velhos");
    System.out.println("3 - Listar alunos mais novos");
    System.out.println("4 - Listar a média de idade");
    System.out.println("5 - Sair");
    System.out.print("\n-> ");
  }

  private void addStudent() {
    System.out.print("\nNome: ");
    String name = System.console().readLine();
    System.out.print("Idade: ");
    int age = Integer.parseInt(System.console().readLine());

    studentRepo.add(new Student(name, age));
  }

  private void showOldestStudents() {
    ArrayList<Student> oldestStudents;

    try {
      oldestStudents = studentRepo.findOldestStudents();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }

    System.out.println("\nAluno(s) mais velho(s):");
    oldestStudents.forEach(this::printStudent);
  }

  private void showYoungestStudents() {
    ArrayList<Student> youngestStudents;

    try {
      youngestStudents = studentRepo.findYoungestStudents();
    } catch (Exception e) {
      System.out.println("\n" + e.getMessage());
      return;
    }

    System.out.println("\nAluno(s) mais novo(s):");
    youngestStudents.forEach(this::printStudent);
  }

  private void showAverageAge() {
    ArrayList<Student> students = studentRepo.findAll();

    if (students.isEmpty()) {
      System.out.println("\nNão há alunos cadastrados!");
      return;
    }

    int ageSum = 0;
    for (Student student : students)
      ageSum += student.getAge();

    System.out.println("\nA média de idade é: " + ageSum / students.size());
  }

  private void waitForEnter() {
    System.out.print("\nPressione ENTER para continuar...");
    this.scanner.nextLine();
  }

  public void run() {
    while (true) {
      showMenu();
      int option = this.scanner.nextInt();
      this.scanner.nextLine();

      switch (option) {
        case 1:
          addStudent();
          break;
        case 2:
          showOldestStudents();
          waitForEnter();
          break;
        case 3:
          showYoungestStudents();
          waitForEnter();
          break;
        case 4:
          showAverageAge();
          waitForEnter();
          break;
        case 5:
          System.exit(0);
          break;
        default:
          System.out.println("Opção inválida");
      }
    }
  }
}
