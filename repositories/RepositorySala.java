package repositories;

import java.util.ArrayList;
import java.util.List;
import models.Sala;

public class RepositorySala extends Repository<Sala> {
    private static RepositorySala singleton;

    public RepositorySala(List<Sala> list) {
        super(list);
    }

    public static RepositorySala getInstance() {
        if(singleton == null)
            singleton = new RepositorySala(new ArrayList<>());

        return singleton;
    }

        @Override
    public Sala findElementById(Long id) {
        for (Sala element : list) {
            if(element.getId() == id) {
                return element;
            }
        }

        return null;
    }
    
}
