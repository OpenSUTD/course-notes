# Clustering

- Unsupervised learning
- Cluster: collection of similar data points, and is sufficiently different from other groups.
- Criterion for selecting clusters & representatives
  - Cosine Similarity: $\frac{x^{(i)}\cdot x^{(j)}}{||x^{(i)}||\cdot ||x^{(j)}||}$
  - Euclidean Distance: $||x^{(i)}|| - ||x^{(j)}||$

## K-means

### Cost of Clustering

$$ cost(C_1...C_k, z^{(1)}...z^{(k)}) = \sum_{j=1...k}\sum_{i\Subset C_j} ||x^{(i)} - z^{(j)} ||^2 $$

$$ cost(z^{(1)}...z^{(k)}) = \sum_{i=1...n} \min_{j=1...k} ||x^{(i)} - z^{(j)} ||^2 $$
### How it works
1. Choose the number of clusters $k$
2. Place the centroids $c_1, c_2, ..... c_k$ randomly 
3. for each data point $x_i$:
    - find the nearest centroid $(c_1, c_2 .. c_k)$ 
    - assign the point to that cluster 
4. for each cluster j = $1..k$
    - new centroid = mean of all points assigned to that cluster
  $$z^{(j)} = \frac{1}{|C_j|} \sum_{i \Subset C_j} x^{(i)}$$
5.  Repeat steps 4 and 5 until 
    - convergence ( when we find a clustering that minimizes the cost of clustering) 
    - or until the end of a fixed number of iterations.

Each iteration requires $O(kn)$ operations, and necessarily lowers the cost of clustering,, the sum of costs of individual clusters.


## K-medoids

### Choosing k
We should choose the value of k that results in the highest relative drop in the cost (which corresponds to an “elbow” in the graph capturing as a function of $k$).

### How it works
1. Choose the number of clusters $k$
2. Choose the exemplars $z_1, z_2, ..... z_k$ randomly out of the data points (or given otherwise)
3. For each data point $x_i$, other than the centroids:
    - calculate the distance to each exemplar $z_1, z_2, ..... z_k$ 
    - add the data point to the cluster that contains $z^{(j)}$ which is nearest to the point $x_i$.
4. Set new exemplar $z^{(j)}$ to be the point in $C^j$ that minimizes $\sum_{i\Subset C^j} d(x^{(i)},z^{(j)})$
5. Repeat steps 3-4 until no further change in cost.

## Difference between K-means and K-medoids

| K-medoids                                                                                                             | K-means                                                                                      |
| --------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| K-mediods is applicable to arbitrary objects and distance functions (e.g. categorical data)                           | Not possible to be applied for arbitrary objects and distance functions                      |
| It is less sensitive to noisy data when compared to k-means since a mediod is less influenced by outlier than a mean. | More sensitive to noisy data                                                                 |
| Can be applied even when true data points are not available and only their pair-wise distances are provided           | Cannot be applied if true data points are not available                                      |
| Can be applied to both continuous and discrete domains                                                                | Can only be applied to the continuous domain since the mean is not necessarily a data point. |
| Longer run time, especially for large and random datasets. Computing the medoid is harder than computing the average  | Shorter run time                                                                             |
| Medoid has no statistical meaning; it is neither a median nor geometric median                                        | The mean value has a true geometrical and statistical meaning                                |

### Similarities between K-means and K-medoids
- each iteration decreases the cost
- the algorithm always converges
- different starts gives different final answers
- it does not achieve the global minimum