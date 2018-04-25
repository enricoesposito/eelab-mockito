package eelab.mockito.exercise1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SayHelloTest {

    @Mock
    private DatabaseProvider databaseProvider;

    @Spy
    private List<String> list = new LinkedList<>();

    private SayHello sayHello;

    @Test
    public void save() {

//        Mockito.when(databaseProvider.save("ciao")).thenCallRealMethod();

        sayHello = new SayHello(databaseProvider);
        System.out.println("Chiama save");
        int result = sayHello.save("ciao");
        assertNotEquals(0, result);
    }
}