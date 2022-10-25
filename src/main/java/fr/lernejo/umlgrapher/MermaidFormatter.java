package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;
import java.util.Set;

public class MermaidFormatter {

    private final Set<UmlType> type;

    public MermaidFormatter(Set<UmlType> type){
        this.type = type;
    }

    public String form(){
        String str = "classDiagram\n";
        for(UmlType u : type){
            str += " class " + u.name();
            if(Modifier.isInterface(u.getClasse().getModifiers())){
                str += " {\n     <<interface>>\n }";
            }
            str += "\n";
        }
        return str;
    }
}
