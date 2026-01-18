# java-island-43

A small Java tool that computes text statistics for island.

## Objective
- Provide quick text metrics for island documents.
- Report top word frequencies for fast inspection.

## Use cases
- Validate island drafts for repeated terms before review.
- Summarize island notes when preparing reports.

## Usage
javac TextStats.java && java TextStats data/sample.txt --top 5

## Output
- lines: total line count
- words: total word count
- chars: total character count
- top words: most frequent tokens (case-insensitive)

## Testing
- run `bash scripts/verify.sh`

## Notes
- Only ASCII letters and digits are treated as word characters.
