from typing import List

class NextPermutation:
    def next_permutation(self, arr:List[int])-> None:
        i = len(arr) - 2
        while i >=0 and arr[i] >= arr[i+1]:
            i -= 1
        
        if i >=0 :
            j = len(arr) - 1
            while arr[j] > arr[i]:
                j -= 1
            self._swap(arr,i,j)
        
        self._reverse(arr,i+1)
        
    
    def _swap(self, arr:List[int], i:int, j:int)-> None:
        arr[i], arr[j] = arr[j], arr[i]

    def _reverse(self, arr:List[int], start:int)-> None:
        i , j = start, len(arr) - 1
        while i<j:
            self._swap(arr,i,j)
            i += 1
            j -= 1

def main():
    solution = NextPermutation()

    input = [3,2,1]
    solution.next_permutation(input)
    print(input)

if __name__ == "__main__":
    main()