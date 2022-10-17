package fr.lernejo.umlgrapher;

public class UmlGraph{
    private final Class[] tabNameClasse;
    public UmlGraph(Class... tabNameClasse){
        this.tabNameClasse = tabNameClasse;
    }
    public String as(GraphType graphType){
        String mot ="classDiagram\n" ;
        for(Class nameClasse : tabNameClasse){

            mot = mot + "class " +nameClasse.getSimpleName();
            if(nameClasse.isInterface() == true){
                mot = mot +" {\n    <<interface>>\n}\n";
            }
        }
        return mot;
    }
}
