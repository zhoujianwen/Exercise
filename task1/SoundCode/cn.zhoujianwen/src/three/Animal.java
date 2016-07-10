package three;

/**
 * Created by Clement0908 on 2016-4-25.
 */
abstract class Animal
{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void  Voice(){
        System.out.println(getContent());
    }

    public abstract String getContent();
}