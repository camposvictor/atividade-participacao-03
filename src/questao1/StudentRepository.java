package questao1;

import java.util.ArrayList;

public class StudentRepository {
  private ArrayList<Student> students;

  public StudentRepository() {
    this.students = new ArrayList<Student>();
  }

  public void add(Student student) {
    this.students.add(student);
  }

  public ArrayList<Student> findAll() {
    return this.students;
  }

  public ArrayList<Student> findYoungestStudents() {
    ArrayList<Student> youngest = new ArrayList<Student>();
    youngest.add(this.students.get(0));

    for (Student student : students.subList(1, students.size())) {
      if (student.getAge() < youngest.get(0).getAge()) {
        youngest.clear();
        youngest.add(student);
        continue;
      }
      if (student.getAge() == youngest.get(0).getAge()) {
        youngest.add(student);
      }
    }

    return youngest;
  }

  public ArrayList<Student> findOldestStudents() {
    ArrayList<Student> oldest = new ArrayList<Student>();
    oldest.add(this.students.get(0));

    for (Student student : students) {
      if (student.getAge() > oldest.get(0).getAge()) {
        oldest.clear();
        oldest.add(student);
        continue;
      }
      if (student.getAge() == oldest.get(0).getAge()) {
        oldest.add(student);
      }
    }

    return oldest;
  }

}
