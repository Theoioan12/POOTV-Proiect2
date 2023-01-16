// Buliga Theodor Ioan
// 323 CA

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
    public static final class Builder {
        private CredentialsInput credentials;
        private int tokensCount = 0;
        private int numFreePremiumMovies = 15;
        private ArrayList<MovieData> purchasedMovies = new ArrayList<>();
        private ArrayList<MovieData> watchedMovies = new ArrayList<>();
        private ArrayList<MovieData> likedMovies = new ArrayList<>();
        private ArrayList<MovieData> ratedMovies = new ArrayList<>();
        private ArrayList<Notification> notifications = new ArrayList<>();


        public Builder(final CredentialsInput crdentials) {
            this.credentials = crdentials;
        }

        /**
         *
         * @param tkensCount
         * @return
         */
        public Builder tokensCount(final int tkensCount) {
            this.tokensCount = tkensCount;
            return this;
        }

        /**
         *
         * @param nmFreePremiumMovies
         * @return
         */
        public Builder numFreePremiumMovies(final int nmFreePremiumMovies) {
            this.numFreePremiumMovies = nmFreePremiumMovies;
            return this;
        }

        /**
         *
         * @param prchasedMovies
         * @return
         */
        public Builder purchasedMovies(final ArrayList<MovieData> prchasedMovies) {
            this.purchasedMovies = prchasedMovies;
            return this;
        }

        /**
         *
         * @param wtchedMovies
         * @return
         */
        public Builder watchedMovies(final ArrayList<MovieData> wtchedMovies) {
            this.watchedMovies = wtchedMovies;
            return this;
        }

        /**
         *
         * @param lkedMovies
         * @return
         */
        public Builder likedMovies(final ArrayList<MovieData> lkedMovies) {
            this.likedMovies = lkedMovies;
            return this;
        }

        /**
         *
         * @param rtedMovies
         * @return
         */
        public Builder ratedMovies(final ArrayList<MovieData> rtedMovies) {
            this.ratedMovies = rtedMovies;
            return this;
        }

        /**
         *
         * @param ntifications
         * @return
         */
        public Builder notifications(final ArrayList<Notification> ntifications) {
            this.notifications = ntifications;
            return this;
        }

        /**
         *
         * @return
         */

        public UserData build() {
            return new UserData(this);
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
