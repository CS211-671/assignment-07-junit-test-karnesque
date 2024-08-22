package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }
    @Test
    void testAddNewStudentWithoutScore() {
        studentList.addNewStudent("666", "karn");
        Student student = studentList.findStudentById("666");

        assertEquals("666", student.getId());
    }
    @Test
    void testAddNewStudentWithScore() {
        studentList.addNewStudent("666", "karn", 85);
        Student student = studentList.findStudentById("666");

        assertEquals(85., student.getScore());
    }

    @Test
    void testGiveScoreToId(){
        studentList.addNewStudent("666" , "karn");
        studentList.giveScoreToId("666" , 80);
        Student student = studentList.findStudentById("666");

        assertEquals(80., student.getScore());

    }

    @Test
    void testFindStudentById(){
        studentList.addNewStudent("666" , "karn");

        assertEquals("karn" ,studentList.findStudentById("666").getName());


    }
    @Test
    void testViewGradeOfId(){
        studentList.addNewStudent("666" , "karn" , 88);
        String grade = studentList.viewGradeOfId("666");
        assertEquals("A", grade);

    }
}