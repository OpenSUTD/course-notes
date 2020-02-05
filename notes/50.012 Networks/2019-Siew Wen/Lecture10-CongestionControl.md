# Principles of Flow Control
- Receiver controls sender so the sender won't overflow receiver's buffer by transmitting too much/too fast
  - Application may remove data from TCP socket buffers
- Receiver includes a `rwnd` (receiver window) value in TCP header of receiver-to-sender segments
  - `RcvBuffer`

# Principles of Congestion Control

- Congestion Control $\not ={}$ Flow Control!
- Manifestations
  - Buffer Overflow at Routers: Lost Packets
  - Queueing in Router buffers: Long Delay

When packets are lost, any upstream transmission capacity used for that packet is wasted.

## Scenario 1: One Router w/ Infinite Buffers

- Assuming no retransmission

## Scenario 2: One Router w/ Finite Buffers

Assumptions for idealized case
- Sender knows when router buffers available
- Sender sends only when router buffers available

Transfer rates
- $\lambda_{in} = \lambda_{out}$: Application-layer input = output
- $\lambda_{in}' >= \lambda_{in}$ Transport-layer input includes retransmissions


## TCP Congestion Controls
### Increase sender's transmission rate until loss occurs

- Additive Increase: Increase `cwnd` (congestion window) by 1 MSS every RTT until loss detected
- Multiplicate Increase: Reduce `cwnd` in half after loss
