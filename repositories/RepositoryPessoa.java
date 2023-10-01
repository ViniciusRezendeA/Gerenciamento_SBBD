package repositories;

import java.util.List;
import models.Pessoa;

public class RepositoryPessoa extends Repository<Pessoa>{

    public RepositoryPessoa(List<Pessoa> list) {
        super(list);
    }

    @Override
    public Pessoa findElementById(int id) {
        for (Pessoa element : list) {
            if(element.getId() == id) {
                return element;
            }
        }

        return null;
    }

}
