package functionalities;

import java.util.ArrayList;

import inputmplementation.CredentialsInput;
import inputmplementation.UsersInput;

public final class Login {
    /**
     *
     * @param users
     * @param credentials
     * @return
     */
    public int login(final ArrayList<UsersInput> users, final CredentialsInput credentials) {
        int ok = -1;

        // searching through the users
        // if there is a user I keep his position in ok
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getCredentials().getName().equals(credentials.getName())
                    && users.get(i).
                    getCredentials().getPassword().equals(credentials.getPassword())) {
                ok = i;
            }
        }

        // if there is no user in the database I return -1
        return ok;
    }
}
