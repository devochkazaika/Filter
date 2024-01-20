package com.filter.Statistic.Types;

public interface IStatisticTypes<T> {
    public int getCount();
    public T getMax();
    public T getMin();
    public T getSum();
    public Double getMean();
    void setCount(Integer value);
    void setMax(T value);
    void setSum(T value);
    void setMin(T value);
    void setMean(T s, Integer c);
}