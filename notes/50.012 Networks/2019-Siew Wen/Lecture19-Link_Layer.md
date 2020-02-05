# Link layer <!-- omit in toc -->

Table of Contents
- [Introduction](#introduction)
  - [Two types of links](#two-types-of-links)
- [Link Layer Services](#link-layer-services)
- [Addressing: IP vs MAC](#addressing-ip-vs-mac)
- [Address Resolution Protocol (ARP)](#address-resolution-protocol-arp)
  - [Within the same Local Access Network (LAN)](#within-the-same-local-access-network-lan)
  - [Across LANs](#across-lans)
- [Multiple Access Protocol (MAP)](#multiple-access-protocol-map)
- [Ethernet](#ethernet)
- [Switches](#switches)
  - [Self-learning](#self-learning)
- [Virtual Local Area Network (VLANs)](#virtual-local-area-network-vlans)
- [Example of all layers together!](#example-of-all-layers-together)

## Introduction
- **Main Responsibility of the Link Layer** 
  - Transfer datagram from one node to *physically adjacent* node over a link.
  - Over different links, the datagram is transferred by different link protocols. 
    - *e.g)* First Link 802.11, Second Link PPP, ... Last link Ethernet
  - Each link protocol provide different service. 
    - *e.g)* may or may not provide RDT over link
- **Where the Link Layer is implemented**
  - Implemented via the combination of hardware, software and firmware in *every host*
  - Particularly in the *network interface card (NIC)* such as Ethernet card/802.11 card or a Ethernet chipset. It has a physical interface (physical layer) and a controller (link layer)
  - Attaches to the host's system buses to connect to the CPU of the host (application, transport, network and link layers), so that it is easier manage the link layer.

### Two types of links
1. Point-to-point (PPP)
   - Dial-up Access
   - Link between Ethernet switch and host
2. Broadcast
   - Ethernet
   - upstream HFC
   - 802.11 wireless LAN

## Link Layer Services
- **Framing, link access**
  - Encapsulate datagram into frame, add header and trailer
  - Channel access if *shared medium* [optional]
  - "MAC" Address used in frame headers to identify `src`, `dest`.
- **Reliable delivery** between adjacent nodes
  - Usually used on wireless links that would have *high error rates*. Seldomly used on low bit-error links incude Fiber, Twisted pair, Coaxial Cables.
- **Duplexing**
  - Half-duplex: Nodes at both ends of link can transmit *but not at the same time*.
    - There may be collision if the node receive $>=2$ signals at the same time, due to simultaneous transmissions (interference). 
  - Duplex: Nodes at both ends of link can transmit at the same time. There will be 1 wire for 1 direction. 
    - Utilize Multiple Access Protocol.

## Addressing: IP vs MAC

| IP address  <img width=600/>                                                         | MAC address                                                                                                                                                  |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| 32-bit                                                                               | 48-bit                                                                                                                                                       |
| Organizations reserve certain IP address ranges                                      | MAC address allocation adminstered by IEEE, and the manufacturer buys portion of MAC address space, so the first 24 bits are configured by the manufacturer. |
| Dynamically assigned by the network                                                  | The MAC Address is then burnt in the NIC ROM. But some are also software configurable.                                                                       |
| Uses Decimal Notation <br> e.g. 224.12.13.2/24                                       | Uses Hexadecimal Notation. <br> e.g. IA-2F-BB-76-09-AD                                                                                                       |
| Network layer forwarding                                                             | To get frame from one interface to another physically connected interface                                                                                    |
| Not portable, as the address depends on the IP subnet to which the node is attached. | Portable, as the LAN card containing the fixed MAC flat address can be moved from one LAN to another.                                                        |

## Address Resolution Protocol (ARP)

| IP address | MAC Address | TTL |
| ---------- | ----------- | --- |
Each IP node (host/router) on LAN has a **ARP Table** that contains IP/MAC address mappings for some LAN nodes, and the TTL time after which address mapping will be forgotten. These ARP tables are created by nodes without intervention from net adminstrator.

So if we know an interface's IP address, we can determine an interface's MAC Address. 

### Within the same Local Access Network (LAN)

1. A wants to send datagram to B, but A's ARP table does not have B's MAC Address
2. A broadcast **ARP query packet**, containing B's IP Address. All nodes on same LAN will receive this query.
3. B receives this packet and replies to A with its MAC Address as a frame.
4. A Caches the IP-to-MAC Address pair in its ARP table until timeout.

### Across LANs


1. All the nodes in the same LAN as A will not know the MAC address of B, who is inside another LAN. But there is a router R between the 2 LANs
2. A create IP datagram with `IP src A, dest B`, and put it inside a link-layer frame with `dest R`. This frame is thus sent from A to R.
3. R receives this datagram, take it out of the frame and pass it to IP.
4. R can now create a link-layer frame with `dest B`, containing the A-to-B IP datagram.  

## Multiple Access Protocol (MAP)

- MAP is a distributed algorithm that determines how nodes share channel (when the node can transmit).
- Communication about channel sharing uses the channel itself.
- No out-of-band channel for coordinated.

## Ethernet

The sending adaptor encapsulates IP datagram in an **Ethernet Frame structure** as such:
| Preamble | Dest Addr | Src Addr | Type | Payload | CRC |
| -------- | --------- | -------- | ---- | ------- | --- |

- Preamble: 7 bytes with pattern $10101010$ followed by one byte with pattern $10101011$
- Address: 6 byte source, dest MAC Address
- Type: Indicates higher layer protocol (Mostly IP but others possible, e.g. Novell IPX, AppleTalk)
- CRC: Cyclic Redundancy Check at receiver

## Switches

Switches and Routers are rather similar:
- Both are store-and-forward
- Both have forwarding tables

| Switches                                                       | Routers                                               |
| -------------------------------------------------------------- | ----------------------------------------------------- |
| Link-layer devices                                             | Network-layer devices                                 |
| Learn forwarding table using flooding, learning, MAC Addresses | Compute tables using routing algorithms, IP addresses |


### Self-learning

- When the switch receives a frame, it will record sender/location pair in switch table and learn of the location of the sender.

## Virtual Local Area Network (VLANs)

- Made up of switch(es) supporting VLAN capabilities to define multiple virtual LANs over single physical LAN infrastructure
- **Port-based VLANs** 
  1. *Single physical switch can operate as multiple virtual switches*: Switch ports are grouped by switch management software
  2. *Traffic Isolation*: Frames to/from ports 1-8 can only reach ports 1-8
  3. *Dynamic Membership*: Ports can be dynamically assigned among VLANs
  4. *Trunk port*: Carries frames between VLANs defined over multiple physical switches

802. IQ VLAN frame format

| preamble | dest | src | 🆕  | type | data(payload) | CRC |
| -------- | ---- | --- | --- | ---- | ------------- | --- |

:new: : 
- 2-byte Tag Protocol Identifier
- Tag Control Information
  - 3-bit priority field like IP TOS
  - 1 bit drop eligible indicator
  - 12 bit VLAN ID field

## Example of all layers together!

A typical scenario
1. Laptop tries to connect to the Internet and requires the following:
   1. its IP addr
   2. First-hop router addr
   3. DNS server addr
2. Make a DHCP request encapsulated in IP & 802.3 Ethernet
3. Broadcast Ethernet frame on LAN, and the router running the DHCP router receives it.
   1. This frame is demuxed to IP, UDP demuxed to DHCP
   2. DHCP Server formulate DHCP ACK containing what the client wants
   3. Encapsulate frame at DHCP server and forward (Switch Learning) through LAN
4. Client demultiplexes the DHCP frame and receive the ACK reply 

