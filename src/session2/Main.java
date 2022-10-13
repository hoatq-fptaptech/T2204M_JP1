package session2;

import session1.Student;

public class Main {
    public static void main(String[] args){
        Student t = new Student();
        t.name = "Vũ Xuân Đồng";

        FptStudent ft = new FptStudent();
        ft.run();
        ft.run(10);
        ft.run(10,"Hello");

        FptStudent ft1 = new FptStudent("Xin chao cac ban");

        FptStudent ft2 = new FptStudent("Th22092929","Vũ Thế Anh","092282882");
    }
}
