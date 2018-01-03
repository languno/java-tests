package generics;

public class GenericClass<T> {

    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public static void main(String[] args) {
        GenericClass<Integer> intClass = new GenericClass<>();
        GenericClass<String> stringClass = new GenericClass<>();

        intClass.setContent(1);
        stringClass.setContent("content");

        System.out.println("intClass.content: " + intClass.getContent());
        System.out.println("stringClass.content: " + stringClass.getContent());
    }
}
