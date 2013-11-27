
<%@ page import="grails.cqrs.CreditCardTransaction" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditCardTransaction.label', default: 'CreditCardTransaction')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-creditCardTransaction" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				%{--<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>--}%
				<li><g:link class="create" action="create"><g:message code="default.new.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-creditCardTransaction" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="creditCardNumber" title="${message(code: 'creditCardTransaction.creditCardNumber.label', default: 'Credit Card Number')}" />
					
						<g:sortableColumn property="creditCardCvvCode" title="${message(code: 'creditCardTransaction.creditCardCvvCode.label', default: 'Credit Card Cvv Code')}" />
					
						<g:sortableColumn property="creditCardOwner" title="${message(code: 'creditCardTransaction.creditCardOwner.label', default: 'Credit Card Owner')}" />
					
						<g:sortableColumn property="validDate" title="${message(code: 'creditCardTransaction.validDate.label', default: 'Valid Date')}" />
					
						<g:sortableColumn property="amount" title="${message(code: 'creditCardTransaction.amount.label', default: 'Amount')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${creditCardTransactionInstanceList}" status="i" var="creditCardTransactionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${creditCardTransactionInstance.id}">${fieldValue(bean: creditCardTransactionInstance, field: "creditCardNumber")}</g:link></td>
					
						<td>${fieldValue(bean: creditCardTransactionInstance, field: "creditCardCvvCode")}</td>
					
						<td>${fieldValue(bean: creditCardTransactionInstance, field: "creditCardOwner")}</td>
					
						<td><g:formatDate date="${creditCardTransactionInstance.validDate}" /></td>
					
						<td>${fieldValue(bean: creditCardTransactionInstance, field: "amount")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${creditCardTransactionInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
