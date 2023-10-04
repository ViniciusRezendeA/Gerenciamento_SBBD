package repositories;

import java.util.List;
import models.SessaoTecnica;

public class RepositorySessaoTecnica extends Repository<SessaoTecnica> {

    public RepositorySessaoTecnica(List<SessaoTecnica> list) {
        super(list);
    }

    @Override
    public SessaoTecnica findElementById(Long id) {
        for (SessaoTecnica element : list) {
            if(element.getId() == id) {
                return element;
            }
        }

        return null;
    }
    
}
