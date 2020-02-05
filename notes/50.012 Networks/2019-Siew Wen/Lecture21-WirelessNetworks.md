Table of Contents
- [802.11 Wireless LAN](#80211-wireless-lan)
  - [Mobility within same subnet](#mobility-within-same-subnet)
  - [Rate Adaptation](#rate-adaptation)
  - [Power Management](#power-management)
- [Mobile Networks](#mobile-networks)
  - [Cellular Network Architecture](#cellular-network-architecture)
  - [Handling Mobility](#handling-mobility)
    - [Handoff with common MSC](#handoff-with-common-msc)
    - [Handoff Between MSCs](#handoff-between-mscs)
    - [Consequences of mobility](#consequences-of-mobility)

<hr>

# Wireless Networks <!-- omit in toc -->

Examples
|                                                                            | single hop                                                                             | multiple hop                                                                                    |
| -------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| **Infrastructure**                                                         | *WiFi, Cellular* <br> Host connect to a base station which connects to larger Internet | *Mesh Net* <br> Host have to relay through several wireless nodes to connect to larger Internet |
| No infrastructure (**No base station + no connection to larger internet**) | *Bluetooth*                                                                            | *MANET, VANET*                                                                                  |

## 802.11 Wireless LAN

- Basic Service Set (BSS) in infrastructure mode consists of wireless hosts and access point
- Host communicates with a base station, known as an access point (AP).
- 802.11b spectrum divided into 11 channels at different frequency
  - Admin choose frequency for AP
- Channel can be same as that chosen by neighboring AP, which may result in **interference**
  - Under **Carrier Sense Multiple Access** (CSMA)
    - *Collision Detection*: Collisions are detected within short time to reduce channel wastage
      - Easy in wired LANs: can measure signal strength,sand ompare
      - Difficult in wireless LANs: Received signal strength overwhelmed by local transmission strength
    - *Collision Avoidance*: 
      - Sender Channel sensed idle 👉 transmit entire frame
      - Sender Channel sensed busy 👉 defer transmission by starting random *backoff time* and transmit when timer expires. *This interval increases exponentially if no ACK.*
- Host associates with an AP by scanning channels, listening for **beacon frames** containing AP's name (*SSID*) and *MAC address* and selecting one to associate with
  - There are 2 types of scanning: Passive, Active
    - Passive: APs will send beacon frames
    - Active:Host broadcast Probe Reuqest Frame + AP will send Probe Response Frames
  - Then, the host will send Association Request Frame to the selected AP and the selected AP will send Association Response Frame back.
  - Typically run DHCP to get IP address in the selected AP's subnet

### Mobility within same subnet
- When hosts are **moving between diff APs in the same subnet**, then the self-learning switch will see frame from the host and remember which switch port can be used to reach the hosts. 
  - If diff subnets, then the host will probably lose connection.
  - Othewise, OUT OF SYLLABUS

### Rate Adaptation
Rate adaptation allows transmission to be done at different rates within the wireless network, depending upon the network conditions.

- Adaptor can detect channel condition in real-time
- Plotted in a Signal Noise Ratio (SNR) vs Bit Error Rate (BER) graph
- As the mobile moves away from base station
  - BER $\uparrow$, SNR $\downarrow$
  - When BER becomes too high, switch to a lower transmission rate but with lower BER.

### Power Management

Beacon Frame: Contains list of mobiles with AP-to-mobile frames waiting to be sent

1. Node stays awake if AP-to-mobile frames are to be sent. 
2. Otherwise node tells AP "I am going to zzz until next **beacon frame**"
3. AP say "ok then i don't transmit frames to you"
4. Node autowakes up before next beacon frame.
  
## Mobile Networks

### Cellular Network Architecture

*Components of the architecture*

2G:
- BTS: Base Transceiver Station
- BSC: Base Station Controller
- MSC: Mobile Switching Center

3G: 
- SGSN: Serving GPRS Support Node
- GGSN: Gateway GPRS Support Node

4G: 
- UE: User Element
- MME: Mobility Management Entity
- HSS: Home Subscriber Server
- S-GW: Serving Gateway
- P-GW: Packet data network Gateway
- EPC: Evolved Packet Core

| Network | What changed                                                                                                             | Components                    |
| ------- | ------------------------------------------------------------------------------------------------------------------------ | ----------------------------- |
| 3G      | New Cellular Data Network operates in parallel with existing cellular voice network. Voice network is unchanged in core. | SGSN, GGSN                    |
| 4G      | No more separation between voice and data - All traffic is carried over IP core to gateway                               | UE, MME, HSS, S-GW, P-GW, EPC |

### Handling Mobility
#### Handoff with common MSC

1. Old BSS: "Oi MSC, i want to HOTO, this is the list of new BSSs"
2. MSC: "Ok i set up new path and allocate resources for these new BSS"
3. New BSS tries to prepare to take over and allocates radio channel for use by mobile
4. After finishing, the New BSS signals MSC and old BSS "I am ready"
5. Old BSS tells new BSS: "ok now i really HOTO to you"
6. New BSS signal to activate new channel
7. Mobile signals via new BSS to MSC: "Handoff complete"

✔️ Allows stronger signal to/from new BSS: Continuing connectivity and less battery drain
✔️Load Balancing: Free up channel in current BSS

#### Handoff Between MSCs
*Distinguishing networks beyond a single MSC*
1. Home Network
   - Network of cellular provider that a mobile is subscribed to
   - Network to which the mobile user's permanent phone number belongs
   - Data Stored in **Home Location Register** (HLR): The database containing permanent cell phone #, profile info, info of current location (even outside the home network)
2. Visited Network
   - Network in which mobile currently resides
   - Data is stored in **Visitor Location Register** (VLR): Database with entry for each user currently in network.
   - A visited network can also be home network

**Multi-MSC Chain**
Made up by the Anchor MSC (1st MSC visited during call) + other MSCs that are added onto the end of the chain as the mobile moves to new MSC.
- Optional path minimization step to shorten multi-MSC Chain

#### Consequences of mobility

- Performance
  - There may be packet loss/delay due to handoff / link-layer retransmissions
  - TCP may interpret this loss as congestion, and *decrease cwnd unnecessarily*
  - *Limited bandwidth* of wireless links; wireless behind wired networks by 1-2 orders in terms of speed
- Aside from Performance, there should be minimal impact 
  - Best Effort Service Model remained unchanged.
  - TCP and UDP can run over wireless mobile