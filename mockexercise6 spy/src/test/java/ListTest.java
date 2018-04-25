import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class ListTest {

    // Nota: la lista può essere inizializzata qui e iniettata dentro la classe da testare
    @Spy
    private ArrayList<String> spyList = new ArrayList<String>();

    @Mock
    private ArrayList<String> justMockedList = new ArrayList<String>();

    @Test
    public void testSpyList() {

        // Eseguo una chiamata sull'oggetto spiato
        spyList.add("Ciao mondo");


        // Verifico come un mock che il comportamento sia stato supportato
        BDDMockito.then(spyList).should().add(Mockito.eq("Ciao mondo"));
//        Mockito.verify(spyList).add("Ciao mondo");

        // Qui posso verificare che lo stato della lista è stato modificato
        Assert.assertEquals(1, spyList.size());

    }


    @Test
    public void testJustMockedList() {

        // Esempio se è solo il mock
        justMockedList.add("Ciao mondo");

        BDDMockito.then(justMockedList).should().add(Mockito.eq("Ciao mondo"));

        // Qui posso verificare che lo stato della lista è quello di default
        Assert.assertEquals(0, justMockedList.size());

    }

    @Test
    public void testSpyReturnsStubbedValues() throws Exception {
        int size = 5;
        // Stubbo la chiamata a size
        BDDMockito.given(spyList.size()).willReturn(1, size);
//        Mockito.when(listSpy.size()).thenReturn(1, size);

        // Prima chiamata risultato reale
        int mockedListSize = spyList.size();
        Assert.assertEquals(1, mockedListSize);

        // Dalla seconda il risultato stubbato
        mockedListSize = spyList.size();
        Assert.assertEquals(5, mockedListSize);

        mockedListSize = spyList.size();
        Assert.assertEquals(5, mockedListSize);
    }

    @Test(expected=Exception.class)
    public void shouldThrowsException() throws Exception {
        spyList.add("dobie");
        Assert.assertEquals(1, spyList.size());

        // Stubbo il lancio di una eccezione
        BDDMockito.given(spyList.get(Mockito.anyInt())).willThrow(new Exception());
//        Mockito.when(listSpy.get(anyInt())).thenThrow(new Exception());
        spyList.get(0);
    }

}
