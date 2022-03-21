package Day16;

public class card {
    private String size;
    private String color;
    private int mum;

    public card() {
    }

    public card(String size, String color, int mum) {
        this.size = size;
        this.color = color;
        this.mum = mum;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMum() {
        return mum;
    }

    public void setMum(int mum) {
        this.mum = mum;
    }

    @Override
    public String toString() {
        return size+color;
    }
}
