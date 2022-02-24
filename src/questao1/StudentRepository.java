package questao1;

public class StudentRepository implements IStudentRepository {
  private ArrayList<Student> students;

  public StudentRepository() {
    this.students = new ArrayList<Student>();
  }

  private void ensureListHasStudents() throws Exception {
    if (students.isEmpty()) {
      throw new Exception("Não há alunos cadastrados!");
    }
  }

  public void add(Student student) {
    this.students.add(student);
  }

  public ArrayList<Student> findAll() {
    return this.students;
  }

  public ArrayList<Student> findYoungestStudents() throws Exception {
    ensureListHasStudents();

    ArrayList<Student> youngest = new ArrayList<Student>();
    youngest.add(this.students.get(0));

    for (Student student : students) {
      if (student == students.get(0))
        continue;

      if (student.getAge() < youngest.get(0).getAge()) {
        youngest.clear();
        youngest.add(student);
        continue;
      }
      if (student.getAge() == youngest.get(0).getAge())
        youngest.add(student);
    }

    return youngest;
  }

  public ArrayList<Student> findOldestStudents() throws Exception {
    ensureListHasStudents();

    ArrayList<Student> oldest = new ArrayList<Student>();
    oldest.add(this.students.get(0));

    for (Student student : students) {
      if (student == students.get(0))
        continue;

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
