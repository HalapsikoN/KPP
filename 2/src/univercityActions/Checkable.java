package univercityActions;

import universityThings.Lecture;
import universityThings.Register;
import universityThings.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Checkable {

    public Map checkPresence(List<Student> studentList, Lecture lecture);
    public Register getRegister(List<Student> students, List<Lecture> lectures);
}
