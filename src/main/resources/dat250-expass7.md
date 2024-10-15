# Dat250 expass 7

The primary aim of this assignment is to explore the functionalities of messaging systems, particularly focusing on the RabbitMQ. I successfully completed the experiments.

## Technical Problems Encountered
During the completion of the tutorial, I encountered technical issue with log message redirection. Initially, I faced problems with redirecting log messages from the consumer to a file. The issue stemmed from Python's output buffering behavior. To resolve this, I either modified the print statements to flush the output immediately or ran the script in unbuffered mode using the `-u` flag. This allowed the log messages to be written to the file without delay.

## Code Repository
GitHub repository link: [Repository](https://github.com/magddzi881/250-lab6/tree/main).

## Pending Issues
As of now, there are no pending issues with this assignment.
