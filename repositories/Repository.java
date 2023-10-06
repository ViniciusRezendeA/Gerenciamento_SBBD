package repositories;

import java.util.List;

public abstract class Repository<T> {
    List<T> list;

    public Repository(List<T> list) {
        this.list = list;
    }
    
    public abstract T findElementById(Long id);

    public List<T> findAllElements() {
        return list;
    }

    public boolean updateElement(Long id, T element) {
        int lastIndex = list.indexOf(findElementById(id));

        if(lastIndex == -1)
            return false;

        list.set(lastIndex, element);

        return true;
    }

    public boolean deleteElement(T element) {
        return list.remove(element);
    }

    public boolean addElement(T element) {
        return list.add(element);
    }

    public int getAmountOfElements() {
        return list.size();
    }

}
