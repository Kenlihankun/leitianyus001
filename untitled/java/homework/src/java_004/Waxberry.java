package java_004;

public final class Waxberry extends Fruits{
    private String color;

    public Waxberry() {
    }

    public final void face(){
        System.out.println("杨梅："+color+"、"+super.getShape()+"，果味酸甜适中。");
    }

    @Override
    public void eat(){
        System.out.println("杨梅酸甜适中，非常好吃！");
    }

    @Override
    public String toString() {
        return "杨梅的信息：果实为"+super.getShape()+"、"+color+"，"+super.getTaste()+"，非常好吃！";
    }

    public Waxberry(String color) {
        this.color = color;
    }

    public Waxberry(String shape, String taste, String color) {
        super(shape, taste);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
