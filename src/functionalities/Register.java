package functionalities;

import inputmplementation.UsersInput;

import java.util.ArrayList;

public final class Register {
    /**
     *
     * @param users
     * @param tmpUser
     */
    public void register(final ArrayList<UsersInput> users, final UsersInput tmpUser) {
        users.add(tmpUser);
    }
}
