package major.bean;

import java.util.HashMap;
import java.util.Map;

public class Customer extends User {
    private Map<Movie,Double> movieBooleanMap = new HashMap<>();

    public Map<Movie, Double> getMovieBooleanMap() {
        return movieBooleanMap;
    }

    public void setMovieBooleanMap(Movie movie,Double b) {

        this.movieBooleanMap.put(movie,b);
    }
}
