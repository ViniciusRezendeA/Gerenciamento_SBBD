package repositories;

import java.util.List;

import models.Apresentacao;

public class RepositoryApresentacao extends Repository<Apresentacao> {

    public RepositoryApresentacao(List<Apresentacao> list) {
        super(list);
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
