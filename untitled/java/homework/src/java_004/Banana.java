package java_004;

public class Banana extends Fruits {
    private String variety;

    public void advantage(){
        System.out.println(variety+"果形"+super.getShape()+",果肉香甜，可供生食。");
    }

    public void advantage(String color){
        System.out.println(variety+"颜色为"+color);
    }

    public Banana(String shape, String taste, String variety) {
        super(shape, taste);
        this.variety = variety;
    }

    public Banana() {
    }

    public Banana(String variety) {
        this.variety = variety;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}
