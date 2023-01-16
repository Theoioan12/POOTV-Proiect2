import com.fasterxml.jackson.databind.ObjectWriter;
import functionalities.BannedCountries;
import functionalities.DataBaseAdd;
import functionalities.Filter;
import functionalities.FilterFactory;
import functionalities.Login;
import functionalities.MovieData;
import functionalities.Register;
import inputmplementation.CredentialsInput;
import inputmplementation.InputData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import inputmplementation.UserData;

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

        // reading the input data from Json
        ObjectMapper objectMapper = new ObjectMapper();
        InputData inputData = objectMapper.readValue(in,
                InputData.class);

        // output node
        ArrayNode output = objectMapper.createArrayNode();

        // a string reflecting the current page
        String currPage = "Homepage Neautentificat";

        // an object to generate the output, using singleton
        Output outputGenerator = Output.getInstance();

        // getting the number of commands
        int commandCount = inputData.getActions().size();

        // subscribed string
        String subscribed = "-1";
        String previousPage = null;

        // current user
        UserData currUser = null;

        // useful movie lists
        ArrayList<MovieData> currentMoviesList = new ArrayList<>();
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
                    // logging out
                } else if (inputData.getActions().get(i).getPage().equals("logout")) {
                    currPage = "Homepage Neautentificat";

                    // movies page
                } else if (inputData.getActions().get(i).getPage().equals("movies")
                        && currPage.equals("Homepage Autentificat")) {
                    currPage = "movies";
                    previousPage = "Homepage Autentificat";
                    outputGenerator.outputgenerator(output,
                            availableMoviesList, currUser, objectMapper);

                    // error
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
                        BannedCountries check = new BannedCountries();
                        check.bannedCheck(inputData, currUser,
                                availableMoviesList);

                        // error
                    } else {
                        outputGenerator.outputErrorGenerator(output, objectMapper);
                        currPage = "Homepage Neautentificat";
                    }

                    // register  action
                } else if (currPage.equals("register")
                        && inputData.getActions().get(i).getFeature().equals("register")) {
                    CredentialsInput tmp = inputData.getActions().get(i).getCredentials();
                    Register register = new Register();
                    register.register(inputData.getUsers(), tmp);
                    currPage = "Homepage Autentificat";
                    currUser =
                            new UserData(inputData.getActions().get(i).getCredentials());
                    outputGenerator.outputgenerator(output,
                            currentMoviesList, currUser, objectMapper);
                    BannedCountries check = new BannedCountries();
                    check.bannedCheck(inputData, currUser,
                            availableMoviesList);

                    // filter action
                } else if (currPage.equals("movies")
                        && inputData.getActions().get(i).getFeature().equals("filter")) {
                    int type = 2;

                    if (inputData.getActions().get(i).getFilters().getContains() != null) {
                        if (inputData.getActions().get(i).getFilters().
                                getContains().getActors() != null) {
                            if (inputData.getActions().get(i).getFilters().
                                    getContains().getGenre() != null) {
                                type = 1;
                            }
                        } else {
                            type = 2;
                        }
                        // using factory for the two strategies
                        Filter filter = FilterFactory.createFilter(type);
                        filter.filter(inputData, availableMoviesList, i,
                                filteredMovies);
                    }
                    outputGenerator.outputgenerator(output,
                            filteredMovies, currUser, objectMapper);

                    // search function
                } else if (currPage.equals("movies")
                        && inputData.getActions().get(i).getFeature().equals("search")) {
                     if (availableMoviesList.contains(inputData.
                             getActions().get(i).getStartsWith())) {
                        continue;
                    } else {
                        outputGenerator.outputgenerator(output,
                                currentMoviesList, currUser, objectMapper);
                    }

                     // subscribe function
                } else if (currPage != "movies"
                        && inputData.getActions().get(i).getFeature().equals("subscribe")) {
                    subscribed = inputData.getActions().get(i).getSubscribedGenre();

                    // database add
                } else if (inputData.getActions().get(i).getType().equals("database")) {
                    if (inputData.getActions().get(i).getFeature().equals("add")) {
                        DataBaseAdd add = new DataBaseAdd();
                        add.add(inputData, inputData.getActions().get(i).getAddedMovie(), currUser);
                    }

                    // error
                } else {
                    outputGenerator.outputErrorGenerator(output, objectMapper);
                }

                // back error
            } else if (inputData.getActions().get(i).getType().equals("back")
                    && (currPage.equals("Homepage Autentificat"))) {
                outputGenerator.outputErrorGenerator(output, objectMapper);

                // working back
            }  else if (inputData.getActions().get(i).getType().equals("back")) {
                currPage = previousPage;
            }
        }

        // output in case of a premium user
        if (currUser.getCredentials().getAccountType().equals("premium")) {
            outputGenerator.finalOutput(output, currUser, objectMapper);
        }

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(out, output);
    }
}
