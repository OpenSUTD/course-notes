# Logistic Regression

$$ \sigma (\theta\cdot x + \theta_0) = \frac{\exp(\theta\cdot x + \theta_0)}{1+\exp(\theta\cdot x + \theta_0)} $$

Let $h(x) = \sigma (\theta\cdot x + \theta_0)$

- $p(y|x) = h(x) \text{ for } y = + 1$
- $p(y|x) = 1-h(x) \text{ for } y = - 1$

We can combine the piece-wise function into one expression.

$$p(y|x) = \sigma (y(\theta\cdot x + \theta_0))  $$

### Determining the label of prediction

If new input $x$ is positive, 
$$p(y=+1|x) > p(y=-1|x)$$
$$\frac{p(y=+1|x)}{p(y=-1|x)} > 0$$
$$\log \frac{p(y=+1|x)}{p(y=-1|x)} > 0$$
$$\log \exp (\theta\cdot x + \theta_0) = \theta\cdot x + \theta_0 > 0$$

## Objective Function

$$ 
\begin{aligned}
  &\max_{\theta,\theta_0} \prod_{i=1}^n p(y^{(i)}|x^{(i)}) \\
  = &\max_{\theta,\theta_0} \log\prod_{i=1}^n p(y^{(i)}|x^{(i)} \\
  = &\max_{\theta,\theta_0} \sum_{i=1}^n \log p(y^{(i)}|x^{(i)}) \\
  = &\min_{\theta,\theta_0} \sum_{i=1}^n -\log p(y^{(i)}|x^{(i)}) \\
  = &\min_{\theta,\theta_0} \sum_{i=1}^n \log \frac{1}{p(y^{(i)}|x^{(i)})} \\
\end{aligned}
$$

We reduce the expression into a summation term from a product term **to avoid the underflow problem** where the constant multiplication of probabilities leads to a number that is too small to be represented in the computer.

## Loss Function

Since the objective function refers to the minimization of the loss function, we have
$$ 
\begin{aligned}
  &\sum_{i=1}^n \log p(\frac{1}{y^{(i)}|x^{(i)}}) \\
  = &\sum_{i=1}^n \log(1+\exp(-y^{(i)}(\theta\cdot x^{(i)}+ \theta_0))
\end{aligned}
$$

To determine the cost/error at each iteration, let's drop $\theta_0$ to make life easier for now since it can be added back easily.

$$ e^{(t)}(\theta) = \log(1+\exp(-y^{(i)}(\theta\cdot x^{(i)})) $$
$$ \triangledown e^{(t)}(\theta) = \frac{-y^{(t)}x^{(t)}}{1+\exp(-y^{(i)}(\theta\cdot x^{(i)}))} $$

Then we update the weights as such

$$ \theta \leftarrow \theta - \alpha\triangledown e^{(t)}(\theta)  $$