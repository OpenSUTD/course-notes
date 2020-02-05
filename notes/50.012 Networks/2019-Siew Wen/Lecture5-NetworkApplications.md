# Multimedia Network Applications <!-- omit in toc -->
Table of Contents
- [Streaming stored video](#streaming-stored-video)
  - [Steraming multimedia: DASH](#steraming-multimedia-dash)
- [Voice over IP (VoIP)](#voice-over-ip-voip)
  - [Adaptive Playout Delay](#adaptive-playout-delay)
    - [Adaptively Estimate Packet Delay](#adaptively-estimate-packet-delay)
      - [Exponentially Weighted Moving Average ( EWMA )](#exponentially-weighted-moving-average--ewma)
      - [Average deviation of delay](#average-deviation-of-delay)

<hr>

## Streaming stored video

- Use Redundancy within and between images to decrease # bits required to encode image
  - Spatial (within image)
  - Temporal (from one image to next)
- Encoding Rate
  - CBR (Constant Bit Rate): Fixed encoding rate
  - VBR (Variable Bit Rate): Changes as amount of spatial, temporal coding changes
- Challenges
  - Continuous playout constraint: Once client playout begins, playback must match original timing
    - Network Delay e.g. queue delay are variable--> need client side buffer to match playout requirements
  - Client Interactivity: Allow pause, fast-forward, rewind and jump through video
  - Video packets may be lost, need to retransmit
    -  Packets may be received slower than it is being sent, so some packets might be skipped.

### Steraming multimedia: DASH

Dynamic, Adaptive Streaming over HTTP (DASH)
Other adaptive solutions: Apple's HTTP Live Streaming (HLS) solution, Adobe Systems HTTP Dynamic Streaming, Microsoft Smooth Streaming

- Server
  - encodes vid file into multiple versions
  - each version stored, encoded at a different rate
  - manifest file: provide URLs for different versions
- Client
  - Handles most of the streaming logic:
    - When to request chunk
    - What encoding rate to request
    - Where to request

## Voice over IP (VoIP)

VoIP end-end-delay requirement: <150 msec good, > 400msec bad

- For delay jitter, we aim to minimize client playout delay
- Receiver attempts to playout each chunk exactly q msecs after chunk is generated
    - Large q: less packet loss
    - Small q: better interactive experience

### Adaptive Playout Delay

#### Adaptively Estimate Packet Delay 

##### Exponentially Weighted Moving Average ( EWMA )
$d_i = (1-\alpha)d_{i-1} + \alpha(r_i - t_i)$

where: 
- $d_i$ is the delay estimate after ith packet
- $\alpha$ is a small constat
- $r_i$ is the time received, $t_i$is the time sent
- so $r_i - t_i$ is the measured delay of ith packet

##### Average deviation of delay
$v_i = (1-\Beta)v_{i-1} + \Beta|r_i - t_i - d_i|$

$d_i$, $v_i$ are calculated for every received packet, but used only at the start of talk spurt. 

- 1st packet in talkspurt: $playout-time_i = t_i + d_i + Kv_i $
  - longer playback delay
- Remaining packets are played out periodically