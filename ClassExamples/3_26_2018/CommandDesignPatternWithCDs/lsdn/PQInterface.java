package lsdn;

public interface PQInterface<T extends KeyedItem<S>, S extends Comparable<S>>
{
   public boolean pqIsEmpty();
   public void pqInsert(T item) throws PQException;
   public T pqDelete() throws PQException;
} 