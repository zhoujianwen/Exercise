package three;

/**
 * Created by Clement0908 on 2016-4-25.
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String getContent() {
        return getName();
    }
}
