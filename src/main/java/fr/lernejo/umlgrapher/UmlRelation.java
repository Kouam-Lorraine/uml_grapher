package fr.lernejo.umlgrapher;

import java.util.Set;

public class UmlRelation {

    private final Set<UmlType> tree;

    public UmlRelation(Set<UmlType> tree){
        this.tree = tree;
    }

    public String getRelation(String relation){

        for(UmlType umlType : tree){
            Class[] types = umlType.getClasse().getInterfaces();
            for(Class type : types){
                if(umlType.getClasse().getSuperclass() == null){
                    relation +=" "+ type.getSimpleName()+" <|-- "+ umlType.getClasse().getSimpleName()+" : extends\n";
                } else{
                    relation += " " +type.getSimpleName()+" <|.. "+ umlType.getClasse().getSimpleName()+" : implements\n";
                }
            }
        }
        return relation;
    }

}
