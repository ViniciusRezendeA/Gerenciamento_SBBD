package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Apresentacao;

public class RepositoryApresentacao extends Repository<Apresentacao> {
    private static RepositoryApresentacao singleton;

    public RepositoryApresentacao(List<Apresentacao> list) {
        super(list);
    }

    public static RepositoryApresentacao getInstance() {
        if(singleton == null)
            singleton = new RepositoryApresentacao(new ArrayList<>());
        
        return singleton;
    }

    @Override
    public Apresentacao findElementById(Long id) {
        for (Apresentacao element : list) {
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
