package universityThings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Register {

    private List<StringRegister> stringRegisters;

    public Register(List<Student> students, List<Lecture> lectures) {

        stringRegisters=new ArrayList<>();
        for (int i=0; i<students.size(); ++i)
        {
            stringRegisters.add(new StringRegister(students.get(i), lectures));
        }
    }

    public List<StringRegister> getStringRegisters() {
        return stringRegisters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register register = (Register) o;
        return Objects.equals(stringRegisters, register.stringRegisters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringRegisters);
    }
}
