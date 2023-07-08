package july2023;

import java.util.LinkedList;

public class hhhhh {

	public static void main(String[] args) {

		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		
		int[] answer = new int[2];
        int people = 0;
        int turn = 1;
        LinkedList<String> list = new LinkedList<>();
        
        for(int i = 0; i<words.length; i++) {
        	people++; // people은 0이 없음
        	
        	if(i>0) { // 앞, 뒷 단어 체크
        		if(list.get(i-1).charAt(list.get(i-1).length() - 1) != words[i].charAt(0)) {
        			answer[0] = people;
        			answer[1] = turn;
        			break;
        		}
        	}
        	
        	if(list.contains(words[i])) {
        		answer[0] = people;
        		answer[1] = turn;
        		break;
        	}
        	
        	list.add(words[i]);        	
        	
        	if(people == n) { 
        		people = 0;
        		turn++;
        	}
        }
        
        System.out.println(answer);
	}

}
