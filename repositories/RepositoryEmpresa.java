package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Empresa;

public class RepositoryEmpresa extends Repository<Empresa> {
    private static RepositoryEmpresa singleton;

    public RepositoryEmpresa(List<Empresa> list) {
        super(list);
    }

    public static RepositoryEmpresa getInstance() {
        if(singleton == null)
            singleton = new RepositoryEmpresa(new ArrayList<>());
        
        return singleton;
    }

    @Override
    public Empresa findElementById(Long id) {
        for (Empresa element : list) {
            if(element.getId() == id) {
                return element;
            }
        }

        return null;
    }

    
}