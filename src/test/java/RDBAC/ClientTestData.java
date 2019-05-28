package RDBAC;

import RDBAC.model.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClientTestData {
    private static Client client1 = new Client(1, "Ivanov Viktor", "+375291111111");
    private static Client client2 = new Client(2, "Vales Dmitry", "+375297777777");
    private static Client client3 = new Client(3, "Koval Alexander", "+375295555555");
    public static final List<Client> testClientList = new ArrayList<>(Arrays.asList(client1, client2, client3));


}
