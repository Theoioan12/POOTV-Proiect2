// Buliga Theodor Ioan
// 323 CA

package functionalities;

import inputmplementation.InputData;
import inputmplementation.MoviesInput;
import inputmplementation.UserData;

public final class DatabaseAdd {
    /**
     *
     * @param inputData
     * @param movie
     * @param currUser
     */
    public void add(final InputData inputData, final MoviesInput movie, final UserData currUser) {
        if (!inputData.getMovies().contains(movie)) {
            inputData.getMovies().add(movie);
        }
    }

}
