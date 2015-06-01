package LoginServiceHomework;

public class LoginService {

    UserDataBase db;
    Encoder encoder;
    public LoginService(UserDataBase db, Encoder encoder){
        this.db = db;
        this.encoder = encoder;
        db.connect();
    }
    /**
     * Dokonuje autoryzacji uzytkownika.
     * W tym celu szyfruje userPassword uzywajac encoder'a,
     * a nastepnie sprawdza w bazie danych (db) czy uzytkownik
     * o danym userLogin i obliczonym zaszyfrowanym haśle istnieje.
     * Przed pierwsza operacja na bazie danych sprawdza stan połączenia,
     * w razie potrzeby wywoluje metode connect.
     *
     * @param userLogin     login uzytkownika
     * @param userPassword  haslo uzytkowika
     * @return zwraca true jeżeli dany użytkownik zajduje się w bazie danych.
     *         zwraca false jeżeli użytkownik nie istnieje albo
     *         gdy userLogin lub userPassword sa równe null
     */
    public boolean login(String userLogin, String userPassword){

        if(!db.isConnected()) db.connect();
        if((userLogin == null) || (userPassword == null))
            return false;

        String hashPassword = encoder.encode(userPassword);
        return (db.getUserByLoginAndPassword(userLogin, hashPassword)!=null);
    }
}
