package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array of strings, group anagrams together.
Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
All inputs will be in lowercase.
The order of your output does not matter  .


aat, at, att
*/

public class Anagrams {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("eat");
		names.add("tea");
		names.add("tan");
		names.add("nat");
		names.add("bat");
		names.add("ate");
		
		groupByAnagrams(names);
	}

	private static void groupByAnagrams(List<String> names) {
		// TODO Auto-generated method stub
	    List<List<String>> output = new ArrayList<List<String>>();
	    List<String> out;
	    String two ="";
	    for(String one : names){
	    	//Work on this logic to create List of Lists
//	    	if(!output.isEmpty()){
//	    		for(List<String> stList : output){
//	    			if(!stList.contains(one)){
//	    				out = new ArrayList<String>();
//	    			}
//	    		}
//	    		
//	    	}
	    	out = new ArrayList<String>();
	    	for(int i=1; i<=names.size()-1; i++){
		    	//one = names.get(i);
		    	two = names.get(i);
		    	System.out.println("One:" + one+ " -Two:" + two);
		    	if(one.length() != two.length())
		    		return;
		    	if(sortStringChars(one).equals(sortStringChars(two)))
		    	{
		    		//System.out.println("Anagram:" + one+ " -" + two);
		    		if(!out.contains(one))
		    			out.add(one);
		    			
		    		if(!out.contains(two))
		    			out.add(two);
		    	}
		    	
		    }
	    	
	    	System.out.println("out:" + out);
	    	output.add(out);
	    	
	    	
	    }
	}
	
	private static String sortStringChars(String str){
		char[] strChar = str.toCharArray();
		Arrays.sort(strChar);
		
		return new String(strChar);
	}
}
  
