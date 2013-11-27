package grails.cqrs.command

/**
 * Created by IntelliJ IDEA.
 * User: damian.blazejewski
 * Date: 20.11.13
 */

@grails.validation.Validateable
class CancelTransactionCommand {
    Integer id
    UUID aggregateIdentifier

    static constraints = {
        id nullable: false
        aggregateIdentifier nullable: false
    }
}
