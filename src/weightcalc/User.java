package weightcalc;

import java.util.Scanner;

public class User {
	/**
	 * 名前
	 */
	String name;
	/**
	 * 身長
	 */
	double height;
	/**
	 * 体重
	 */
	double weight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setNameFromConsole(Scanner scanner) {
		boolean isLoop = true;
		while (isLoop) {

			System.out.print("名前を入力してください：");
			String inputText = scanner.nextLine();
			// TODO: バリデーション関数を別で構えてもいいかも
			if (inputText != null && inputText.matches("^[a-zA-Z .]*$")) {
				// ローマ字の場合のみ名前と認める
				this.name = inputText;
				isLoop = false;
				break;
			}

			System.out.println("正しい名前が入力されませんでした。\n以下条件を満たす文字を再度入力してください。");
			System.out.println("- アルファベットの大文字、小文字、半角スペース、ピリオドのみ");
		}
	}

	public void setHeightFromConsole(Scanner scanner) {
		boolean isLoop = true;
		while (isLoop) {
			System.out.print("身長[m]を入力してください：");
			String inputText = scanner.nextLine();
			try {
				Double inputDouble = Double.parseDouble(inputText);
				// TODO: バリデーション関数を別で構えてもいいかも
				if (inputDouble >= 0.0 && inputDouble <= 3.0) {
					// 0.0m～3.0mの場合のみ身長と認める
					this.height = inputDouble;
					isLoop = false;
					break;
				}
			} catch (Exception e) {
				// NOTE: いったんすべての例外で握りつぶす
			}

			System.out.println("正しい身長が入力されませんでした。\n以下条件を満たす文字を再度入力してください。");
			System.out.println("- '0.0'～'3.0'の範囲内の数字");
		}
	}

	public void setWeightFromConsole(Scanner scanner) {
		boolean isLoop = true;
		while (isLoop) {
			System.out.print("体重[kg]を入力してください：");
			String inputText = scanner.nextLine();
			try {
				Double inputDouble = Double.parseDouble(inputText);
				// TODO: バリデーション関数を別で構えてもいいかも
				if (inputDouble >= 0.0 && inputDouble <= 500.0) {
					// 0kg～500kgの場合のみ体重と認める
					this.weight = inputDouble;
					isLoop = false;
					break;
				}
			} catch (Exception e) {
				// NOTE: いったんすべての例外で握りつぶす
			}

			System.out.println("正しい体重が入力されませんでした。\n以下条件を満たす文字を再度入力してください。");
			System.out.println("- '0'～'500'の範囲内の数字");
		}
	}

}
