package repositories;

import java.util.ArrayList;
import java.util.List;
import models.SessaoTecnica;

public class RepositorySessaoTecnica extends Repository<SessaoTecnica> {
    private static RepositorySessaoTecnica singleton;

    public RepositorySessaoTecnica(List<SessaoTecnica> list) {
        super(list);
    }

    public static RepositorySessaoTecnica getInstance() {
        if(singleton == null)
            singleton = new RepositorySessaoTecnica(new ArrayList<>());

        return singleton;
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
        @Override
    public Long getLastIndex() {
        if(list.isEmpty())
            return 1L;
        return list.get(list.size()-1).getId();
    }
}
