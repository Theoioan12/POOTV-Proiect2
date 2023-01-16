// Buliga Theodor Ioan
// 323 CA

package functionalities;

import inputmplementation.CredentialsInput;
import inputmplementation.UsersInput;

import java.util.ArrayList;

public final class Register {
    /**
     *
     * @param users
     * @param tmpCred
     */
    public void register(final ArrayList<UsersInput> users, final CredentialsInput tmpCred) {
        UsersInput tmp = new UsersInput();
        tmp.setCredentials(tmpCred);
        users.add(tmp);
    }
}
