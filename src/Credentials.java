public final class Credentials {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(final String balance) {
        this.balance = balance;
    }

    public Credentials() {

    }

    public Credentials(final Credentials credentials) {
        this.setName(credentials.getName());
        this.setAccountType(credentials.accountType);
        this.setCountry(credentials.getCountry());
        this.setPassword(credentials.getPassword());
        this.setBalance(new String(credentials.getBalance()));
    }
}
