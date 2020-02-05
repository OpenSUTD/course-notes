# Transport-layer service models
- [Transport-layer service models](#transport-layer-service-models)
  - [Protocols](#protocols)
    - [TCP/UDP](#tcpudp)
  - [Client-server Architecture](#client-server-architecture)
  - [Peer-to-peer Architecture](#peer-to-peer-architecture)
  - [Electronic Mail](#electronic-mail)
    - [Mail Access Protocol](#mail-access-protocol)
- [Processes](#processes)
  - [Message Segmentation](#message-segmentation)

<hr>

**Transport service requirements**

-   Data loss
-   Throughput
-   Time sensitivity

## Protocols

### TCP/UDP

| TCP                                                             | UDP                                                        |
| --------------------------------------------------------------- | ---------------------------------------------------------- |
| reliable transport                                              | unreliable data transfer between sending/receiving process |
| **flow control**: sender won't overwhelm receiver               | NIL                                                        |
| **congestion control**: throttle sender when network overloaded | NIL                                                        |
| **connection-oriented**: setup required btw client/server       | no need                                                    |

For both TCP & UDP, there is no encryption of data. Hence we have SSL (Secure Sockets Layer)/ TLS(Transport Layer Security) for providing an encrypted TCP connection, ensuring data integrity and end-point authentication. Apps can use SSL/ TLS APIs to do so.

## Client-server Architecture

Server is always on with permanent IP address. Hosted in data centers for scaling.
Clients communicate with the server and may be intermittently (irregularly) connected with the server. Could have dynamic IP addresses. Clients usually do not communicate directly with each other.

## Peer-to-peer Architecture

-   Server is not always on
-   Arbitrary End Systems directly communicate: Good for file sharing, overlay-routing
-   Principles:
    -   Fault-tolerant
    -   Fate-sharing: It's okay to fail if it's your own mistake?
-   Self Scalability
    -   Peers request service from other peers and provide service in return
    -   New peers bring new service capacity and new service demands
-   Challenges:
    -   Peers are intermittently connected and change IP addresses
    -   Chunk Poisoning

## Electronic Mail

3 Major Components:

1. User Agents
2. Mail Servers
    1. Mailbox: contain incoming messages for user
    2. Message Queue: Messages to be sent (outgoing)
3. Simple Mail Transfer Protocol: SMTP
    - uses TCP for sending emails from client to server via port 25
    - has 3 phases of transfer: handshake, transfer, closure.
    - Requires message to be in 7-bit ASCII
    - Uses CRLF.CRLF for determining end of message

Compared to [HTTP](./Lecture3-HTTP.md), SMTP is a push rather than a pull server.
Both have ASCII command/res interaction, status codes.

User Agent -> SMTP -> Sender Mail Server -> SMTP -> Receiver's Mail Server -> Mail Access Protocol -> User Agent

Mail server: forward mail from sender to receiver mail server. if both the client and the receiver mail server are offline, the sender's mail server will keep retrying to send the mail until it works. Back then the mail servers are not so reliable to on all the time.

### Mail Access Protocol

Mail Access protocol is used for retrieval from server

-   POP (Post Office Protocol)
-   IMAP (Internet Mail Access Protocol)
-   HTTPs

# Processes

Definition of a Process: A program running within the host. It must have an identifier that includes IP address, port numbers associated with the process on host.
e.g. HTTP: 80, Mail: 25

Types of Process Communication

-   Inter-process communication: Dependent on OS
    -   unless the process is on the application layer, then it is controlled by the app developer.
-   Host-to-host communication: Exchange Messages
    -   Messages are sent/received via sockets.

Types of processes

-   Client Process: Initiate Communication
-   Server Process: Waits to be contacted

## Message Segmentation

- Reducing end-to-end delay.
- More efficient recovery from bit error. Otherwise the whole message needs to eb retransmitted.
- Huge message may block other smaller packets

- Header overhead linear to the no. of packets
- Cause new problem e.g. out-of-order arrival of packets