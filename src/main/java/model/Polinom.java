package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polinom {

    private List<Monom> list=new ArrayList<>();

    public void addMonom(Monom m){
        this.list.add(m);
    }

    public List<Monom> getList() {
        return list;
    }

    public void setList(List<Monom> list) {
        this.list = list;
    }

    public boolean checkOrder(){
        List<Monom> tmp=new ArrayList<>(list);
        Collections.sort(tmp, new SortMonoame());
        boolean sorted=tmp.equals(list);
        return sorted;
    }

    public String toString(){
        String x="";
        for(Monom m: list){
            x+=m.toString();
        }
        return x;
    }
}
