/*-< 演習：Ex1_12_1 >---------------------------------
コマンドライン引数から数値を1つ受け取り、これをテストの点数とします。

(1)以下のプログラムを作成してください。
  - 点数が0～100以外の数字だった場合「不正な点数です！」と表示する

(2)以下の機能を(1)のプログラムに追加してください。
  - 点数が0～59の数字だった場合「赤点です！」と表示する
  - 点数が60～79の数字だった場合「普通です！」と表示する
  - 点数が80～100の数字だった場合「優秀です！」と表示する

(3)以下の機能を(1)(2)のプログラムに追加してください。
  - 点数の数字が100だった場合のみ「満点だったので宿題免除です！！」と最後に表示する
----------------------------------------------------*/
class Ex1_12_1 {
	public static void main (String[] args) {
		// int score = Integer.parseInt(args[0]);
    
    checkTestScore(101);
    checkTestScore(59);
    checkTestScore(60);
    checkTestScore(80);
    checkTestScore(100);

   
	}


  private static void checkTestScore(int score) {
    boolean isInvalidScore = score < 0 || 100 < score;
    if(isInvalidScore) {
      System.out.println("不正な値です！");
    }

    if(score < 60) {
      System.out.println("赤点です！");
    } else if( score < 80) {
      System.out.println("普通です！");
    } else {
      System.out.println("優秀です！");
    }
    if(score == 100) {
      System.out.println("満点だったので宿題免除です！！");
    }
  }
}
