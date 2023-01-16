package functionalities;

import inputmplementation.InputData;

import java.util.ArrayList;

public final class Filter2 extends Filter {
    @Override
    public void filter(final InputData inputData,
                final ArrayList<MovieData> currentMoviesList, final int i,
                final ArrayList<MovieData> filteredMovies) {
        //String actor = null;

        // this variable tells me in which case I am
        // if it is 1 I have an actor filter
        // if it is 2 I have a genre filter
        //int var = 1;
        //filteredMovies = new ArrayList<MovieData>();
        if (inputData.getActions().get(i).getFilters().getContains() != null) {
            if (inputData.getActions().get(i).getFilters().getContains().getActors() != null) {
                this.setActor(inputData.getActions().get(i).getFilters().
                        getContains().getActors().get(0));
            } else {
                this.setActor(inputData.getActions().get(i).
                        getFilters().getContains().getGenre().get(0));
                this.setVar(2);
                //filteredMovies = new ArrayList<MovieData>();
            }
        }
        //boolean ok = false;
        this.setOk(false);
        if (currentMoviesList.size() > 0) {
            for (int j = 0; j < currentMoviesList.size() && this.getVar() == 1; j++) {
                this.setOk(false);
                for (int k = 0; k < currentMoviesList.get(j).getActors().size(); k++) {
                    if (currentMoviesList.get(j).getActors().
                            get(k).equals(this.getActor())
                            && this.getActor() != null && this.getVar() == 1) {
                        this.setOk(true);
                    }
                }
                if (this.isOk()) {
                    filteredMovies.add(currentMoviesList.get(j));
                }
            }

            // in case I am in the genre case
            for (int j = 0; j < currentMoviesList.size() && this.getVar() == 2; j++) {
                this.setOk(false);
                for (int k = 0; k < currentMoviesList.get(j).getGenres().size(); k++) {
                    if (currentMoviesList.get(j).getGenres().get(k).equals(this.getActor())) {
                        this.setOk(true);
                    }
                }
                if (this.isOk()) {
                    filteredMovies.add(currentMoviesList.get(j));
                }
            }
        }
    }
}