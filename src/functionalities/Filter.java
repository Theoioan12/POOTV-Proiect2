// Buliga Theodor Ioan
// 323 CA

package functionalities;

import inputmplementation.InputData;

import java.util.ArrayList;

public abstract class Filter {
    private String actor = null;
    private int var = 1;
    private boolean ok = false;

    /**
     *
     * @param inputData
     * @param currentMoviesList
     * @param i
     * @param filteredMovies
     */
    public void filter(final InputData inputData,
                          final ArrayList<MovieData> currentMoviesList, final int i,
                          final ArrayList<MovieData> filteredMovies) { };

    /**
     *
     * @return
     */

    public String getActor() {
        return actor;
    }

    /**
     *
     * @param actor
     */
    public void setActor(final String actor) {
        this.actor = actor;
    }

    /**
     *
     * @return
     */

    public int getVar() {
        return var;
    }

    /**
     *
     * @param var
     */

    public void setVar(final int var) {
        this.var = var;
    }

    /**
     *
     * @return
     */

    public boolean isOk() {
        return ok;
    }

    /**
     *
     * @param ok
     */

    public void setOk(final boolean ok) {
        this.ok = ok;
    }
}
