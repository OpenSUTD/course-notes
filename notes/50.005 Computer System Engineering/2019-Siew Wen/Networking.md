# Networking

Table of Contents

- [Networking](#networking)
  - [The Internet - A nuts &amp; bolts view](#the-internet---a-nuts-amp-bolts-view)
  - [The Packet](#the-packet)
    - [Single Router Packet Delay Sources](#single-router-packet-delay-sources)
    - [End-to-end Delay for many hosts](#end-to-end-delay-for-many-hosts)
      - [Calculating Throughput](#calculating-throughput)
    - [Average Link Utilization](#average-link-utilization)
    - [Modems](#modems)
  - [The Internet - A service view](#the-internet---a-service-view)
  - [Internet Protocol Stack (Layering)](#internet-protocol-stack-layering)
    - [Internet Control Message Protocol (ICMP)](#internet-control-message-protocol-icmp)
    - [Internet Service Provider (ISP)](#internet-service-provider-isp)
  - [Sharing of Information via Switching](#sharing-of-information-via-switching)
    - [Circuit Switching](#circuit-switching)
    - [Packet Switching](#packet-switching)

## The Internet - A nuts & bolts view

1. Hosts (End Systems) running network apps
2. Communication Links
3. Packet Switches

## The Packet

- Packet = Header + Payload

  - Header data is used by networking hardware to direct the packet to its destination
  - Payload is extracted and used by application software.

- Usually, the mode of transmission of packets is: PC -> Switch -> Router -> Modem -> Modem -> Switch -> Servers

- When the packets arrive at the router, the packet arrival rate to link temporarily exceeds the output link capacity. Hence they would queue in the router buffers, causing a delay.
  - If there are no free buffers for them to get into queue, then the packets will be dropped. This is known as packet loss.

### Single Router Packet Delay Sources

$$ d_{nodal} = d_{proc} + d_{queue} + d_{trans} + d_{prop} $$

1. Nodal Processing $(d_{nodal})$
   - Examine packet header
   - Check for bit errors
   - Determine output link (destination IP address in packet header)
2. Queueing $(d_{queue})$
   - Waiting time for packet to get to front of queue for output link
   - Depends on congestion level (how much other users are also sending data)
3. Transmission $(d_{trans})$ - Time to push the whole packet _(all the bits)_ from router to link
   $$ d_{trans} = \frac{L}{R} = \frac{\text{packet length (bits)}}{\text{link bandwith (bps)}}$$
4. Propagation $(d_{prop})$ - Time for packet to move from beginning to end of the link - _dprop_ = length of physical link (m) / propagation speed in medium _(~2x10^8 m/s - 2/3 speed of light in vacuum)_
   $$ d_{prop} = \frac{d}{s} m/s $$

### End-to-end Delay for many hosts

- If not given space-time diagram
  $$ d_{end} = \text{no. of hops} * \text{nodal delay} $$

- If given space-time diagram, we can approximate $d_{end}$ from the graph.

#### Calculating Throughput

Throughput: File Receival rate (bits/s)

- Instantaneous Throughput : at any instant of time
- Average Throughput : over a longer period

  - for a file consisting of F bits
  - and the transfer takes T seconds for Host B to receive all F bits, then the calculation for average throughput is as shown below.
    $$ \frac{F}{T} bits/s$$

- Effective throughput is determined by the slowest bandwidth in the route, the **_bottleneck link_**.

### Average Link Utilization

Also known as _Traffic Intensity_, given by the formula

$$ \text{Traffic Intensity} = \frac{La}{R}  $$

where:

- $L$ is the packet length (bits)
- $a$ = average packet arrival rate
- $R$ = link bandwidth (bits/s)

If $\frac{La}{R} > 1$ ,

- the average rate at which bits arrive at the queue exceeds the rate at which the bits can be transmitted from the queue.
- the queue will tend to increase without bound and the queuing delay will approach infinity.
- so system must be designed that traffic intensity should be <= 1.

If $\frac{La}{R} <= 1$ ,

- If packets arrive individually periodically, then every packet will arrive at an empty queue and there will be no queueing delay
- If the packets arrive periodically in bursts _(bursty data)_, then the nth packet transmitted will have a queueing delay of
  $$(n-1)*L/R \text  { seconds}$$

> Do note that the cases stated here are more academic examples than reality. In reality, typically, the arrival process to a queue is random; that is, the arrivals do not follow any pattern and the packets are spaced apart by random amounts of time. La/R is not usually sufficient to fully characterize the queueing delay statistics.

### Modems

- Carries out Modulation & Demodulation
- Modulation: A process to add text/img/vid/sound etc into a carrier signal. Demodulation is vice versa.
  - Types of broadbands:
    - Dial-up: audio freq <-> digital
    - DSL: copper telephone lines
    - Coaxial Cables: faster than DSL
    - Fibre Optic Cables: Light pulses
  - Wifi signals: EM waves
- But for modern modems, there is no longer a need for conversion of signals from audio freq <-> digital. Their primary role is for converting electrical signals over long connections, into some signal form that is understood by router & computers.

## The Internet - A service view

1. **Protocols for communication**
   - Define format, order of messages sent & received
   - Appropriate actions to be taken on message transmission and receipts.
   - Set by RFC (Request for Comment) documents, published by IETF (Internet Engineering Task Force).
   - e.g. TCP connection request -> connection response -> Get request to a server URI -> receive packet for a file
2. Network API for infrastructures to **provide services to user applications**
3. **Sharing of info among many devices** via circuit switching & packet switching
4. **Scalability of systems** via the Hierarchy of ISPs

## Internet Protocol Stack (Layering)

1. Application: messages
2. Transport: segments
3. Network: datagrams
4. Link: frames
5. Physical: bits

The stack is separated into 5 layers so that we can **avoid complex interactions between components.**

- The packet's header & payload is relative to the layer.
- E.g. Transport layer's header is network layer's payload.
- Number of possible interactions with N layers is N-1.
- Without layers, there are N^2 possible interactions instead
  - Difficult to debug
  - Might lead to emergent & undesirable behaviour

### Internet Control Message Protocol (ICMP)

ICMP is used by hosts and routers to communicate network-layer information to each other. ICMP is often considered part of IP but architecturally it lies just above IP, as
**ICMP messages are carried inside IP datagrams. (is also carried as IP payload)** _Similar to TCP/UDP segments being carried as IP payload._

When a host receives an IP datagram with ICMP specified as the upper-layer protocol, it demultiplexes the datagram’s contents to ICMP.

ICMP messages have a type and a code field, and contain the header and the first 8 bytes of the IP datagram that caused the ICMP message to be generated in the first place.The sender can then determine the datagram that caused the error.

Types of ICMP Messages:

- Source Quench: perform congestion control - congested routers send this message to a host to force that host to reduce its transmission rate
- Port Unreachable
- Ping Echo request/reply

### Internet Service Provider (ISP)

An organization that provides services for accessing and using the internet. It is also a network of packet switches & comm links.

The hierarchy of ISPs:
![](https://i.imgur.com/YPivUEQ.png)

- IXP connects the various global ISPs together.
- Then the small individual access ISP subscribe to commercial global Tier 1 ISPs.
- Google here is not a global ISP, but rather a Content Delivery Network    (CDN), which is a private network that carries data to & from Google servers only, but connects to everyone.

## Sharing of Information via Switching

### Circuit Switching

Circuit switching can performed via Time Domain Multiplexing (TDM) & Frequency Domain Multiplexing (FDM).

**Multiplexing** is the process of combining multiple signals into one, in such a manner that each individual signal can be retrieved at the destination. These multiple signals are also travelling in the same channel.

| TDM                                                                                                                                                                                        | FDM                                                                                                                                                                                                                 |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Bandwidth = bits/second                                                                                                                                                                    | Bandwidth = frequency range                                                                                                                                                                                         |
| divides and allocates certain time periods to each channel in an alternating manner.                                                                                                       | divides the channel into two or more frequency ranges that do not overlap.                                                                                                                                          |
| Greater flexibility as it can dynamically allocate more time periods to the signals that need more of the bandwidth, while reducing the time periods to those signals that do not need it. | Less flexible since it preallocates use of transmission link regardless of demand. Cannot dynamically change the width of the allocated frequency. So there could be allocated but unneeded link time going unused. |
| each signal uses all of the bandwidth some of the time                                                                                                                                     | each signal uses a small portion of the bandwidth all of the time.                                                                                                                                                  |

While there are advantages & disadvantages to each method, FDM and TDM are _often used in tandem_, to create even more channels in a given frequency range.

A common practice for telecoms to allow a huge number of users to use a certain frequency band:

- **divide the channel with FDM**, so that you have a dedicated channel with a smaller frequency range.
- Each of the FDM channels is then **occupied by multiple channels that are multiplexed using TDM**.

Circuit switching allows a **fixed, dedicated fraction of the link for each user**. Better for continuous, streamline usage.

### Packet Switching

On the other hand, Packet switching occupy link on demand, **better for bursty data**.
e.g. A link shared among many users, but only a low proportion of users are active at the same time.
