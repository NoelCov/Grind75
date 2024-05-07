class MyQueue(object):

    def __init__(self):
        self.list1 = []
        self.list2 = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.list1.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        for i in range(len(self.list1)):
            self.list2.append(self.list1.pop())

        num_to_pop = self.list2.pop()

        for i in range(len(self.list2)):
            self.list1.append(self.list2.pop())

        return num_to_pop

    def peek(self):
        """
        :rtype: int
        """
        for i in range(len(self.list1)):
            self.list2.append(self.list1.pop())

        num_to_peek = self.list2[-1]

        for i in range(len(self.list2)):
            self.list1.append(self.list2.pop())

        return num_to_peek

    def empty(self):
        """
        :rtype: bool
        """
        print(self.list1)
        return len(self.list1) == 0
        
