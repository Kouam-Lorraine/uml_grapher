package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import fr.lernejo.umlgrapher.GraphType;
import fr.lernejo.umlgrapher.UmlGraph;

class UmlGraphTests {
    @Test
    void empty_interface_with_no_relation() {
        Class[] tab = {Machin.class};
        UmlGraph graph = new UmlGraph(tab);
        String output = graph.as(GraphType.Mermaid);
        Assertions.assertThat(output).isEqualTo("""
            classDiagram
             class Machin {
                 <<interface>>
             }
            """);
    }

    interface Machin {
    }
}
