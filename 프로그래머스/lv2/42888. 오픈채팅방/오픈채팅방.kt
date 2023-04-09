class Solution {
    val uidToNick = HashMap<String, String>()
    
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        
        for(i in record.indices) {
            val split = record[i].split(" ")
            if(split[0] == "Enter" || split[0] == "Change") {
                uidToNick[split[1]] = split[2]
            }
        }
        
        for(i in record.indices) {
            val split = record[i].split(" ")
            if(split[0] == "Enter") {
                answer.add("${uidToNick[split[1]]}님이 들어왔습니다.")
            } else if(split[0] == "Leave") {
                answer.add("${uidToNick[split[1]]}님이 나갔습니다.")
            }
        }
        
        return answer.toTypedArray()
    }
}