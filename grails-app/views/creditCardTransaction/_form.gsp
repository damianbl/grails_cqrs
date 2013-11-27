<%@ page import="grails.cqrs.CreditCardTransaction" %>



<div class="fieldcontain ${hasErrors(bean: creditCardTransactionInstance, field: 'creditCardNumber', 'error')} required">
	<label for="creditCardNumber">
		<g:message code="creditCardTransaction.creditCardNumber.label" default="Credit Card Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="creditCardNumber" maxlength="16" required="" value="${creditCardTransactionInstance?.creditCardNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: creditCardTransactionInstance, field: 'creditCardCvvCode', 'error')} required">
	<label for="creditCardCvvCode">
		<g:message code="creditCardTransaction.creditCardCvvCode.label" default="Credit Card Cvv Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="creditCardCvvCode" maxlength="3" required="" value="${creditCardTransactionInstance?.creditCardCvvCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: creditCardTransactionInstance, field: 'creditCardOwner', 'error')} required">
	<label for="creditCardOwner">
		<g:message code="creditCardTransaction.creditCardOwner.label" default="Credit Card Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="creditCardOwner" required="" value="${creditCardTransactionInstance?.creditCardOwner}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: creditCardTransactionInstance, field: 'validDate', 'error')} required">
	<label for="validDate">
		<g:message code="creditCardTransaction.validDate.label" default="Valid Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="validDate" precision="day"  value="${creditCardTransactionInstance?.validDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: creditCardTransactionInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="creditCardTransaction.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: creditCardTransactionInstance, field: 'amount')}" required=""/>
</div>

