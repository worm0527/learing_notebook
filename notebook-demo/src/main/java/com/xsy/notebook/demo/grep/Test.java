package com.xsy.notebook.demo.grep;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shuyuan.xu
 * @date 2020-12-12.
 */
public class Test {

  // (index + size - distribute_cout) mod size

  public static void main(String[] args) {
    int distributeCount = 3;
    int studentCount = 400;
    List<Student> students = new ArrayList<>();
    for (int i = 0; i < studentCount; i++) {
      Student student = new Student();
      student.setName(String.format("学生%03d", i));
      students.add(student);
    }

    Collections.shuffle(students);

    int step = studentCount - distributeCount;
    for (int i = 0; i < students.size(); i++) {
      Student student = students.get(i);
      for (int j = 0; j < distributeCount; j++) {
        student.putStu(students.get((i + step + j) % studentCount));
      }
    }

    students.forEach(System.out::println);

  }

  protected void proTest() {

  }

  @Data
  public static class Student {

    private String name;

    private List<Student> evalStudents;

    private void putStu(Student evalStu) {
      if (evalStudents == null) {
        evalStudents = new ArrayList<>();
      }
      evalStudents.add(evalStu);
    }

    @Override
    public String toString() {
      String evalStuInfo = evalStudents != null ?
          evalStudents.stream().map(Student::getName).collect(Collectors.joining(" ")) : "";
      int evalCount = evalStudents != null ? evalStudents.size() : 0;
      return String.format("学生：%s 分发数：%d 分配给了：%s", name, evalCount, evalStuInfo);
    }
  }

}
