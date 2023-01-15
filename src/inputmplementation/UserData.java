package inputmplementation;

import functionalities.MovieData;

import java.util.ArrayList;
public final class UserData {
    private int standardMovies = 15;
    private CredentialsInput credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<MovieData> purchasedMovies;
    private ArrayList<MovieData> watchedMovies;
    private ArrayList<MovieData> likedMovies;
    private ArrayList<MovieData> ratedMovies;
    private ArrayList<Notification> notifications;

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(final ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public CredentialsInput getCredentials() {
        return credentials;
    }

    public void setCredentials(final CredentialsInput credentials) {
        this.credentials = credentials;
    }

    public int getTokensCount() {
        return tokensCount;
    }

    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }

    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    public ArrayList<MovieData> getPurchasedMovies() {
        return purchasedMovies;
    }

    public void setPurchasedMovies(final ArrayList<MovieData> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    public ArrayList<MovieData> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(final ArrayList<MovieData> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public ArrayList<MovieData> getLikedMovies() {
        return likedMovies;
    }

    public void setLikedMovies(final ArrayList<MovieData> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public ArrayList<MovieData> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(final ArrayList<MovieData> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    public UserData(final CredentialsInput credentials) {
        this.credentials = credentials;
        this.setNumFreePremiumMovies(standardMovies);
        this.setTokensCount(0);
        this.purchasedMovies = new ArrayList<MovieData>();
        this.watchedMovies = new ArrayList<MovieData>();
        this.likedMovies = new ArrayList<MovieData>();
        this.ratedMovies = new ArrayList<MovieData>();
        this.notifications = new ArrayList<>();
    }
    public UserData() {

    }
    public UserData(final UserData userData) {
        this.setCredentials(userData.getCredentials());
        this.setNumFreePremiumMovies(userData.getNumFreePremiumMovies());
        this.setTokensCount(userData.tokensCount);
        this.purchasedMovies = new ArrayList<MovieData>();
        this.watchedMovies = new ArrayList<MovieData>();
        this.likedMovies = new ArrayList<MovieData>();
        this.ratedMovies = new ArrayList<MovieData>();
        this.setNotifications(userData.getNotifications());
    }
}
