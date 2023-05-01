package section14.jihan;

import java.util.Arrays;
import java.util.List;

class Coin {

    private List<Integer> coins;
    private int appropriateCoinAmount = 0;

    public Coin(String[] args) {
        this.coins = Arrays.stream(args).map(a -> Integer.parseInt(a)).toList();
    }

    public int checkCoin() {

        for (int c : coins) {
            if (!isCoin(c)) {
                System.out.println("警告：%s は硬貨として適切な値ではありません".formatted(c));
                continue;
            }
            if (!isUsableCoin(c)) {
                System.out.println("警告：%s 円玉は使えません".formatted(c));
                continue;
            }
            appropriateCoinAmount += c;
        }

        return appropriateCoinAmount;
    }

    boolean isCoin(int coin) {
        return coin == 1 || coin == 5 || coin == 10 || coin == 50 || coin == 100 || coin == 500;
    }

    boolean isUsableCoin(int coin) {
        return coin == 10 || coin == 50 || coin == 100 || coin == 500;
    }
}