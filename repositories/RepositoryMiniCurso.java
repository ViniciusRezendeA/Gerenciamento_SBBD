package repositories;

import java.util.ArrayList;
import java.util.List;

import models.MiniCurso;

public class RepositoryMiniCurso extends Repository<MiniCurso> {
    private static RepositoryMiniCurso singleton;

    public RepositoryMiniCurso(List<MiniCurso> list) {
        super(list);
    }

    public static RepositoryMiniCurso getInstance() {
        if(singleton == null)
            singleton = new RepositoryMiniCurso(new ArrayList<>());
        
        return singleton;
    }

    @Override
    public MiniCurso findElementById(Long id) {
        for (MiniCurso element : list) {
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
