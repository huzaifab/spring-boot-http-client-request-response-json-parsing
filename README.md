# spring-boot-http-client-request-response-json-parsing

Requirements
- Java 1.8
- Maven (latest version is good)


How to compile?
- >PATH-TO-PROJECT mvn clean install
- >java -jar target\spring-boot-http-client-request-response-json-parsing-0.1.0.jar

provide port no using command line while running
- >java -jar target\spring-boot-http-client-request-response-json-parsing-0.1.0.jar --server.port=8080

How to run?
- from Browser or using Postman Client GET request url http://localhost:8080/httpresponse/1
- it will show output as :
	[
		"SUPER_ADMIN",
		"GROUP",
		"LIMITED_ACCESS",
		"EXTERNAL_USER",
		"ADMIN",
		"USER",
		"TEMP_USER",
		"CLIENT"
	]
OUTPUT will filtered from below json which resides at location http://api.myjson.com/bins/17akzo

{
    "data": [
        {
            "type": "web",
            "id": "uid-web",
            "attributes": {
                "permissions": [
                    "GROUP",
                    "SUPER_ADMIN",
                    "USER",
                    "LIMITED_ACCESS"
                ]
            },
            "days": [
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY"
            ]
        },
        {
            "type": "api",
            "id": "uid-api",
            "attributes": {
                "permissions": [
                    "ADMIN",
                    "GROUP",
                    "TEMP_USER",
                    "LIMITED_ACCESS"
                ]
            },
            "days": [
                "SUNDAY",
                "MONDAY"
            ]
        },
        {
            "type": "mobile",
            "id": "uid-mobile",
            "attributes": {
                "permissions": [
                    "ADMIN",
                    "CLIENT",
                    "EXTERNAL_USER",
                    "LIMITED_ACCESS"
                ]
            },
            "days": [
                "FRIDAY",
                "SATURDAY",
                "SUNDAY"
            ]
        }
    ]
}
	
GET request url http://localhost:8080/httpresponse/6
- it will show output as : 3 	

Same way id can be between 1 to 8

- you are all set
