package repositories;

import java.util.List;
import models.Sala;

public class RepositorySala extends Repository<Sala> {

    public RepositorySala(List<Sala> list) {
        super(list);
    }

        @Override
    public Sala findElementById(int id) {
        for (Sala element : list) {
            if(element.getId() == id) {
                return element;
            }
        }

        return null;
    }
    
}
