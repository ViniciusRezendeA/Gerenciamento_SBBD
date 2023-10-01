package repositories;

import java.util.List;
import models.Professor;

public class RepositoryProfessor extends Repository<Professor> {

    public RepositoryProfessor(List<Professor> list) {
        super(list);
    }

        @Override
    public Professor findElementById(int id) {
        for (Professor element : list) {
            if(element.getId() == id) {
                return element;
            }
        }

        return null;
    }

}
