package universityThings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teacher {

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

    public boolean readLecture(Lecture lecture){
        boolean result=false;
        String subjectTeacher=subject.getSubject();
        String subjectLecture=lecture.getSubject();

        if(subjectLecture.equals(subjectTeacher))
        {
            result=true;
        }

        return result;
    }

    public Map chaeckStudents(List<Student> studentList, Lecture lecture){

        Map register=new HashMap();

        for(int i=0; i<studentList.size();++i){
            Student student=studentList.get(i);

            String studentName=student.getName();
            boolean visit=student.visitLecture(lecture);

            register.put(studentName,visit);
        }

        return register;
    }
}
