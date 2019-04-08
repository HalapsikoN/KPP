package universityThings;

import customExceptions.EnteredNumberInName;
import customExceptions.HugeLectureSize;
import customExceptions.NotEnoughSubjects;

import java.util.ArrayList;
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

    public void enrollStudent(String namesOfStudents) throws EnteredNumberInName {
        String[] names=namesOfStudents.split(" ");
        /*for (String name : names) {

        }
        Arrays.stream(names).forEach(n-> {   быстрее

        });*/
        for(int i=0; i<names.length;++i) {
            studentList.add(new Student(names[i]));
        }
        for(String name:names){
/*            if(isNumeric(name)){
                throw new EnteredNumberInName();
            }*/
            if(!name.matches("^\\D*$") || name.length()>10){
                throw new EnteredNumberInName();
            }
        }
    }

    public void hireTeacher(String namesOfTeachers, String subjectStr) throws EnteredNumberInName {
        String[] names=namesOfTeachers.split(" ");
        String[] subjects=subjectStr.split(" ");

        for(int i=0; i<names.length;++i) {
            if(i<subjects.length) {
                teacherList.add(new Teacher(names[i], subjects[i]));
            }
        }
        for(String name:names){
            if(!name.matches("^\\D*$") || name.length()>10){
                throw new EnteredNumberInName();
            }
        }
        for(String subject:subjects){
            if(!subject.matches("^\\D*$") || subject.length()>10){
                throw new EnteredNumberInName();
            }
        }
    }

    public void makePlanOfClasses(String namesSubject, String themesSubject) throws EnteredNumberInName, NotEnoughSubjects, HugeLectureSize {
        String[] names=namesSubject.split(" ");
        String[] themes=themesSubject.split(" ");
        for(int i=0; i<names.length;++i) {
            if(i<themes.length) {
                lectureList.add(new Lecture(names[i], themes[i]));
            }
        }
        for(String name:names){
            if(!name.matches("^\\D*$") || name.length()>10){
                throw new EnteredNumberInName();
            }
        }
        for(String theme:themes){
            if(!theme.matches("^\\D*$") || theme.length()>10){
                throw new EnteredNumberInName();
            }
        }
        if(names.length>3){
            throw new HugeLectureSize();
        }
        if(names.length!=themes.length){
            throw new NotEnoughSubjects();
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

    private boolean isNumeric(String str){
        try{
            Double d=Double.parseDouble(str);
        }
        catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
}
