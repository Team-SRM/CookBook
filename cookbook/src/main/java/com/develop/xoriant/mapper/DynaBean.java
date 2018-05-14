package com.develop.xoriant.mapper;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
/*
 * @Author : Sagar Gaikwad
 * @Created On 14/05/2018
 * */
public class DynaBean {
	/**
     * The map of name / value pairs.
     */
    protected final Map<String, Object> other = new HashMap<String, Object>();

    /**
     * Default constructor.
     */
    public DynaBean()
    {
    }
    
    /**
     * Constructor.
     * 
     * @param other initial name/value pairs
     */
    public DynaBean(Map<String, Object> other)
    {
        this.other.putAll(other);
    }
    
    /**
     * @param name the name of the item
     * @return the associated object
     */
    public Object get(String name)
    {
        return other.get(name);
    }

    /**
     * "any getter" needed for serialization.
     * 
     * @return map of strings to objects
     */
    @JsonAnyGetter
    public Map<String, Object> any()
    {
        return other;
    }

    /**
     * @param name the name
     * @param value the value
     */
    @JsonAnySetter
    public void set(String name, Object value)
    {
        other.put(name, value);
    }
}
