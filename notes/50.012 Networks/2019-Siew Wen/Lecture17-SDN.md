# Software defined Networking (SDN)

- Separation of Control plane and Data plane
- **Centralized Control Plane**: A distinct remote controller interact swith local control agents (CAs) in routers to compute forwarding tables and distribute
  - Easier network management: Avoid Router misconfigurations, greater flexibility of traffic flows
  - Table-based forwarding allows "programmable" routers
- Data Plane Switches that implement generalized data-plane forwarding in its hardware can focus on making routing fast 

- Incorporated for *Service Function Chaining*
  - Enterprise Virtual Services: 
    - Subscriber, application or destination based granular traffic steering
  - Consumer Virtual Home Gateway
    - PNF: Firewall
    - VNFs: Parent Control, TCP/HTTP optimization, IPv4/IPv6 NAT


## OpenFlow Protocol

- TCP is used to exchange messages, with default port `6653`. 
- There are 3 classes of messages
  1. Controller-to-switch
  2. Asynchronous (Switch to Controller)
  3. Symmetric (misc)

