package section14.jihan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Jihan2 {

    public static void main(String[] args) {

        args = new String[]{"1", "5", "10", "50", "100", "500", "777", "580"};
        List<String> argsList = new ArrayList<>(Arrays.asList(args));
        String inputAmount = argsList.remove(argsList.size() - 1);

        Coin c = new Coin(argsList.toArray(new String[argsList.size()]));
        int usableCoinAmount = c.checkCoin();
        System.out.println("ただいまの投入金額は %s 円です".formatted(usableCoinAmount));

        int returnFound = usableCoinAmount - Integer.parseInt(inputAmount);
        System.out.println("%s円のおつりです。ありがとうございました。".formatted(returnFound));
    }
}