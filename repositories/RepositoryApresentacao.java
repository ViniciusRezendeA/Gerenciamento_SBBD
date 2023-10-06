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

    
}
