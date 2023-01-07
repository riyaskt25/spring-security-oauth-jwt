# spring-security-oauth-jwt
This is a sample project for implementing spring security native oauth support using JWT tokens.

This project has 2 modules/applications/servers.
1. Auth server, Auth server code based is available in the folder 'auth2-authserver'
1. Resource server, Resource server code base is available in the folder 'auth2-resserver'.

Auth sever has to run in a seperate domain for this we need edit the /etc/hosts file and add an entry like below

	127.0.0.1       auth-server
Note : If we are executing on a windows system this file is located in the below path.
C:\Windows\System32\drivers\etc

Once the /etc/hosts file update completed we need to execute the auth server first and then we need to execute the resouce server.

How to Execute Auth Server ?

Import the project 'auth2-authserver' to the IDE and run the project from  'Auth2AuthserverApplication' class.

This Authe server has a token end point, once we hit this end point using the registered client credentials it will provide access token for accessing other APIs.

Resurce APIs are protected  using this access token so we need to provide the access token in subsequent API calls.

Once Auth server execution completed we can proceed to execute Resouce server.

How to Execute Resource Server ?

Import the project 'auth2-resserver' to the IDE and run the project from 'Auth2ResserverApplication' class.

Once resource server started, We can execute the protected resouce APIs using the access token received from the token end point.

Please refer the attached postman collection for the details for token and resource APIs. 
