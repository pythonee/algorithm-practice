class StackQueue(object):

    stack_a = []
    stack_b = []

    def enQueue(self, data):
        self.stack_a.append(data)

    def deQueue(self):
        if(len(self.stack_b)<=0):
            while(self.stack_a):
                t = self.stack_a.pop()
                self.stack_b.append(t)

        return self.stack_b.pop()


q = StackQueue()
q.enQueue(1)
q.enQueue(2)

print q.deQueue()
print q.deQueue()

