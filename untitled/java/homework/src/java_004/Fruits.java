package java_004;

import java.util.Objects;

public class Fruits {
    private String shape;
    private String taste;

    public Fruits() {
    }

    public void eat(){
        System.out.println("水果可供人们食用！");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruits fruits = (Fruits) o;
        return Objects.equals(shape, fruits.shape) && Objects.equals(taste, fruits.taste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape, taste);
    }

    public Fruits(String shape, String taste) {
        this.shape = shape;
        this.taste = taste;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
