package ru.vsu.cs.course1.hash.demo;

import ru.vsu.cs.course1.hash.SimpleHashMap;

import java.io.File;
import java.util.*;


public class Program {

    /**
     * Основная функция программы
     *
     * @param args Параметры командной строки
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
//        MapTest.correctTest(new SimpleHashMap<Integer, Integer>(1000), false);
//
//        class Test {
//            int a, b;
//            public Test(int a, int b) {
//                this.a = a;
//                this.b = b;
//            }
//
//            @Override
//            public int hashCode() {
//                // return  a + b;
//                return Objects.hash(a, b);
//            }
//
//            @Override
//            public boolean equals(Object other) {
//                if (!(other instanceof Test)) {
//                    return false;
//                }
//                Test testOther = (Test) other;
//                return this.a == testOther.a && this.b == testOther.b;
//            }
//        }
//
//        Test t1 = new Test(3, 5);
//        Test t2 = new Test(3, 5);
//        System.out.println(t1.hashCode());
//        System.out.println(t2.hashCode());
//        HashMap<Test, Integer> hm = new HashMap<>();
//        hm.put(t1, 3);
//        System.out.println("t2 -> " + hm.get(t2));
//
//        String s1 = "abc";
//        String s2 = "ab";
//        s2 += "c";
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
//        System.out.println("ivanov".hashCode());
// слово, слово
        solution();
    }
    public static void solution(){
    String[] strings = read("input01.txt");
    SimpleHashMap<String, Integer> map = new SimpleHashMap<>(strings.length);
    ArrayList<String> keys = new ArrayList<>();
    for(int i = 0; i < strings.length-1; i++){
        String word = strings[i];
        char[] symbols = word.toCharArray();
        if(Character.isLetter(symbols[word.length()-1])){
            String phrase = strings[i] + " " + strings[i+1];
            if(!map.containsKey(phrase)){
                map.put(phrase,1);
                keys.add(phrase);
            }else{
                int value = map.get(phrase);
                map.put(phrase,value+1);
            }
        }
    }
  /*  double length = map.getLoadedBucketsCount();*/
        for (String key: keys ) {
            System.out.println(key + ": " + map.get(key));
        }
    }
    public static String[] read(String filename){
        try {
            Scanner scanner = new Scanner(new File(filename));
            String text = "";
            while (scanner.hasNextLine()) {
                text = text + scanner.nextLine();
            }
            text.toLowerCase(Locale.ROOT);
            scanner.close();
            String[] words = text.split("[ ]+");
            return words;
        } catch (Exception e) {
            return null;
        }
    }
}
