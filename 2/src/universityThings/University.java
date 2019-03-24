package universityThings;

import java.util.ArrayList;
import java.util.List;

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
}
