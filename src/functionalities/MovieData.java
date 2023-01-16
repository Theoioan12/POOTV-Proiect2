// Buliga Theodor Ioan
// 323 CA

package functionalities;

import java.util.ArrayList;
import inputmplementation.MoviesInput;

public final class MovieData {
    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;

    private int numLikes;
    private double rating;
    private int numRatings;

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(final double rating) {
        this.rating = rating;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(final String year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    public MovieData(final MoviesInput tmp) {
        this.setName(tmp.getName());
        this.setYear(tmp.getYear());
        this.setDuration(tmp.getDuration());
        this.setNumLikes(0);
        this.setRating(0.00);
        this.setNumRatings(0);
        this.setActors(tmp.getActors());
        this.setCountriesBanned(tmp.getCountriesBanned());
        this.setGenres(tmp.getGenres());
    }
    public MovieData() {

    }
}
