package amazon.arrays;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// CLASS BEGINS, THIS CLASS IS REQUIRED
// two solutions : either using pattern or by simply checking
class ShoppingListAndCouponCodeListMatching {

	public static void main(String[] args) {
		ShoppingListAndCouponCodeListMatching solution = new ShoppingListAndCouponCodeListMatching();
		List<List<String>> codeList = new ArrayList<List<String>>();
		List<String> shoppingCart = Arrays.asList("o", "a", "a", "b", "o", "a", "b");
		codeList.add(Arrays.asList("o"));
		codeList.add(Arrays.asList("a", "a"));
		codeList.add(Arrays.asList("b", "anything", "a"));
		codeList.add(Arrays.asList("b"));
		int checkWinner = solution.checkWinner1(codeList, shoppingCart);
		System.out.println(checkWinner);
		
	}

	public int checkWinner1(List<List<String>> codeList, List<String> shoppingCart) {
		String sl = shoppingCart.stream().collect(Collectors.joining("_"));
		StringBuilder sb = new StringBuilder();
		for (List<String> l : codeList) {
			for (String string : l) {
				if (string.equals("anything")) {
					string = "[a-z]+";
				}
				sb.append(string).append("_");
			}
		}
		String regex = sb.replace(sb.length() - 1, sb.length(), "").toString();
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(sl);
		boolean find = matcher.find();
		return find ?1:0;
	}

	int cur = 0;
	int grpPointer = 0;

	public int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
		int i = 0;
		if (codeList.isEmpty())
			return 0;
		int win1 = codeList.size();

		int win2 = codeList.get(win1 - 1).size();
		while (i < shoppingCart.size()) {
			String fruit = shoppingCart.get(i);
			if (contains(codeList, fruit)) {
				while (i < shoppingCart.size()) {
					fruit = shoppingCart.get(i);
					if (contains(codeList, fruit)) {
						i++;
						grpPointer++;

						if (cur == win1 - 1 && grpPointer == win2) {
							return 1;
						}
						if (grpPointer == codeList.get(cur).size()) {
							grpPointer = 0;
							cur++;
						}
					} else {
						break;
					}
				}
				cur = 0;
				grpPointer = 0;
			}
			i++;
		}
		return 0;
	}

	private boolean contains(List<List<String>> codeList, String fruit) {
		List<String> list = codeList.get(cur);
		boolean flag = false;
		if (list.get(grpPointer).equals(fruit) || list.get(grpPointer).equals("anything")) {
			flag = true;
		}
		return flag;
	}
}