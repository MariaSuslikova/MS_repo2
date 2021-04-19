package com.mssslkova.tamagotchi;

public class RecordEntity
{
    public String name;
    public float livetime;
    public RecordEntity(String name, float livetime)
    {
        this.name = name;
        this.livetime = livetime;
    }
    public String getName()
    {
        return name;
    }
    public float getLivetime()
    {
        return livetime;
    }
}
