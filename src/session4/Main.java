package session4;

public class Main {
    public static void main(String[] args){
        //Human h= new Human(); // error
        Vietnamese vn = new Vietnamese();

        Human h = new Human() {
            @Override
            public void eat() {

            }

            @Override
            public void run() {

            }
        };
    }
}
