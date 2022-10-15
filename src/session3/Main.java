package session3;


import session2.FptStudent;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        FptStudent[] fptStudents = new FptStudent[4];
        fptStudents[0] = new FptStudent();
        fptStudents[1] = new FptStudent();

        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        fptStudents[0].run();

        ArrayList<FptStudent> fArr = new ArrayList<>();
        fArr.add(new FptStudent());
        fArr.add(new FptStudent());
        fArr.add(new FptStudent());

        fArr.get(0).run(); // fArr[0]

        for(int i=0;i<fArr.size();i++){
            fArr.get(i).run("ABC");
        }

        for(FptStudent fx : fArr){
            fx.run("XYZ");// fx = fArr[i]
        }

        ArrayList<String> strArr = new ArrayList<>();
        ArrayList<Integer> intArr = new ArrayList<Integer>();
        intArr.add(10);

        T2204MStudent ts = new T2204MStudent();
        ts.run();
        ts.setMark(5);
        System.out.println(ts.getMark());
       // ts.mark
    }
}
