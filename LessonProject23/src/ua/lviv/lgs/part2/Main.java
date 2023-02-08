package ua.lviv.lgs.part2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

            Set<Object> setObject = new HashSet<Object>();
            Consumer<Object> addToHashSet = ObjectItem -> setObject.add(ObjectItem);
            
            addToHashSet.accept(new Object("Igor", 25));
            addToHashSet.accept(new Object("Ulia", 17));
            addToHashSet.accept(new Object("Oleg", 68));
            addToHashSet.accept(new Object("Oleg", 28));
            addToHashSet.accept(new Object("Oleg", 12));
            addToHashSet.accept(new Object("Ivan", 11));
            addToHashSet.accept(new Object("Mykola", 45));
            addToHashSet.accept(new Object("Sema", 76));
            addToHashSet.accept(new Object("Sema", 86));
            addToHashSet.accept(new Object("Dima", 43));
 
            setObject.forEach(System.out::println);

            Set<Object> linkedHashSetObject = new LinkedHashSet<Object>();
            Consumer<Object> addToLinkedHashSet = objectItem -> linkedHashSetObject.add(objectItem);   
            
            addToLinkedHashSet.accept(new Object("Igor", 25));
            addToLinkedHashSet.accept(new Object("Ulia", 17));
            addToLinkedHashSet.accept(new Object("Oleg", 68));
            addToLinkedHashSet.accept(new Object("Oleg", 28));
            addToLinkedHashSet.accept(new Object("Oleg", 12));
            addToLinkedHashSet.accept(new Object("Ivan", 11));
            addToLinkedHashSet.accept(new Object("Mykola", 45));
            addToLinkedHashSet.accept(new Object("Sema", 76));
            addToLinkedHashSet.accept(new Object("Sema", 86));
            addToLinkedHashSet.accept(new Object("Dima", 43));
            

            System.out.println();

            linkedHashSetObject.forEach(System.out::println);
            

            Set<Object> treeSetObject = new TreeSet<Object>();
            Consumer<Object> addToTreeSet = objectItem -> treeSetObject.add(objectItem);
            
            addToTreeSet.accept(new Object("Igor", 25));
            addToTreeSet.accept(new Object("Ulia", 17));
            addToTreeSet.accept(new Object("Oleg", 68));
            addToTreeSet.accept(new Object("Oleg", 28));
            addToTreeSet.accept(new Object("Oleg", 12));
            addToTreeSet.accept(new Object("Ivan", 11));
            addToTreeSet.accept(new Object("Mykola", 45));
            addToTreeSet.accept(new Object("Sema", 76));
            addToTreeSet.accept(new Object("Sema", 86));
            addToTreeSet.accept(new Object("Dima", 43));

            System.out.println();
            System.out.println("Выводит людей (name) в порядке, переопределенном в Comparable.");
            treeSetObject.forEach(System.out::println);

            System.out.println();
            System.out.println("Выводит людей (name, quont) в порядке, переопределенном в Comparator.");
            treeSetObject.stream().sorted(new ObjectIntegerComparator()).forEach(System.out::println);
        }
    }