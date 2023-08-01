# Wordle Development
Wordle is a guessing game, where the terminal generates a random 5 letter word, and a user enters a 5-letter word guessed and the terminal provide feedback on whether the word is correct or not. Feedback will be for each character, and it will specify whether the character is present in the word and either in correct or incorrect position using predefined parameters.
I validated the user input and then assign parameters as follows:
If the character is present in the word and in the correct position it will be indicated with an A.
If the character is present in the word but not in the correct position it will be indicated with a B.
If the character is not present in the word, it will be indicated with a C. 
In other words, the feedback may be something like [A, A, C, B, C].
I then allowed the user to guess until either the user guessed correctly or there where no remaining guesses. 
