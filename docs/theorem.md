# Boundary-contact threshold theorem

## Setup

Let

\[
\Delta^{n-1}=\{x\in\mathbb R_+^n:\mathbf 1^\top x=1\}.
\]

For independent parameter blocks `w_i`, let `a_i(w_i)` be smooth and nonnegative, and define

\[
A(w)=\sum_i a_i(w_i)>0,
\qquad
\Phi_i(w)=a_i(w_i)/A(w).
\]

Fix `w_bar`, put `x_bar = Phi(w_bar)`, and let `S` be the positive support of `x_bar`.

Assume:

1. `grad a_i(w_bar_i) != 0` for every active coordinate `i in S`.
2. Every inactive coordinate `j` has a finite contact order `r_j`: all derivatives of `a_j` below order `r_j` vanish at `w_bar_j`, while some direction `v_j` satisfies

   \[
   a_j(\bar w_j+t v_j)=c_jt^{r_j}+o(t^{r_j}),
   \qquad c_j>0.
   \]

Local nonnegativity forces each finite `r_j` to be even.

Contact order is unchanged by a smooth local reparametrization of each block. The curve-based `q`-jet condition is invariant under the same local diffeomorphisms, so the threshold does not depend on smooth block coordinates.

## Jet criticality

A point is `q`-jet critical for a smooth function `F` if every smooth curve through that point has one of two behaviors through order `q`:

- all derivatives vanish; or
- the first nonzero derivative has even order and positive value.

For `q = 1`, this is first-order stationarity. For `q = 2`, it is the usual second-order necessary condition on a smooth parameter space.

## Exact convex characterization

Let `f` be convex and `C^q` near the simplex, and write `g = grad f(x_bar)`. Then `w_bar` is `q`-jet critical for `f o Phi` exactly when a scalar `lambda` exists such that

\[
g_i=\lambda \quad(i\in S),
\]

and

\[
g_j\ge\lambda
\quad
(j\notin S\text{ with }r_j\le q).
\]

The `q`-jet therefore sees precisely those missing-coordinate KKT inequalities whose contact orders do not exceed `q`.

## Universal preservation threshold

Define

\[
R(\bar w)=
\begin{cases}
1,&S=[n],\\
\max_{j\notin S}r_j,&S\ne[n].
\end{cases}
\]

For every sufficiently smooth objective, `q`-jet criticality of the lifted objective implies simplex stationarity of the image if and only if

\[
q\ge R(\bar w).
\]

Sharpness already holds for a linear objective. If `q < r_j`, take `f(x) = -x_j`. Every lifted derivative through order `q` vanishes, although the image violates the simplex KKT inequality at coordinate `j`.

## Boundary-jet certificate

At a lifted first-order critical point, choose an inactive coordinate `j` and a direction `v_j` realizing its contact order. Along the curve that changes only block `j`,

\[
\frac{d^{r_j}}{dt^{r_j}}
f(\Phi(\bar w_1,\ldots,\bar w_j+t v_j,\ldots,\bar w_n))
\bigg|_{t=0}
=
\frac{D^{r_j}a_j(\bar w_j)[v_j^{r_j}]}{A(\bar w)}
(g_j-\lambda).
\]

The displayed multiplication is scalar multiplication. Equivalently,

\[
g_j-\lambda
=
\frac{A(\bar w)}{D^{r_j}a_j(\bar w_j)[v_j^{r_j}]}
\frac{d^{r_j}}{dt^{r_j}}(f\circ\Phi\circ\gamma_j)(0).
\]

This identity recovers the missing reduced cost from the first boundary-visible derivative.

## Deep squared-Hadamard lift

For

\[
a_i(U)=\prod_{\ell=1}^{L}u_{\ell i}^2,
\qquad
\Phi_i(U)=\frac{a_i(U)}{\sum_k a_k(U)},
\]

let `z_i` count the zero factors in inactive coordinate `i`. Varying every zero factor linearly gives

\[
a_i(U(t))
=
\left(\prod_{\ell:u_{\ell i}\ne0}u_{\ell i}^2\right)t^{2z_i}.
\]

Hence

\[
r_i=2z_i.
\]

An ordinary second-order test sees exactly the inactive coordinates with one zero factor. Multiple coincident zeros create higher-order blind spots. In a tied power lift `a_i(u_i)=u_i^{2m}`, every missing coordinate has contact order `2m`.

## Proof map

The manuscript proof uses four ingredients:

1. Differentiating active blocks gives equality of active gradient components.
2. Opening an inactive block yields a simplex direction `e_j - x_bar` at its first nonzero contact order.
3. Convexity supplies the supporting-hyperplane lower bound needed for sufficiency.
4. The linear cost `-x_j` proves every lower threshold fails.
