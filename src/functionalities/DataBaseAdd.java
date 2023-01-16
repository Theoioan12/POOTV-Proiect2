package functionalities;

import inputmplementation.InputData;
import inputmplementation.MoviesInput;
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
            ok = 0;
        }
    }

}
