package global.goit;

import global.goit.myhashmapfolder.MyHashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String,String> mm= new MyHashMap<>();
        mm.put("zeroUser"," MyHashMap");
        mm.put("firstUser"," firstUser ");
        mm.put("secondUser"," secondUser ");
        System.out.println(mm);
    }
}
