package grails.cqrs.commandhandler
import grails.cqrs.command.CreateTransactionCommand
import grails.cqrs.domain.CreditCardTransactionAggregate
import grails.cqrs.spring.SpringBeanResolver
import org.axonframework.commandhandling.annotation.CommandHandler
import org.axonframework.eventsourcing.EventSourcingRepository
import org.springframework.stereotype.Component
/**
 * Created by IntelliJ IDEA.
 * User: damian.blazejewski
 * Date: 17.11.13
 */

@Component
class CreateTransactionCommandHandler {

    @CommandHandler
    void handle(CreateTransactionCommand command) throws Throwable {
        CreditCardTransactionAggregate creditCardTransactionAggregate = new CreditCardTransactionAggregate(command)

        EventSourcingRepository eventSourcingRepository = SpringBeanResolver.resolve("creditCardTransactionRepository")

        eventSourcingRepository.add(creditCardTransactionAggregate)
    }
}
