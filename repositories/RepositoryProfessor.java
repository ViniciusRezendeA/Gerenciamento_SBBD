package repositories;

import java.util.ArrayList;
import java.util.List;
import models.Professor;

public class RepositoryProfessor extends Repository<Professor> {
    private static RepositoryProfessor singleton;

    public RepositoryProfessor(List<Professor> list) {
        super(list);
    }

    public static RepositoryProfessor getInstance() {
        if(singleton == null)
            singleton = new RepositoryProfessor(new ArrayList<>());

        return singleton;
    }

        @Override
    public Professor findElementById(Long id) {
        for (Professor element : list) {
            if(element.getId() == id) {
                return element;
            }
        }

        return null;
    }
    @Override
    public Long getLastIndex() {
        if(list.isEmpty())
            return 0L;
        return list.get(list.size()-1).getId();
    }
}
