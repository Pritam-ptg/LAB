from math import gcd

def rsa(p, q, m):
    n, t = p*q, (p-1)*(q-1)
    e = next(e for e in range(2, t) if gcd(e, t) == 1)
    d = pow(e, -1, t)

    c = pow(m, e, n)
    print("Encrypted message is", c)
    print("Decrypted message is", pow(c, d, n))


# Test
rsa(3, 7, 9)
rsa(3, 7, 17)