import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import functionalities.MovieData;

import java.util.ArrayList;

final class Output {
    public void outputgenerator(final ArrayNode output,
                                final ArrayList<MovieData> currentMoviesList,
                                final UserData currUser, final ObjectMapper objectMapper) {
        ObjectNode out2 = objectMapper.createObjectNode();
        out2.set("error", null);
        out2.putPOJO("currentMoviesList", currentMoviesList);
        out2.putPOJO("currentUser", currUser).deepCopy();
        output.add(out2.deepCopy()).deepCopy();
    }

    // the error output
    public void outputErrorGenerator(final ArrayNode output,
                                     final ObjectMapper objectMapper) {
        ArrayList<MovieData> movies = new ArrayList();
        ObjectNode out2 = objectMapper.createObjectNode();
        out2.put("error", "Error");
        out2.putPOJO("currentMoviesList", movies);
        out2.putPOJO("currentUser", null);
        output.add(out2);
    }
}