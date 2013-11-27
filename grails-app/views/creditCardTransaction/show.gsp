
<%@ page import="grails.cqrs.CreditCardTransaction" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditCardTransaction.label', default: 'CreditCardTransaction')}" />
		<title><g:message code="default.show.label"/></title>
	</head>
	<body>
		<a href="#show-creditCardTransaction" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				%{--<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>--}%
				<li><g:link class="list" action="index"><g:message code="default.list.label"/></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" /></g:link></li>
			</ul>
		</div>
		<div id="show-creditCardTransaction" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list creditCardTransaction">
			
				<g:if test="${creditCardTransactionInstance?.creditCardNumber}">
				<li class="fieldcontain">
					<span id="creditCardNumber-label" class="property-label"><g:message code="creditCardTransaction.creditCardNumber.label" default="Credit Card Number" /></span>
					
						<span class="property-value" aria-labelledby="creditCardNumber-label"><g:fieldValue bean="${creditCardTransactionInstance}" field="creditCardNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${creditCardTransactionInstance?.creditCardCvvCode}">
				<li class="fieldcontain">
					<span id="creditCardCvvCode-label" class="property-label"><g:message code="creditCardTransaction.creditCardCvvCode.label" default="Credit Card Cvv Code" /></span>
					
						<span class="property-value" aria-labelledby="creditCardCvvCode-label"><g:fieldValue bean="${creditCardTransactionInstance}" field="creditCardCvvCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${creditCardTransactionInstance?.creditCardOwner}">
				<li class="fieldcontain">
					<span id="creditCardOwner-label" class="property-label"><g:message code="creditCardTransaction.creditCardOwner.label" default="Credit Card Owner" /></span>
					
						<span class="property-value" aria-labelledby="creditCardOwner-label"><g:fieldValue bean="${creditCardTransactionInstance}" field="creditCardOwner"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${creditCardTransactionInstance?.validDate}">
				<li class="fieldcontain">
					<span id="validDate-label" class="property-label"><g:message code="creditCardTransaction.validDate.label" default="Valid Date" /></span>
					
						<span class="property-value" aria-labelledby="validDate-label"><g:formatDate date="${creditCardTransactionInstance?.validDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${creditCardTransactionInstance?.amount}">
				<li class="fieldcontain">
					<span id="amount-label" class="property-label"><g:message code="creditCardTransaction.amount.label" default="Amount" /></span>
					
						<span class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${creditCardTransactionInstance}" field="amount"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:creditCardTransactionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:actionSubmit class="delete" action="cancel" value="${message(code: 'default.button.delete.label', default: 'Cancel')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
