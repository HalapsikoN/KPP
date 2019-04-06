package universityThings;

import java.util.Objects;

public class Class {

    private String subject;

    public Class(String subject) {
        this.subject = subject;
    }

    public String getSubjectName() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return Objects.equals(subject, aClass.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject);
    }
}
