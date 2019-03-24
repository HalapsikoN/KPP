package universityThings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Headman extends Student {

    public Headman(String name) {
        super(name);
    }

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
}
