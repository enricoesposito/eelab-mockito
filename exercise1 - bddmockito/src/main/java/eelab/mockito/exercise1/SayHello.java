package eelab.mockito.exercise1;

public class SayHello {

    private String greeting;

    private DatabaseProvider databaseProvider = new DatabaseProvider();

    public SayHello(DatabaseProvider databaseProvider){
        this.databaseProvider = databaseProvider;
    }

    public int save(String greeting) {

        if(greeting.length()<4) {
            return 0;
        }

        databaseProvider.save(greeting);

        this.greeting = greeting;
        return greeting.length();
    }
}
