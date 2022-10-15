package fr.lernejo.umlgrapher;

public class UmlGraph{

    final Class nameClasse;

    public UmlGraph(Class nameClasse){

        this.nameClasse = nameClasse;
    }

    public String as(GraphType graphType){

        String typeClassName = "";

        if(nameClasse.isInterface() == true){
            typeClassName = "interface";
        }

        String mot = "classDiagram\nclass " +nameClasse.getSimpleName()+ " {\n    <<"+typeClassName+ ">>\n}\n";

        return mot;
    }
}
