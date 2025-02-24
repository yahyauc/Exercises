import string

def word_frequency(text):
    text = text.lower().translate(str.maketrans('', '', string.punctuation))
    
    words = text.split()
    

    frequency = {}
    for word in words:
        frequency[word] = frequency.get(word, 0) + 1
    
    return frequency

text = "Hello world! This is a test. Hello again, world."
print(word_frequency(text))
