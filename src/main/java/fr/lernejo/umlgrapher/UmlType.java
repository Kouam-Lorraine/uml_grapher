package fr.lernejo.umlgrapher;

public class UmlType {

    private final Class classe;

    private final String name;

    private final String packageName;

    public UmlType(Class classe){
        this.classe = classe;
        this.name = classe.getSimpleName();
        this.packageName = classe.getPackageName();
    }

    public Class getClasse(){
        return  this.classe ;
    }

    public String name(){
        return this.name;
    }

    public String packageName(){
        return this.packageName;
    }
}
