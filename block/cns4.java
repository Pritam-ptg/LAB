<!DOCTYPE html>
<html>

<head>
    <title>Diffie-Hellman</title>
    <style>
        body {
            font-family: Arial;
            text-align: center;
            margin-top: 50px
        }

        input,
        button {
            padding: 10px;
            margin: 10px
        }
    </style>
</head>

<body>
    <h2>Diffie-Hellman Key Exchange</h2>

    <input type="number" id="a" placeholder="Enter Alice's private key">
    <button onclick="calc()">Compute</button>

    <div id="res"></div>

    <script>
        const p = 23, g = 5, b = 6;

        const modPow = (b, e, m) => {
            let r = 1; b %= m;
            while (e > 0) { if (e % 2) r = r * b % m; e = Math.floor(e / 2); b = b * b % m; }
            return r;
        }

        function calc() {
            let a = parseInt(document.getElementById("a").value);
            if (!a) return res.innerText = "Enter valid key";

            let A = modPow(g, a, p), B = modPow(g, b, p);
            let s1 = modPow(B, a, p), s2 = modPow(A, b, p);

            res.innerHTML = `
  prime number: ${p} <br> Primitive root: ${g} <br>
  Alice Private: ${a} <br>
  Alice Public: ${A} <br>
  Bob Public: ${B} <br>
  Shared (Alice): ${s1} <br>
  Shared (Bob): ${s2} <br><br>
  ${s1 === s2 ? " Success" : " Error"}
  `;
        }
    </script>

</body>

</html>