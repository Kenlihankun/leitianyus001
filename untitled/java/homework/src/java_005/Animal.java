package java_005;

public abstract class Animal {
    public String kind;
    public abstract void cry();

    public Animal() {
    }

    public Animal(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
