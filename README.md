Assignment
==========
Spring MVC project to get weather of a city that is chosen from dropdown.<br/>
Uses hibernate validators to validate the dropdown input selection<br/>
Uses JSP and form tag lib for rendering html.<br/>
View resolved using viewResolver configured as InternalViewResolver in the servlet config.<br/>
WeatherController.java has the business logic, it responds to GET request with a HTMLform and a dropdown for selection of city.<br/>
WeatherController.java responds to form SUBMIT, POST request by accessing a open source weather REST API using RESTTemplate and the resulting JSON data is parsed to retrieve relevant attributes and stored in Model object.<br/>
City.java - java bean is the backing form object.
