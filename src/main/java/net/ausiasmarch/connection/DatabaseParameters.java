package net.ausiasmarch.connection;

public class DatabaseParameters {
    private static final String dbUrl ="jdbc:mysql://localhost:3306/spooller";
    private static final String dbUser ="usuario_app";
    private static final String dbPassword ="1234";

    public static String getDbUrl() {
        return dbUrl;
    }

    public static String getDbUser() {
        return dbUser;
    }

    public static String getDbPassword() {
        return dbPassword;
    }
}
