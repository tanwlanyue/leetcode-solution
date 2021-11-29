package EXT23;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 循环依赖检测。如，[['A', 'B'], ['B', 'C'], ['C', 'D'], ['B', 'D']] => false，[['A', 'B'], ['B', 'C'], ['C', 'A']] => true
 * @author zhanglei211 on 2021/11/29.
 */
public class Solution {

    public void checkLoop(char[][] arr){
        HashMap<Character, Integer> inDegreeMap = new HashMap<>();
        HashMap<Character, ArrayList<Character>> childMap = new HashMap<>();
        for (char[] pair : arr) {
            inDegreeMap.put(pair[1],inDegreeMap.getOrDefault(pair[1],0)+1);
            ArrayList<Character> list = childMap.computeIfAbsent(pair[0], k -> new ArrayList<>());
            list.add(pair[0]);
        }
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (char[] chars : arr) {
            if (!inDegreeMap.containsKey(chars[0])) {
                queue.add(chars[0]);
            }
        }
        int count=0;
        while (!queue.isEmpty()){
            Character poll = queue.poll();
            count++;
            ArrayList<Character> characters = childMap.get(poll);
            for (Character character : characters) {
                Integer inDegree = inDegreeMap.get(character);
                inDegreeMap.put(character,inDegree-1);
                if(inDegree==1){
                    queue.add(character);
                }
            }
        }
    }
}
