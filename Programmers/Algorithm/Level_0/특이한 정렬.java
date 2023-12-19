import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Arrays.sort(numlist);
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<numlist.length; i++){
            list.add(numlist[i]);
        }
        list.sort((s1, s2) -> Integer.compare(Math.abs(s2-n), Math.abs(s1-n)));
        Collections.reverse(list);

        return list.stream().mapToInt(num->num).toArray();
    }
}