from typing import Dict, List

class SubarraySumEqualsK:

    @staticmethod
    def subarray_sum_equals_k(num: List[int], k: int)-> int:
        count = 0
        sum = 0

        freq: Dict[int, int] = {0 : 1}

        for i in num:
           sum += i
           count += freq.get(sum - k, 0)
           freq[sum] = freq.get(sum, 0) + 1
        return count
    

def main():
    arr1 = [1,1,1]
    k1 = 2
    arr2 = [1,2,3]
    k2 = 3
    ans1 = SubarraySumEqualsK.subarray_sum_equals_k(arr1,k1)
    ans2 = SubarraySumEqualsK.subarray_sum_equals_k(arr2,k2)
    print(f"The solution for case 1 : {ans1}")
    print(f"The solution for case 2 : {ans2}")

if __name__ == "__main__":
    main()