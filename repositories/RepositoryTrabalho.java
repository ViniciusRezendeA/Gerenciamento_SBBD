package repositories;

import java.util.List;

import models.Estudante;
import models.Trabalho;

public class RepositoryTrabalho extends Repository<Trabalho> {

    public RepositoryTrabalho(List<Trabalho> list) {
        super(list);
    }

    @Override
    public Trabalho findElementById(int id) {
        for (Trabalho element : list) {
            if (element.getId() == id) {
                return element;
            }
        }

        return null;
    }

}
