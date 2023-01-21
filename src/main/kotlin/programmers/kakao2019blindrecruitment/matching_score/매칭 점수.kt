package programmers.kakao2019blindrecruitment.matching_score

class Solution {
    data class Page(
        val id: Int,
        val url: String,
        val links: List<String>,
        var matchCount: Float,
        val linkPointToOther: Float,
        var myLinkPoint: Float
    )

    fun solution(word: String, pages: Array<String>): Int {
        val metaMatcher = "<meta.*property=[\"|']og:url[\"|'].*content=[\"|']https://(.+?)[\"|']".toRegex()
        val bodyMatcher = "(?s)<.*?body.*?>(.*?)</.*?body.*?>".toRegex()
        val anchorMatcher = "<a href=\"https://(.+?)\">".toRegex()
        val wordSplit = "[^a-z]".toRegex()

        val lowerWord = word.lowercase()
        val pageMap = mutableMapOf<String, Page>()

        pages.forEachIndexed { idx, it ->
            val lowerIt = it.lowercase()
            val url = metaMatcher.findAll(lowerIt).map { meta -> meta.groups[1]!!.value }.toList().first()
            val body = bodyMatcher.find(lowerIt)?.value ?: ""
            val links = anchorMatcher.findAll(body).map { anchor -> anchor.groups[1]!!.value }.toList()
            val wordMatchCount = body.split(wordSplit).count { it == lowerWord }

            pageMap[url] =
                Page(idx, url, links, wordMatchCount.toFloat(), (wordMatchCount / links.count().toFloat()), 0F)
        }

        pageMap.forEach { it1 ->
            pageMap.forEach it2@{ it2 ->
                it2.value.links.forEach { link ->
                    if (link == it1.value.url) {
                        it1.value.myLinkPoint += it2.value.linkPointToOther
                        return@it2
                    }
                }
            }
        }

        val topPage =
            pageMap.values.toList().sortedWith(compareBy({ -(it.myLinkPoint + it.matchCount) }, { it.id })).first()
        return topPage.id
    }
}

fun main() {
    val s = Solution()
    val array: Array<String> = arrayOf(
        "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
        "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
    )

    println(
        s.solution(
            "Muzi", array
        )
    )
}