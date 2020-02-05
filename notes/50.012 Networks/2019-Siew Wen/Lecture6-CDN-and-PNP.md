Table of Contents

- [Content Distribution Networks (CDN)](#content-distribution-networks-cdn)
  - [CDN Server](#cdn-server)
    - [Types of CDN](#types-of-cdn)
    - [Choice of Placement](#choice-of-placement)
    - [Server Selection](#server-selection)
    - [Routing the Content](#routing-the-content)
    - [Content Replication](#content-replication)
- [Peer-to-peer architecture](#peer-to-peer-architecture)
  - [File distribution time (lower bound)](#file-distribution-time-lower-bound)
    - [Client-server](#client-server)

<hr>

# Content Distribution Networks (CDN)

Problem Background: Sreaming Content to hundred of thousands of simultaneous users

Possible solutions

1. Single mega server: doesn't scale
    - point of network congestion
    - long path to distant clients
    - single point of failure
    - multiple copies of vid sent over outgoing link
2. Store/serve multiple copies of videos at multiple geographically distributed sites (CDN)

CDN Operators stores copies of content at CDN Nodes.

## CDN Server

### Types of CDN

-   Commercial CDN
    -   e.g. Akamai, Cloudflare
-   Content provider's own CDN
    -   e.g. Google, netflix
-   Telco CDN

### Choice of Placement

-   Push CDN servers deep into many access ISPs so that they are close to users
-   Smaller no. of larger clusters in IXPs near access ISPs

### Server Selection

Points of consideration

-   Geographically close
-   Performance: Real-time measurement
-   Load-balancing
-   Cost: CDN may need to pay its provider ISP
-   Fault-tolerance

### Routing the Content

After selection, we still have a routing problem. We can route content access in 3 diff ways:

1. DNS-based
2. Application Driven
    - Multiple connection setup, name lookups
3. Routing(anycast)-based

### Content Replication

Mechanisms:

-   Push: Use of off-peak bandwidth optimization
-   Pull: More Adapative

e.g. Netflix

-   has prepared content
-   so push content to CDN during off-peak hours whose CDN servers pull & cache content by user demand.

e.g. Youtube

-   people can upload content anytime
-   so CDN servers pull content by user demand at all time

# Peer-to-peer architecture

-   Arbitrary end systems directly communicate as peers
-   Peers are intermittently connected and may change IP addresses

e.g. VoIP (Skype), Mulmedia Streaming (Kan kan), File Distribution (BitTorrent)

## File distribution time (lower bound)

-   $d_{min}$: min client download rate
-   $\frac{F}{d_{min}}$: min client download time
-   $\frac{F}{u_s}$: server upload time for one copy of file

### Client-server

-   Server must sequentially upload N file copies (to N clients)
-   Each client must download file copy

**Time to distribute F to N clients**
$$ D_{c-s} >= \max(N\frac{F}{u_s}, \frac{F}{d_{min}}) $$

P2P:

-   Server must upload at least one copy
-   each client must download one file copy
-   Clients asaggregate must download $NF$ bits

**Time to distribute F to N clients**
$$ D_{p2p} >= \max(\frac{F}{u_s},\frac{F}{d_{min}}, N\frac{F}{u_s+\sum{u_i}} ) $$

Another simplification of the third term of the equation:
$$N\frac{F}{u_s+\sum{u_i}} = \frac{F}{u_s/N+u} $$

