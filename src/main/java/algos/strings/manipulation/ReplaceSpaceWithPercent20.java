package algos.strings.manipulation;

public class ReplaceSpaceWithPercent20 {
	public String replaceSpaceWithPercent20(String str) {
		StringBuilder sb = new StringBuilder(str);
		int index = 0;
		int length = sb.length();
		while (index < length) {
			length = sb.length();
			if (sb.charAt(index) == ' ') {
				// from index +1 to current Sb lenght push them right by 2 digit
				shiftCharacterRightByTwoDigit(sb, index);
				sb.replace(index, index + 3, "%20");
				index = index + 3;
			} else {
				index++;
			}
		}

		return sb.toString();
	}

	// the logic of from which point to which point we want to move
	// we need to go (index  i) from the end of string , i.e. sb.length-1
	// we need to make sure that every thing from sb.length-1 to index+1 gets right shifted
	// sb.append ("  ") has added two extra spaces on the right.
	// so we want to set the char at i to what we had two space left
	// therefore sb.setCharAt(i, sb.charAt(i - 2));
	// but we still want to make sure that we dont end up processing left to index+1
	// therefore index i can go as far as i-2 = index+1
	// i = index+3
	// we also know
	public void shiftCharacterRightByTwoDigit(StringBuilder sb, int index) {
		sb.append("  ");

		for (int i = sb.length() - 1; i >= index + 3; i--) {
			sb.setCharAt(i, sb.charAt(i - 2));
			sb.setCharAt(i - 2, ' ');
		}
	}

	public static void main(String[] args) {
		String replacedSpaceWithPercent20 = new ReplaceSpaceWithPercent20().replaceSpaceWithPercent20("  abc  bd  ");
		System.out.println(replacedSpaceWithPercent20);
	}
}
