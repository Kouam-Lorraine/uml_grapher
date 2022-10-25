package fr.lernejo.umlgrapher;

import java.util.ArrayList;
import java.util.List;

public class InternalGraphRepresentation {

    private final Class classes;

    public InternalGraphRepresentation(Class classes){
        this.classes = classes;
    }

    public List<Class> recursiveRelation(List<Class> recursiveList, Class... otherClasses){

        for(Class c : otherClasses){
            if(!recursiveList.contains(c)){
                recursiveList.add(c);
                recursiveList = recursiveRelation(recursiveList, c.getInterfaces());
            }
        }
        return recursiveList;
    }

    public List<Class> isRelation(){
        List<Class> list = new ArrayList<>();
        list = recursiveRelation(list, this.classes);
        return list;
    }
}
