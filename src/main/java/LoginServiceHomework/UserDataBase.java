package LoginServiceHomework;

/**
 * Created by lucjan on 30.05.15.
 */
public interface UserDataBase {
    /**
     *  Laczy z bazą danych.
     *  Polecenie connect nalezy wykonac przed wykonaniem innych metod klasy UserDataBase.
     *  @throws RuntimeException jeżeli polaczenie nie zostalo nawiazane.
     */
    public void connect() throws RuntimeException;
    /**
     * Zwraca stan polaczenia
     * @return true jezeli polaczenie jest nawiazane
     */
    public boolean isConnected();
    /** Zwraca użytkownika o podanym loginie i haśle,
     *   jeżeli taki nie istnieje w bazie danych to zwraca null.
     *
     * @param  login     login użytkownika
     * @param  password  hash hasla
     * @return User
     */
    public User getUserByLoginAndPassword(String login, String password);
}
