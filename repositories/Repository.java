package repositories;

import java.util.List;

public abstract class Repository<T> {

    Repository<T> singleton;
    List<T> list;

    public Repository(List<T> list) {
        this.singleton = this;
        this.list = list;
    }

    public abstract T findElementById(Long id);

    public List<T> findAllElements() {
        return list;
    }

    public boolean updateElement(Long id, T element) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).hashCode() == id.hashCode() - 31)
            {
                list.set(i, element);
                return true;
            }
        }

        return false;
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
