## Caesar Cipher
This is a simple Java program that either encodes or decodes a caesar, or shift, cipher. 

### About
(last updated 2/6/25)

This program isn't really intended for use. Rather, I wrote it as a sample project because I've never made a sample project before. I didn't want the only thing on my GitHub to be school assignments. I've done much more work with Python over the last year, so my skills with Java aren't as developed, so this also acted as a refresher on Java syntax.

Three user inputs are processed, the first being the selection of the "encode" or "decode" options. There is little variation between the two, but determining the order to shift the letters (up or down, increasing or decreasing) is necessary so the program can provide the correct answer. The second is the selection of the offset number, which must be an int for the program to run. The offset number is simply the amount the user wishes to shift the letters. For example, encoding 'B' with an offset of 3 will be returned as 'E'. The final user input is the string to be encoded/decoded. At the moment, this program only works with individual words.
