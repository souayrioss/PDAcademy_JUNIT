package org.pda.junit.service;

public interface IFilterService<T> {
    public T getAllAndCount();
    public long getCount();

}
