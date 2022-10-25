package fr.lernejo;

import fr.lernejo.umlgrapher.GraphType;
import fr.lernejo.umlgrapher.UmlGraph;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class UmlGraphTypeTest {

    @Test
    void interface_with_parent_relation() {
        Class[] tab = {Living.Animal.Ant.class, Living.Animal.Cat.class, Living.Plant.Tree.Alder.class};
        UmlGraph graph = new UmlGraph(tab);
        String output = graph.as(GraphType.Mermaid);
        Assertions.assertThat(output).isEqualTo("""
            classDiagram
             class Alder
             class Animal {
                 <<interface>>
             }
             class Ant
             class Cat
             class Living {
                 <<interface>>
             }
             class Plant {
                 <<interface>>
             }
             class Tree {
                 <<interface>>
             }
             Tree <|.. Alder : implements
             Living <|-- Animal : extends
             Animal <|.. Ant : implements
             Animal <|.. Cat : implements
             Living <|-- Plant : extends
             Plant <|-- Tree : extends
            """);
    }

    public sealed interface Living {
        sealed interface Animal extends UmlGraphTypeTest.Living {
            final class Ant implements Animal {
            }

            final class Cat implements Animal {
            }
        }

        sealed interface Plant extends UmlGraphTypeTest.Living {
            sealed interface Tree extends Plant {
                final class Alder implements Tree {
                }
            }
        }
    }

}
