package grails.cqrs

import grails.cqrs.command.CancelTransactionCommand
import grails.cqrs.command.CreateTransactionCommand
import grails.transaction.Transactional
import org.axonframework.commandhandling.gateway.DefaultCommandGateway

import static java.util.UUID.randomUUID
import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class CreditCardTransactionController {
    DefaultCommandGateway commandGateway

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CreditCardTransaction.list(params), model: [creditCardTransactionInstanceCount: CreditCardTransaction.count()]
    }

    def show(CreditCardTransaction creditCardTransactionInstance) {
        respond creditCardTransactionInstance
    }

    def create() {
        respond new CreditCardTransaction(params)
    }

    @Transactional
    def save(CreateTransactionCommand command) {
        if (command == null) {
            notFound()
            return
        }

        if (command.hasErrors()) {
            respond command.errors, view: 'create'
            return
        }
        command.id = randomUUID()
        commandGateway.send(command)

        flash.message = 'Credit card transaction created'
        redirect(action: "index")
    }

    @Transactional
    def cancel(CancelTransactionCommand command) {

        if (command == null) {
            notFound()
            return
        }

        CreditCardTransaction creditCardTransaction = CreditCardTransaction.findById(command.id)

        command.aggregateIdentifier = creditCardTransaction.aggregateIdentifier

        commandGateway.send(command)

        request.withFormat {
            form {
                flash.message = "Credit card transaction cancelled"
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'creditCardTransactionInstance.label', default: 'CreditCardTransaction'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
