Table of Contents
- [HTTP](#http)
  - [HTTP Methods](#http-methods)
- [Proxy](#proxy)
  - [Forward Proxy](#forward-proxy)
  - [Reverse Proxies](#reverse-proxies)

<hr>

# HTTP 

Each HTTP message designed to be *self-contained*:

-   it bring as much detail asthe server needs to servethatrequest
-   server does not maintain state

**Protocols that maintain state** are complex

-   Past History must be maintained
-   If server/client crash, the state that is stored on either host will be inconsistent
-   however doing so is likely to improve performance

## HTTP Methods

***Safe*** Methods e.g. GET, HEAD:

-   enable caching and loading distribution
-   does not modify resources on server

***Idempotent*** Methods e.g. Multiple DELETE:

- _Definition_: An effort that can be applied multiple times without changing the result beyond the initial application.

  -   Handle lost confirmations by re-sending
  -   May modify resources on the server
  -   Can be executed multiple times without changing outcome

- counter.e.g. Multiple POST

# Proxy


_Definition_: An entity **authorized to act on behalf of another** e.g. an intermediatory server performing requests for us

-   Serve as a single point access of control to enforce security protocols

**Common traits of proxies**:

-   Single access of control
-   Load Balancing: Distribute incoming requests to a cluster of servers, all provide the same kind of service

## Forward Proxy

When a client makes a connection attempt to that file transfer server on the Internet, its requests usually have to *pass through the forward proxy first*, where a firewall will be behind it.

1. Depending on the forward proxy's settings, a request can be allowed or denied.
2. If allowed, then the request is forwarded to the firewall and then to the file transfer server.
3. From the point of view of the file transfer server, it is the proxy server that issued the request, not the client. So when the server responds, it addresses its response to the proxy.
4. When the forward proxy receives the response, it recognizes it as a response to the request that went through earlier. And so it in turn sends that response to the client that made the request.

Applications:

-   Content Logging & Eavesdropping
-   Accessing Services Anonymously

## Reverse Proxies

The reverse proxy does the exact opposite of what a forward proxy does. It accepts requests from external clients on behalf of servers stationed behind it. The firewall is between the client and reverse proxy instead of being in between the forward proxy and the servers.

1. Depending on the reverse proxy'settings, a request can be allowed or denied.
2. From the perspective ofthe client, it is the reverse proxy that is providing file transfer services.

Applications:

-   A/B testing, Multivariete testing
-   Distribute load
