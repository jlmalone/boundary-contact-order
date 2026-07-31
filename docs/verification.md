# Verification contract

## Current static checks

The resource-constrained snapshot supports only inspection-based verification:

- every theorem hypothesis is stated before use;
- the convex and arbitrary-objective statements are separated;
- the lower-threshold counterexample is linear;
- the deep-Hadamard contact order is derived from the number of zero factors;
- literature claims are bounded to inspected primary sources;
- generated PDFs, build claims, and executed-test claims are absent.

## Future dynamic checks

After resource constraints are lifted:

1. Run the exact-rational transcription checks:

   ```bash
   kotlin verification/verify_identities.main.kts
   ```

2. Build the manuscript:

   ```bash
   latexmk -pdf -interaction=nonstopmode -halt-on-error -output-directory=paper/build paper/boundary_contact_order.tex
   ```

3. Render every PDF page and inspect equations, references, line breaks, and link targets.
4. Have an independent reviewer reconstruct the proofs without relying on the verification script.
5. Repeat the literature audit in citation indexes unavailable to the current search path.

## Proof-risk checklist

- Confirm that local nonnegativity makes the first nonzero contact order even.
- Confirm that active-block regularity gives all within-face exchange directions.
- Check the supporting-hyperplane argument for curves mixing visible and invisible inactive coordinates.
- Check that an invisible coordinate contributes `O(t^(q+1))` whenever its contact order exceeds `q`.
- Verify the factorial convention in the boundary-jet identity.
- Treat infinite-order flat coordinates separately; the current theorem assumes finite contact order.
- Do not transfer the exact-zero theorem to approximate zeros without condition-number bounds.
