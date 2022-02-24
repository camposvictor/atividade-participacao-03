package questao1;

interface IStudentRepository {
  void add(Student student);

  ArrayList<Student> findAll();

  ArrayList<Student> findYoungestStudents() throws Exception;

  ArrayList<Student> findOldestStudents() throws Exception;

}
