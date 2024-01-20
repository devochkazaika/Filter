package com.filter.Statistic.Types;

public class StatisticInt implements IStatisticTypes<Long>{
    int count = 0;
    Double mean = (double) 0;
    long sum = 0;
    long max = -Long.MAX_VALUE;
    long min = Long.MAX_VALUE;
    @Override
    public int getCount(){return count;}
    @Override
    public Long getSum(){return sum;}
    @Override
    public Long getMax(){return max;}
    @Override
    public Long getMin(){return min;}
    @Override
    public Double getMean() {return mean;}
    @Override
    public void setCount(Integer value){count = value;}
    @Override
    public void setMax(Long value){max = value.intValue();}
    @Override
    public void setMin(Long value){min = value.intValue();}
    @Override
    public void setMean(Long s, Integer c){mean = (double) s / (double) c;}
    @Override
    public void setSum(Long value){sum += value.intValue();}
}