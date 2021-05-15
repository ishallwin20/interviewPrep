package hashtablelc;

public class DesignHashSet {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(3);
        System.out.println(myHashSet.contains(3));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }
}
