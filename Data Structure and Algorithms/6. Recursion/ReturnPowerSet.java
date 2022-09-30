import java.util.ArrayList;

class Solution{
    
	static ArrayList<String> powerSet(String s, ArrayList<String> res) {

		if (s.equals(""))
			return res;

		int n = res.size();

		for (int i = 0; i < n; i++)
			res.add(res.get(i) + s.charAt(0));

		return powerSet(s.substring(1), res);
	}

	static ArrayList<String> powerSet(String s) {
		
		ArrayList<String> res = new ArrayList<>();
		res.add("");
		res = powerSet(s,res);
		return res;
	}
	
}