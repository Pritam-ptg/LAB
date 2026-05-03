{
 "cells": [
  {
   "cell_type": "code",
   "execution_count": 4,
   "id": "4ea8f974",
   "metadata": {},
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "Plaintext: Reva University\n",
      "Shift: 3\n",
      "Ciphertext: Uhyd Xqlyhuvlwb\n",
      "Decrypted text: Reva University\n"
     ]
    }
   ],
   "source": [
    "def caesar(text, shift):\n",
    "    return ''.join(\n",
    "        chr((ord(c) - (65 if c.isupper() else 97) + shift) % 26 + (65 if c.isupper() else 97))\n",
    "        if c.isalpha() else c\n",
    "        for c in text\n",
    "    )\n",
    "\n",
    "t = input(\"Enter the plain text: \")\n",
    "s = int(input(\"Enter the number of shifts: \"))\n",
    "\n",
    "c = caesar(t, s)\n",
    "print(\"Plaintext:\", t)\n",
    "print(\"Shift:\", s)\n",
    "print(\"Ciphertext:\", c)\n",
    "print(\"Decrypted text:\", caesar(c, -s))"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "id": "a4adda41",
   "metadata": {},
   "outputs": [],
   "source": []
  }
 ],
 "metadata": {
  "kernelspec": {
   "display_name": "Python 3",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "codemirror_mode": {
    "name": "ipython",
    "version": 3
   },
   "file_extension": ".py",
   "mimetype": "text/x-python",
   "name": "python",
   "nbconvert_exporter": "python",
   "pygments_lexer": "ipython3",
   "version": "3.11.9"
  }
 },
 "nbformat": 4,
 "nbformat_minor": 5
}
