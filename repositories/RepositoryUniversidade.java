package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Universidade;

public class RepositoryUniversidade extends Repository<Universidade> {
    private static RepositoryUniversidade singleton;

    public RepositoryUniversidade(List<Universidade> list) {
        super(list);
    }

    public static RepositoryUniversidade getInstance() {
        if(singleton == null)
            singleton = new RepositoryUniversidade(new ArrayList<>());

        return singleton;
    }

    @Override
    public Universidade findElementById(Long id) {
        for (Universidade element : list) {
            if (element.getId() == id) {
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
