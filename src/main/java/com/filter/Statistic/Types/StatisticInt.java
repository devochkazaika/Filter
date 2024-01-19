package com.filter.Statistic.Types;

public class StatisticInt implements IStatisticTypes<Integer>{
    int count = 0;
    float mean = 0;
    int sum = 0;
    int max = -Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    @Override
    public int getCount(){return count;}
    @Override
    public Integer getSum(){return sum;}
    @Override
    public Integer getMax(){return max;}
    @Override
    public Integer getMin(){return min;}
    @Override
    public float getMean() {return mean;}
    @Override
    public void setCount(Integer value){count = value;}
    @Override
    public void setMax(Integer value){max = value.intValue();}
    @Override
    public void setMin(Integer value){min = value.intValue();}
    @Override
    public void setMean(Integer s, Integer c){mean = (float) s / (float) c;}
    @Override
    public void setSum(Integer value){sum += value.intValue();}
}