package grails.cqrs.command

/**
 * Created by IntelliJ IDEA.
 * User: damian.blazejewski
 * Date: 17.11.13
 */
@grails.validation.Validateable
class CreateTransactionCommand {
    UUID id;
    String creditCardNumber
    String creditCardCvvCode
    String creditCardOwner
    Date validDate
    BigDecimal amount

    static constraints = {
        creditCardNumber blank: false, size: 16..16
        creditCardCvvCode blank: false, size: 3..3
        creditCardOwner blank: false
        validDate nullable: false
        amount nullable: false
    }
}
