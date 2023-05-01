package section14.cake;

public enum Cake {
    SHORT_CAKE(320),
    MONBRAN(350),
    CHOCOLATE_CAKE(370),
    STOROBERY_TALT(400),
    CHEESE_CAKE(300),
    OTHER(0);

    private int price;

    Cake(int i) {
        this.price = i;
    }

    public int getPrice() {
        return price;
    }

    public static Cake getCake(String name) {
        if(name.equals("ショートケーキ")) {
            return Cake.SHORT_CAKE;
        }
        if(name.equals("モンブラン")) {
            return Cake.MONBRAN;
        }
        if(name.equals("チョコレートケーキ")) {
            return Cake.CHOCOLATE_CAKE;
        }
        if(name.equals("いちごのタルト")) {
            return Cake.STOROBERY_TALT;
        }
        if(name.equals("チーズケーキ")) {
            return Cake.CHEESE_CAKE;
        }
        return Cake.OTHER;
    }
}
