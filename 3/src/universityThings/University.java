package universityThings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class University {

    private List<Teacher> teacherList;
    private List<Student> studentList;
    private List<Lecture> lectureList;

    public University() {
        this.teacherList = new ArrayList<Teacher>();
        this.studentList = new ArrayList<Student>();
        this.lectureList = new ArrayList<Lecture>();
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void enrollStudent(String namesOfStudents){
        String[] names=namesOfStudents.split(" ");
        /*for (String name : names) {

        }
        Arrays.stream(names).forEach(n-> {   быстрее

        });*/
        for(int i=0; i<names.length;++i) {
            studentList.add(new Student(names[i]));
        }
    }

    public void hireTeacher(String namesOfTeachers, String subjectStr){
        String[] names=namesOfTeachers.split(" ");
        String[] subjects=subjectStr.split(" ");
        for(int i=0; i<names.length;++i) {
            if(i<subjects.length) {
                teacherList.add(new Teacher(names[i], subjects[i]));
            }
        }
    }

    public void makePlanOfClasses(String namesSubject, String themesSubject){
        String[] names=namesSubject.split(" ");
        String[] themes=themesSubject.split(" ");
        for(int i=0; i<names.length;++i) {
            if(i<themes.length) {
                lectureList.add(new Lecture(names[i], themes[i]));
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(teacherList, that.teacherList) &&
                Objects.equals(studentList, that.studentList) &&
                Objects.equals(lectureList, that.lectureList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherList, studentList, lectureList);
    }
}
