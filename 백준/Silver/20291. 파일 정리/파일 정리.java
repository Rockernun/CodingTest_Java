import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// 8
// sbrus.txt
// spc.spc
// acm.icpc
// korea.icpc
// sample.txt
// hello.world
// sogang.spc
// example.txt

// icpc 2
// spc 2
// txt 3
// world 1

public class Main {
    
    static Map<String, Integer> extensionMap;
    
    public static void main(String[] args) {
        extensionMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            String file = sc.next();
            String extension = file.split("\\.")[1];
            extensionMap.put(extension, extensionMap.getOrDefault(extension, 0) + 1);
        }
        
        List<String> keySet = new ArrayList<>(extensionMap.keySet());
        Collections.sort(keySet);
        
        for (String key : keySet) {
            System.out.println(key + " " + extensionMap.get(key));
        }
    }
}
