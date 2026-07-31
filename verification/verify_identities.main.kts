#!/usr/bin/env kotlin

import java.math.BigInteger

/**
 * Exact-rational transcription checks for the boundary-contact manuscript.
 *
 * These checks support algebraic transcription and examples. The manuscript
 * proofs remain authoritative.
 *
 * Run after resource constraints are lifted:
 *     kotlin verification/verify_identities.main.kts
 */

data class Rational private constructor(
    val numerator: BigInteger,
    val denominator: BigInteger,
) : Comparable<Rational> {
    companion object {
        val ZERO: Rational = of(0)
        val ONE: Rational = of(1)

        fun of(numerator: Long, denominator: Long = 1): Rational =
            of(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator))

        fun of(numerator: BigInteger, denominator: BigInteger): Rational {
            require(denominator != BigInteger.ZERO) { "denominator must be nonzero" }
            val sign = if (denominator.signum() < 0) BigInteger.valueOf(-1) else BigInteger.ONE
            val signedNumerator = numerator * sign
            val positiveDenominator = denominator * sign
            val divisor = signedNumerator.gcd(positiveDenominator)
            return Rational(signedNumerator / divisor, positiveDenominator / divisor)
        }
    }

    operator fun plus(other: Rational): Rational = of(
        numerator * other.denominator + other.numerator * denominator,
        denominator * other.denominator,
    )

    operator fun minus(other: Rational): Rational = of(
        numerator * other.denominator - other.numerator * denominator,
        denominator * other.denominator,
    )

    operator fun times(other: Rational): Rational =
        of(numerator * other.numerator, denominator * other.denominator)

    operator fun div(other: Rational): Rational {
        require(other.numerator != BigInteger.ZERO) { "division by zero" }
        return of(numerator * other.denominator, denominator * other.numerator)
    }

    fun pow(exponent: Int): Rational {
        require(exponent >= 0) { "exponent must be nonnegative" }
        return of(numerator.pow(exponent), denominator.pow(exponent))
    }

    override fun compareTo(other: Rational): Int =
        (numerator * other.denominator).compareTo(other.numerator * denominator)
}

fun normalizedLinearChange(
    activeMass: Rational,
    activeValue: Rational,
    missingValue: Rational,
    contactCoefficient: Rational,
    parameter: Rational,
    contactOrder: Int,
): Rational {
    val missingMass = contactCoefficient * parameter.pow(contactOrder)
    val lifted =
        (activeMass * activeValue + missingMass * missingValue) / (activeMass + missingMass)
    return lifted - activeValue
}

fun expectedLinearChange(
    activeMass: Rational,
    activeValue: Rational,
    missingValue: Rational,
    contactCoefficient: Rational,
    parameter: Rational,
    contactOrder: Int,
): Rational {
    val missingMass = contactCoefficient * parameter.pow(contactOrder)
    return (missingValue - activeValue) * missingMass / (activeMass + missingMass)
}

data class ContactData(val order: Int, val leadingCoefficient: Rational)

fun deepContactOrder(factors: List<Rational>): ContactData {
    val zeroCount = factors.count { it == Rational.ZERO }
    require(zeroCount > 0) { "contact order is defined here only for inactive coordinates" }

    val coefficient = factors
        .filter { it != Rational.ZERO }
        .fold(Rational.ONE) { product, value -> product * value * value }
    return ContactData(order = 2 * zeroCount, leadingCoefficient = coefficient)
}

fun factorial(value: Int): BigInteger {
    require(value >= 0) { "factorial input must be nonnegative" }
    return (2..value).fold(BigInteger.ONE) { product, factor ->
        product * BigInteger.valueOf(factor.toLong())
    }
}

fun boundaryDerivative(
    activeMass: Rational,
    activeValue: Rational,
    missingValue: Rational,
    contactCoefficient: Rational,
    contactOrder: Int,
): Rational =
    Rational.of(factorial(contactOrder), BigInteger.ONE) *
        contactCoefficient *
        (missingValue - activeValue) /
        activeMass

fun checkExactArcIdentity() {
    val activeMass = Rational.of(7, 3)
    val activeValue = Rational.of(5, 11)
    val missingValue = Rational.of(-2, 13)
    val coefficient = Rational.of(9, 5)

    for (order in listOf(2, 4, 6, 8)) {
        for (parameter in listOf(Rational.of(1, 2), Rational.of(-2, 5), Rational.of(3, 7))) {
            val observed = normalizedLinearChange(
                activeMass,
                activeValue,
                missingValue,
                coefficient,
                parameter,
                order,
            )
            val expected = expectedLinearChange(
                activeMass,
                activeValue,
                missingValue,
                coefficient,
                parameter,
                order,
            )
            check(observed == expected) {
                "boundary-opening identity failed at order $order and parameter $parameter"
            }
        }
    }
}

fun checkZeroMultiplicity() {
    val cases = mapOf(
        listOf(Rational.of(0), Rational.of(2), Rational.of(-3)) to
            ContactData(2, Rational.of(36)),
        listOf(Rational.of(0), Rational.of(0), Rational.of(5)) to
            ContactData(4, Rational.of(25)),
        listOf(Rational.of(0), Rational.of(0), Rational.of(0)) to
            ContactData(6, Rational.of(1)),
        listOf(Rational.of(7, 2), Rational.of(0), Rational.of(0), Rational.of(-2)) to
            ContactData(4, Rational.of(49)),
    )

    for ((factors, expected) in cases) {
        check(deepContactOrder(factors) == expected) {
            "zero-multiplicity identity failed for $factors"
        }
    }
}

fun checkDerivativeSigns() {
    val activeMass = Rational.of(4)
    val coefficient = Rational.of(3, 2)
    val contactOrder = 6
    val downward = boundaryDerivative(
        activeMass = activeMass,
        activeValue = Rational.of(2),
        missingValue = Rational.of(-1),
        contactCoefficient = coefficient,
        contactOrder = contactOrder,
    )
    val upward = boundaryDerivative(
        activeMass = activeMass,
        activeValue = Rational.of(-1),
        missingValue = Rational.of(2),
        contactCoefficient = coefficient,
        contactOrder = contactOrder,
    )
    check(downward < Rational.ZERO && upward > Rational.ZERO) {
        "boundary derivative signs do not match the reduced costs"
    }
}

checkExactArcIdentity()
checkZeroMultiplicity()
checkDerivativeSigns()
println("Exact-rational transcription checks passed.")
