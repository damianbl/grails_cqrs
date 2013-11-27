package grails.cqrs.commandhandler
import grails.cqrs.command.CancelTransactionCommand
import grails.cqrs.domain.CreditCardTransactionAggregate
import grails.cqrs.spring.SpringBeanResolver
import org.axonframework.commandhandling.annotation.CommandHandler
import org.axonframework.eventsourcing.EventSourcingRepository
import org.springframework.stereotype.Component
/**
 * Created by IntelliJ IDEA.
 * User: damian.blazejewski
 * Date: 21.11.13
 */
@Component
class CancelTransactionCommandHandler {

    @CommandHandler
    void handle(CancelTransactionCommand command) throws Throwable {
        EventSourcingRepository eventSourcingRepository = SpringBeanResolver.resolve("creditCardTransactionRepository")

        CreditCardTransactionAggregate creditCardTransactionAggregate = eventSourcingRepository.load(command.aggregateIdentifier);

        creditCardTransactionAggregate.cancelTransaction(command)
    }
}
