import java.util.*

class Solution {
    fun solution(new_id: String): String {
        val stack = Stack<Char>()
        
        for(ch in new_id.toCharArray()) {
            if(stack.size == 15) break
            
            if(ch in 'a'..'z') {
                stack.push(ch)
            } else if(ch in 'A'..'Z') {
                stack.push(('a' + ch.code - 'A').toChar())  
            } else if(ch == '.') {
                if(stack.size == 0) continue
                // 길이제한은 나중에
                if(stack.peek() == '.') continue
                
                stack.push('.')
            } else if(ch.isDigit() || ch == '-' || ch == '_') {
                stack.push(ch)
            }
        }
        
        if(stack.isNotEmpty()) {
            if(stack.peek() == '.') stack.pop()
        }
        
        if(stack.isEmpty()) {
            stack.push('a')
        }
        
        if(stack.size <= 2) {
            while(stack.size < 3) {
                stack.push(stack.peek())
            }
        }
        
        val answer = StringBuilder()
        stack.forEach { answer.append(it) }
        return answer.toString()
    }
}