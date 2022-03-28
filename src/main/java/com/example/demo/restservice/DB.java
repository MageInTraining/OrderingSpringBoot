package com.example.demo.restservice;

import java.util.TreeMap;

public class DB {
    private static DB instance = null;
    private TreeMap<Integer, Order> tm = new TreeMap();

    public static DB getInstance() {
        if (instance == null)
            instance = new DB();
        return instance;
    }
    
    public boolean addObject(Order t, int key){
        boolean r = false;
        if(tm.put(key, t)!=null){
            r = true;
        }
        t.setId(key);
        return r;
    }
    
    public Order getObject(int id) {
        return tm.get(id);
    }
    
    public boolean deleteObject(int id) {
        boolean r = tm.containsKey(id);
        tm.remove(id);
        return r;
    }
    
    public int getLastKey(){
        int r = 0;
        if(tm.isEmpty()==false){
                   r = (int) tm.lastKey();
                }
        return r +1;
    }
    
    public int getnextKey(int i){
        int r = i;
        if(tm.higherKey(i)!= null){
            r = tm.higherKey(i);
        }
        return r;
    }
    public void purgre(){
        tm.clear();
    }
}