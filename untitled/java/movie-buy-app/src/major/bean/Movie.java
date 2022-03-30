package major.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {
    private String name;
    private String actor;
    private double score;
    private double time;
    private double price;
    private int number;
    private Date startTime;
    private List<BigDecimal> listCode = new ArrayList<>();
    public Movie() {
    }

    public Movie(String name, String actor, double time, double price, int number, Date startTime) {
        this.name = name;
        this.actor = actor;
        this.score = score;
        this.time = time;
        this.price = price;
        this.number = number;
        this.startTime = startTime;
    }

    public List<BigDecimal> getListCode() {
        return listCode;
    }

    public void setListCode(List<BigDecimal> listCode) {
        this.listCode = listCode;
    }

    public void setListCodeByCustomer(BigDecimal dou) {
        this.listCode.add(dou);
        codeMath();
    }

    public void codeMath(){
        int mum = 0;
        BigDecimal dou = BigDecimal.valueOf(0);
        for (BigDecimal bigDecimal : listCode) {
            dou = dou.add(bigDecimal);
            mum+=1;
        }
        BigDecimal mumber = BigDecimal.valueOf(mum);
        dou = dou.divide(mumber,2, RoundingMode.UP);
        this.score=dou.doubleValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", actor='" + actor + '\'' +
                ", score=" + score +
                ", time=" + time +
                ", price=" + price +
                ", number=" + number +
                ", startTime=" + startTime +
                '}';
    }
}
