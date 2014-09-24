<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get City Weather</title>
</head>
<body>
	<h2>City Weather Report</h2>
	<form:form method="POST" action="/WeatherReports/weather"
		commandName="weatherForm">
		<p>
			<form:select path="cityName">

				<form:option value="" label="Select" />

				<form:options items="${cityList}" />

			</form:select>
			<form:errors path="cityName" cssclass="error"></form:errors>
			<br/>
			<br /> <input type="submit" value="Submit" />
		</p>
	</form:form>
</body>
</html>