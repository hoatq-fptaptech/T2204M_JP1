package assignment;

import java.util.ArrayList;

public class PhoneNumber {
    String name;
    ArrayList<String> tel;

    public PhoneNumber(String name,String tel) {
        this.name = name;
        this.tel = new ArrayList<>();
        this.tel.add(tel);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getTel() {
        return tel;
    }
}
