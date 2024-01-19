package com.filter.Statistic.Types;

public class StatisticFloat implements IStatisticTypes<Float>{
    float mean = 0;
    int count = 0;
    float sum = 0;
    float max = -Float.MAX_VALUE;
    float min = Float.MAX_VALUE;
    @Override
    public int getCount(){return count;}
    @Override
    public Float getSum(){return sum;}
    @Override
    public Float getMax(){return max;}
    @Override
    public Float getMin(){return min;}
    @Override
    public float getMean() {return mean;}
    @Override
    public void setCount(Integer value){count = value;}
    @Override
    public void setMax(Float value){max = value;}
    @Override
    public void setMin(Float value){min = value;}
    @Override
    public void setMean(Float value, Integer value2){mean = value / value2;}
    @Override
    public void setSum(Float value){sum += value;}
}