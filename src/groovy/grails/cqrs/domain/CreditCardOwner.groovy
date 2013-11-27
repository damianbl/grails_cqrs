package grails.cqrs.domain

/**
 * Created by IntelliJ IDEA.
 * User: damian.blazejewski
 * Date: 18.11.13
 */
class CreditCardOwner {
    String name
    String surname
    String personalId
    Address address

    CreditCardOwner(String name) {
        this.name = name
    }
}
