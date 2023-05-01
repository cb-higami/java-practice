package section14.jihan;

class  Jihan{

    public static void main(String[] args) {

        args = new String[]{"1", "5", "10", "50", "100", "500", "777"};
        Coin c =  new Coin(args);
        int usableCoinAmount = c.checkCoin();
        System.out.println("ただいまの投入金額は %s 円です".formatted(usableCoinAmount));
    }
}