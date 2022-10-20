package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook extends Phone{
    ArrayList<PhoneNumber> phoneList = new ArrayList<>();

    public ArrayList<PhoneNumber> getPhoneList() {
        return phoneList;
    }

    @Override
    void insertPhone(String name, String phone) {
        for(PhoneNumber p : getPhoneList()){
            if(p.getName().equals(name)){
                for(String s: p.getTel()){
                    if(s.equals(phone)){
                        return;
                    }
                }
                p.getTel().add(phone);
                return;
            }
        }
        PhoneNumber pn = new PhoneNumber(name,phone);
        getPhoneList().add(pn);
    }

    @Override
    void removePhone(String name) {
        for(PhoneNumber p : getPhoneList()){
            if(p.getName().equals(name)){
                getPhoneList().remove(p);
                return;
            }
        }
    }

    @Override
    void updatePhone(String name, String oldPhone, String newPhone) {
        for(PhoneNumber p : getPhoneList()){
            if(p.getName().equals(name)) {
                p.getTel().remove(oldPhone);
                p.getTel().add(newPhone);
                return;
            }
        }
    }

    @Override
    PhoneNumber searchPhone(String name) {
        for(PhoneNumber p: getPhoneList()){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    @Override
    void sort() {
        // bubble sort
//        for(int i=0;i<getPhoneList().size()-1;i++){
//            for(int j=0;j<getPhoneList().size()-i-1;j++){
//                if(getPhoneList().get(j).getName().compareTo(getPhoneList().get(j+1).getName()) >0){
//                    PhoneNumber pn = getPhoneList().get(j);
//                    getPhoneList().set(j,getPhoneList().get(j+1)); // arr[j]=arr[j+1]
//                    getPhoneList().set(j+1,pn);
//                }
//            }
//        }
//        Collections.sort(getPhoneList(), new Comparator<PhoneNumber>() {
//            @Override
//            public int compare(PhoneNumber o1, PhoneNumber o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
        Comparator<PhoneNumber> cp = (o1,o2)->{
            return o1.getName().compareTo(o2.getName());
        };
        Collections.sort(getPhoneList(), cp);
    }
}
