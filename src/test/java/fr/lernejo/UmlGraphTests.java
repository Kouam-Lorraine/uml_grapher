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

    /*public sealed interface Living {
        sealed interface Animal extends Living {
            final class Ant implements Animal {
            }

            final class Cat implements Animal {
            }
        }

        sealed interface Plant extends Living {
            sealed interface Tree extends Plant {
                final class Alder implements Tree {
                }
            }
        }
    }*/
}
