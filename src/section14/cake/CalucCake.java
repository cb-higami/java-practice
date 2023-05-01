package section14.cake;

import java.util.HashMap;
import java.util.Map;

public class CalucCake {
    public static void main(String[] args) {
//        ケーキ名、個数　をコマンドラインで取得
//        合計が１０００円以上は２割引
//        消費税８％、小数点以下で切り捨て

//        args = new String[]{"ショートケーキ", "2", "いちごのタルト", "3"};
        args = new String[]{"モンブラン", "1", "ショートケーキ", "2", "チーズケーキ", "3"};

        Map<Cake, Integer> orders = new HashMap<>();
        for (int i = 0; i < args.length; ) {
            orders.put(Cake.getCake(args[i]), Integer.valueOf(args[i + 1]));
            i = i + 2;
        }

        int orderSum =  orders.entrySet().stream()
                .mapToInt(o -> o.getKey().getPrice() * o.getValue()).sum();

        if(orderSum > 1000) {
            orderSum = (int) (orderSum * 0.8);
        }
        int incluedTaxPrice = (int) (orderSum * 1.08);
        System.out.println("合計金額は%s円です。".formatted(incluedTaxPrice));
    }
}
