# Reinforcement Learning

**Problem:** $f: S \rightarrow A$
  - $S$: Set of States
  - $A$: Set of Actions

**Transition Probability**
- Moving from one state to another state is not definite
- $ T(s,a,s') = p(s'|s,a) $

**Reward**
- Incentivize a target state to be reached / not reached.
- Can be positive (reward) / negative (penalty)
- $R(s,a,s')$: Generally
- $R(s')$ : if the system only requires the target state to be reached.

## Markov Decision Process

Given
- a set of states $S$
- a set of actions $A$
- a transition probability function $T(s,a,s') = p(s'|s,a) $
- a reward function $R(s,a,s')$ or $R(s')$

### Utility (Long Term Reward)
- Maximizing the rewards alone is not sufficient to incentivise the program to reach the final state that you want. The program may infinitely loop around a few states
- Hence we apply a **discount** $\gamma$ to long-term rewards.

$$ 
\begin{aligned}
  U([s_1,s_2,...s_n]) &= R(s_1) + \gamma R(s_2) + \gamma_2 R(s_3) + ... \\
  &= \sum_{t=0}^\infty R(s_t)
\end{aligned}
$$

### Value Iteration Policy

We first define the following
-  $\pi(s)$: a particular policy that specifies the action we should take in state $s$
-  $V^\pi(s)$: The value of state $s$ under policy $\pi$
-  $Q^\pi(s,a)$: The $Q$-value of state $s$ and action $a$ under policy $\pi$

and the optimal version of them
-  $\pi^*(s)$: a particular policy that specifies the action we should take in state $s$
-  $V^*(s)$: The value of state $s$ under the optimal policy $\pi^*$
-  $Q^*(s,a)$: The $Q$-value of state $s$ and action $a$ under policy $\pi^*$

$$ 
\begin{aligned}
  Q^*(s,a) &= \sum_{s'} T(s,a,s') [R(s,a,s') + \gamma V^*(s')] \\\\
  V^*(s) &= Q^*(s,\pi^*(s)) \\
  &= \max_a Q^*(s,a)  \\
   &= \max_a \sum_{s'} T(s,a,s') [R(s,a,s') + \gamma V^*(s')] \\\\
  \pi^*(s) = \argmax_a Q^*(s,a)
\end{aligned}
$$

### Value Iteration Algorithm
1. Start with $V_0^*(s) = 0$ $\forall s \in S$
2. Given $V_i^*$, 
   1. calculate the values for all states $s \in S$ and 
   2. keep track of the best actions to formulate the best policy

$$ 
V^*(s) \leftarrow \max_a \sum_{s'} T(s,a,s') [R(s,a,s') + \gamma V^*(s')] 
$$

3. Repeat until convergence.

### Q-value Iteration Algorithm

Similar to Value Iteration Algorithm.