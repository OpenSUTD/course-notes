Table of Contents

- [Introduction to Machine Learning](#introduction-to-machine-learning)
    - [Key Aspects of Learning Problems](#key-aspects-of-learning-problems)
- [Types of ML](#types-of-ml)
  - [Based on Learner's role](#based-on-learners-role)
  - [Based on Information/Dataset Available](#based-on-informationdataset-available)
    - [Supervised Learning](#supervised-learning)
      - [Classification](#classification)
      - [Steps to solving a supervised learning problem](#steps-to-solving-a-supervised-learning-problem)
    - [Unsupervised Learning](#unsupervised-learning)
      - [Clustering](#clustering)
      - [Dimensionality Reduction: Sub-space Learning](#dimensionality-reduction-sub-space-learning)
        - [The importance of Dimensions](#the-importance-of-dimensions)
        - [Principal Component Analysis](#principal-component-analysis)
    - [Reinforcement Learning](#reinforcement-learning)
- [Why Study ML](#why-study-ml)
    - [Engineering reasons for studying ML:](#engineering-reasons-for-studying-ml)
    - [Scientific reasons for studying ML](#scientific-reasons-for-studying-ml)

# Introduction to Machine Learning

`algorithms` `tasks` `performance` `experience`

Definition Of Machine Learning: ML is programming computers to optimize a **performance criterion** using example data or past experience.

ML has been studied since computers came out, but back then the amount of existing data is insufficient to do any useful ML, so it died quickly by 1970s. It is only now in the Big Data, IOT age that data is ever so abundant,and with enhanced computational power, ML can be applied meaningfully to these data to solve real-world problems that were previously too complex to be analyzed/ computationally difficult. Using ML, we aim to build models that are useful **approximations** of the relationship between input data and output data. After all, we can never tell if there is ever an absolute relationship between any sets of data.

We usually denote each feature (column) vector of dimension _d_ as such:

$$ x = x[x_1,...,x_d]^T \subset \R^d $$

$$
\begin{aligned}

x^(1), x^(2), ..., x^(n):& \textsf{ training examples} \\
y^(1),y^(2),...,y^(n) :&\textsf{ the corresponding labels}
\end{aligned}
$$

If _x_ is used to denote the original object (e.g. image), then we would use the following notation to denote the feature vector

$$ \phi(x) \subset R^d $$

### Key Aspects of Learning Problems

1. Data: could be Biased
2. Modelling: Set of Classifiers _H(x)_
3. Optimizing: Learning Algorithm / Performance Criterion
    - each algorithm comes with its assumptions

# Types of ML

## Based on Learner's role

-   Passive Learning
    -   Traditionally, learning algorithms have been passive learners in which they just take the data to produce hypothesis/model
-   Active Learning
    -   Active Learners can query the environment by asking questions/ performing experiments
    -   But it is difficult to account for the cost of queries/ query the environment optimally.

## Based on Information/Dataset Available

1. **_Supervised Learning:_** using labeled data
    - Classification (discrete values)
    - Regression (real values)
2. **_Unsupervised Learning:_** using unlabeled data
    - [Clustering](#clustering)
    - Probability Distribution Estimation
    - Finding Association In Features
    - [Dimension Reduction](#dimensionality-reduction-sub-space-learning)
3. **_Semi-supervised Learning:_** using a small subset of labeled data with a large amount of unlabeled data for learning
4. **_Reinforcement Learning:_** Using state spaces
    - Decision Making (robotics, games like DOTA)
5. **_Transfer Learning:_** Reusing trained filters for other models

### Supervised Learning

#### Classification

#### Steps to solving a supervised learning problem

1. Decide what the input-output pairs
2. Decide how to encode inputs and outputsm
3. Choose a class of hypothesis (modelling)
4. Choose error function to define best hypothesis
5. Choose algorithm for serarching efficiently through the space of hypotheses (optimizing)

### Unsupervised Learning

#### Clustering

Need to know approximately how many clusters of data is expected.

#### Dimensionality Reduction: Sub-space Learning

##### The importance of Dimensions

Say Boy A is training for IPPT and he records all the timings he takes to train 2.4km. It will result in 1D plot on the number line. But if he adds in the readings by his friend and have his records be differentiated, the result will be a 2D plot. If he adds a 3rd friend, the graph will become a 3D plot. The 4th friend onwards will be a Nth-D plot but it cannot be visualized anymore.

For a fitness trainer that sees data like this, sometimes he doesn't really care who ran how long but he just wants to see the duration of each practice run that has taken place and how the data varies. So for such a problem, we can perform **Principal Component Analysis** to reduce the dimensions involved and still get useful information out it.

##### Principal Component Analysis

Definition of PCA: A statistical procedure that uses an orthogonal transformation to convert a set of observations of possibly correlated variables (entities each of which takes on various numerical values) into a set of values of **linearly uncorrelated** variables called _principal components_.

> PCA works optimally only in the situation where the correlations are linear, which is most of the time an approximation. Otherwise do something to transform the data to linear variables or perform Nonlinear dimensionality reduction.

-   As described in the IPPT example, PCA can be used to convert the Original Data Space to Component Space.
-   These principal components mark the axes for the new plot with reduced dimensions. The first principal component (PC1) is the axis that spans the most variation in data, followed by PC2 with the 2nd most variation and so on.

Orthogonal transformation is performed via [Eigenvalue decomposition](https://en.wikipedia.org/wiki/Eigendecomposition_of_a_matrix) of a data covariance/ correlation matrix (must be diagonalizable).:

  Let A be a square n × n matrix with n linearly independent eigenvectors qi(where i = 1, ..., n). Then A can be factorized as
  $$ \Alpha v =\lambda v  $$ 
  $$ \Alpha Q = Q  $$ 
  $$ \Alpha = Q\Lambda Q^{-1} $$ 
  $$ \text{Q:  square n × n matrix whose ith column is the eigenvector  of A}$$
  $$ \text{Λ: the diagonal matrix whose diagonal elements are the corresponding eigenvalues } Λ_{ii} = λ_i. $$

### Reinforcement Learning

-   _Curse of Dimensionality_: all data points appear to be sparse and dissimilar in many ways, which prevents common data organization strategies from being efficient. This result in more complicated control problems to not fit enumerable states even if we discretize them.
-   Assumes _Markov Property_: The future does not depend on the past. The conditional probability distribution of future states of the process (conditional on both past and present values) depends only upon the present state.
    -   If there are consistent unknown factors that influence result, and could logically be deduced - maybe from history of state or actions - but are excluded from the state representation,the agent may fail to learn.

# Why Study ML

### Engineering reasons for studying ML:

-   Improving existing programs via:
    -   instruction scheduling and register allocation in compilers
    -   Combinatorial Optimization Problems
-   Solving tasks that require adaptive systems
    -   where humans can perform the task but cannot explain how e.g. speech/handwriting recognitiion, intelligent UIs
    -   desired function changes frequently e.g. predict stock prices
    -   each user needs a customized function e.g. news filtering
-   we don't want to hand code a lot of programs
-   performing tasks where there is no human expert

### Scientific reasons for studying ML

-   Discover knowledge & patterns in highly dimensional, complex data
-   Understanding the process of learning
