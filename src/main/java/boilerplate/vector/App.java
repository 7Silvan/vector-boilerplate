package boilerplate.vector;

import org.apache.commons.lang3.SerializationUtils;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static java.lang.System.out;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        Tree tree = new Tree("Береза");
        DateTime today = new DateTime();
        DateTime yesterday = today.minusDays(1);
        DateTime tomorrow = today.plusDays(1);

        tree.addObject(yesterday);
        tree.addObject(today);
        tree.addObject(tomorrow);

//        Tree clonedTree = (Tree) tree.clone();
        Tree clonedTree = SerializationUtils.clone(tree);

        out.println(clonedTree.toString());
        clonedTree.printCollection();
        tree.addObject(today);
        out.println("tree");
        tree.printCollection();
        out.println("clonedTree");
        clonedTree.printCollection();
    }
}

class Nature implements Serializable {

    private Collection<DateTime> collection = new ArrayList();

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void addObject(DateTime dateTime) {
        collection.add(dateTime);
    }

    public void printCollection() {
        out.print("Collection elements: [");
        for (DateTime o : collection) {
            out.print(o.dayOfYear().get() + ",");
        }

        out.println("]");
    }

    public void setCollection(DateTime ... args) {
        collection.addAll(Arrays.asList(args));
    }



    @Override
    public Object clone() {
        Nature cloned;
        try {
            cloned = (Nature) super.clone();
            cloned.collection = new ArrayList<DateTime>();
            for (DateTime dateTime : collection) {

                cloned.collection.add(new DateTime(dateTime));
            }

            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
            return this;
        }
    }
}

class Tree extends Nature implements Cloneable, Serializable {

    private String name;

    public DateTime getDateTime() {
        return DateTime;
    }

    public void setDateTime(DateTime DateTime) {
        this.DateTime = DateTime;
    }

    private DateTime DateTime = new DateTime();


    public Tree() {
    }

    public Tree(String name) {
        this.name = name;
    }

    @Override
    public Object clone() {

        try {
            return super.clone();
//        } catch (CloneNotSupportedException e) {
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return this;
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", DateTime=" + DateTime +
                '}';
    }
}
