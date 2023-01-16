package inputmplementation;

import functionalities.MovieData;

import java.util.ArrayList;
public final class UserData {
    //private int standardMovies = 15;
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
        this.setNumFreePremiumMovies(15);
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
    public static class Builder {
        private CredentialsInput credentials;
        private int tokensCount = 0;
        private int numFreePremiumMovies = 15;
        private ArrayList<MovieData> purchasedMovies = new ArrayList<>();
        private ArrayList<MovieData> watchedMovies = new ArrayList<>();
        private ArrayList<MovieData> likedMovies = new ArrayList<>();
        private ArrayList<MovieData> ratedMovies = new ArrayList<>();
        private ArrayList<Notification> notifications = new ArrayList<>();


        public Builder(final CredentialsInput credentials) {
            this.credentials = credentials;
        }

        /**
         *
         * @param tokensCount
         * @return
         */
        public Builder tokensCount(final int tokensCount) {
            this.tokensCount = tokensCount;
            return this;
        }

        /**
         *
         * @param numFreePremiumMovies
         * @return
         */
        public Builder numFreePremiumMovies(final int numFreePremiumMovies) {
            this.numFreePremiumMovies = numFreePremiumMovies;
            return this;
        }

        /**
         *
         * @param purchasedMovies
         * @return
         */
        public Builder purchasedMovies(final ArrayList<MovieData> purchasedMovies) {
            this.purchasedMovies = purchasedMovies;
            return this;
        }

        /**
         *
         * @param watchedMovies
         * @return
         */
        public Builder watchedMovies(final ArrayList<MovieData> watchedMovies) {
            this.watchedMovies = watchedMovies;
            return this;
        }

        /**
         *
         * @param likedMovies
         * @return
         */
        public Builder likedMovies(final ArrayList<MovieData> likedMovies) {
            this.likedMovies = likedMovies;
            return this;
        }

        /**
         *
         * @param ratedMovies
         * @return
         */
        public Builder ratedMovies(final ArrayList<MovieData> ratedMovies) {
            this.ratedMovies = ratedMovies;
            return this;
        }

        /**
         *
         * @param notifications
         * @return
         */
        public Builder notifications(final ArrayList<Notification> notifications) {
            this.notifications = notifications;
            return this;
        }
    }
    private UserData(final Builder builder) {
        this.credentials = builder.credentials;
        this.tokensCount = builder.tokensCount;
        this.numFreePremiumMovies = builder.numFreePremiumMovies;
        this.purchasedMovies = builder.purchasedMovies;
        this.watchedMovies = builder.watchedMovies;
        this.ratedMovies = builder.ratedMovies;
        this.likedMovies = builder.likedMovies;
        this.notifications = builder.notifications;
    }
}
