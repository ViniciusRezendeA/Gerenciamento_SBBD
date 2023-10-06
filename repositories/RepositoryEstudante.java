package repositories;

import java.util.ArrayList;
import java.util.List;
import models.Estudante;

public class RepositoryEstudante extends Repository<Estudante> {
    private static RepositoryEstudante singleton;

    public RepositoryEstudante(List<Estudante> list) {
        super(list);
    }

    public static RepositoryEstudante getInstance() {
        if(singleton == null)
            singleton = new RepositoryEstudante(new ArrayList<>());
            
        return singleton;
    }

    @Override
    public Estudante findElementById(Long id) {
        for (Estudante element : list) {
            if (element.getId() == id) {
                return element;
            }
        }

        return null;
    }
    @Override
    public Long getLastIndex() {
        return list.get(list.size()-1).getId();
    }
}
