package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CARD")
@Entity
public class Card extends BaseTime {

    @Id
    @Column(name = "CARD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "CARD_NAME", nullable = false)
    private String cardName; //카드이름

    @Column(name = "CARD_COMPANY", nullable = false)
    private String cardCompany; //카드회사 이름

    @Column(name = "ANNUAL_FEE", nullable = false)
    private String annualFee; //연회비

    @Column(name = "CARD_TYPE", nullable = false)
    private String cardType; // 카드 종류 (체크 or 신용)

    @Column(name = "CARD_DESCRIPTION", nullable = false)
    private String cardDescription; //카드 간단한 설명

    @Column(name = "FRANCHISEE", nullable = false)
    private String franchisee; // 가맹점 적립률 "0.3 1.0"

    @Column(name = "SHOPPING", nullable = false)
    private String shopping; // "10만원 당 5천 머니" 적립

    @Column(name = "OILING", nullable = false)
    private String oiling; // "5만원당 3천원"

    @Column(name = "INSURANCE", nullable = false)
    private String insurance; // "10만원 당 5천 머니"

    @Column(name = "CAFE", nullable = false)
    private String cafe; // "1000"

    @Column(name = "TAG", nullable = false)
    private String tag; // "주부 그림/운동 30대" 나이/직업/취미 하나씩 들가는 곳

    @Builder
    public Card(String productType, String cardName, String annualFee, String cardType, String subjectToJoin, String explanation) {
        this.productType = productType;
        this.cardName = cardName;
        this.annualFee = annualFee;
        this.cardType = cardType;
        this.subjectToJoin = subjectToJoin;
        this.explanation = explanation;
    }

    public void update(String productType, String cardName, String annualFee, String cardType, String subjectToJoin, String explanation) {
        this.productType = productType;
        this.cardName = cardName;
        this.annualFee = annualFee;
        this.cardType = cardType;
        this.subjectToJoin = subjectToJoin;
        this.explanation = explanation;
    }
}
// 카드상품 : 연회비, 카드 종류(체크인지 신용인지), 가입대상, 카드 이름, 요약설명