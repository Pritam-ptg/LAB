import string, random

key = dict(zip(string.ascii_lowercase, random.sample(string.ascii_lowercase, 26)))
rev = {v: k for k, v in key.items()}

def convert(text, k):
    return ''.join(
        (k[c.lower()].upper() if c.isupper() else k[c.lower()]) if c.isalpha() else c
        for c in text
    )

t = input("Enter the plain text: ")
c = convert(t, key)

print("Substitution Key:", key)
print("Plaintext:", t)
print("Ciphertext:", c)
print("Decrypted Text:", convert(c, rev))