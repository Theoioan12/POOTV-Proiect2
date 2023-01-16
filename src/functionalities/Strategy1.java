package functionalities;

import inputmplementation.InputData;

import java.util.ArrayList;

public final class Strategy1 extends Strategy {
    @Override
    public void filter(final InputData inputData,
                       final ArrayList<MovieData> currentMoviesList, final int i,
                       final ArrayList<MovieData> filteredMovies) {
        String actor = null;

        // this variable tells me in which case I am
        // if it is 1 I have an actor filter
        // if it is 2 I have a genre filter
        int var = 1;
        //filteredMovies = new ArrayList<MovieData>();
        boolean ok = false;
        if (currentMoviesList.size() > 0) {
            for (int j = 0; j < currentMoviesList.size() && var == 1; j++) {
                ok = false;
                for (int k = 0; k < currentMoviesList.get(j).getActors().size(); k++) {
                    if (currentMoviesList.get(j).getActors().
                            get(k).equals(actor) && actor != null && var == 1) {
                        ok = true;
                    }
                }
                if (ok) {
                    filteredMovies.add(currentMoviesList.get(j));
                }
            }
            if (inputData.getActions().get(i).getFilters().
                    getContains().getGenre() != null && var == 1) {
                actor = actor = inputData.getActions().get(i).
                        getFilters().getContains().getGenre().get(0);

                ArrayList<MovieData> tmp = (ArrayList<MovieData>) filteredMovies.clone();
                filteredMovies.clear();
                for (int j = 0; j < tmp.size(); j++) {
                    ok = false;
                    for (int k = 0; k < tmp.get(j).getGenres().size(); k++) {
                        if (tmp.get(j).getGenres().get(k).equals(actor)) {
                            ok = true;
                        }
                    }
                    if (ok) {
                        filteredMovies.add(currentMoviesList.get(j));
                    }
                }
            }
        }

    }
}
