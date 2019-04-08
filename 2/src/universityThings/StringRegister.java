package universityThings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StringRegister {

    private String name;
    private Map<Lecture, Boolean> visit;

    public StringRegister(Student student, List<Lecture> lectures) {
        this.name = student.getName();
        visit=new HashMap();

        /*for (int i=0; i<lectures.size(); ++i)
        {
            visit.put(lectures.get(i), student.visitLecture(lectures.get(i)));
        }*/
        for(Lecture lecture:lectures){
            visit.put(lecture,student.visitLecture(lecture));
        }
    }

    public String getName() {
        return name;
    }

    public Map getVisit() {
        return visit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringRegister that = (StringRegister) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(visit, that.visit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, visit);
    }
}
