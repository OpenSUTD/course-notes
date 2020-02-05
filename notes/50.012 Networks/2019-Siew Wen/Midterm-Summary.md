# Midterms Summary

| Week | Topic                                                                          | Specific Notes                                                                                                                                                                                                                                    |
| ---- | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1-2  | Internet Overview, Application Layer                                           | [Lecture 1: Transport Layer](Lecture1-TransportLayer.md), <br> [Lecture 2: HTTP](Lecture2-HTTP.md), <br> [Lecture 3: WebAPI](Lecture3-WebAPI.md)                                                                                                  |
| 3    | Multimedia Networking and CDN                                                  | [Lecture 5: Network Applications](Lecture5-NetworkApplications.md), <br> [Lecture 6: CDN and PNP](Lecture6-CDN-and-PNP.md)                                                                                                                        |
| 4-5  | Transport Layer Principles: <br> Reliable Data Transfer and Congestion Control | [Lecutre 7: RDT](Lecture7-RDT.md), <br> [Lecture 8: RDT Pipelines](Lecture8-RDTPipelines.md), <br> [Lecture 9: TCP and RDT Principles](Lecture9-TCP_RDT_CC_Principles.md), <br> [Lecture10: Congestion Control](lecture10-Congestion-Control.pdf) |
| 6    | TCP                                                                            | [Lecture 11: TCP Wrap up ](Lecture11-TCPWrapup.md)                                                                                                                                                                                                |

**Resources for practice**

Problem sets: http://gaia.cs.umass.edu/kurose_ross/interactive/index.php

# Learning Checklist
## Week 1-2: Internet Overview and Application Layer

**Overview**
- [ ] Internet Structure: ISPs
- [ ] The Internet Protocol Stack: APTNLP
- [ ] Network Performance: Throughput, Delay and Loss Probability
- [ ] 4 Sources of Packet Delay
- [ ] Space-Time Diagrams
- [ ] Circuit Switching vs. Packet Switching

**Application Layer**
- [ ] Application Architectures
- [ ] Process Communication
  - [ ] Addressing processes with *identifiers*
  - [ ] What are Sockets
- [ ] Internet Transport Protocol Services: TCP vs. UDP
  - [ ] Socket Programming: Establishment and Usage
  - [ ] Protocol definitions
- [ ] Electronic Mail Application Protocols
  - [ ] SMTP Interaction and DATA Format
- [ ] HTTP
  - [ ] Web API
    - [ ] URI, URL, URNs
    - [ ] Architectural Style: REST
  - [ ] Idempotence and safe methods

## Week 3 : Multimedia Networking
  - [ ] Streaming Stored Media
    - [ ] Role of UDP
    - [ ] DASH: Dynamic Adaptive Streaming over HTTP
    - [ ] Interpreting plots for data transmission and playout rate
  - [ ] VoIP (Voice-over-IP)
    - [ ] Adaptive Playout Delay: Average Estimate of Packet Delay, Average Deviation of Delay, Playout time for packets in talk spurts
    - [ ] Recovery From Packet Loss: Simple Forward Error Correction (FEC)
  - [ ] Streaming Live Media
  - [ ] Content Distribution Networks (CDN) and concerns of CDN Operators
    - [ ] CDN Server Placement
    - [ ] CDN Server Selection
    - [ ] CDN Content Routing
    - [ ] CDN Content Replication

## Week 4: Transport Layer

- [ ] Multiplexing/Demultiplexing
  - [ ] Connectionless
  - [ ] Connection-oriented
- [ ] UDP
  - [ ] Segment Header
  - [ ] Checksum
- [ ] Reliable Data Transfer
- [ ] Flow Control
- [ ] Congestion Control
- [ ] TCP Connection Management

