# Web API

API specifies how 2 software components should interact.

**Types of API Protocols**

  - [SOAP](#soap)
  - [REST](#rest)
    - [Resources in REST](#resources-in-rest)
    - [Running HTTP Requests with curl](#running-http-requests-with-curl)
      - [PUT vs POST](#put-vs-post)
- [MIME](#mime)

## SOAP
Simple Object Access Protocol (SOAP) is the specific protocol for XML-based data exchange, popular in enterprise M-M communication.
- However, Specific protocol seems to add overhead in many cases


Web service definition language (WSDL) is used to specify available service to client
- client-side functions to call API can be automatically generated
- auto-completion for API calls

## REST

Representational State Transfer (REST) is not a protocol, but rather an architectural style.

- Pros: Simple, scalable, general, high performance
- Cons: No-built-in ACID & Under-fetching/Over-fetching
  - ACID: Atomicity, Consistency, Isolation, Durability
  - Over-fetching: You might get more data than you need, but the end point is designed to give you that specific data.
  - Underfetching: You might get less data than you need, because there is no end point designed to give you the data you need from that server.

### Resources in REST

- 2 Types
  1. Collections
  2. Instances
- Referenced in the HTTP header

| Simple Static Settings                   | Dynamic Settings                                                                                                                                                  |
| ---------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Each resource corresponds to single file | The server will interpret the URL as parameters and dynamically create content for the provided parameters. So the content at the resource URL may not exist yet. |

### Running HTTP Requests with curl

At any point of time, if you want to understand more about the flags that you pass into curl to test your http requests, run `curl --help`

Examples of sending a get request and giving the -v flag to show more information on exchanged messages.
![](./demo_rest_api.png)

For a patch request, you can run
```bash
curl -H "Content-Type: application/json" -X PATCH -d '{"title":"test"}' http://jsonplaceholder.typicode.com/todos/199
```
The result will be
```
{
  "userId": 10,
  "id": 199,
  "title": "test",
  "completed": true
}
```

#### PUT vs POST

PUT: Used to update an existing resource. Reply will be 200.
POST: Used to create an element in a collection. Reply will be 201 with URL of created element.

# MIME 

Multipurpose Internet Mail Extensions (MIME) is an Internet standard that extends the format of email messages to support text in character sets other than ASCII, as well attachments of audio, video, images, and application programs. Message bodies may consist of multiple parts, and header information may be specified in non-ASCII character sets.
