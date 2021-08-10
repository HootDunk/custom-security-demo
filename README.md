# custom-security-demo

## About
A repository to explore permission based authorization rather than role based authorization using the Micronaut framework.  The goal is to create a system of authorization that is more flexible to changing requirements for various users/roles. 

## ERD

![Screenshot from 2021-08-05 12-02-29](https://user-images.githubusercontent.com/58009556/128391454-5539af57-add1-451c-b8e3-d6aeb76c1f25.png)

## To run the App:
1) From the root directory, start the database container with: docker-compose up
2) Open another terminal and cd into server.  Type ./run.sh to start the app. 


## Resources
This resource was very helpful and demonstrates a similar approach -> https://blog.wick.technology/micronaut-security-rule/
I also recommend the JWT security section of the Micronaut docs as they explain some of the boilerplate code needed to get set up. 

## Testing out the app
Use the demo_endpoint to test out the @Required_Permission annotation
Use the Controllers in the memberProfile, role, and permission packages to explore the test data and get familiar with the test data. 


Here are the permissions of each person in the test data:

Josh ->     
    [
      {
        "id": "0f299d11-df47-406f-a426-8e3160eaeb21",
        "permission": "Can View Organization Members"
      }
    ]

Zach -> 
[
    {
        "id": "0f299d11-df47-406f-a426-8e3160eaeb21",
        "permission": "Can View Organization Members"
    },
    {
        "id": "c7b4d5e0-09ba-479a-8c40-ca9bbd8f217a",
        "permission": "Can Edit Team Membership"
    }
]

Mohit -> 
[
    {
        "id": "0f299d11-df47-406f-a426-8e3160eaeb21",
        "permission": "Can View Organization Members"
    },
    {
        "id": "20bf1ddb-53a0-436e-99dc-802c1199e282",
        "permission": "Can View PDL Data"
    },
    {
        "id": "c7b4d5e0-09ba-479a-8c40-ca9bbd8f217a",
        "permission": "Can Edit Team Membership"
    }
]

Jesse -> 

[
    {
        "id": "0f299d11-df47-406f-a426-8e3160eaeb21",
        "permission": "Can View Organization Members"
    },
    {
        "id": "20bf1ddb-53a0-436e-99dc-802c1199e282",
        "permission": "Can View PDL Data"
    },
    {
        "id": "439ad8a8-500f-4f3f-963b-a86437d5820a",
        "permission": "Can Create/Delete Organization Members"
    },
    {
        "id": "c7b4d5e0-09ba-479a-8c40-ca9bbd8f217a",
        "permission": "Can Edit Team Membership"
    }
]


## Brief summary of authentication and authorization flow in the app
### The basic flow for Authentication
1) A user sends a Post request to sign in to the application (localhost:8080/login).
2) The authenticate method within UserPasswordAuthProvider is called where the users records are checked in the database.  An AuthenticationResponse is provided which includeds the ExtendedUserDetails.  Why ExtendedUserDetails instead of the default Micronaut UserDetails class?  We need to include a List of the Users permissions as part of the UserDetails.
3) A Custom JWT claim is created from the populateWithUserDetails method within the CustomJWTClaimsSetGenerator.  The users permissions are included as part of this claim which we are able to get from our ExtendedUserDetails that were created in the prior method.
4)  The user gets the successful login response which included the JWT. 


### Basic flow for Authorization
All requests are filtered by the check method in the PermissionSecurityRule class.  It checks to see if the route has our custom RequiredPermission annotation.  If it does, then it checks the users claims (these claims come from the JWT which we made sure includes all of the users permissions).  If the permission written in the RequiredPermission is included in the list of permissions from the claim, then they are allowed to access the endpoint. 
If the route doesn't have the RequiredPermission annotation or the user doesn't have claims then unknown SecurityResult is returned which allows the request to be checked elsewhere (ex: if a route is annoted with the @Secured(SecurityRule.IS_ANONYMOUS) annotation we want it to pass through the check method inside of PermissionSecurityRule). 



## Todo
- Change the permission annoation to use value member variable and create and use a permissions Enum instead of any string
- Investigate the use of a database ENUM for permission instead of table


