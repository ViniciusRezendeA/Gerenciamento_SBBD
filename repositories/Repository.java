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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addElement'");
    }

    public boolean updateElement(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addElement'");

    }

    public boolean deleteElement(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addElement'");

    }

    public boolean addElement(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addElement'");

    }

    public int getAmountOfElements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addElement'");

    }

}
