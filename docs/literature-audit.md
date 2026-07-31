# Literature audit

## Decision boundary

The project does not claim the square-root or Hadamard-square simplex lift as new. It does not claim that smooth parametrizations can create flat saddles as a new observation.

The proposed contribution is narrower:

1. an exact necessary-and-sufficient boundary-contact threshold for normalized block-separable simplex lifts;
2. a complete convex characterization showing which missing KKT inequalities are visible at each derivative order;
3. the zero-multiplicity law `r_i = 2 z_i` for deep squared-Hadamard factorizations;
4. an exact boundary-jet identity recovering each missing reduced cost.

The curve-based finite-jet condition is a formulation used to state the result. The project does not claim that higher-order necessary conditions or curve tests are new.
The coordinate-invariance proposition is a supporting standard lemma, not a separate novelty claim.

## Closest primary results

### Sphere-to-simplex squaring

Qiuwei Li, Daniel McKenzie, and Wotao Yin, “From the simplex to the sphere: faster constrained optimization using the Hadamard parametrization,” *Information and Inference* 12(3), 1898–1937 (2023), DOI: [10.1093/imaiai/iaad017](https://doi.org/10.1093/imaiai/iaad017).

This paper establishes the first- and second-order landscape correspondence for the square lift. The present draft treats it as the contact-order-two case.

### General smooth-lift framework

Eitan Levin, Joe Kileel, and Nicolas Boumal, “The effect of smooth parametrizations on nonconvex optimization landscapes,” *Mathematical Programming* (2024), DOI: [10.1007/s10107-024-02058-3](https://doi.org/10.1007/s10107-024-02058-3).

This paper characterizes cost-independent preservation of local minima and first- or second-order critical points. It proves that failure of second-to-first preservation can already be witnessed by a strongly convex quadratic. Its conclusion identifies general higher-order preservation as an open direction. The present draft addresses that direction for block-separable simplex lifts.

### Polyhedral Hadamard parametrizations

Tianyun Tang and Kim-Chuan Toh, “Optimization over convex polyhedra via Hadamard parametrizations,” [arXiv:2410.23874](https://arxiv.org/abs/2410.23874) (2024).

This work develops tangent, second-order tangent, multiplier-recovery, and stratification results for square-based polyhedral parametrizations. It increases the prior-art risk for any claim framed only around polyhedral boundaries or second-order conditions.

### KL exponents and local rates

Wenqing Ouyang, Yuncheng Liu, Ting Kei Pong, and Hao Wang, “Kurdyka–Łojasiewicz exponent via Hadamard parametrization,” [arXiv:2402.00377](https://arxiv.org/abs/2402.00377) (2024).

This paper studies second-order points and KL exponents for Hadamard-difference-parametrized `l1` models. Any future convergence-rate claim for the present project must be compared against this line of work.

### Deep linear landscapes

El Mehdi Achour, François Malgouyres, and Sébastien Gerchinovitz, “The loss landscape of deep linear neural networks: a second-order analysis,” [arXiv:2107.13289](https://arxiv.org/abs/2107.13289) (2021).

This paper classifies global minima, strict saddles, and non-strict saddles in deep linear networks. It is adjacent to the zero-multiplicity application but does not state the simplex boundary-contact threshold checked in the current audit.

### Recent Hadamard-overparametrization synthesis

Chris Kolb, Christian L. Müller, Bernd Bischl, and David Rügamer, “Smoothing the Edges: Smooth Optimization for Sparse Regularization Using Hadamard Overparametrization,” *Machine Learning* 115, article 87 (2026), DOI: [10.1007/s10994-026-06997-0](https://doi.org/10.1007/s10994-026-06997-0).

This paper develops smooth variational forms, treats deeper Hadamard product maps, and proves local-minimum preservation from openness of the product map. It does not state a finite-jet threshold for recovering missing simplex KKT inequalities. Its treatment of depth makes it essential adjacent work for the zero-multiplicity application.

### Recent simplex algorithm work

James Chok and Geoffrey M. Vasil, “Optimization Over a Probability Simplex,” *Journal of Machine Learning Research* 26(73), 1–35 (2025), [journal page](https://www.jmlr.org/papers/v26/23-1166.html).

This paper maps simplex optimization through the positive sphere and derives a first-order algorithm and convergence theory. It does not analyze higher-order boundary visibility, but it confirms continuing algorithmic interest in sphere and simplex transformations.

## Searches performed

The audit was refreshed on 2026-07-31. Targeted searches covered combinations of:

- Hadamard parametrization and higher-order stationarity;
- normalized power simplex lifts;
- smooth parametrizations and `k`-critical preservation;
- monomial lifts and boundary contact order;
- deep diagonal or deep Hadamard networks and flat saddles;
- zero multiplicity and higher-order critical points.
- 2025 and 2026 deep diagonal, monomial, and simplex parametrization results.

The refreshed search recovered the 2026 Kolb–Müller–Bischl–Rügamer synthesis and the 2025 Chok–Vasil simplex algorithm paper. It also confirmed that Levin–Kileel–Boumal explicitly list general cost-independent `k => 1` preservation as a future direction. The accessible search results did not expose a paper stating the theorem package above. Citation-index coverage remains incomplete, so this is a bounded audit rather than an exhaustive novelty determination.

## Remaining novelty risks

- The block-separable theorem may be implicit in singularity theory under different terminology such as order of ramification, jet accessibility, or arc order.
- Deep diagonal-network papers may contain the zero-count threshold as a lemma without using simplex language.
- Higher-order necessary-condition literature may use a different stationarity definition and subsume the curve-jet condition.
- The theorem is elementary after the correct invariant is identified. A referee may require the robust approximate-stationarity corollary or a coordinate-free jet-cone extension for sufficient significance.

## Independent checks required

Before journal submission:

1. Search MathSciNet, zbMATH, and Google Scholar citations of the Levin–Kileel–Boumal paper.
2. Ask one researcher in nonconvex landscape geometry and one in mathematical optimization to review the theorem and terminology.
3. Compare the zero-multiplicity result against deep diagonal linear-network and deep Hadamard regularization papers published after 2024.
4. Compare the curve-based finite-jet condition with standard higher-order necessary-condition terminology and record any differences explicitly.
