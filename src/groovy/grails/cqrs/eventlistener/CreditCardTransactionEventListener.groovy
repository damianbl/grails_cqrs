package grails.cqrs.eventlistener

import grails.cqrs.CreditCardTransaction
import grails.cqrs.event.TransactionCancelledEvent
import grails.cqrs.event.TransactionCreatedEvent
import org.axonframework.eventhandling.annotation.EventHandler
import org.springframework.stereotype.Component

/**
 * Created by IntelliJ IDEA.
 * User: damian.blazejewski
 * Date: 20.11.13
 */
@Component
class CreditCardTransactionEventListener {

    @EventHandler
    public void handle(TransactionCreatedEvent event) {
        CreditCardTransaction creditCardTransaction = new CreditCardTransaction()
        creditCardTransaction.creditCardNumber = event.creditCardNumber
        creditCardTransaction.creditCardCvvCode = event.creditCardCvvCode
        creditCardTransaction.creditCardOwner = event.creditCardOwner
        creditCardTransaction.validDate = event.validDate
        creditCardTransaction.amount = event.amount
        creditCardTransaction.transactionDate = event.transactionDate
        creditCardTransaction.aggregateIdentifier = event.id

        creditCardTransaction.save flush: true
    }

    @EventHandler
    public void handle(TransactionCancelledEvent event) {
        CreditCardTransaction creditCardTransaction = CreditCardTransaction.findById(event.transactionId)

        creditCardTransaction.delete flush: true
    }
}
