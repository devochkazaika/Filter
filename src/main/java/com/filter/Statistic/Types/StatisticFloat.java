package com.filter.Statistic.Types;

public class StatisticFloat implements IStatisticTypes<Double>{
    double mean = 0;
    int count = 0;
    Double sum = (double) 0;
    Double max = -Double.MAX_VALUE;
    Double min = Double.MAX_VALUE;
    @Override
    public int getCount(){return count;}
    @Override
    public Double getSum(){return sum;}
    @Override
    public Double getMax(){return max;}
    @Override
    public Double getMin(){return min;}
    @Override
    public Double getMean() {return mean;}
    @Override
    public void setCount(Integer value){count = value;}
    @Override
    public void setMax(Double value){max = value;}
    @Override
    public void setMin(Double value){min = value;}
    @Override
    public void setMean(Double value, Integer value2){mean = value / value2;}
    @Override
    public void setSum(Double value){sum += value;}
}