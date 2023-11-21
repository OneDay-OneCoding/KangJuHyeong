import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        // 차량 번호별 최근 입차 기록을 기록하는 맵
        HashMap<String, String> in = new HashMap<>();
        
        // 차량 번호별 최근 출차 기록을 기록하는 맵
        HashMap<String, String> out = new HashMap<>();
        
        // 차량 번호별 입출차 기록을 근거로한 주차 시간을 기록하는 맵
        HashMap<String, Integer> park = new HashMap<>();
        
        // records 배열을 순회하면서 입출차 기록에 따른 주차 시간을 저장한다.
        for(int i=0; i<records.length; i++){
            String time = records[i].split(" ")[0];
            String car = records[i].split(" ")[1];
            String gate = records[i].split(" ")[2];
            
            // records의 원소들은 시간 순에 따라 입차 기록이 먼저, 출차 기록이 나중에 나온다.
            // 이때, 출차와 함께 입차 기록을 제거해줘야한다.
            if(gate.equals("IN")){
                in.put(car, time);
            }
            else if(gate.equals("OUT")){
                out.put(car, time);
                park.put(car, park.getOrDefault(car, 0) + getTime(in.get(car), out.get(car)));
                
                // 정산 완료 후 입출차 기록을 제거한다.
                in.remove(car);
                out.remove(car);
            }
        }
        
        // 입차 기록은 존재하지만, 출차 기록이 없는 차량은 23:59에 출차된 것으로 간주한다.
        Iterator<Map.Entry<String, String>> inIter = in.entrySet().iterator();
        while(inIter.hasNext()){
            Map.Entry<String, String> entry = inIter.next();
            String car = entry.getKey();
            if(in.containsKey(car)){
                if(!out.containsKey(car)){
                    park.put(car, park.getOrDefault(car, 0) + getTime(in.get(car), "23:59"));
                }
            }
        }
        
        Iterator<Map.Entry<String, Integer>> parkIter = park.entrySet().iterator();
        ArrayList<Car> list = new ArrayList<>();
        
        while(parkIter.hasNext()){
            Map.Entry<String, Integer> entry = parkIter.next();
            
            // Comparable의 비교를 위해 Integer로 변환해준다.
            list.add(new Car(Integer.parseInt(entry.getKey()), entry.getValue(), 
                             getPrice(entry.getValue(), fees[0], fees[1], fees[2], fees[3])));
        }
        Collections.sort(list);
        
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i).price;
        }
        
        return answer;
    }
    
    // 시간은 00:00의 형식으로 제공된다.
    public int getTime(String in, String out){
        int outHour = Integer.parseInt(out.split(":")[0]);
        int outMinute = Integer.parseInt(out.split(":")[1]);
        
        int inHour = Integer.parseInt(in.split(":")[0]);
        int inMinute = Integer.parseInt(in.split(":")[1]);
        
        if(outMinute < inMinute){
            outHour -= 1;
            outMinute += 60;
        }
        
        int time = (outHour - inHour) * 60 + (outMinute - inMinute);
        
        return time;
    }
    
    public int getPrice(int time, int basicTime, int basicPrice, int unitTime, int unitPrice){
        if(time <= basicTime){
            return basicPrice;
        }
        else{
            return basicPrice + ((int)Math.ceil((double)(time-basicTime)/unitTime) * unitPrice); 
        }
    }
    
    class Car implements Comparable<Car>{
        int number;
        int time;
        int price;
        
        public Car(int n, int t, int p){
            number = n;
            time = t;
            price = p;
        }
        
        @Override
        public int compareTo(Car c){
            return this.number - c.number;
        }
    }
}