package SearchingAndSorting;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();

        for(String str : strs){
            List<String> list;
            String key= getSortedStringKey(str);
            // you can use any one of the 2 methods to generate the keys
            // the counting method reduces the time complexity.
            //String key= getCountedStringKey(str);
            if(map.containsKey(key))
                list=map.get(key);
            else{
                list = new ArrayList<String>();
                result.add(list);
            }
            list.add(str);
            map.put(key,list);
        }
        return result;
    }

    public String getSortedStringKey(String str){
        char [] acharArray = str.toCharArray();
        Arrays.sort(acharArray);
        return String.valueOf(acharArray);
    }

    public String getCountedStringKey(String str){
        int [] counter = new int [26];
        char [] ch =  str.toCharArray();
        for(char c: ch)
            counter[c-'a']=counter[c-'a']+1;

        StringBuilder sb = new StringBuilder();
        for(int i : counter){
            sb.append("#");
            sb.append(i);
        }
        return sb.toString();
    }
}
