# XmlVsJsonRestControllerOutputs
A demonstration of JSON or XML outputs differences. Here also the annotation to prevent Hibernate POJO error


Spring uses JacksonLibrary to return a Json of the Objects or List<Object> that the RestController returns.
To use alternatively json or xml you must:

1. add @XmlRootElement on the Pojo
2. create Wrapper for the Lists
3. create the Controller methods which respond to .xml request.

That's because if you add .json at the end of the url you'll obtain the Json response message as you would if you don't add it, because json is the default format.
In this example I create some equivalent request mappings with ".xml" to ensure an xml answer too.

In this example you can also notice the difference between @PostConstruct method and CommandLineRunner run() method.
