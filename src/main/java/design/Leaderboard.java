package design;

import java.util.*;

class Leaderboard {
	public static void main(String[] args) {
		Leaderboard l = new Leaderboard();
		l.addScore(1,73);
		l.addScore(2,56);
		l.addScore(3,39);
		l.addScore(4,51);
		l.addScore(5,4);
		
		
		l.top(1);
		l.reset(1);
		l.reset(2);
		l.addScore(2,51);
		l.top(3);
		
	}
    Map<Integer,Integer> m = new HashMap<>();
    Map<Integer,Integer> tm = new TreeMap<>((a,b)->b-a); // reverse comparator
    public Leaderboard() {
        
    }
    
    public void addScore(int playerId, int score) {
        int currentScore = m.getOrDefault(playerId,0);
        int newScore =currentScore+score;
        m.put(playerId,newScore);
        if( tm.containsKey(currentScore) ){// MISTAKE: was only executing when not 0
            int currentCount  = tm.get(currentScore);
            tm.put(currentScore,currentCount-1);
        }
        tm.put(newScore, tm.getOrDefault(newScore,0)+1);
        m.put(playerId,newScore);
    }
    
    public int top(int K) {
        int sum =0;
        for(Integer score: tm.keySet()){
            int count = tm.get(score);
            while( count>0 && K>0){
                sum=sum+score;
                K--;
                count--;
            }
            
            if( K==0){
              break ;  
            } 
        }
        return sum;
    }
    
    public void reset(int playerId) {
        int currentScore = m.get (playerId);
        int newScore = 0;
        
        int currentCount  = tm.get(currentScore);
        tm.put(currentScore,currentCount-1);
        if(tm.get(currentScore) ==0)tm.remove(currentScore);
        tm.put(newScore, tm.getOrDefault(newScore,0)+1);
        m.put(playerId,newScore);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such: Leaderboard
 * obj = new Leaderboard(); obj.addScore(playerId,score); int param_2 =
 * obj.top(K); obj.reset(playerId);
 */