# java-island-43

A small Java tool that computes text statistics for island.

## Goal
- Provide quick text metrics for island documents.
- Report top word frequencies for fast inspection.

## Usage
javac Main.java && java TextStats data/sample.txt --top 5

## Output
- lines: total line count
- words: total word count
- chars: total character count
- top words: most frequent tokens (case-insensitive)

## Notes
- Only ASCII letters and digits are treated as word characters.
