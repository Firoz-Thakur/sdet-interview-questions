# Validation

The initial publication was compiled with the Eclipse Java compiler 3.39.0 targeting Java 17 and executed on OpenJDK 21 in the preparation environment. The compiler artifact was downloaded from Maven Central and verified against its published checksum; it is not included in this repository.

Result: **2,098 explicit checks passed**, exercising all 51 question groups. This includes deterministic normal, boundary, invalid-input, overflow, and repeated-call cases, plus 250 seeded randomized rounds comparing next-greater-element, equilibrium counts, window sums, maximum-subarray sums, palindrome implementations, and substring search against independent baselines or alternatives.

All relative documentation links were checked. The preserved original upload is excluded from compilation. The GitHub Actions workflow uses JDK 17 and the javac commands documented in the README; a hosted Actions result must be checked separately after pushing. No claim is made that every possible input has been exhaustively tested.
