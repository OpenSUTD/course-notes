- [The Internet - Networks of networks](#the-internet---networks-of-networks)
  - [Broadband Access](#broadband-access)
    - [Digital Subscriber Line (DSL)](#digital-subscriber-line-dsl)
    - [Cable - Hybrid Fiber Coax (HFC)](#cable---hybrid-fiber-coax-hfc)
    - [Fiber to The Home (FTTH)](#fiber-to-the-home-ftth)
      - [Optical Network Architectures](#optical-network-architectures)
  - [The evolution of routers](#the-evolution-of-routers)
    - [Interface Message Processors (IMP)](#interface-message-processors-imp)
  - [DARPA Design Policy](#darpa-design-policy)

# The Internet - Networks of networks

## Broadband Access

Today, the most prevalent types of broadband residential access are digital subscriber line and cable. However, Fiber to The Home internet access is now rapidly gaining popularity as well in first world countries. If these 3 methods of access are unavailable then satellite link or dial-up access can also be used to connect residences, but these won't be covered in the notes.

### Digital Subscriber Line (DSL)

1. A residence obtain DSL Internet access from a telco.
2. The customer's telco is then its Internet Service Provider (ISP).
3. The home's DSL modem takes digital data and translate it to high frequency tones fortransmission over telephone wires to the Central Office
4. The Central Office hosts a DSLAM where the analog signals from theseh ouses are translated back to digital data.
5. The telephone line carries data and telephone signals simultaneously, in different speed channels. This is also known as frequency-division multiplexing, resulting in asymmetric access.
    - High speed downstream channel => 50kHz - 1m MHz
    - Medium speed upstream channel => 4 kHz - 50 kHz
    - 2-way telephone channel => 0 - 4 kHz

### Cable - Hybrid Fiber Coax (HFC)

-   It is a shared broadcast medium that makes use of the cable's tv company's existing cable tv infrastructure.
    -   Hundreds of homes are connected via coaxial cable to a neighborhood junction. which is also connectedto a higher tier ISP (global ISP).
-   Cable modems are required in homes to access cable internet
    -   Connects the home PC through an Ethernet port.
    -   Divides the HFC network into a downstream and upstream channel.
        -   Each packet sent by the cable head end travels downstream on every link
        -   Each packet sent by a home travels upstream to the head end.

### Fiber to The Home (FTTH)

-   The mainstream mode of internet access nowadays
-   A optical fiber path is provided from the Central Office directly to home. Usually many homes share a single fiber from the CO, but when the fiber gets relatively close to the homes, then it is split into individual customer-specific fibers. This splitting can be done through 2 different architectures.

#### Optical Network Architectures

1.  Active Optical Networks (AONs): switched Ethernet (_covered later_)
2.  Passive Optical Networks (PON)
    1. Each home has an optical network terminator (ONT) which is connected by dedicated optical fiber to a neighborhood splitter.
    2. The splitter combines the homes onto a single, shared optical fiber which connects to an optical line terminator (OLT)

## The evolution of routers

### Interface Message Processors (IMP)

The IMP are the First Generation of Routers.

## DARPA Design Policy

[Anatomy of a data packet](https://www.techrepublic.com/article/exploring-the-anatomy-of-a-data-packet/)
