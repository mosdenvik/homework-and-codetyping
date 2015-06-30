package org.oa.md.dao;

import java.util.Collection;
import java.util.List;

public interface AbstractDAO<T> {

	List<T> loadAll();

	T findById(long id);

	boolean delete(long id);

	boolean update(T changed);

	boolean add(T item);

	boolean addAll(Collection<T> collection);
}
