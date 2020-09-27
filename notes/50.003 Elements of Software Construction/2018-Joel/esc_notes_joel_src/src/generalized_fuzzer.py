from random import randint

inp = open("generalized_fuzzer_input")
line_array = inp.read().splitlines()

def swap(line):
    if (len(line) < 2):
        print("can't swap if only 1 char")
        return
    # implementation from ex.3 (mutation.py)
    position = randint(0,len(line)-2)
    left = line[:position] + line[position+1]
    right = line[position] + line[position+2:]
    print("swapped: "+line+ " -> "+left+right)

def trim(line):
    if (len(line) < 2):
        print("can't trim if only 1 char")
        return
    position = randint(0,len(line)-2)
    trimmed = "trimmed: " + line + " -> " + line[:position]
    print(trimmed)

def flip(line):
    flipped = ""
    for char in line:
        # choose random index to flip
        index = randint(0,6)
        binary = bin(ord(char))[2:]
        # ascii space is 32=2^5, so need to add a 0 in front
        if (len(binary) == 6):
            binary = "0" + binary
        if (binary[index] == '0'):
            binary = binary[:index] + '1' + binary[index+1:]
        elif (binary[index] == '1'):
            binary = binary[:index] + '0' + binary[index+1:]
        flipped += chr(int(binary,2))
    print("flipped: " + line + " -> "+ flipped)

# randomly choose a mutation
mutations = {
    0: swap,
    1: trim,
    2: flip
}

for line in line_array:
    mut = randint(0,len(mutations)-1)
    mutations[mut](line)