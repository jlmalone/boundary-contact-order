# Draft preprint metadata

## Classification

- Primary: `math.OC` (Optimization and Control)
- Possible cross-list: `cs.LG` (Machine Learning)
- Journal reference: blank until accepted
- DOI: blank until assigned

## Title

Boundary Contact Order Governs Stationarity Preservation in Normalized Simplex Lifts

## Abstract

Smooth parametrizations can remove explicit nonnegativity constraints while changing which optimality violations are visible to derivative-based methods. We study normalized block-separable lifts of the probability simplex of the form

\[
\Phi_i(w)=a_i(w_i)/\sum_k a_k(w_k),
\qquad a_i\ge 0.
\]

At a boundary preimage, the first nonzero Taylor order of an inactive coordinate map is its contact order. Using a curve-invariant notion of higher-order criticality, we prove that a derivative order `q` detects exactly the missing simplex KKT inequalities whose contact orders do not exceed `q`. Consequently, the largest inactive contact order is the sharp universal threshold at which lifted criticality implies stationarity of the simplex image. The threshold fails at every lower order for a linear objective. For convex costs we give a complete characterization of all higher-order critical points and an exact boundary-jet formula recovering each visible reduced cost. In a deep squared-Hadamard factorization, the contact order of a missing coordinate is twice its number of zero factors. Thus simple zeros remain second-order visible, coincident zeros create higher-order blind spots, and tied even-power lifts realize the maximally degenerate case. The results isolate boundary contact order as the invariant governing higher-order landscape fidelity in this class of simplex parametrizations.

## Comments

Research draft. Proofs are authoritative; the companion Kotlin verification program performs exact-rational transcription checks only.

## Submission contents

- `paper/boundary_contact_order.tex`
- `paper/references.bib`
- optionally `verification/verify_identities.main.kts` under an ancillary directory

A compiled PDF, private review notes, Git metadata, and local build artifacts do not belong in the source archive.
