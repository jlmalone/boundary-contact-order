# Publication roadmap

Snapshot date: 2026-08-05

This is the durable handoff for the boundary-contact-order project. It records the current mathematical claim, completed evidence, unresolved risks, owner decisions, and the ordered path to a defensible submission. The manuscript remains the source of truth for proofs.

## Current state

- Public repository: <https://github.com/jlmalone/boundary-contact-order>
- Canonical branch: `master`
- Manuscript source: [`../paper/boundary_contact_order.tex`](../paper/boundary_contact_order.tex)
- Plain-language theorem map: [`theorem.md`](theorem.md)
- Literature boundary: [`literature-audit.md`](literature-audit.md)
- Verification contract: [`verification.md`](verification.md)
- Exact-rational checker: [`../verification/verify_identities.main.kts`](../verification/verify_identities.main.kts)
- Draft preprint metadata: [`../submission/arxiv_metadata.md`](../submission/arxiv_metadata.md)

The repository is a complete static research package. It is not yet a submission-ready or peer-reviewed paper. The Kotlin verifier has not been executed, the LaTeX manuscript has not been compiled or rendered, and no independent reviewer has certified the proof or novelty.

## Defensible contribution

For a normalized block-separable nonnegative simplex lift

\[
\Phi_i(w)=\frac{a_i(w_i)}{\sum_k a_k(w_k)},
\]

an inactive coordinate has contact order `r_j` when `r_j` is the first nonzero Taylor order of its raw weight `a_j` at the boundary preimage. Under the finite-contact and active-nondegeneracy hypotheses, the draft proves:

1. For a convex `C^q` objective, `q`-jet criticality of the lifted objective is equivalent to equality of active gradient components plus the missing simplex KKT inequalities for exactly those inactive coordinates with `r_j <= q`.
2. For arbitrary sufficiently smooth objectives, `q`-jet criticality universally implies simplex KKT stationarity exactly when `q` reaches the largest inactive contact order.
3. The lower threshold fails for the linear objective `f(x) = -x_j`, so the universal threshold is sharp.
4. A boundary-jet identity recovers the missing reduced cost `g_j - lambda` from the first visible derivative.
5. For deep squared-Hadamard products, an inactive coordinate with `z_j` zero factors has contact order `r_j = 2 z_j`.
6. Higher even-power lifts of a strongly convex quadratic have at least `2^n - 2` distinct nonglobal second-order critical images.
7. Contact order and the curve-based jet condition are invariant under smooth local changes of block coordinates.

The standard square-lift result is not new. It is the `r_j = 2` case and must remain framed as prior art.

## Claims that must not drift

- Convexity is required for the sufficiency direction in the exact finite-jet characterization.
- The universal threshold for recovering first-order simplex KKT stationarity does not require convexity.
- Every inactive block in the main theorem has finite contact order.
- Every active raw weight satisfies the stated nondegeneracy condition.
- Raw weights are block-separable. Coupled raw weights are outside the theorem.
- For `q > 2`, the curve-based condition is a necessary finite-jet condition for a local minimum, not a sufficient condition.
- The deep-Hadamard corollary groups factor entries by simplex coordinate.
- The Kotlin program checks algebraic transcription only. It is not evidence that the theorem is true.
- Accessible searches did not find the same theorem, but the search was not exhaustive and does not certify novelty.

## Completed evidence

- The main theorem, sharpness example, coordinate-invariance proposition, boundary-jet certificate, deep-Hadamard corollary, and exponential example have complete written proofs in the manuscript.
- The square-lift result was identified and excluded from the novelty claim.
- The closest general framework is Levin, Kileel, and Boumal's work on smooth parametrizations. Their paper explicitly identifies general cost-independent `k => 1` preservation as a future direction.
- The audit includes Li, McKenzie, and Yin on simplex squaring; Tang and Toh on polyhedral Hadamard parametrizations; Ouyang and coauthors on KL exponents; Achour, Malgouyres, and Gerchinovitz on deep linear landscapes; Kolb and coauthors on deeper Hadamard overparametrization; and Chok and Vasil on simplex optimization.
- Static checks covered theorem labels, citation keys, whitespace, public paths, Python remnants, and local-to-remote Git consistency.
- Reusable verification is Kotlin, with no Python dependency.

## Unresolved proof risks

An independent reviewer should reconstruct each item rather than treating the current prose as authoritative evidence.

1. Verify that local nonnegativity makes the first nonzero homogeneous Taylor term nonnegative and its order even.
2. Check that active-block nondegeneracy and independent blocks force equality of all active gradient components.
3. Recheck the factorial and denominator in the boundary-jet identity.
4. Stress the convex supporting-hyperplane proof with curves that activate several visible and invisible coordinates at different orders.
5. Confirm that `r_j > q` gives `O(|t|^(q+1))` for every admissible `C^q` curve even though the raw weight has higher smoothness.
6. Reconstruct the linear sharpness example for mixed active-block motion and verify that denominator variation cannot expose coordinate `j` below order `r_j`.
7. Check the local-diffeomorphism invariance proof with the full multivariate chain rule.
8. Verify the zero-multiplicity rule when all factors of one inactive coordinate vanish and when exactly one factor vanishes.
9. Verify the Hessian equivalence used at `q = 2` and the count `2^n - 2` in the strongly convex example.
10. Test edge cases: `n = 1`, full support, `q = 1`, odd `q`, `q = Q`, and an empty set of inactive coordinates.

Infinite-order flat weights, degenerate active blocks, coupled raw weights, approximate zeros, and constrained parameter blocks remain outside the theorem.

## Unresolved novelty risks

The next literature pass should use citation indexes and terminology broader than "contact order."

Search targets:

- MathSciNet and zbMATH citations and references for Levin, Kileel, and Boumal.
- Google Scholar forward citations for the same paper and for Li, McKenzie, and Yin.
- Higher-order optimality conditions phrased through arcs, jets, higher-order tangent sets, order of vanishing, ramification order, or jet accessibility.
- Deep diagonal linear networks, monomial parametrizations, multilinear factorizations, and Hadamard-product landscapes.
- Updated publication records and citation chains for the 2024 Tang-Toh and Ouyang papers.
- Work published after the 2026 Kolb synthesis on depth-dependent criticality.

The review should produce a comparison table with columns for map class, target constraint, criticality order, objective class, conclusion, and whether the result is cost-independent. Any equivalent theorem should trigger a narrower claim or a stop decision.

## Best strengthening direction

The most useful next result is a quantitative approximate-stationarity theorem. It is closer to algorithmic use than adding more exact examples and directly addresses a future direction identified by the closest general framework.

A viable formulation would assume uniform local bounds on:

- the denominator `A(w)` away from zero;
- a positive contact coefficient in a normalized boundary-opening direction;
- derivatives of the raw weights through the relevant order;
- the conditioning of active-block differentials.

The boundary-jet identity can then convert a small visible derivative into a bound on the missing reduced cost. The target conclusion is an explicit simplex KKT residual bound in terms of active lifted-gradient error and boundary-jet errors. The theorem must state how constants deteriorate near extra zeros or vanishing contact coefficients.

Do not pursue the approximate theorem and a general coupled-map extension at the same time. If the approximate theorem becomes technically weak or tautological, the alternative is a coordinate-free jet-cone formulation for coupled raw weights.

## Ordered path to submission

### Gate 1: dynamic verification after resource constraints are lifted

From the repository root:

```bash
kotlin verification/verify_identities.main.kts
latexmk -pdf -interaction=nonstopmode -halt-on-error -output-directory=paper/build paper/boundary_contact_order.tex
pdftoppm -png -r 150 paper/build/boundary_contact_order.pdf paper/build/page
```

Then inspect every rendered page, the LaTeX log, bibliography output, equation numbering, cross-references, and external links. Repair the source and rerun until clean. A compiled PDF may be tracked only after this inspection.

### Gate 2: independent mathematical review

Ask one mathematical-optimization researcher to reconstruct the main theorem and one researcher familiar with nonconvex parametrization landscapes to challenge the novelty framing. Record actionable objections as repository issues or a dated review note. Resolve proof objections before adding applications.

### Gate 3: citation-index novelty review

Complete the searches listed above. Update [`literature-audit.md`](literature-audit.md) with exact comparisons and dates. Do not replace the bounded-audit warning unless the review is genuinely comprehensive.

### Gate 4: significance decision

Choose one of these outcomes:

1. Submit the exact theorem as a focused short note if expert reviewers judge the filtration and deep-Hadamard rule independently useful.
2. Add the quantitative approximate-stationarity theorem, then target a broader optimization journal.
3. Narrow or stop if prior art contains an equivalent finite-jet threshold.

### Gate 5: submission package

- Decide author, affiliation, contact, ORCID, acknowledgments, and reuse-license metadata.
- Choose a venue only after the proof and novelty gates.
- Update the abstract, introduction, and title to match the final contribution.
- Create a clean source archive from tracked manuscript inputs.
- Submit a preprint to `math.OC` when the metadata and owner decisions are final.
- Consider Optimization Online for specialist visibility and a DOI repository as an archival fallback. Recheck current venue rules before acting.
- Tag the exact submitted commit and preserve the submission archive.

## Suggested editorial pass

Before submission:

- Shorten the introduction if the exact theorem remains the only main result.
- Add a compact comparison table after the related-work section.
- Decide whether the coordinate-invariance proposition belongs in the main text or an appendix.
- Add one diagram only if it clearly shows the contact-order filtration across boundary strata.
- Align manuscript and preprint metadata exactly.
- Keep the exponential example because it demonstrates why the order threshold matters.
- Avoid algorithmic convergence language until a quantitative theorem exists.

## Owner decisions

The following choices were not inferred:

- final authorship and affiliation metadata;
- repository and manuscript licensing;
- whether to submit the exact short note or first prove the quantitative extension;
- preferred preprint and journal route;
- whether a compiled and inspected PDF should be tracked.

These decisions do not block preserving the current result. They must be resolved before public preprint submission.

## Continuation point

The next session should begin at Gate 1 if resource constraints are lifted. If static mode remains active, begin with the citation-index novelty review and a paper-only adversarial proof pass. Do not broaden the claim until those gates are complete.
