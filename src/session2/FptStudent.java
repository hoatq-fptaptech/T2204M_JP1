package session2;

import session1.Student;

import java.util.ArrayList;

public class FptStudent {
    protected String code;
    protected String name;
    protected String tel;
    ArrayList<String> girlFriends = new ArrayList<>();
    private int mark;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public FptStudent(){
        System.out.println("FPT student...");
    }

    public FptStudent(String msg){
        System.out.println("FPT student "+msg);
    }

    public FptStudent(String code, String name, String tel) {
        this.code = code;
        this.name = name;
        this.tel = tel;
    }

    public void run(){
        System.out.println("Run 5km/h");
    }

    public void run(int x){
        System.out.println("Run 10km/h");
    }

    public void run(String x){
        System.out.println("Run 15km/h");
    }

    public void run(int x, String y){
        System.out.println("Run 20km/h");
    }

    public void run(String x, int y){
        System.out.println("Run 20km/h");
    }
}
