package repositories;

import java.util.List;

public abstract class Repository<T> {

    Repository<T> singleton;
    List<T> list;

    public Repository(List<T> list) {
        this.singleton = this;
        this.list = list;
    }

    public abstract T findElementById(int id);

    public List<T> findAllElements() {
        return list;
    }

    public boolean updateElement(int id, T element) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).id == id)
            {
                
            }
        }
        list.set(id, element);
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
