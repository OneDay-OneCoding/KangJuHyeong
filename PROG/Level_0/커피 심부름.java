class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for(int i=0; i<order.length; i++){
            switch(order[i]){
                case "anything":
                case "americano":
                case "iceamericano":
                case "americanoice":
                case "hotamericano":
                case "americanohot":
                    answer +=4500;
                    break;
                case "cafelatte":
                case "icecafelatte":
                case "cafelatteice":
                case "hotcafelatte":
                case "cafelattehot":
                    answer += 5000;
                    break;
            }
        }
        return answer;
    }
}