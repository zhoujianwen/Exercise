package three;

/**
 * Created by Clement0908 on 2016-4-25.
 */
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String getContent() {
        return getName();
    }
}
