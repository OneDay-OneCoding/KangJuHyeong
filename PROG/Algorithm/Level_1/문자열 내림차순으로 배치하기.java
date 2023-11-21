import java.util.*;

class Solution {
    public String solution(String s) {
        // 오름차순은 기본 타입 및 Wrapper 클래스 모두 제한없이 가능하지만,
        // 기본 타입(int, double, char..)인 char를 Collections 인터페이스를 활용하여 
        // 내림차순 정렬하기 위해서는 Wrapper 클래스인 Character로 포장해줘야한다. (Collections.reverseOrder())
        // 그 이유는, Collections 인터페이스가 Object를 상속한 클래스를 대상으로만 지원하기 때문이다.
        
        // 따라서, 기본 타입을 오름차순 정렬한뒤 StringBuilder등을 통해 reverse()할수도 있지만
        // Wrapper 클래스 배열로 변환한뒤 바로 내림차순으로 정렬할수도 있다.
        // Character 배열에서 내림차순을 진행한 뒤, char 배열로 그 결과를 다시 가져와서 반환한다.
        
        String answer = "";
        char[] primitiveArray = s.toCharArray();
        Character[] wrapperArray = new Character[primitiveArray.length];
        
        for(int i=0; i<primitiveArray.length; i++){
            wrapperArray[i] = Character.valueOf(primitiveArray[i]);
        }
        
        Arrays.sort(wrapperArray, Comparator.reverseOrder());
        for(int i=0; i<wrapperArray.length; i++){
            primitiveArray[i] = wrapperArray[i];
        }
        answer = new String(primitiveArray);
        return answer;
    }
}