package java_005;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class text {
    public static void main(String[] args) {
        Random random = new Random();
        List<Animal> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int j = random.nextInt(3);
            switch (j){
                case 0:list.add(new Cat());break;
                case 1:list.add(new Dog());break;
                case 2:list.add(new Sheep());break;
            }
        }
        for (Animal animal : list) {
            animal.cry();
        }
    }


}
