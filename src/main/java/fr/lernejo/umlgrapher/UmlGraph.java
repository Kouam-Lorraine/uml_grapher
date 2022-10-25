package fr.lernejo.umlgrapher;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UmlGraph{
    private final Class[] tabNameClasses;

    private final Set<UmlType> types = new TreeSet<>(Comparator
        .<UmlType, String>comparing(t->t.name())
        .thenComparing(t->t.packageName()));

    public UmlGraph(Class... tabNameClasse){
        this.tabNameClasses = tabNameClasse;
    }
    public String as(GraphType graphType){
        String mot ="";
        List<Class> classList = null;

        for(Class nameClasses : tabNameClasses){
            switch (graphType){
                case Mermaid:
                    classList = new InternalGraphRepresentation(nameClasses).isRelation();
                    for(Class cl : classList){
                        types.add(new UmlType(cl));
                    }
                    break;
            }
        }
        mot = new UmlRelation(types).getRelation(mot);
        return new MermaidFormatter(types).form() + mot;
    }
}
