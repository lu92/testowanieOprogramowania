import LoginServiceHomework.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.*;

/**
 * Created by lucjan on 30.05.15.
 */
public class LoginServiceTest {
    private List<User> contentOfDatabase = new ArrayList<User>();

    @Before
    public void MockObjects() {

        String name1 = "Adam";
        String surname1 = encodeBase64("Kowalski");

        String name2 = "Jan";
        String surname2 = encodeBase64("Nowak");

        String name3 = "Krystyna";
        String surname3 = encodeBase64("Czubowna");

        contentOfDatabase.add(new User(name1, surname1));
        contentOfDatabase.add(new User(name2, surname2));
        contentOfDatabase.add(new User(name3, surname3));
    }

    @Test
    public void getUserFromDB() {
        UserDataBase userDataBase = Mockito.mock(UserDataBase.class);
        Mockito.when(userDataBase.getUserByLoginAndPassword(Matchers.anyString(),Matchers.anyString())).thenAnswer(new Answer<User>() {

            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {

                String name = invocationOnMock.getArguments()[0].toString();
                String surname = invocationOnMock.getArguments()[1].toString();

                for (User user : contentOfDatabase) {
                    if (user.getName().equals(name) && user.getSurname().equals(surname))
                        return user;
                }
                return null;
            }
        });


        Encoder encoder = Mockito.mock(Encoder.class);

        Mockito.when(encoder.encode(Matchers.anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
//                do kodowania zosalo uzyte kodowanie Base64 ktore jest juz zaimplementowane w Javie
                String text = invocationOnMock.getArguments()[0].toString();
                return encodeBase64(text);
            }
        });

        LoginService loginService1 = new LoginService(userDataBase, encoder);
        Assert.assertTrue(loginService1.login("Jan", "Nowak"));
    }

    @Test
    public void loginServiceFailureTestWithNameNull() {
//        LoginService loginService1 = new LoginService(userDataBase, encoder);
        UserDataBase userDataBase = Mockito.mock(UserDataBase.class);
        Mockito.when(userDataBase.getUserByLoginAndPassword(Matchers.anyString(),Matchers.anyString())).thenAnswer(new Answer<User>() {

            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {

                String name = invocationOnMock.getArguments()[0].toString();
                String surname = invocationOnMock.getArguments()[1].toString();

                for (User user : contentOfDatabase) {
                    if (user.getName().equals(name) && user.getSurname().equals(surname))
                        return user;
                }
                return null;
            }
        });


        Encoder encoder = Mockito.mock(Encoder.class);

        Mockito.when(encoder.encode(Matchers.anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
//                do kodowania zosalo uzyte kodowanie Base64 ktore jest juz zaimplementowane w Javie
                String text = invocationOnMock.getArguments()[0].toString();
                return encodeBase64(text);
            }
        });

        LoginService loginService1 = new LoginService(userDataBase, encoder);
        Assert.assertFalse(loginService1.login(null, "Nowak"));
    }

    @Test
    public void loginServiceFailureTestSurnameNull() {
//        LoginService loginService1 = new LoginService(userDataBase, encoder);
        UserDataBase userDataBase = Mockito.mock(UserDataBase.class);
        Mockito.when(userDataBase.getUserByLoginAndPassword(Matchers.anyString(),Matchers.anyString())).thenAnswer(new Answer<User>() {

            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {

                String name = invocationOnMock.getArguments()[0].toString();
                String surname = invocationOnMock.getArguments()[1].toString();

                for (User user : contentOfDatabase) {
                    if (user.getName().equals(name) && user.getSurname().equals(surname))
                        return user;
                }
                return null;
            }
        });


        Encoder encoder = Mockito.mock(Encoder.class);

        Mockito.when(encoder.encode(Matchers.anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
//                do kodowania zosalo uzyte kodowanie Base64 ktore jest juz zaimplementowane w Javie
                String text = invocationOnMock.getArguments()[0].toString();
                return encodeBase64(text);
            }
        });

        LoginService loginService1 = new LoginService(userDataBase, encoder);
        Assert.assertFalse(loginService1.login("Jan", null));
    }

    @Test
    public void loginServiceFailureTestWithBothNullParameters() {
//        LoginService loginService1 = new LoginService(userDataBase, encoder);
        UserDataBase userDataBase = Mockito.mock(UserDataBase.class);
        Mockito.when(userDataBase.getUserByLoginAndPassword(Matchers.anyString(),Matchers.anyString())).thenAnswer(new Answer<User>() {

            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {

                String name = invocationOnMock.getArguments()[0].toString();
                String surname = invocationOnMock.getArguments()[1].toString();

                for (User user : contentOfDatabase) {
                    if (user.getName().equals(name) && user.getSurname().equals(surname))
                        return user;
                }
                return null;
            }
        });


        Encoder encoder = Mockito.mock(Encoder.class);

        Mockito.when(encoder.encode(Matchers.anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
//                do kodowania zosalo uzyte kodowanie Base64 ktore jest juz zaimplementowane w Javie
                String text = invocationOnMock.getArguments()[0].toString();
                return encodeBase64(text);
            }
        });

        LoginService loginService1 = new LoginService(userDataBase, encoder);
        Assert.assertFalse(loginService1.login(null, null));
    }

//    UserDataBase tests

    @Test(expected = RuntimeException.class)
    public void connectingFailureTest() {
        UserDataBase userDataBase = Mockito.mock(UserDataBase.class);
        Mockito.doThrow(new RuntimeException()).when(userDataBase).connect();
        userDataBase.connect();
    }

    @Test
    public void connectingFailureTest2() {
        UserDataBase userDataBase = Mockito.mock(UserDataBase.class);
        Mockito.doThrow(new RuntimeException("Cannot connect with database")).when(userDataBase).connect();
        try {
            userDataBase.connect();
        } catch (RuntimeException e) {
            Assert.assertSame("Cannot connect with database", e.getMessage());
        }
        Assert.assertFalse(userDataBase.isConnected());
    }

    @Test
    public void connectingSuccessTest() {
        UserDataBase userDataBase = Mockito.mock(UserDataBase.class);
        Mockito.when(userDataBase.isConnected()).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                return true;
            }
        });
        userDataBase.connect();
        Assert.assertTrue(userDataBase.isConnected());
    }

    @Test
    public void getUserFromDataBaseWhenExists() {
        UserDataBase userDataBase = Mockito.mock(UserDataBase.class);
        Mockito.when(userDataBase.getUserByLoginAndPassword(Matchers.anyString(),Matchers.anyString())).thenAnswer(new Answer<User>() {

            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {

                String name = invocationOnMock.getArguments()[0].toString();
                String surname = invocationOnMock.getArguments()[1].toString();

                for (User user : contentOfDatabase) {
                    if (user.getName().equals(name) && user.getSurname().equals(surname))
                        return user;
                }
                return null;
            }
        });


        Encoder encoder = Mockito.mock(Encoder.class);

        Mockito.when(encoder.encode(Matchers.anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
//                do kodowania zosalo uzyte kodowanie Base64 ktore jest juz zaimplementowane w Javie
                String text = invocationOnMock.getArguments()[0].toString();
                return encodeBase64(text);
            }
        });

        User userFromDB = userDataBase.getUserByLoginAndPassword("Adam", encodeBase64("Kowalski"));
        Assert.assertNotNull(userFromDB);
        Assert.assertEquals("Adam", userFromDB.getName());
        Assert.assertEquals(encodeBase64("Kowalski"), userFromDB.getSurname());
    }

    @Test
    public void getUserFromDataBaseWhenDoesntExists() {
        UserDataBase userDataBase = Mockito.mock(UserDataBase.class);
        Mockito.when(userDataBase.getUserByLoginAndPassword(Matchers.anyString(),Matchers.anyString())).thenAnswer(new Answer<User>() {

            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {

                String name = invocationOnMock.getArguments()[0].toString();
                String surname = invocationOnMock.getArguments()[1].toString();

                for (User user : contentOfDatabase) {
                    if (user.getName().equals(name) && user.getSurname().equals(surname))
                        return user;
                }
                return null;
            }
        });


        Encoder encoder = Mockito.mock(Encoder.class);

        Mockito.when(encoder.encode(Matchers.anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
//                do kodowania zosalo uzyte kodowanie Base64 ktore jest juz zaimplementowane w Javie
                String text = invocationOnMock.getArguments()[0].toString();
                return encodeBase64(text);
            }
        });
        Assert.assertNull(userDataBase.getUserByLoginAndPassword("Fake", new String(Base64.getEncoder().encode("Fake".getBytes()))));
    }




//    Encoder tests

    @Test
    public void encoderTest() {

        Encoder encoder = Mockito.mock(Encoder.class);

        Mockito.when(encoder.encode(Matchers.anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
//                do kodowania zosalo uzyte kodowanie Base64 ktore jest juz zaimplementowane w Javie
                String text = invocationOnMock.getArguments()[0].toString();
                return encodeBase64(text);
            }
        });

        String text = "any text to encode";
        Assert.assertEquals(new String(Base64.getEncoder().encode(text.getBytes())), encoder.encode(text));
    }

    private String encodeBase64(String text) {
        return new String(Base64.getEncoder().encode(text.getBytes()));
    }

    private String decodeBase64(String text) {
        return new String(Base64.getDecoder().decode(text.getBytes()));
    }

}
