Assignment
==========
Spring MVC project to get weather of a city that is chosen from dropdown.
Uses hibernate validators to validate the dropdown input selection
Uses JSP and form tag lib for rendering html.
View resolved using viewResolver configured as InternalViewResolver in the servlet config.
WeatherController.java has the business logic, it responds to GET request with a HTMLform and a dropdown for selection of city.
WeatherController.java responds to form SUBMIT, POST request by accessing a open source weather REST API using RESTTemplate and the resulting JSON data is parsed to retrieve relevant attributes and stored in Model object.
City.java - java bean is the backing form object.
