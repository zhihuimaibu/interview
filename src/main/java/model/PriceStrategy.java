package model;

/**
 * @author wzh
 * @date 2020/1/8 10:47
 * @description
 */
public class PriceStrategy {
    public static void main(String[] args) {
        PrimaryMemberPriceStrategy primaryMemberPriceStrategy = new PrimaryMemberPriceStrategy();
        Price price = new Price(primaryMemberPriceStrategy);
        double calMemberPrice = price.calMemberPrice(100);
        System.out.println(calMemberPrice);
    }
}

class Price {
    private MemberPriceStrategy memberPriceStrategy;

    public Price(MemberPriceStrategy memberPriceStrategy) {
        this.memberPriceStrategy = memberPriceStrategy;
    }

    public double calMemberPrice(double bookPrice) {
        return memberPriceStrategy.calPrice(bookPrice);
    }
}

interface MemberPriceStrategy {
    double calPrice(double bookPrice);

}

class PrimaryMemberPriceStrategy implements MemberPriceStrategy {

    public double calPrice(double bookPrice) {
        System.out.println("初级会员没有折扣");
        return bookPrice;
    }
}

class IntermediateMemberPriceStrategy implements MemberPriceStrategy {

    public double calPrice(double bookPrice) {
        System.out.println("中级会员折扣为10%");
        return bookPrice * 0.9;
    }
}

class AdvanceMemberPriceStrategy implements MemberPriceStrategy {

    public double calPrice(double bookPrice) {
        System.out.println("高级会员折扣为20%");
        return bookPrice * 0.8;
    }
}