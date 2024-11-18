package hu.szamalk;

import hu.szamalk.idomok.FaIdom;
import hu.szamalk.idomok.Gomb;
import hu.szamalk.idomok.Hasab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FaIdomok {
    private ArrayList<FaIdom> idomok;

    public FaIdomok() {
        idomok = new ArrayList<>();
        idomok.add(new Gomb(1));
        //idomok.add(new Gomb(1));
        //idomok.add(new Hasab(1,2,3));
        idomok.add(new Hasab(10,1,1));
    }


    public void run(){
        System.out.println("A programban használt idomok:");
        for(FaIdom idom:idomok){
            System.out.println(idom);
        }
        System.out.println("Összsúly = "+ this.osszSuly());
        System.out.println("Gömbök összsúlya = "+ this.osszGombSuly());
        System.out.println("Max térfogat: "+maxV() +"térfogata: "+this.maxV().terfogat());
        System.out.println("Min térfogat: "+minV()+"térfogata: "+this.minV().terfogat());
    }
    public double osszSuly(){
        double ossz =  0.0;
        for(FaIdom idom:idomok){
            ossz += idom.suly();
        }
        return ossz;
    }
    public double osszGombSuly(){
        double osszG =  0.0;
        for(FaIdom idom:idomok){
            if(idom instanceof Gomb) {
                osszG += ((Gomb)idom).suly();
            }
        }
        return osszG;
    }
    public FaIdom maxV(){
        //Collections.max()
        FaIdom max = idomok.get(0);
        for (int i = 0; i < idomok.size()-1; i++) {
            if(max.terfogat() < idomok.get(i+1).terfogat()){
                max = idomok.get((i+1));
            }
        }
        return max;
    }

    public FaIdom minV(){
        //Collections.min()
        FaIdom min = idomok.get(0);
        for (int i = 0; i < idomok.size()-1; i++) {
            if(min.terfogat() > idomok.get(i+1).terfogat()){
                min = idomok.get((i+1));
            }
        }
        return min;
    }
//    Collection.M

}
