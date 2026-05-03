def caesar(text, shift):
    return ''.join(
        chr((ord(c) - (65 if c.isupper() else 97) + shift) % 26 + (65 if c.isupper() else 97))
        if c.isalpha() else c
        for c in text
    )

t = input("Enter the plain text: ")
s = int(input("Enter the number of shifts: "))

c = caesar(t, s)
print("Plaintext:", t)
print("Shift:", s)
print("Ciphertext:", c)
print("Decrypted text:", caesar(c, -s))