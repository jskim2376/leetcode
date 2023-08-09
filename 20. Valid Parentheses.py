class Solution:
    dic = {}
    dic["("] = ")"
    dic["{"] = "}"
    dic["["] = "]"
    cl = [")", "}", "]"]

    def isValid(self, s: str) -> bool:
        stack = []
        for e in s:
            if e in self.cl:
                if stack == [] or self.dic[stack.pop()] != e:
                    return False
            else:
                stack.append(e)
        if stack:
            return False
        return True
