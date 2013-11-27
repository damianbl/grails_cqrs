package grails.cqrs.event

/**
 * Created by IntelliJ IDEA.
 * User: damian.blazejewski
 * Date: 18.11.13
 */
class TransactionCancelledEvent {
    Integer transactionId
    UUID aggregateIdentifier

    TransactionCancelledEvent(Integer transactionId, UUID aggregateIdentifier) {
        this.transactionId = transactionId
        this.aggregateIdentifier = aggregateIdentifier
    }
}
