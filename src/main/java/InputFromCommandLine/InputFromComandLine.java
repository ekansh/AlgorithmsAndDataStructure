package InputFromCommandLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class InputFromComandLine {
	private static int numOfRows = -1;
	private static int numOfCOlumns = -1;
	private static int indices = -1;
	private static int[][] matrix;
	private static Map<String, String> numberInfo = new HashMap<String, String>();

	public static void main(String[] args) {
		boolean validInput = constructMatrix();
		if (!validInput){
			System.out.println("InvalidInput");
			return ;
		}
		constructNumberInfo();
		int flag = 0;
		String result = "";
		for (int i = 0; i < numOfRows; i++) {

			for (int j = 0; j < numOfCOlumns; j++) {

				String key = "" + matrix[i][j];
				String val = numberInfo.get(key);
				String[] coodrinates = val.split("_");
				for (int index = 0; index < coodrinates.length; index++) {
					String[] info = coodrinates[index].split(",");
					int row1 = Integer.parseInt(info[0]);
					int col1 = Integer.parseInt(info[1]);
					for (int tempIndex = 0; tempIndex < coodrinates.length; tempIndex++) {
						if (tempIndex == index) {
							continue;
						}
						String[] info2 = coodrinates[tempIndex].split(",");
						int row2 = Integer.parseInt(info2[0]);
						int col2 = Integer.parseInt(info2[1]);
						int dist = (row1 - row2) * (row1 - row2) - (col1 - col2) * (col1 - col2);
						dist = Math.abs(dist);
						double sqrt = Math.sqrt(new Double(dist));
						double threshold = new Double(indices);
						if (sqrt <= threshold) {
							System.out.println("YES");
							flag = -1;
							break;
						}

					}

					if (flag == -1) {
						break;
					}
				}
				if (flag == -1) {
					break;
				}
			}
			if (flag == -1) {
				break;
			}

		}
		if (flag != -1) {
			System.out.println("NO");
		}
	

	}

	private static void constructNumberInfo() {
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfCOlumns; j++) {

				String key = "" + matrix[i][j];
				String val = numberInfo.get(key);
				if (val == null || val.isEmpty()) {
					val = i + "," + j;
				} else {
					val = val + "_" + i + "," + j;
				}

				numberInfo.put(key, val);

			}

		}
	}

	private static void display(int[][] matrix, int col, int numOfRows) {
		for (int i = 0; i < numOfRows; i++) {

			for (int j = 0; j < col; j++) {

				System.out.print(matrix[i][j] + " ");

			}
			System.out.println("");
		}
	}

	private static boolean  constructMatrix() {
		boolean validInput = true;
		InputStream in = System.in;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter first line suggesting number of rows matrix will have ");

			numOfRows = Integer.parseInt(reader.readLine());
			if (numOfRows > 0) {
				System.out.println("InputFromComandLine.main()");
				matrix = new int[numOfRows][];
			} else {
				System.out.println("enter a bigger values");
				validInput = false;
				return validInput ;
			}
			for (int i = 0; i < numOfRows; i++) {
				System.out.println("input the  " + (i + 1) + " row of matrix ");
				String row = reader.readLine();
				String[] split = row.split("\\s+");
				matrix[i] = new int[split.length];
				if (numOfCOlumns !=-1 && split.length != numOfCOlumns){
					validInput = false;
					System.out.println("ERROR");
					return validInput ;
				}
				numOfCOlumns = split.length;
				int colIndex = 0;
				for (String string : split) {
					int cell = Integer.parseInt(string);
					matrix[i][colIndex] = cell;
					colIndex++;
				}
			}
			display(matrix, numOfCOlumns, numOfRows);
			indices = Integer.parseInt(reader.readLine());
			System.out.println(numOfRows);
		} catch (InputMismatchException e) {
			validInput= false;
			System.out.println("InputFromComandLine.main().InputMismatch, exiting");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("InputFromComandLine.main().NumberFormat");
			validInput= false;
			e.printStackTrace();
		} catch (IOException e) {
			validInput= false;
			e.printStackTrace();
		}

	return validInput;
	}

}
