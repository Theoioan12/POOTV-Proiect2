package functionalities;

import inputmplementation.InputData;

import java.util.ArrayList;

public final class Filter1 extends Filter {
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
       // boolean ok = false;
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
            if (inputData.getActions().get(i).getFilters().
                    getContains().getGenre() != null && this.getVar() == 1) {
                this.setActor(inputData.getActions().get(i).
                        getFilters().getContains().getGenre().get(0));

                ArrayList<MovieData> tmp = (ArrayList<MovieData>) filteredMovies.clone();
                filteredMovies.clear();
                for (int j = 0; j < tmp.size(); j++) {
                    this.setOk(false);
                    for (int k = 0; k < tmp.get(j).getGenres().size(); k++) {
                        if (tmp.get(j).getGenres().get(k).equals(this.getActor())) {
                            this.setOk(false);
                        }
                    }
                    if (this.isOk()) {
                        filteredMovies.add(currentMoviesList.get(j));
                    }
                }
            }
        }

    }
}
