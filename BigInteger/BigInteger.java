class BigInteger{
	public static String add(String s1,String s2){
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		if(s2.length() > s1.length()){
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}
		for(int i = s2.length() - 1, j = s1.length() - 1;i >= 0 || j >= 0;i--,j--){
			int sum = 0;
			if(i >= 0){
				sum = (s2.charAt(i) - '0') + (s1.charAt(j) - '0') + carry;
			}else{
				sum =  (s1.charAt(j) - '0') + carry;
			}
			carry = sum >= 10 ? 1 : 0;
			sum %=10 ;
			sb.append(sum);
		}
		if(carry > 0)
			sb.append("1");
		return sb.reverse().toString();

	}

	public static String substract(String s1,String s2){
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		String prefix = "";
		if(s2.length() > s1.length() || (s1.length() == s2.length() && s2.compareTo(s1) > 0)){
			String temp = s1;
			s1 = s2;
			s2 = temp;
			prefix = "-";
		}
		for(int i = s2.length() - 1, j = s1.length() - 1;i >= 0 || j >= 0;i--,j--){
			int diff = 0;
			if(i >= 0){
				diff = (s1.charAt(j) - '0') - carry - (s2.charAt(i) - '0');
			}else{
				diff =  (s1.charAt(j) - '0') + carry;
			}
			carry = diff < 0 ? 1 : 0;
			diff = diff < 0 ? diff * (-1) : diff;
			sb.append(diff);
		}
		while(sb.charAt(sb.length() - 1) == '0'){
			sb.deleteCharAt(sb.length() - 1);
		}
		if(carry > 0)
			sb.append(prefix);
		return sb.reverse().toString();
	}
  
  }
