package grails.cqrs.event

/**
 * Created by IntelliJ IDEA.
 * User: damian.blazejewski
 * Date: 18.11.13
 */
class TransactionCreatedEvent {
    UUID id;
    String creditCardNumber
    String creditCardCvvCode
    String creditCardOwner
    Date validDate
    BigDecimal amount
    Date transactionDate

    TransactionCreatedEvent(UUID id, String creditCardNumber, String creditCardCvvCode, String creditCardOwner,
                                      Date validDate, BigDecimal amount, Date transactionDate) {
        this.id = id
        this.creditCardNumber = creditCardNumber
        this.creditCardCvvCode = creditCardCvvCode
        this.creditCardOwner = creditCardOwner
        this.validDate = validDate
        this.amount = amount
        this.transactionDate = transactionDate
    }
}
