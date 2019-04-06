package universityThings;

import univercityActions.Checkable;
import univercityActions.TeacherDuties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Teacher implements Checkable, TeacherDuties {

    private String name;
    private Class subject;

    public String getName() {
        return name;
    }

    public Class getSubject() {
        return subject;
    }

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = new Class(subject);
    }

    @Override
    public boolean readLecture(Lecture lecture){
        boolean result=false;
        String subjectTeacher=subject.getSubjectName();
        String subjectLecture=lecture.getSubjectName();

        if(subjectLecture.equals(subjectTeacher))
        {
            result=true;
        }

        return result;
    }

    @Override
    public Map checkPresence(List<Student> studentList, Lecture lecture){

        Map register=new HashMap();

        for(int i=0; i<studentList.size();++i){
            Student student=studentList.get(i);

            String studentName=student.getName();
            boolean visit=student.visitLecture(lecture);

            register.put(studentName,visit);
        }

        return register;
    }

    @Override
    public Register getRegister(List<Student> students, List<Lecture> lectures){

        return new Register(students, lectures);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(name, teacher.name) &&
                Objects.equals(subject, teacher.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subject);
    }
}
