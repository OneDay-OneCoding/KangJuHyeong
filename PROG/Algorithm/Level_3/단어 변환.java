import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        // words 배열에 target이 존재하지 않는 경우 bfs를 실행하지 않고 바로 종료한다.
        boolean check = false;
        for(int i=0; i<words.length; i++){
            if(target.equals(words[i])){
                check = true;
                break;
            }
        }
        
        if(check){
            bfs(begin, target, words);
            if(answer == Integer.MAX_VALUE){
                answer = 0;
            }    
        }
        else{
            answer = 0;
        }
        
        return answer;
    }
    
    public void bfs(String begin, String target, String[] words){
        Queue<Word> queue = new ArrayDeque<>();
        queue.offer(new Word(begin, 0));
        
        while(!queue.isEmpty()){
            Word w = queue.poll();
            
            // 현재 변환된 단어가 target가 일치하면 중단한다.
            if(w.word.equals(target)){
                answer = Math.min(answer, w.depth);
                return;
            }
            else{
                // 현재 단어와 한 글자 차이인 단어가 words에 존재하는지 확인한다.
                for(int i=0; i<words.length; i++){
                    if(!visited[i]){
                        if(compare(w.word, words[i]) == 1){
                            queue.offer(new Word(words[i], w.depth+1));
                            visited[i] = true;
                        }
                    }
                }
            }
        }
        
    }
    
    public int compare(String a, String b){
        int diff = 0;
        
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        
        for(int i=0; i<arrayA.length; i++){
            if(arrayA[i] != arrayB[i]){
                diff += 1;
            }
        }
        
        return diff;
    }
}

class Word{
    String word;
    int depth;
    
    public Word(String w, int d){
        word = w;
        depth = d;
    }
}