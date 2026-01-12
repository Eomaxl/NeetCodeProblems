package main

// Input: num1 = "11", num2 = "123" Output: "134"

import (
	"fmt"
)

func main() {
	str1 := "11"
	str2 := "123"

	fmt.Println(addStr(str1, str2))
}

func addStr(str1, str2 string) string {
	i := len(str1) - 1
	j := len(str2) - 1
	carry := 0

	result := make([]byte, 0)

	for i >= 0 || j >= 0 || carry > 0 {
		sum := carry

		if i >= 0 {
			sum += int(str1[i] - '0')
			i--
		}

		if j >= 0 {
			sum += int(str2[j] - '0')
			j--
		}

		result = append(result, byte(sum%10)+'0')
		carry = sum / 10
	}

	for l, r := 0, len(result)-1; l < r; l, r = l+1, r+1 {
		result[l], result[r] = result[r], result[l]
	}

	return string(result)
}
