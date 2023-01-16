import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import functionalities.MovieData;
import inputmplementation.Notification;
import inputmplementation.UserData;

import java.util.ArrayList;

final class Output {
    private static Output instance = null;
    private Output() { };
    public static Output getInstance() {
        if (instance == null) {
            instance = new Output();
        }
        return instance;
    }
    public void outputgenerator(final ArrayNode output,
                                final ArrayList<MovieData> currentMoviesList,
                                final UserData currUser, final ObjectMapper objectMapper) {
        ObjectNode out2 = objectMapper.createObjectNode();
        UserData tmp = new UserData(currUser);
        out2.set("error", null);
        out2.putPOJO("currentMoviesList", currentMoviesList);
        out2.putPOJO("currentUser", tmp).deepCopy();
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
    public void finalOutput(final ArrayNode output, final UserData currUser,
                            final ObjectMapper objectMapper) {
        ObjectNode out2 = objectMapper.createObjectNode();
        Notification notification = new Notification();
        notification.setMovieName("No recommendation");
        notification.setMessage("Recommendation");
        UserData tmp = new UserData(currUser);
        tmp.setNotifications(new ArrayList<>());
        tmp.getNotifications().add(notification);
        ArrayList<MovieData> tmp2 = null;
        out2.set("error", null);
        out2.putPOJO("currentMoviesList", tmp2);
        out2.putPOJO("currentUser", tmp).deepCopy();
        output.add(out2.deepCopy()).deepCopy();
    }
}
