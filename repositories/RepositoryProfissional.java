package repositories;

import java.util.ArrayList;
import java.util.List;
import models.Profissional;

public class RepositoryProfissional extends Repository<Profissional> {
    private static RepositoryProfissional singleton;

    public RepositoryProfissional(List<Profissional> list) {
        super(list);
    }

    public static RepositoryProfissional getInstance() {
        if(singleton == null)
            singleton = new RepositoryProfissional(new ArrayList<>());
            
        return singleton;
    }

    @Override
    public Profissional findElementById(Long id) {
        for (Profissional element : list) {
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
