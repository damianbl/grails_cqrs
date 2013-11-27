package grails.cqrs.domain

import grails.cqrs.command.CancelTransactionCommand
import grails.cqrs.command.CreateTransactionCommand
import grails.cqrs.event.TransactionCancelledEvent
import grails.cqrs.event.TransactionCreatedEvent
import org.axonframework.domain.DomainEventMessage
import org.axonframework.eventsourcing.AbstractEventSourcedAggregateRoot
import org.axonframework.eventsourcing.EventSourcedEntity
import org.axonframework.eventsourcing.annotation.AggregateIdentifier

/**
 * Created by IntelliJ IDEA.
 * User: damian.blazejewski
 * Date: 18.11.13
 */
class CreditCardTransactionAggregate extends AbstractEventSourcedAggregateRoot {
    @AggregateIdentifier
    UUID identifier
    String creditCardNumber
    String creditCardCvvCode
    Date validDate
    BigDecimal amount
    Date transactionDate
    Date cancellationDate
    CreditCardOwner creditCardOwner

    CreditCardTransactionAggregate() {
    }

    CreditCardTransactionAggregate(CreateTransactionCommand command) {
        apply(new TransactionCreatedEvent(command.id, command.creditCardNumber, command.creditCardCvvCode,
                command.creditCardOwner, command.validDate, command.amount, new Date()))
    }

    void cancelTransaction(CancelTransactionCommand command) {
        apply(new TransactionCancelledEvent(command.id, command.aggregateIdentifier))
    }

    @Override
    protected Iterable<? extends EventSourcedEntity> getChildEntities() {
        return null
    }

    @Override
    protected void handle(DomainEventMessage event) {
        if (TransactionCreatedEvent.class.isAssignableFrom(event.getPayload().getClass())) {
            handleTransactionCreated(event.getPayload())
        }
        if (TransactionCancelledEvent.class.isAssignableFrom(event.getPayload().getClass())) {
            handleTransactionCancel(event.getPayload())
        }
    }

    private void handleTransactionCreated(TransactionCreatedEvent event) {
        this.identifier = event.id
        this.creditCardNumber = event.creditCardNumber
        this.creditCardCvvCode = event.creditCardCvvCode
        this.validDate = event.getValidDate()
        this.amount = event.getAmount()

        this.transactionDate = new Date()

        creditCardOwner = new CreditCardOwner(event.creditCardOwner)
    }

    private void handleTransactionCancel(TransactionCancelledEvent event) {
        cancellationDate = new Date()
        markDeleted()
    }
}
