package functionalities;

import inputmplementation.InputData;
import inputmplementation.MoviesInput;
import inputmplementation.Notification;
import inputmplementation.UserData;

public final class DataBaseAdd {
    /**
     *
     * @param inputData
     * @param movie
     * @param currUser
     */
    public void add(final InputData inputData, final MoviesInput movie, final UserData currUser) {
        int ok;
        if (inputData.getMovies().contains(movie)) {
            ok = -1;
        } else {
            inputData.getMovies().add(movie);
            //Notification tmp = new Notification();
            //tmp.setMessage("Recommendation");
            //tmp.setMovieName("No recommendation");
            //currUser.getNotifications().add(tmp);
            ok = 0;
        }
        //return ok;
    }

}
