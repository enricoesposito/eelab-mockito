package eelab.mock.exercise2;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SayHelloTest {

    public SayHelloTest() {

    }

    @Mock
    private DatabaseProvider databaseProvider;

    @Test
    public void saveCorrect() {

        SayHello sayHello = new SayHello(databaseProvider);
        int result = sayHello.save("ciao");
        Assert.assertNotEquals(0, result);
    }

    @Test
    public void saveToShort() {

        SayHello sayHello = new SayHello(databaseProvider);
        int result = sayHello.save("hi");
        Assert.assertEquals(0, result);
    }
}