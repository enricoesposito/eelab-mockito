package eelab.mockito.exercise1;

public class DatabaseProvider {

    public Void save(String greeting) {

        System.out.println("Save: " + greeting);
        return null;
    }

}
