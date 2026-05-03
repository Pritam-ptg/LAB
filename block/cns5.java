import hashlib, ipywidgets as w
from IPython.display import display

def hash_step(s, out, algo):
    out.clear_output()
    with out:
        b = s.encode()
        h = hashlib.sha1() if algo=="SHA-1" else hashlib.sha512()
        
        print("Step 1:", b.hex())
        print("Step 2:", algo, "initialized")
        
        h.update(b)
        print("Step 3:", h.hexdigest())
        
        print("Step 4 (Final):", h.hexdigest())

# UI
inp = w.Text(description="Input:")
algo = w.Dropdown(options=["SHA-1","SHA-512"], value="SHA-512", description="Algo:")
btn = w.Button(description="Compute", button_style="primary")
out = w.Output()

btn.on_click(lambda _: hash_step(inp.value, out, algo.value) if inp.value else print("Enter input"))

display(inp, algo, btn, out)