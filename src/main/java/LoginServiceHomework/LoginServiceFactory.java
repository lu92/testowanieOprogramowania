package LoginServiceHomework;

/**
 * Created by lucjan on 30.05.15.
 */
public interface LoginServiceFactory{
    UserDataBase getUserDataBase();
    Encoder getEncoder();
}
