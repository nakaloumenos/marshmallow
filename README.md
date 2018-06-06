# README

This project provides a RESTful web service as a solution to Marshmallow's Java Backend Test https://github.com/marshmallow-insurance/java-backend-test/blob/master/README.md.

The project has been developed with and tested against Java:1.8 using Spring Boot on a UNIX-Like operating system.

Upon cloning this repository, the project can be set up by following the setup instructions below.

### Setup Instructions
**All commands should be executed from the terminal after you have navigated to the root directory of the project**
1.  ```sh
    $ mvn clean install
    ```
2. ```sh
    $ mvn spring-boot:run
    ```

At this point in your terminal there should be a message like the following
```sh
* o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
 ```

Now, the application should be accessible at `localhost:8080/api/cleanup` from an HTTP client of choice. 
Then after sending a POST request with the following body:

```
{
    "areaSize" : [5, 5],
    "startingPosition" : [1, 2],
    "oilPatches" : [
        [1, 0],
        [2, 2],
        [2, 3]
    ],
    "navigationInstructions" : "NNESEESWNWW"
}
```

you should get the following response:

```
{
    "finalPosition": [
        1,
        3
    ],
    "oilPatchesCleaned": 1
}
```
