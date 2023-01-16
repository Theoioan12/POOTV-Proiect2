package functionalities;

import inputmplementation.InputData;

import java.util.ArrayList;

public abstract class Strategy {
    public void filter(final InputData inputData,
                          final ArrayList<MovieData> currentMoviesList, final int i,
                          final ArrayList<MovieData> filteredMovies) { };
}
