package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "Launcher", mixinStandardHelpOptions = true, version = "Launcher 1.0")

public class Launcher implements Runnable{

    public static void main(String[] args){

        new CommandLine(new Launcher()).execute(args);
    }

    @Override
    public void run() {

        UmlGraph umlGraph = new UmlGraph(nomClasses);

        System.out.println(umlGraph.as(typeGraph));
    }

    @Option(names = {"-c", "--classes"}, description = "Renseigne les classes faisant partie de l'analyse", required = true)
    private final Class[] nomClasses = null;


    @Option(names = {"-g", "--graph-type"}, description = "Selectionne le type de graphe que l'on souhaite avoir en sortie")
    private final GraphType typeGraph = GraphType.Mermaid;
}
