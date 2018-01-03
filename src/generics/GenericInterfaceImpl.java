package generics;

public class GenericInterfaceImpl implements GenericInterface<Integer> {

    @Override
    public String stringify(Integer type) {
        return type.toString();
    }

    public static void main(String[] args) {
        GenericInterfaceImpl gii = new GenericInterfaceImpl();

        System.out.println(gii.stringify(1));
    }
}
