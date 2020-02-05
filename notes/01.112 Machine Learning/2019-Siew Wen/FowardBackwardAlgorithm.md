## Forward-Backward Algorthm

### Going Forward

- $\alpha_u(j) =$ the sum of the scores of all paths from START to node $u$ at $j$

- For the first node, there is no emission probability. 
$$
\begin{aligned}
  \alpha_u(1) &= \alpha_{START,u} \\ 
  &= p(x_0 , y_1 = u)
\end{aligned}
$$

- For the other nodes,

$$\text{Given that }\sum_B P(A,B) = P(A)$$

$$
\begin{aligned}
  \alpha_u(j+1) &= p(x_1 ... x_j, y_{j+1} = u) \\
  &= \sum_v p(x_1...x_j, y_{j+1} = u, y_j = v) \\
  &= \sum_v p(x_1...x_{j-1}, y_j = v, x_j, y_{j+1}= u) \\
  &= \sum_v p(x_1...x_{j-1}, y_j = v) \cdot b_v(x_j) \cdot a_{v,u} \\
  &= \sum_v \alpha_v(j) \cdot b_v(x_j)\cdot \alpha_{v,u}
\end{aligned}
$$

### Going Backward

- $\beta_u(j) =$ the sum of the scores of all paths from node $u$ at $j$ to STOP.

> $x_{j+1}$ cannot be generated before $x_j$

$$ 
\begin{aligned}
  \beta_u(j) &= p(x_j...x_n | y_j = u) \\
  &= \sum_v p(x_j...x_n, y_{j+1} = v | y_j = u) \\
  &= \sum_v p(x_j, y_{j+1} = v, x_{j+1}... x_n | y_j =u) \\
  &= \sum_v b_u(x_j) \cdot a_{u,v} \cdot p(x_{j+1}...x_n | y_{j+1} = v) \\
  &= \sum_v b_u(x_j) \cdot a_{u,v} \cdot \beta_v(j+1)
\end{aligned}
$$

Time Complexity: $O(nT^2)$
- $O(T)$ operations for $T$ nodes at $n$ positions

