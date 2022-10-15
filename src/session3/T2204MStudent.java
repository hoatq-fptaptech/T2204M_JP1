package session3;

import session2.FptStudent;

public class T2204MStudent extends FptStudent {
    public String address;

    public T2204MStudent(){

    }

    public T2204MStudent(String code,String name,String tel,String address){
        super(code,name,tel);
        this.address = address;
    }

    @Override
    public void run(int x) {
        System.out.println("100km/h");
    }

    @Override
    public void run(){
        super.run();
        super.run(12);
        this.run(12);
        this.address = "abc";
        System.out.println("50km/h");
    }
}
