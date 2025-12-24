from typing import List

class ProductOfArrayExceptSelf:
    @staticmethod
    def product_except_of_self(arr:List[int])-> List[int]:
        n = len(arr)

        result = [0] * n
        prefix = [0] * n
        suffix = [0] * n

        # Prefix products
        prefix[0] = 1
        for i in range(1, n):
            prefix[i] = prefix[i-1] * arr[i-1]

        # Suffix products
        suffix[n-1] = 1
        for i in range(n-2,-1,-1):
            suffix[i] = suffix[i+1] * arr[i+1]

        # Result    
        for i in range(n):
            result[i] = prefix[i] * suffix[i]
        return result 

def main():
    input = [1,2,3,4]
    output = ProductOfArrayExceptSelf.product_except_of_self(input)
    for i in output:
        print(f"{i} ,", end="")

if __name__ == "__main__":
    main()