# Boundary Contact Order

Boundary contact order determines how many derivatives a smooth simplex lift can hide before a missing-coordinate optimality violation becomes visible.

For a normalized block-separable lift

\[
\Phi_i(w)=\frac{a_i(w_i)}{\sum_k a_k(w_k)},
\qquad a_i\ge 0,
\]

suppose an inactive coordinate satisfies

\[
a_j(\bar w_j+t v_j)=c_jt^{r_j}+o(t^{r_j}),
\qquad c_j>0.
\]

The integer `r_j` is its boundary contact order. The main result gives an exact threshold:

- a `q`-jet critical point detects the missing simplex KKT inequality for coordinate `j` exactly when `q >= r_j`;
- the lift preserves simplex stationarity for every smooth objective exactly when `q` reaches the largest inactive contact order;
- for deep squared-Hadamard lifts, `r_j` equals twice the number of zero factors in coordinate `j`.

This distinguishes tied power lifts from untied factorizations. A tied `2m`-power coordinate has contact order `2m`. An untied deep coordinate with one zero factor has contact order two, so an ordinary second-order test still sees its reduced cost.

## Research status

The repository contains a complete draft proof and a bounded primary-literature audit. The result has not been peer reviewed, and the novelty search is not exhaustive. No compiled PDF or executed verification result is claimed in the current resource-constrained snapshot.

## Repository map

- [`paper/boundary_contact_order.tex`](paper/boundary_contact_order.tex): manuscript source
- [`docs/theorem.md`](docs/theorem.md): theorem and proof map in plain language
- [`docs/literature-audit.md`](docs/literature-audit.md): closest results and exact novelty boundary
- [`docs/verification.md`](docs/verification.md): static checks and future dynamic gates
- [`verification/verify_identities.main.kts`](verification/verify_identities.main.kts): dependency-free exact-rational transcription checks
- [`submission/arxiv_metadata.md`](submission/arxiv_metadata.md): draft preprint metadata

## Verification after static mode

Run these commands only after resource constraints are lifted:

```bash
kotlin verification/verify_identities.main.kts
latexmk -pdf -interaction=nonstopmode -halt-on-error -output-directory=paper/build paper/boundary_contact_order.tex
```

The first command checks finite algebraic instances with exact rational arithmetic. The second builds the manuscript. A release also requires rendered-page inspection and an independent proof review.

## Central contribution

The proposed contribution is the boundary-contact threshold theorem and its zero-multiplicity law for deep Hadamard simplex factorizations. The square-lift second-order result is established prior art and appears here only as the contact-order-two case.
