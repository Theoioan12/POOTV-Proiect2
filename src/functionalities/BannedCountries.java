// Buliga Theodor Ioan
// 323 CA

package functionalities;

import inputmplementation.InputData;
import inputmplementation.UserData;

import java.util.ArrayList;

public class BannedCountries {
    /**
     *
     * @param inputData
     * @param currUser
     * @param availableMoviesList
     */
    public void bannedCheck(final InputData inputData, final UserData currUser,
                            final ArrayList<MovieData> availableMoviesList) {
        for (int j = 0; j < inputData.getMovies().size(); j++) {
            boolean ok = false;
            MovieData tmp = new MovieData(inputData.getMovies().get(j));
            for (int k = 0; k < tmp.getCountriesBanned().size(); k++) {
                if (currUser != null) {
                    // checking if it is banned in the country
                    if (tmp.getCountriesBanned().get(k).
                            equals(currUser.getCredentials().getCountry())) {
                        // if it is banned I stop the search
                        ok = true;
                        break;
                    }
                }

            }
            if (!ok) {
                availableMoviesList.add(tmp);
            }
        }
    }
}
