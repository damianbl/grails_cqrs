package grails.cqrs
/**
 * Created by IntelliJ IDEA.
 * User: damian.blazejewski
 * Date: 15.11.13
 */
class CreditCardTransaction {
    Integer id
    UUID aggregateIdentifier
    String creditCardNumber
    String creditCardCvvCode
    String creditCardOwner
    Date validDate
    BigDecimal amount
    Date transactionDate

    static constraints = {
        aggregateIdentifier nullable: false
        creditCardNumber blank: false, size: 16..16
        creditCardCvvCode blank: false, size: 3..3
        creditCardOwner blank: false
        validDate nullable: false
        amount nullable: false
    }
}
