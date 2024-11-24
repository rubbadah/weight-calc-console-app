package weightcalc;

import java.util.Scanner;
import java.util.Arrays;

public class WeightCalcConsoleApp {
	// NOTE: 過度な拡張性は考慮しないものとする

	public static void main(String[] args) {

		System.out.println("健康管理アプリケーションへようこそ。");
		Scanner scanner = new Scanner(System.in);

		boolean isLoop = true;
		while (isLoop) {
			// 初期情報設定
			User user = new User();
			user.setNameFromConsole(scanner);
			user.setHeightFromConsole(scanner);
			user.setWeightFromConsole(scanner);

			int funcNo = getFuncNoFromConsole(scanner);

			if (funcNo == 1) {
				// BMI指数計算
				calcBmi(user);

			} else if (funcNo == 2) {
				// 標準体重計算
				calcStandardWeight(user);

			} else if (funcNo == 9) {
				// 終了
				System.out.println("ありがとうございました。");
				scanner.close();
				break;
			}

		}

	}

	/**
	 * BMI指数計算
	 * 
	 * @param user
	 */
	public static void calcBmi(User user) {
		if (user.height == 0) {
			// 0除算回避
			System.out.println("身長が0の場合はBMIの計算ができません。");
			return;
		}
		double bmi = user.weight / user.height / user.height;

		if (bmi < 18.5) {
			System.out.println(String.format("%sさんはやせています。", user.name));
		} else if (bmi >= 18.5 && bmi < 25) {
			System.out.println(String.format("%sさんはふつうです。", user.name));
		} else {
			System.out.println(String.format("%sさんはふとっています。", user.name));
		}
	}

	/**
	 * 標準体重計算
	 * 
	 * @param user
	 */
	public static void calcStandardWeight(User user) {
		double standardWeight = user.height * user.height * 22;

		System.out.println(String.format("%sさんの標準体重は%.2fです。", user.name, standardWeight));
	}

	/**
	 * メニュー選択
	 * 
	 * @param scanner
	 * @return
	 */
	public static int getFuncNoFromConsole(Scanner scanner) {
		boolean isLoop = true;
		int ret = 0;
		Integer funcNoList[] = { 1, 2, 9 };

		while (isLoop) {
			System.out.println("**********メニュー**********");
			System.out.print("1)BMI指数計算  2)標準体重計算  9)終了:");
			String inputText = scanner.nextLine();
			try {
				int inputInt = Integer.valueOf(inputText);
				// TODO: バリデーション関数を別で構えてもいいかも
				if (Arrays.asList(funcNoList).contains(inputInt)) {
					// メニューとして登録されている数値のみ認める
					ret = inputInt;
					isLoop = false;
					break;
				}
			} catch (Exception e) {
				// NOTE: いったんすべての例外で握りつぶす
			}

			System.out.println("正しい入力がされませんでした。\n以下条件を満たす文字を再度入力してください。");
			System.out.println("- '1', '2', '9'いずれかの数字");
		}
		return ret;
	}

}
