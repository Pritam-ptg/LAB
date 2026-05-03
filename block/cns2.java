!pip install pycryptodome

from Crypto.Cipher import DES
from Crypto.Util.Padding import pad, unpad
import binascii

def enc(key, text):
    c = DES.new(key.encode(), DES.MODE_CBC)
    ct = c.encrypt(pad(text.encode(), 8))
    return binascii.hexlify(c.iv).decode(), binascii.hexlify(ct).decode()

def dec(key, iv, ct):
    c = DES.new(key.encode(), DES.MODE_CBC, binascii.unhexlify(iv))
    return unpad(c.decrypt(binascii.unhexlify(ct)), 8).decode()


# Example
k, t = '12345678', 'naveen'
iv, ct = enc(k, t)

print("Encrypted Data:", ct)
print("IV:", iv)
print("Decrypted Data:", dec(k, iv, ct))