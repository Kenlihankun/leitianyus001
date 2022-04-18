package java_007;

import java.util.Objects;

public class Student {
    private int stuId;
    private String  name;
    private  float score;

    public Student() {
    }

    public Student(int stuId, String name, float score) {
        this.stuId = stuId;
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return stuId == student.stuId && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, name);
    }

    @Override
    public String toString() {
        return "[" +
                "stuId=" + stuId +
                ", name='" + name + '\'' +
                ", score=" + score +
                ']';
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
