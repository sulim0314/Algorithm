
public class 카펫 {

	public static int[] solution(int brown, int yellow) {

		final int area = brown + yellow;

		int height = (int) Math.sqrt(area);
		int width = area / height;

		if (width < height) {
			final int temp = width;
			width = height;
			height = temp;
		}

		while (true) {
			final int derivedY = (width - 2) * (height - 2);
			final int derivedX = area - derivedY;
			if (derivedX == brown && derivedY == yellow)
				break;

			if (area % (++width) == 0)
				height = area / width;
		}
		
		return new int[] { width, height };
	}

	public static void main(String[] args) {
		solution(10, 2);
		solution(8, 1);
		solution(24, 24);
		solution(16, 8);
		solution(18, 6);
	}
}