package three;

/**
 * Created by Clement0908 on 2016-4-25.
 * 3.动物的不同的叫声
 * 定义一个动物类(Animal)、猫类(Cat)及狗类(Dog)，用猫类及狗类实现动物类的不同的叫声(voice)。
 */

public class ObjOrientedDemo {
    public static void main(String[] args)
    {
        Animal animal = new Cat("我是黄猫，喵喵喵！");
        animal.Voice();
        animal = new Dog("我是黑狗，汪汪汪！");
        animal.Voice();
        animal = new Sheep("我是山羊，咩咩咩！");
        animal.Voice();
    }
}
