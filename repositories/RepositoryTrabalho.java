package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Trabalho;

public class RepositoryTrabalho extends Repository<Trabalho> {
    private static RepositoryTrabalho singleton;

    public RepositoryTrabalho(List<Trabalho> list) {
        super(list);
    }

    public static RepositoryTrabalho getInstance() {
        if(singleton == null)
            singleton = new RepositoryTrabalho(new ArrayList<>());

        return singleton;
    }

    @Override
    public Trabalho findElementById(Long id) {
        for (Trabalho element : list) {
            if (element.getId() == id) {
                return element;
            }
        }

        return null;
    }

}
