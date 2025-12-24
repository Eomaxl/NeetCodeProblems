#
# Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]..nums[i]).
# Return the running sum of nums.
# nums = [1,2,3,4], o/p: 1,3,6,10
# #


class RunningSumOf1DArray:
    @staticmethod
    def running_sum(arr):
        if not arr:
            return []
        
        result = [0] * len(arr)
        result[0] = arr[0]

        for i in range(1, len(arr)):
            result[i] = result[i-1] + arr[i]

        return result
    
def main():
    nums = [1,2,3,4]
    output = RunningSumOf1DArray.running_sum(nums)
    for i in output:
        print(f"{i}, ",end = "")

if __name__ == "__main__":
    main()
