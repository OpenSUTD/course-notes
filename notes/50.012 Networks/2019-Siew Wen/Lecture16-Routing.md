Table of Contents
- [Scalable Routing](#scalable-routing)
  - [Inter-AS: Border Gateway Protocol (BGP)](#inter-as-border-gateway-protocol-bgp)
    - [BGP Route Selection](#bgp-route-selection)
  - [Intra-AS: IGP](#intra-as-igp)


<hr>

# Scalable Routing

Routers are usually aggregated into domains known as *autonomous systems* (AS)

| Intra-AS routing                                                                  | Inter-AS Routing                                                                                                                |
| --------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| Gateway has links to routers in other AS                                          | Gateways perform inter-domain routing and intra-domain routing                                                                  |
| All routers in AS must run same intra-domain protocol                             | Routers in different AS can run different intra-domain routing, but all routers would need torun the same inter-domain protocol |
| Single admin, so no policy decisions needed                                       | Admin wants to control over how its traffic is routed, who routes through its net.                                              |
| Scalability less of an issue, can always use hierarchical routing to reduce scale | Scalability is critical                                                                                                         |
| Focus on performance                                                              | Policy may dominate over performance                                                                                            |

## Inter-AS: Border Gateway Protocol (BGP)

- It is a **path-vector** protocol
  - Link cost is not the priority; **the routing policy is the most important** for BGP Routing.
  - `CIDRized Prefix` + `AS-path` + `Next-hop`
    - Next-hop: IP addr of gateway router to enter the path (You cannot route AS, only route routers.)
    - AS-path: Enforce import-policy for paths, avoid looping
- Provides each AS a means to 
  - **eBGP**: Obtain subnet reachability information from neighbor AS
  - **iBGP**: Propagate reachability information to all AS-internal routers
- BGP messages are exchanged between peers over semi-permanent TCP connection to advertise paths to different destination network prefixes
  - OPEN: *open TCP connection* to remote BGPpeer and authenticate sending BGP peer
  - UPDATE: Advertises new path / withdraw old path
  - KEEPALIVE: Keeps connection alive *in absence of UPDATES*. ACKs OPEN request
  - NOTIFICATION: Report errors in previous msg / Close Connection.

### BGP Route Selection

- BGP *sequentially* invokes these rules to select a route
  1. Local Preference value attribute: Policy Decision
  2. Shortest AS-Path
  3. Closest Next-Hop router: Hot Potato Routing
  4. Additional Criteria e.g.
- **Hot Potato Routing**: Choose local gateway that has the **least intra-domain cost**, without caring about inter-domain cost.
- *Habit of Keeping quiet*: If a network X does not want to route from B to C via X, X will not advertise to B a route to C.

## Intra-AS: IGP 

Routing with *Interior Gateway Protocols (IGP)*.
- RIP: Routing Information Protocol
- OSPF: Open Shortest Path First**
  - Area Border: Summarize distances to nets in own area then advertise to other Area Border routers
  - Backbone: run OSPF routing limited tobackbone
  - Boundary: Connect to other AS
- IGRP: Interior Gateway Routing Protocol
