package org.example;

import java.io.IOException;
import java.util.regex.Pattern;

public class SessionWorker implements  SessionWorkerInterface{

    public SessionWorker() {

    }

    @Override
    public Session getSession() throws IOException {

        boolean sessionStatus = getSessionStatus();
        return sessionStatus ? new Session(getUsername(), getUserPassword(), TypeOfSession.Login)
                : new Session(getUsername(), getUserPassword(), TypeOfSession.Register);
    }

    /**
     * Type of Session
     *
     * @return true if login, false if register
     */
    private boolean getSessionStatus() throws IOException{
        String answer;

        do {
            MessageHandler.displayToUser("\tDo you register or login? [\"r\", \"l\"]: ");
            answer = InputClientReader.getInputReader().nextLine().trim();
        } while (answer == null || !answer.equals("r") && !answer.equals("l"));

        return answer.equals("l");
    }

    private String getUsername() throws IOException {

        String username;
        Pattern usernamePattern = Pattern.compile("^\\s*\\b(\\w+)\\b\\s*");

        while (true) {
            MessageHandler.displayToUser("\tPlease, enter username! (Example: Lololoshka1337): ");
            username = InputClientReader.getInputReader().nextLine().trim();
            if (!username.isEmpty() && usernamePattern.matcher(username).find()) break;
            MessageHandler.displayToUser("Username should be not empty string of letters and digits");
        }

        return username.trim();
    }

    private String getUserPassword() throws IOException {
        if (System.console() == null) {
            String password;
            Pattern passwordPattern = Pattern.compile("^\\s*([\\d\\w]*)\\s*");
            while (true) {
                MessageHandler.displayToUser("\tPlease, enter password! " +
                        "(You can skip this by keeping field in empty state): ");
                password = InputClientReader.getInputReader().nextLine().trim();
                if (!password.isEmpty() && passwordPattern.matcher(password).find() && password.length() <= 16) break;
                MessageHandler.displayToUser("Password should be string of letters and digits");
            }
            return password.trim();
        } else {
            String password;
            Pattern passwordPattern = Pattern.compile("^\\s*([\\d\\w]*)\\s*");
            while (true) {
                MessageHandler.displayToUser("\tPlease, enter password! " +
                        "(You can skip this by keeping field in empty state): ");
                password = new String(System.console().readPassword());
                if (!password.isEmpty() && passwordPattern.matcher(password).find() && password.length() <= 16) break;
                MessageHandler.displayToUser("Password should be string of letters and digits!");
            }
            return password.trim();
        }
    }
}
