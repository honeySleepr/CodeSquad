package practice.adapterPattern;

public class DogAdapter implements Cat{
    Dog dog;
    public DogAdapter(Dog dog){
        this.dog = dog;
    }

    @Override
    public void meow() {
        dog.bark();
    }
}
