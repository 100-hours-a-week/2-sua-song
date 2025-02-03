package starbucks.item_order;
import java.util.ArrayList;
import java.util.List;
//dessert 오타 있습니다.. ㅠ
public class Desert extends MenuItem{
    public Desert(String name, int price) {
        super(name, price);
    }
        // 변경할 수 없는 디저트 메뉴 배열
    public static final Desert[] DessrtMenu(){
        return new Desert[]{
                new Desert("치즈케이크", 5000),
                new Desert("초코쿠키", 3500),
                new Desert("마카롱", 4000),
        };



    }

}
