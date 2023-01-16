import com.fasterxml.jackson.databind.ObjectWriter;
import functionalities.*;
import inputmplementation.InputData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import inputmplementation.Notification;
import inputmplementation.UserData;
//import inputmplementation.UsersInput;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class Main {
    private Main() { }
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {
        File in = new File(args[0]);
        File out = new File(args[1]);
        ObjectMapper objectMapper = new ObjectMapper();
        InputData inputData = objectMapper.readValue(in,
                InputData.class);
        ArrayNode output = objectMapper.createArrayNode();

        // a string reflecting the current page
        String currPage = "Homepage Neautentificat";

        // an object to generate the output
        Output outputGenerator = Output.getInstance();

        // getting the number of commands
        int commandCount = inputData.getActions().size();

        String subscribed = "-1";
        String previousPage = null;

        // current user
        UserData currUser = null;

        ArrayList<MovieData> currentMoviesList = new ArrayList<>();

        // observable
        ArrayList<MovieData> availableMoviesList = new ArrayList<>();

        ArrayList<MovieData> filteredMovies = new ArrayList<>();

        // command loop
        for (int i = 0; i < commandCount; i++) {
            // change page command type
            if (inputData.getActions().get(i).getType().equals("change page")) {
                if (currPage.equals("Homepage Neautentificat")) {
                    // login page
                    if (inputData.getActions().get(i).getPage().equals("login")) {
                        currPage = "login";
                        previousPage = "Homepage Neautentificat";
                        // register page
                    } else if (inputData.getActions().get(i).getPage().equals("register")) {
                        currPage = "register";
                        previousPage = "Homepage Neautentificat";

                        // error
                    } else {
                        outputGenerator.outputErrorGenerator(output, objectMapper);
                    }
                } else if (inputData.getActions().get(i).getPage().equals("logout")) {
                    currPage = "Homepage Neautentificat";
                } else if (inputData.getActions().get(i).getPage().equals("movies")
                        && currPage.equals("Homepage Autentificat")) {
                    currPage = "movies";
                    previousPage = "Homepage Autentificat";
                    outputGenerator.outputgenerator(output,
                            availableMoviesList, currUser, objectMapper);
                } else {
                    outputGenerator.outputErrorGenerator(output, objectMapper);
                }
            } else if (inputData.getActions().get(i).getType().equals("on page")) {
                // login action
                if (currPage.equals("login")
                        && inputData.getActions().get(i).getFeature().equals("login")) {
                    Login login = new Login();
                    if (login.login(inputData.getUsers(),
                            inputData.getActions().get(i).getCredentials()) != -1) {
                        currPage = "Homepage Autentificat";
                        int currUserIndex = login.login(inputData.getUsers(),
                                inputData.getActions().get(i).getCredentials());
                        currUser =
                                new UserData(inputData.getUsers().
                                        get(currUserIndex).getCredentials());
                        outputGenerator.outputgenerator(output,
                                currentMoviesList, currUser, objectMapper);
                        availableMoviesList = new ArrayList<>();
                    } else {
                        outputGenerator.outputErrorGenerator(output, objectMapper);
                        currPage = "Homepage Neautentificat";
                    }
                } else if (currPage.equals("register")
                        && inputData.getActions().get(i).getFeature().equals("register")) {
                    //UsersInput tmp = new UsersInput(inputData.
                    // getActions().get(i).getCredentials());
                    //Register register = new Register();
                    //register.register(inputData.getUsers(), tmp);
                    currPage = "Homepage Autentificat";
                    currUser =
                            new UserData(inputData.getActions().get(i).getCredentials());
                    outputGenerator.outputgenerator(output,
                            currentMoviesList, currUser, objectMapper);
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
                } else if (currPage.equals("movies")
                        && inputData.getActions().get(i).getFeature().equals("filter")) {
                    outputGenerator.outputgenerator(output,
                            currentMoviesList, currUser, objectMapper);

                    if (inputData.getActions().get(i).getFilters().getContains() != null) {
                        Strategy strategy = new Strategy1();
                        if (inputData.getActions().get(i).getFilters().
                                getContains().getActors() != null) {
                            if (inputData.getActions().get(i).getFilters().
                                    getContains().getGenre() != null) {
                                strategy = new Strategy1();
                            }
                        } else {
                            strategy = new Strategy2();
                        }
                        strategy.filter(inputData,
                                currentMoviesList, i,
                                filteredMovies);
                    }

                } else if (currPage.equals("movies")
                        && inputData.getActions().get(i).getFeature().equals("search")) {
                    outputGenerator.outputgenerator(output,
                            currentMoviesList, currUser, objectMapper);

                } else if (currPage != "movies"
                        && inputData.getActions().get(i).getFeature().equals("subscribe")) {
                    subscribed = inputData.getActions().get(i).getSubscribedGenre();
                } else if (inputData.getActions().get(i).getType().equals("database")) {
                    if (inputData.getActions().get(i).getFeature().equals("add")) {
                        DataBaseAdd add = new DataBaseAdd();
                        add.add(inputData, inputData.getActions().get(i).getAddedMovie(), currUser);

                    }
                } else {
                    outputGenerator.outputErrorGenerator(output, objectMapper);
                }

            } else if (inputData.getActions().get(i).getType().equals("back")
                    && (currPage.equals("Homepage Autentificat"))) {
                outputGenerator.outputErrorGenerator(output, objectMapper);
            }  else if (inputData.getActions().get(i).getType().equals("back")) {
                currPage = previousPage;
            }
        }
        if (currUser.getCredentials().getAccountType().equals("premium")) {
            outputGenerator.finalOutput(output, currUser, objectMapper);
        }
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(out, output);
    }
}
