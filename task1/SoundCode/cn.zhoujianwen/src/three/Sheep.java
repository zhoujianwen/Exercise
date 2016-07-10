package three;

/**
 * Created by Clement0908 on 2016-4-26.
 */
public class Sheep extends Animal {
    public Sheep(String name) {
        super(name);
    }

    @Override
    public String getContent() {
        return getName();
    }
}
