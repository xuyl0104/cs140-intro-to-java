package assignment03;

public interface Named extends Comparable<Named> {
   String name();
   default int compareTo(Named other) {
       return name().compareToIgnoreCase(other.name());
   }
}