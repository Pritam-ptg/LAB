def mod_inv(a, m=26):
    for x in range(1, m):
        if (a*x) % m == 1:
            return x

def mat_inv(m):
    a,b,c,d,e,f,g,h,i = sum(m, [])
    det = (a*(e*i-f*h)-b*(d*i-f*g)+c*(d*h-e*g)) % 26
    inv = mod_inv(det)

    adj = [
        [e*i-f*h, c*h-b*i, b*f-c*e],
        [f*g-d*i, a*i-c*g, c*d-a*f],
        [d*h-e*g, b*g-a*h, a*e-b*d]
    ]
    return [[(inv*x)%26 for x in row] for row in adj]

def mul(mat, vec):
    return [[sum(mat[i][j]*vec[j][0] for j in range(3)) % 26] for i in range(3)]

def hill(msg, key):
    K = [[ord(key[3*i+j])-65 for j in range(3)] for i in range(3)]
    M = [[ord(msg[i])-65] for i in range(3)]

    print("Key Matrix:", *K, sep="\n")
    print("Message Matrix:", *M, sep="\n")

    C = mul(K, M)
    print("Cipher Matrix:", *C, sep="\n")

    ct = ''.join(chr(x[0]+65) for x in C)
    print("Ciphertext:", ct)

    K_inv = mat_inv(K)
    print("Inverse matrix modulo 26:", *K_inv, sep="\n")

    D = mul(K_inv, C)
    print("Decrypted Matrix:", *D, sep="\n")

    print("Decrypted Text:", ''.join(chr(x[0]+65) for x in D))


# Run
hill("MOR", "RVCRSCFVT")