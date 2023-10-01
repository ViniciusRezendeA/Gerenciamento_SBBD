package repositories;

import java.util.List;
import models.Estudante;

public class RepositoryEstudante extends Repository<Estudante> {

    public RepositoryEstudante(List<Estudante> list) {
        super(list);
    }

    @Override
    public Estudante findElementById(int id) {
        for (Estudante element : list) {
            if (element.getId() == id) {
                return element;
            }
        }

        return null;
    }

}
